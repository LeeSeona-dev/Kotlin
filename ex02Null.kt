fun main() {
    // 기본 자료형
    // Int , Float, Double, Char, Boolean...
    val age : Int = 20
    // 선언할때는 객체 자료형으로 선언하지만 저장하는 값을 보고
    // 기본자료형임을 추론해서 정적인 공간 (int)에 저장

    // 참조 자료형
    // String , Person...
    //  + String? , Int?, Float?...
    // String? -> 해당 변수에는 문자열이 저장 될 수 도 있고,
    //          Null 값이 저장 될 수 도 있음
    val name : String? = "이선아"
    // String : 무조건 문자열만 들어갈 수 있다. null 허용 x
    // String? :  문자열/Null 가능
    println(name?.length)
    // null을 허용하는 순간 해당 변수에 대해 아래쪽에서 null 처리를 해줘야함
    // 방법1)  ?(safe-call) : 세이프콜
    // name?.length -> name.Length가 가져오는 결과값이 null일 수 도 있다.
    // 만약에 null이라면 null을 그대로 출력해라!

    // ---> ReclerView에서 view를 리턴
    // !!를 사용하면 반드시 이유를 작성해줘야한다.
    // 방법2)  !!(non-null asserted) : 단정기호
    // name!!.length - name.length는 절대로 null일 수 가 없음
    // null이 들어와버리면 NPE를 발생시킴

    // 3) ?: (Elvis 연산자) 삼항연산자와 비슷함
    println(name?.length ?: "이름이 null 입니다.")
    // name.Length가 null값을 가져오면 ?: 기본값이 출력된다.

    // Int vs Int?
    // 기본 vs 참조
    // 정적 vs 동적
    // static vs heap

}