package com.lsa.ex20230706

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
   // @SuppressLint("MissingInflatedId")
    lateinit var btn_click : Button
    lateinit var btn_change : Button

    lateinit var tv_result : TextView
    lateinit var edit_input :TextView

    // field에서는 변수 생성만!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //이미 생성된 변수에 find 한 값 저장만!
        btn_click = findViewById(R.id.btn_click)
        btn_change= findViewById(R.id.btn_change)
        tv_result= findViewById(R.id.tv_result)
        edit_input = findViewById(R.id.edit_input)


        //Toggle Event 실습

        var isKorean : Boolean = true

        var cnt: Int= 0


        btn_click.setOnClickListener {
            //1)
            if(!isKorean){// true이면 실행! 왜? == 비교연산의 결과값이 boolean이기때문
                tv_result.text = "안녕"
            }else {
                tv_result.text = "Hello"
            }
            isKorean=!isKorean
            // 2) 버튼 눌렀을 때 textView에 뭐라고 적혀있는지 검사
//            if(tv_result.text=="안녕"){
//                tv_result.text = "Hello"
//            }else{
//                tv_result.text="안녕"
//            }
            //3) 버튼 누를 때마다 숫자 세어서 홀/짝 구분
            // 숫자를 센다? => cnt에 저장된 값을 1증가
//            cnt++
//            if(cnt%2==1){
//                tv_result.text = "Hello"
//            }else{
//                tv_result.text="안녕"
//            }
            }


//        btn_change.setOnClickListener {
//
//            tv_result.text = edit_input.text
//            edit_input.text=""
//            //edit_input.setText("")
//        } //xml에서 Event 처리하는 코드로 고치기

        // ❗xml로 Event 처리하는 방법
        // 1. 버튼을 클릭 했을 때 실행 될 메서드 정의(.kt)
        //  - 매개변수를 반드시 View타입으로 생성!!
        // 2. xml 파일을 열어서 버튼 선택 후 onClick 속성에 메서드 연결
    }

    // public void btnClick(View currentClick){}
    fun btnClick( currentClick : View){ //매개변수 생성 시 var 생략
        tv_result.text = edit_input.text
           edit_input.text=""
    }
}
