package com.lsa.ex2023307072

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //배열
    //R파일에 등록된 리소스는 int타입(주소!)
    //자바 -> int[] imgs = new int[3]
    //        int[] imgs = {1,2,3}

    lateinit var imgview : ImageView
    lateinit var imgs : Array<Int>
    var cnt : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgview = findViewById(R.id.imageView2)
        imgs = arrayOf(R.drawable.dog1,R.drawable.dog2,R.drawable.dog3)
        //lv1.
        //1.btnClick 메서드 만들기
        //2. ImageView 찾기
        // 이전에는 TextView text 속성을 바꿨음 이번에는 ImageView의 ImageResource변경
        //3. 클릭이 일어난 버튼의 id값에 따라 imageView의 ImageResource를 바꿔주면 됨
        // 이미지뷰 . setImageResource(R.drawable.파일명)
        // 1,2,3 버튼 이벤트 구현하기
        // !연결해주기 onclick속성

        //lv2.
        //1.R.drawable.파일명 <- 배열에 저장
        //2. 화살표 버튼 누를 때마다 Index 증가시키면서 배열에서 이미지 꺼내기

        //lv3.
        //숫자버튼 클릭 후 양 옆 버튼 클릭하면 ~

        //lv4.
        //랜덤 이미지

    }

    fun btnClick(currentClick : View){

//        if(currentClick.id == R.id.btn1){
//           imgview.setImageResource(R.drawable.dog1)
//        }else if(currentClick.id==R.id.btn2){
//            imgview.setImageResource(R.drawable.dog2)
//        }else if(currentClick.id==R.id.btn3){
//            imgview.setImageResource(R.drawable.dog3)
//        }
        // 알고리즘
        if(currentClick.id==R.id.btn1){
            cnt = 0
        }else if(currentClick.id== R.id.btn2){
            cnt = 1
        }else if(currentClick.id == R.id.btn3){
            cnt = 2
        }else if(currentClick.id == R.id.btn_pre){
            if(cnt > 0){
                cnt--
            }else{
                Toast.makeText(applicationContext, "첫번째 사진입니다.", Toast.LENGTH_SHORT).show()
            }
        }else if(currentClick.id == R.id.btn_next){
            if(cnt<imgs.size-1){
                cnt++
            }else{
                Toast.makeText(applicationContext,"마지막 사진입니다.", Toast.LENGTH_SHORT).show()
            }
        }
        // UI 바꾸는 부분
        imgview.setImageResource(imgs[cnt])
    }

}
