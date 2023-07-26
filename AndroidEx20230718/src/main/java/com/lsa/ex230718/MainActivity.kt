package com.lsa.ex230718

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    lateinit var editText : EditText
    lateinit var  btn : Button
    lateinit var resultText : TextView

    lateinit var reqQueue : RequestQueue

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //component 가져오기
        editText = findViewById(R.id.etUrl)
        btn = findViewById(R.id.btnUrl)
        resultText = findViewById(R.id.tvResult)

        //RequestQueue 생성
        reqQueue = Volley.newRequestQueue(this@MainActivity)

        //버튼이 클릭되면 editText에 작성된 주소를 가져와서 요청! 응답 오는 값 출력
        btn.setOnClickListener {
            val input = editText.text.toString()

            //String 타입의 응답값 받을 때 사용하는 Request객체

          val request : StringRequest =  StringRequest(
                Request.Method.GET, //요청메서드(GET/POST)
                input, //요청 주소 ( editText에 적은 주소 가져오는 input 변수)
                { //요청과 응답 성공했을때(200) 
                    //response -> 서버가 응답해준 결과 값
                    response -> 
                    Log.d("response", response.toString())
                    resultText.text = response
                },{ //통신 실패 했을때
                    //error -> 발생한 오류에 대한 정보 가지고 있음
                    error ->
                    Log.d("error", error.toString())
                    Toast.makeText(this, "error 발생", Toast.LENGTH_SHORT).show()
                }
            )

            //생성된 request 객체를 -> request Queue에 추가
            // (=> 큐 안에서 쓰레드 생성되어 서버로 요청, 응답 받기 가능!)
            reqQueue.add(request)

        }

    }
}