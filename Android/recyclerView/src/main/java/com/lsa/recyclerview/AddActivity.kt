package com.lsa.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddActivity : AppCompatActivity() {
    lateinit var etAddTitle : EditText
    lateinit var etAddUrl : EditText
    lateinit var btnAdd : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        etAddTitle = findViewById(R.id.etAddTitle)
        etAddUrl = findViewById(R.id.etAddUrl)
        btnAdd = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener{
            var add_title = etAddTitle.text.toString()
            var add_url = etAddUrl.text.toString()

            var resultIntent = Intent()
                resultIntent.putExtra("add_title",add_title)
                resultIntent.putExtra("add_url",add_url)

            // title과 url이 비어있지 않은지 검사 하면 더 좋겠음~~
            setResult(RESULT_OK, resultIntent)
            finish()
        }

    }
}
