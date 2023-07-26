package com.lsa.ex20230712

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class SubActivity : AppCompatActivity() {
    lateinit var btn_finish : Button
    lateinit var  listview : ListView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        btn_finish = findViewById(R.id.btn_finish)
        listview = findViewById(R.id.listview)

        // Intent로 전달된 데이터 꺼내서 Button에 띄우기
        var myIntent : Intent = intent //intent = getIntent

        var email : String? = myIntent.getStringExtra("email")

        btn_finish.text = email+"님 종료하시겠습니까?"

       // button 클릭시 메인 액티비티로 이동하기
        btn_finish.setOnClickListener {
//            var intent : Intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
            finish()
        }
        //1. Data
        //2.템플릿 (Android에서 제공해주는 템플릿)
        //3. Adapter(Data+템플릿 연결해주는 역할) - Android에서 제공해주는 Adapter

        var foods = arrayOf("부추전","튀김", "감자탕","치킨","피자")

        var adapter = ArrayAdapter<String> (applicationContext, android.R.layout.simple_list_item_1 , foods)

        //listView에 adapter 연결!
        listview.adapter = adapter

    }


}