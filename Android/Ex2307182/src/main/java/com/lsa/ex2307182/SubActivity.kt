package com.lsa.ex2307182

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class SubActivity : AppCompatActivity() {
    lateinit var  listView: ListView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        listView=findViewById(R.id.colorList)

        var color = arrayOf("Red", "Green", "Blue")

        var adapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_list_item_1,color)

        listView.adapter = adapter

        listView.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, i, l ->

            //1. 데이터 담을 빈 Intent 생성
            var it_result = Intent()
            //2. Intent에 값 담기(index)
            it_result.putExtra("color",i) //i => 내가 클릭한 항목 index
            //3. 다시 돌려주기
            setResult(RESULT_OK, it_result)
            //4. 종료...
            finish()

        })

    }
}