package com.lsa.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.lsa.fragment.vo.AndMemberVO
import com.lsa.fragment.vo.BoardDataVO
import java.io.ByteArrayOutputStream

class BoardWriteActivity : AppCompatActivity() {

    lateinit var etTilte:EditText
    lateinit var etContent:EditText
    lateinit var ibGallery:ImageButton
    lateinit var ibCamera: ImageButton
    lateinit var ivUpload: ImageView
    lateinit var btnWrite :Button

    lateinit var reqQueue: RequestQueue
    lateinit var encodeImgString:String
    val STORAGE_CODE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_write)

        etContent=findViewById(R.id.etContent)
        etTilte=findViewById(R.id.etTitle)
        ibGallery=findViewById(R.id.ibGallery)
        ibCamera=findViewById(R.id.ibCamera)
        ivUpload=findViewById(R.id.ivUpload)
        btnWrite=findViewById(R.id.btnWrite)

        reqQueue= Volley.newRequestQueue(this@BoardWriteActivity)

        val spf = getSharedPreferences("mySPF",Context.MODE_PRIVATE)

       val member =  Gson().fromJson(spf.getString("member",""), AndMemberVO::class.java)


        //갤러리이미지버튼
        ibGallery.setOnClickListener {
           val intent =  Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            //다른 액티비티 시작된 후 그 액티비티의 결과를 다시 가져오고 싶을때 사용!
            startActivityForResult(intent,STORAGE_CODE)
        }


        btnWrite.setOnClickListener {
            val inputTitle = etTilte.text.toString()
            val inputContent = etContent.text.toString()
            val writer = member.id

           val request = @SuppressLint("SuspiciousIndentation")
           object: StringRequest(
                Request.Method.POST,
                "http://172.30.1.36:8888/board/write",
                {
                    response -> Log.d("response",response.toString())
                    if(response=="Success"){
                        val intent = Intent(this,MainActivity::class.java)
                            startActivity(intent)
                        }
                },
                {
                    error->Log.d("error",error.toString())
                }
            ){ //익명객체 object는 마지막에 항상 {} 바디 붙여줘야함
               override fun getParams(): MutableMap<String, String>? {

                   val params:MutableMap<String,String> =HashMap<String,String>()

                   val board = BoardDataVO(null,null,inputTitle,inputContent,writer,encodeImgString)
                    params.put("board",Gson().toJson(board))

                   return params
               }
           }
            reqQueue.add(request)

        }

        }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode){
            STORAGE_CODE->{
                //image uri 가져오기
               val selectedImgUri =  data?.data

                if(selectedImgUri!=null){
                    //uri -> bitmap 으로 변환
                   val bitmap= MediaStore.Images.Media.getBitmap(contentResolver,selectedImgUri)
                    ivUpload.setImageBitmap(bitmap)

                    val options = BitmapFactory.Options()
                    options.inSampleSize = 4 //4개의 픽셀->1개의 픽셀 =>1/4 크기로 변환
                    //      filter : true(선명) false(흐림)
                    val resized = Bitmap.createScaledBitmap(bitmap,100,100,true)
                    encodeBitmapImg(resized)
                }
            }
        }

    }
    //bitmap -> String (Base64사용)
    private fun encodeBitmapImg(bitmap:Bitmap){
        //ByteArray 생성 할 수 있는 Stream
        val byteArrayOutputStream = ByteArrayOutputStream()
        //bitmap 압축
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream)
        //img => array형태
        val bytesOfImg = byteArrayOutputStream.toByteArray()
        //encoding:ByteArray->String(Base64 사용 -> encoding)
        encodeImgString = Base64.encodeToString(bytesOfImg,Base64.DEFAULT)
    }
}