package com.lsa.ex20230720

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ktx.ChildEvent
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    //ListView의 업그레이드 버전
    //RecyclerView를 만들어보자!
    //Custom RecyclerView (ex 인스타, 유튜브 등등)
    // 원리!
    // Data의 개수만큼 Template 을 복사하여 REcyclerView안에 배치
    // => Adapter가 함!

    //필요한것
    //1.Data(VO, ArrayList)
    // VO=>사용자(개발자) 정의 자료형
    //2.Template(.xml)
    //3.Adapter(.kt)
    // ->ViewHolder : 템플릿에 있는 뷰를 저장함(.kt)도 만들어야함!
    lateinit var  rv :RecyclerView
    lateinit var  btn_send : Button
    lateinit var edt_msg : EditText

    //FireBase => 구글 클라우드 서버
    // 클라우드 서버?
    // 구글에서 일정량의 저장소와 서버를 구축해두고 Android 개발자에게 제공해주는 서비스
    // 목적: Android 개발자가 서버를 구현하는 번거로움을 해소!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.listview)
        btn_send = findViewById(R.id.btn_send)
        edt_msg = findViewById(R.id.edt_msg)

        //App에 연결되어있는 FireBase DataBase 객체 가져오기
        val database = Firebase.database
        //DataBase 경로 가져오기
        val myRef = database.getReference("message")
        //해당 경로에 데이터 저장하기


        var data = ArrayList<kakaoVO>()
        //자바: ArrayList<kakaoVO> data = new ArrayList<kakaoVO>()

        //add 함수 사용하여 메세지 5개 저장
        //1개의 메세지를 저장하기 위해 새로운 자료형을 설계(kakaoVO)
        //클래스 -> 설계 , 객체 -> 생성
        //자바 : kakaoVO vo1 = new kakaoVO(data1, data2, data3, data4);
        //      data.add(vo1);

//        var vo1 : kakaoVO = kakaoVO(R.drawable.img0438,"보낸이","안녕하세요","12:00")
//        data.add(vo1)

//        myRef.push().setValue(kakaoVO(R.drawable.img0438,"보낸이","안녕하세요","오후 12:37"))
//        myRef.push().setValue(kakaoVO(R.drawable.img0498,"보낸이2","반갑습니다","오후 20:08"))
//        myRef.push().setValue(kakaoVO(R.drawable.img0499,"보낸이3","메세지메세지","오후 10:39"))
//        myRef.push().setValue(kakaoVO(R.drawable.img0508,"보낸이4","집가고싶어요","오후 22:20"))
//        myRef.push().setValue(kakaoVO(R.drawable.img0586,"보낸이5","12시간자고싶다","오전 06:27"))


        // 내가 보낸 채팅은 오른쪽에 띄우는 법!
        //1. template.xml 파일에 오른쪽 톡 추가(중요! 같은 파일에 추가할것!)
        //2. 현재 로그인한 id를 생성자로 전달 => 메세지 주인!
        //3. adapter 클래스의 onBindView 메서드에서 data.get(position).name
        // (메세지 주인과) 생성자로 전달된 id를 비교
        //4. 일치한다면 왼쪽 뷰들은 전부 gone, 오른쪽 뷰들은 visiable
        // tip! tamplate에 뷰가 추가됐으니 ViewHolder도 수정 필요!
        var adapter:kakaoAdapter = kakaoAdapter(applicationContext, R.layout.templete, data)

        // 중요!!!!
        rv.layoutManager = LinearLayoutManager(applicationContext) // 목록형
        rv.adapter = adapter

        btn_send.setOnClickListener{
            myRef.push().setValue(kakaoVO(R.drawable.img0438,"보낸이",edt_msg.text.toString(),"오후 12:37"))
            data.add(kakaoVO(R.drawable.img0438, "보낸이",edt_msg.text.toString(),"20:30"))
            // adapter 새로고침
         //   adapter.notifyDataSetChanged()
            // 스크롤 옮기기
            rv.smoothScrollToPosition(data.size-1)
            // editText 비우기
            edt_msg.text.clear()
        } //onclicklistener 끝

        myRef.addChildEventListener(ChildEvent(data, adapter))

    } //oncreate 끝


}