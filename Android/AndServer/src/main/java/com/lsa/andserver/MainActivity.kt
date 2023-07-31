package com.lsa.andserver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    lateinit var etId:EditText
    lateinit var etPw:EditText
    lateinit var etTel:EditText
    lateinit var etBd:EditText
    lateinit var btnJoin :Button

    lateinit var reqQueue : RequestQueue


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etId=findViewById(R.id.etId)
        etPw=findViewById(R.id.etPw)
        etTel=findViewById(R.id.etTel)
        etBd=findViewById(R.id.etBd)
        btnJoin=findViewById(R.id.btnJoin)

        reqQueue=Volley.newRequestQueue(this@MainActivity)

        //버튼을 클릭하면 사용자가 작성한 값 가져오기 -> Node서버로 보내기
        //->응답(가입이 성공/실패했는지)
        btnJoin.setOnClickListener {
            val inputId = etId.text.toString()
            val inputPw = etPw.text.toString()
            val inputTel = etTel.text.toString()
            val inputBd = etBd.text.toString()

            //object : 무명객체 생성
            //StringRequest 구현 하는 객체 생성하겠다는 키워드
            //일회성, 한번만 사용할 객체 바로 생성해주는 키워드
            val request = object :StringRequest(
                Request.Method.POST,
                //manifest.xml ->android:usesCleartextTraffic="true" 추가 필수(http로 요청시)
                "http://172.30.1.36:8089/join",
                {
                    response->
                    Log.d("response",response.toString())
                    if(response=="Success"){
                        //LoginActivity 전환
                        var intent:Intent = Intent(this,LoginActivity::class.java)
                        startActivity(intent)

                    }else{ //response ==="Fail"
                        Toast.makeText(this,"회원가입 실패",Toast.LENGTH_SHORT).show()
                    }
                },
                {
                    error->
                    Log.d("error",error.toString())
                }

            ){
               override fun getParams() : MutableMap<String,String>{
                   //맵 생성
                  val params:MutableMap<String,String> =  HashMap<String,String>()

                   val amv = AndMemberVO(inputId,inputPw,inputTel,inputBd)

                   //AndMemberVO(Object) -> json형태로 변환
                   params.put("AndMember", Gson().toJson(amv))

                   return params
               }
            }

            reqQueue.add(request)
        }
    }
}