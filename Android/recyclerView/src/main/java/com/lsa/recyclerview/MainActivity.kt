package com.lsa.recyclerview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var btn_add:Button
    lateinit var rv : RecyclerView
    var data = ArrayList<customVO>()
    lateinit var adapter: customAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_add = findViewById(R.id.btn_add)
        rv = findViewById(R.id.rv)


        var vo1 : customVO = customVO("네이버","http://www.naver.com")
        var vo2 : customVO = customVO("넷플릭스", " http://www.netflix.com/browse")
        var vo3 : customVO = customVO("SMHRD", "http://smhrd.or.kr/")
        var vo4 : customVO = customVO("유튜브","https://www.youtube.com")
        data.add(vo1)
        data.add(vo2)
        data.add(vo3)
        data.add(vo4)

         adapter= customAdapter(applicationContext,R.layout.templete,data)

        rv.layoutManager = LinearLayoutManager(applicationContext)
        rv.adapter = adapter

        btn_add.setOnClickListener{
            var intent = Intent(this,AddActivity::class.java)
            frLauncher.launch(intent)
        } //btnadd click 끝
    }//oncreate끝
    var frLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK){
            var title = it.data!!.getStringExtra("add_title")
            var url = it.data!!.getStringExtra("add_url")
            data.add(customVO(title!!,url!!))
            adapter.notifyDataSetChanged()
        }//if문 끝
    }//launcher 끝

}
