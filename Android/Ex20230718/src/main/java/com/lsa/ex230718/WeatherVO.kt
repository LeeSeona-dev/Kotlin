package com.lsa.ex230718

//data class 만들어줌 (class 앞에 data 붙이기)
//POJO(Plain Old Java Object) : 클래스 안에 간단한 기능만 가진 자바 객체
//data class가 pojo 생성하는 역할 -> 필드만 정의 -> getter,setter,toString... 자동 생성
//data class 지정하는 조건
//1) 최소 하나의 파라미터(필드 )가 있어야함
//2) 파라미터는 val or var로 선언해야함
//3) abstract, open(부모클래스 지정하는것), sealed(자식 클래스 제한),inner(중첩클래스지정)
//   이런 키워드는 붙이면 안됨!
//4) 다른 클래스를 상속 받을 수 없음(sealed 클래스는 상속 받을 수 있음)
data class WeatherVO(var city:String, var state:String, var temp:Int )