package com.lsa.ex20230719login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SubActivity : AppCompatActivity() {
    lateinit var edtId : EditText
    lateinit var edtPw : EditText
    lateinit var btnLogin2 : Button
    lateinit var members : HashMap<String,String>


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        members = HashMap()
        members.put("smart","1234")
        members.put("test","1234")
        members.put("test2","1234")
        edtId = findViewById(R.id.edtId)
        edtPw = findViewById(R.id.edtPw)
        btnLogin2 = findViewById(R.id.btnLogin2)

        btnLogin2.setOnClickListener {

            var inputID=edtId.text.toString()
            var inputPW=edtPw.text.toString()

            if(members.containsKey(inputID)){
                if(members.get(inputID).equals(inputPW)){
                    var intent :Intent = Intent()
                    intent.putExtra("id",inputID)
                    setResult(RESULT_OK,intent)
                    Log.d("intent",edtId.toString())
                    finish()
                }
            }else{
                Toast.makeText(applicationContext,"다시 확인해주세요",Toast.LENGTH_SHORT).show()
            }
        }


    }
}