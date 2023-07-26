package com.lsa.ex20230711

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {
    // 1. Button 25개 findViewById => 배열, for문
    // - 변수로 생성하면 노가다, 순서가 없어서 for문도 못돌림
    // 2. 1~25까지 저장된 배열 생성! 랜덤으로 섞기
    // 3. Button에 숫자 띄우기!
    // 4. ClickEvent 처리하기
    //  - 버튼 눌렀을 때 사라지기
    //  - 순서에 맞는지 확인하기
    //  : 버튼 누를때마다 카운트를 세고 카운트와 버튼에 적혀있는 숫자가 같다면 사라짐!
    //  - 25버튼 눌렀으면 멈춤!

    //배열
    //var temp = arrayOf(1,2,3)
    var btns = arrayOfNulls<Button>(25)
    //자바 버전 => Button btns = new Button[25]
    var nums =  Array(25){i  -> i+1} //람다식으로 1~25까지 채운 배열 생성
    var cnt : Int = 1 //내가 눌러야 하는 숫자
    lateinit  var time : Chronometer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        setContentView(R.layout.gamelayout) //로그인 xml 띄우기!

        time = findViewById(R.id.tv_time)
        time.start()

        //자바버전 for(int x = 0; x<=24; x++)
       // for(x in 0 ..24) {}
        
        nums.shuffle() // 배열 무작위로 섞임
        
        for(index in 0 until 25){
            // id명(String)으로 주소값(int) 알아내기
            var id : Int = resources.getIdentifier("btn" +(index+1), "id",packageName)
            btns[index] = findViewById(id)
            
            btns[index]!!.text = nums[index].toString() //nums인덱스 스트링 변환해서 버튼 숫자띄우기

            //!! => null값이 아닐때만 메서드 호출
            btns[index]!!.setOnClickListener {

                // cnt와 버튼에 적혀있는 글자가 같다면!
                if(cnt.toString() == btns[index]!!.text ){
                    //viwe를 화면에서 안보이게하는 코드
                    btns[index]!!.visibility = View.INVISIBLE
                    cnt++
                    if(cnt == 26){
                        time.stop()
                    }
                }

            }


        }

        //배열이랑 함께 쓰는 for문
        // 자바버전 for(Button data : btns)
        //자바 for each문은 인덱스로 접근 불가능
        //x => 인덱스 , data => 값
//        for((x,data) in btns.withIndex()){
//
//        }


    }
}