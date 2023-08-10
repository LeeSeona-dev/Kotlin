package com.lsa.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class GameActivity : AppCompatActivity() {
    var imgs = arrayOfNulls<ImageView>(9) // imageView 타입의 배열 9칸 생성하고 null 로 초기화
    var threads = arrayOfNulls<dodoThread>(9)//Thread 객체 9개 저장
    lateinit var tv_score : TextView
    lateinit var tv_time : TextView
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        tv_score = findViewById(R.id.tv_score)
        tv_time = findViewById(R.id.tv_time)

        // 생성될 때 ImageView 를 전달받는 Thread 를 설계
        // 알고리즘 => run() 메소드안에

        cntThread(tv_time,10).start()
        //new cntThread().start()

        for(index in 0 until 9){ // 0~8까지
            //"imageView 1~9" id를 가진 view 주소 알아내는 코드
            var id = resources.getIdentifier("imageView" + (index+1), "id", packageName)
            imgs[index] = findViewById(id) // 9개의 ImageView for 문 돌면서 다 찾음
            imgs[index]!!.tag = "off"

            //배열에 생성된 Thread 누적
            threads[index]= dodoThread(imgs[index]!!)
            threads[index]!!.start()


            //doThread.interrupt()
            //Thread 종료시키는 방법
            // 1. interrupt를 발생시킨다
            // 2. Thread 내부에서는 interrupt exception이 발생!
            // 3. 이걸 이용해서! try-catch를 활용하여 run메서드 종료시킴!
            // => Thread클래스 안에서

            // 두더지 클릭했을 때 on인지 off 인지 판단 R.drawble.__ 주소로 이미지 변경 했음
            //Android 에서 이미지끼리 비겨교하는 방법은 Drawble이라는 객체로 변경 후 이미지 처리
            //일이 커짐 => View에 tag 라는 변수 활용
            imgs[index]!!.setOnClickListener{
                if(imgs[index]!!.tag.toString()=="on"){ //두더지에 "on" tag 가 걸려 있다면
                    score++
                }else{
                    score--
                }
                tv_score.text = score.toString()
                imgs[index]!!.tag = "off"
            }

        }

    }

    //Handler 생성 후 메세지 받아서 처리할 메소드 오버로딩
    var dodohandler : Handler = object : Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            (msg.obj as ImageView).setImageResource(msg.arg1)
            //업캐스팅 되어있는 상태에서 하위클래스로 형변환

            (msg.obj as ImageView).tag = if(msg.arg1 == R.drawable.on)"on" else "off"

        }
    }


    inner class dodoThread(var dodo : ImageView): Thread(){

        override fun run(){

            try {
                while (true){
                    var offTime = Random().nextInt(5000)+500//0.5 ~ 5초 사이
                    Thread.sleep(offTime.toLong())

                    //올라가는 이미지로 변경 => dodohandler에 요청
                    var msg = Message()
                    msg.obj = dodo;
                    msg.arg1 = R.drawable.on

                    dodohandler.sendMessage(msg)

                    var onTime = Random().nextInt(1000)+500 //0.5~1.5 초 사이
                    Thread.sleep(onTime.toLong())

                    //내려가는 이미지로 변경
                    // Message 객체는 일회성 => 한번 보낸 메세지를 객체에 재사용 불가능
                    msg = Message()
                    msg.obj = dodo;
                    msg.arg1 = R.drawable.off
                    dodohandler.sendMessage(msg)

                }

            }catch ( e : InterruptedException){
                return //메서드 종료!
                // 메서드는 return 키워드를 만나는 그 즉시 호출한 곳으로 돌아간다
            }

        }

    }
    var cnthandler : Handler = object :Handler(Looper.getMainLooper()){
        //java 버전 => Handler cntHandler = new Handler(Looper.getMainLooper())
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            var tv :TextView = msg.obj as TextView
            tv.text= msg.arg1.toString()
            //Thread 중지
            if(msg.arg1 == 1){
                //for each문이랑 같음
                for(temp in threads){
                    //in 오른쪽에 적힌 배열에서 순서대로 하나씩 꺼내 temp에 저장
                    temp!!.interrupt()
                }
            }

        }
    }

    inner class cntThread(var tv : TextView, var startNum: Int): Thread(){

        override fun run(){

            for(i in startNum  downTo  0){

                var msg : Message = Message()

                msg.arg1 = i
                msg.obj = tv

                cnthandler.sendMessage(msg)
                Thread.sleep(500)

            }

        }

    }


}