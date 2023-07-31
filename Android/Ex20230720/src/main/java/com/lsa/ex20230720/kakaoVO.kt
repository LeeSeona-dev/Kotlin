package com.lsa.ex20230720

data class kakaoVO(var imgID:Int?=0, var name:String?="", var msg:String?="", var time:String?="")
//childEvent 클래스에서 DataSnapshot 을 kakaoVO 로 형변환하고 있음
// => getValue(kakaoVO::class.java)
// 자바 버전 : getValue(kakaoVO.class)
// 중요한점! 형변환시 반드시 기본생성자가 정의되어 있어야함!
// 기본생성자란 ? => 매개변수가 하나도 없는 생성자!
// kakaoVO(){}
// 생성자는 객체를 생성 할 때 함께 호출 되는 메서드!
// ex) new kakaoVO() => 기본생성자 호출
// ex) new kakaoVO(1, "a", "b", "c", "d") => 매개변수가 5개 있는 생성자 호출
// 코틀린에서 기본 생성자 만드는 방법?=> 매개변수에 null 값을 허용해주면 된다!
// ex) data class kakaoVO(var imgID:Int?=0)