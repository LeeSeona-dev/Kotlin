package com.lsa.andserver

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class LoginActivity : AppCompatActivity() {

    lateinit var etId:EditText
    lateinit var etPw:EditText
    lateinit var btnLogin:Button

    lateinit var reqQueue:RequestQueue

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etId=findViewById(R.id.etId)
        etPw=findViewById(R.id.etPw)
        btnLogin=findViewById(R.id.btnLogin)

        reqQueue = Volley.newRequestQueue(this@LoginActivity)

        btnLogin.setOnClickListener {
            //1.로그인 버튼 누르면 사용자가 입력한 id,pw 가져오기
            var inputId = etId.text.toString()
            var inputPw = etPw.text.toString()
            // 2.request생성(POST,url : /login, {성공했을때 response 출력}, {error}
            val request = object :StringRequest(
                Request.Method.POST,
                "http://172.30.1.36:8089/login",
                {
                    response->
                    Log.d("response",response.toString())
                },
                {
                    error->
                    Log.d("error",error.toString())
                
                }
            )
            //  +getParams(id,pw)
            {
                override  fun getParams():MutableMap<String,String>{

                    //맵 생성
                    val params:MutableMap<String,String> = HashMap<String,String>()
                    val amv = AndMemberVO(inputId,inputPw,null,null)
                    //AndMemberVO(Object)-> json형태 변환
                    params.put("AndMember", Gson().toJson(amv))
                    return params
                }
            }
            //3.requestQueue추가
            request.setShouldCache(false)
            reqQueue.add(request)
            //node
            //1.indexRouter - /login 추가
            //2. => andmember 테이블에 사용자가 입력한 id,pw가 같은 행에 있는 데이터 확인(select*)
            // => 가지고 오는 데이터가 있으면 -> 로그인 성공->"success"
        }
    }
}
