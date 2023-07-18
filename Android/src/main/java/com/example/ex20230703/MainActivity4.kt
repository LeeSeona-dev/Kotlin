package com.example.ex20230703

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity4 : AppCompatActivity() { //AppCompatActivity:슈퍼클래스
    override fun onCreate(savedInstanceState: Bundle?) {//상속 받는 메서드
        super.onCreate(savedInstanceState) //화면 구성 준비하는 코드
        // View를 세팅하기 이전에 findViewById를 하는건 불가능
        // NPE가 발생한다!
        setContentView(R.layout.activity_main4) //xml, kt 파일 연결하는 코드

        // btnPlus를 클릭했을 때, 이벤트가 일어나는지 확인
        // xml에 부여했던 id값을 class 에서 바로 참조하는 건 불가능!
        // xml에 부여한 id-> R.id에 저장이 된다(16진수의 랜덤한 값)
        // -> class에서 findViewById()
        // id값(16진수의 랜덤한 값)을 통해서 View를 찾아온다!
        val btnPlus : Button = findViewById(R.id.btnPlus)
        // Button타입 btnPlus 변수 생성후 R.id.btnPlus로 찾은 view 저장
        // : 변수의 자료형을 통해 추론이 가능하기 때문에 <Button> 생략 가능

        //변수
        //생성(선언): 변수명 앞에 자료형 표기
        //사용(참조): 변수명 앞에 자료형 표기 x



        // TypeMismatchException : 내가 찾아오려는 view랑
        // 변수의 view타입이 일치하지 않을 경우에 발생하는 예외상황

        // 1) Toast 창을 Emulator에 띄워보자 (문구 : 클릭!!)
        // 2) Log를 통해 확인해보기
        btnPlus.setOnClickListener {
            // btnPlus를 클릭했을 때 실행시킬 코드
            Toast.makeText(this@MainActivity4,
                "클릭!!",Toast.LENGTH_SHORT).show()
            // 1) context : 화면정보(어디에 토스트를 보여지게 만들건지?)
            // this@MainActivity4
            // 2) text : CharSequence -> String의 문구
            // Int 자료형을 띄울 수 는 있음 단, View의 Id값만 가능
            // 3) duration : 토스트 창의 지속시간 (몇초동안 띄울건지)
            // + show() : Toast창이 화면에 보임

        }


    }
}