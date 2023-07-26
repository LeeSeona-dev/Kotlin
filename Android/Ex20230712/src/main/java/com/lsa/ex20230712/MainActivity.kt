package com.lsa.ex20230712

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    //iv_kakaopage 이미지뷰 찾기
    lateinit var iv_kakaopage : ImageView
    lateinit var tv_googlekakao : TextView
    lateinit var tv_sms : TextView
    lateinit var tv_call : TextView
    lateinit var btn_next : Button
    lateinit var edt_email : EditText
    lateinit var edt_pw : EditText
    lateinit var members : HashMap<String, String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //members = new HashMap();  =>자바
        members = HashMap()
        members.put("aaa","1234")
        members.put("bbb","4321")
        members.put("test","0000")
        members.put("smart","1234")
        members.put("vvv","1234")

        iv_kakaopage = findViewById(R.id.iv_kakaopage) //iv_kakaopage 주소이기 때문에 int형
        tv_googlekakao = findViewById(R.id.tv_googlekakao)
        tv_sms = findViewById(R.id.tv_sms)
        tv_call = findViewById(R.id.tv_call)

        btn_next = findViewById(R.id.btn_next)
        edt_email = findViewById(R.id.edt_email)
        edt_pw = findViewById(R.id.edt_pw)

        //https://www.kakaocorp.com/page/
        iv_kakaopage.setOnClickListener{
            // Intent
            // 카카오 웹페이지 이동~
            // 1. intent 생성
            //자바 버전 Intent it_kakao = new Intent()
            var it_kakao : Intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.kakaocorp.com/page/"))
            //Intent 생성 할 때 매개변수 2개 들어감
            // (해야할 일(Action , 웹페이지이동), 데이터(Uri, 주소))

            // 2. intent 실행
            // 중요! startActivities XXX!
            startActivity(it_kakao)
        }

        //모바일 계정~~ 클릭->구글에 카카오 검색 페이지
        tv_googlekakao.setOnClickListener{
            // 1. Intent 생성
            var it : Intent = Intent(Intent.ACTION_WEB_SEARCH)
            // 2. putExtra 함수 사용, 데이터 담기
            it.putExtra(SearchManager.QUERY, "광주맛집")
            // 3. Intent 실행
            startActivity(it)

        }

        //카카오계정 안내 클릭시 -> 문자 보내기
        tv_sms.setOnClickListener{
            // 문자보내는 페이지까지 이동!
            // 실제로 문자 보내야된다 -> 문자보내는 업체 사용해야함
            // 1. Intent 생성
            var it : Intent = Intent(Intent.ACTION_SENDTO,
                Uri.parse("smsto:010-7382-6709")
            )
            // 2. putExtra 함수 사용해서 문자 내용 작성
            it.putExtra("sms_body", "안녕하세요!")
            // 3. Intent 실행
            startActivity(it)

        }

        //비밀번호를~~ 클릭시 전화걸기
        tv_call.setOnClickListener{

            // 튕겨야 맞음
            // 왜냐하면 android에는 예민한 기능들(전화, gps, 갤러리...등)
            // 권한 요청을 해서 사용자가 허용을 해야 수행할 수 있도록 Android가 설계해놨음

            // 1. 이미 권한을 승인하지 않았는지 검사!
            // 2. 승인하지 않았다면 다이얼로그 띄움!
            // 3. Manifest.xml 파일 열어서 permission 태그 추가!

            //                      applicationContext: 현재 화면 정보
            if(ActivityCompat.checkSelfPermission
                    (applicationContext, android.Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.CALL_PHONE), 0)
            }

            // 1.Intent 생성(Action, Data)
            var it : Intent = Intent(Intent.ACTION_CALL,
                Uri.parse("tel:010-7382-6709"))
            // 2. Intent 실행
            startActivity(it)

        }


//        btn_next.setOnClickListener {
//
//        if(edt_email.text.toString()=="smart"&&edt_pw.text.toString()=="1234"){
//            //로그인버튼 클릭 시 -> 페이지 이동
//                // 다른 Activity로 이동!
//                var intent : Intent = Intent(this, SubActivity::class.java)
//
//                intent.putExtra("email",edt_email.text.toString())
//
//                startActivity(intent)
//
//            }
//        }

        btn_next.setOnClickListener {

            // 1. id가 존재하는지
            var inputID =edt_email.text.toString()
            var inputPW = edt_pw.text.toString()

            if(members.containsKey(inputID)){
            //해당되는 key값이 있으면 true, 없으면 false
             if(members.get(inputID).equals(inputPW)){
                 // members에 저장된 값 중 inputID를 키 값으로 하는 데이터가
                 // inputPW와 같으면 true, 다르면 false
                 //로그인버튼 클릭 시 -> 페이지 이동
                 // 다른 Activity로 이동!
                 var intent : Intent = Intent(this, SubActivity::class.java)

                 intent.putExtra("email",edt_email.text.toString())

                 startActivity(intent)
             }else{
                 Toast.makeText(applicationContext,"틀린 비밀번호입니다.",Toast.LENGTH_SHORT).show()
             }

            }else{
                Toast.makeText(applicationContext,"존재하지 않는 id입니다.",Toast.LENGTH_SHORT).show()
            }



        }


    }
}