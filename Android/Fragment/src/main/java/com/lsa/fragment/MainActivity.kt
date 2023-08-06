package com.lsa.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.lsa.fragment.vo.AndMemberVO

class MainActivity : AppCompatActivity() {

    lateinit var  bnv:BottomNavigationView
    lateinit var fl : FrameLayout
    lateinit var tvId : TextView
    lateinit var btnLogout : Button

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bnv = findViewById(R.id.bnv)
        fl = findViewById(R.id.fl)
        tvId = findViewById(R.id.tvId)
        btnLogout =findViewById(R.id.btnLogout)


        //SharedPreference 생성(name : mySPF)
        val spf = getSharedPreferences("mySPF", Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor = spf.edit()
        //"member" 값 가져오기 -> json 형태의 문자열
        val strMember =  spf.getString("member","")
        //json 문자열을 AndMemberVO 타입으로 변환 (Gson 사용)
        val memberVO =  Gson().fromJson(strMember,AndMemberVO::class.java)
        //VO에서 id만 꺼내서 textView text 속성으로 넣어주기
        tvId.text = memberVO.id+"님 환영합니다💖"
            //MainActivity로 전환되자마자 프레그먼트 1번으로 바꾸기!
            //supportFragmentManager 활용 transaction 생성
            //transaction을 통해 프래그먼트 교체 -> commit(완료)
            supportFragmentManager.beginTransaction().replace(
                R.id.fl,
                Fragment1()
            ).commit()


        //btnLogout에 클릭리스터
        //->spf 저장된 값 삭제하기
        //-> LoginActivity로 전환(intent)
        btnLogout.setOnClickListener{
            editor.remove("member")
            editor.commit()
            tvId.text = ""
            val intent =  Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }


        //bnv에서 선택한 메뉴에 따라 fl에 표시할 Fragment를 갈아 끼우기!
        bnv.setOnItemSelectedListener {
            Log.d("id", it.itemId.toString())

            //switch랑 비슷함
            when(it.itemId){

                R.id.tab1 ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl,
                        Fragment1()
                    ).commit()
                }

                R.id.tab2 ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl,
                        Fragment2()
                    ).commit()
                }
                R.id.tab3 ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl,
                        Fragment3()
                    ).commit()
                }
                R.id.tab4 ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl,
                        Fragment4()
                    ).commit()
                }
            }
            //boolean -> true/false(false이벤트인식을 잘 못함)
            //true(이벤트 인식이 더 좋음)
            true
        }
    }
}