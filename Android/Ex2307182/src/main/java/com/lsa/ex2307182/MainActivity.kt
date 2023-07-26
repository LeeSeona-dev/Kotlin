package com.lsa.ex2307182

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var btn_color : Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_color = findViewById(R.id.btn_color)

        btn_color.setOnClickListener {

            var it : Intent= Intent(this,SubActivity::class.java)

            //startActivity => 편도
            //ForResultLauncher => 왕복
            frLauncher.launch(it)
        }
    }

    //onCreate메서드 바깥에 Launcher 생성하기
    var frLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        // it : 갔다가 돌아왔을 때 담아준 데이터!

        //1. 이상없이 돌아왔는지
        if(it.resultCode == RESULT_OK){
          var result:Int =  it.data!!.getIntExtra("color",-1)
        }
        //2. 담아준 데이터가 있는지
    }
}