package com.lsa.ex20230707

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

//    lateinit var  btn_plus : Button
//    lateinit var  btn_minus : Button

    lateinit var tv_result: TextView
    var resultNum: Int = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        btn_plus = findViewById(R.id.btn_plus)
//        btn_minus = findViewById(R.id.btn_minus)
        tv_result = findViewById(R.id.tv_result)

    }

    //    fun btnClick1 (currentClick : View){
//        ++resultInt
//        tv_result.text = resultInt.toString()
//    }
//    fun btnClick2 (currentClick : View){
//        if(resultInt>0){
//            --resultInt
//            tv_result.text = resultInt.toString()
//        }
//    }
    //하나의 메서드안에서 처리하기
    fun btnClick(currentClick: View) {
        //버튼이 늘어날 때마다 메서드를 하나씩 계속 추가해야하나..?
        //click메서드 하나로 여러개의 Event를 처리할 수 있음!
        //매개변수 currentClick => 사용자가 클릭한 View(Button...)
        if (currentClick.id == R.id.btn_minus) {
            // - 버튼을 클릭했다면!
            if (resultNum > 0) {
                --resultNum
            }
        } else if (currentClick.id == R.id.btn_plus) {
            // + 버튼을 클릭했다면!
            ++resultNum
        }
        tv_result.text = resultNum.toString()
    }

}