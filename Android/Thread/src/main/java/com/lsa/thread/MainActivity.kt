package com.lsa.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tv_start1 : TextView
    lateinit var btn_start1 : Button
    lateinit var tv_start2 : TextView
    lateinit var btn_start2 : Button
    lateinit var etNum : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Thread는 class로 설계한다!
        // 때문에 객체를 생성해야한다!
        tv_start1 = findViewById(R.id.tv_start1)
        tv_start2= findViewById(R.id.tv_start2)
        btn_start1 = findViewById(R.id.btn_start1)
        btn_start2 = findViewById(R.id.btn_start2)
        etNum = findViewById(R.id.etNum)



        btn_start1.setOnClickListener {
            //버튼을 클릭했을때 숫자를 가져와야한다! 시점 중요!!
            var startNum = etNum.toString().toInt()
            var th1 : cntThread = cntThread(tv_start1,startNum) //내가 생성하는 스레드 start1하는 스레드
            th1.start()
        }

        btn_start2.setOnClickListener {
            var startNum = etNum.toString().toInt()
            var th1 = cntThread(tv_start2,startNum)
            th1.start()
        }

    }
    var cntHandler : Handler = object :Handler(Looper.getMainLooper()){
        // 자바 버전: Handler cntHandler = new Handler(Looper.getMainLooper())
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            //메세지를 받아서 처리하는 곳!

            var tv : TextView = msg.obj as TextView //형변환
            tv.text = msg.arg1.toString()
        }
    }

    inner class cntThread(var tv: TextView, var startNum: Int) : Thread(){

        // 1. Thread 클래스 상속(extends)
        // 2. Runnable 인터페이스 구현 (implements)
        override fun run() {
          //  super.run()
            // super.메서드명
            // => 삭제해도 되는 경우 or 안되는 경우
            // 삭제해도 되는 경우: 매개변수 없을 경우
            // 안되는 경우 : 매개변수가 있을 경우

            //10~1까지 세기!
            for(i in startNum downTo  1){
                //1. 메세지 생성!
                var msg : Message = Message()
                //2. 데이터 세팅
                msg.arg1 = i
                msg.obj = tv
                //3. 핸들러한테 전송!
                cntHandler.sendMessage(msg)
                Thread.sleep(500) //0.5초로 세기
            }
            // Thread는 run메서드가 끝나면 소멸!

        }
    }

}

