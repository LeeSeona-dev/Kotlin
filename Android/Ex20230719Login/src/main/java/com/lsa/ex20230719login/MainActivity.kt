package com.lsa.ex20230719login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    lateinit var tvLogin : TextView
    lateinit var btnCreate : Button
    lateinit var btnLogin : Button
    lateinit var lvContent : ListView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        tvLogin = findViewById(R.id.tvLogin)
        btnCreate = findViewById(R.id.btnCreate)
        btnLogin = findViewById(R.id.btnLogin)
        lvContent = findViewById(R.id.lvContent)


        // listView 만들때!
        //1. 데이터(배열/ArrayList)
        //2. 템플릿(xml)
        //3. 어뎁터(.kt : BaseAdapter 상속)
        var content:Array<String> = arrayOf("1.Android 짱 재밌음", "2.아님 어려움..","3.그래도 재밌음","4.집에 가고 싶다")

        //simple_list_item_1:템플릿
        var adapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_list_item_1,content)
        lvContent.adapter = adapter

        btnLogin.setOnClickListener {

            var intent :Intent =  Intent(this,SubActivity::class .java)

            frLauncher.launch(intent)

        }

    }

    var frLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

        if(it.resultCode == RESULT_OK){

            //id+환영합니다 , 글작성 버튼 보이게 하기
            var myIntent = it.data
            var id : String? = myIntent?.getStringExtra("id")

            tvLogin.text=id+"님 환영합니다."
            btnCreate.visibility= View.VISIBLE
        }


    }

}