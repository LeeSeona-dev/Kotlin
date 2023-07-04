fun main() {

    //Int, Float, String? ---> String
    // 안드로이드에서 결과값을 토스트 , Log를 통해서 확인하고싶을때
    // 반드시 문자열로만 출력이 가능 -> 형변환 필요

    val num : Int = 16
    val str = num.toString()
    val str2 = ""+num
    println(str::class.java.simpleName)
    // class.java.simpleName --> 해당 변수가 가진 자료형을 출력

    // Double ---> Float
    val num2 = 3.141592.toFloat()
   // val num2 = 3.141592.f

    // 스마트 캐스트
    // 서버로부터 나의 전체 성적에 대한 평균을 받아온다. (라고 가정)
    // 스마트 캐스트가 적용 되는 자료형 : Number
    var test : Number = 12.2
    println(test::class.java.simpleName)
    test = 56
    println(test::class.java.simpleName)

    // Any (= 자바의 Object)
    var test2 : Any = "이선아"
    println(test2::class.java.simpleName) //String
    test2 = 12
    println(test2::class.java.simpleName) //Int
}