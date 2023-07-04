fun main() {
    // 실행시킬 코드는 main()함수 안에 작성

    // 데이터를 저장 할 수 있는 공간 만들기
    // 1) val / var 정해주기
    // val(value) : 변경 불가능(immutable)한 변수, 초기화만 가능, 재할당 불가
    // var(variable) : 변경 가능(mutable)한 변수, 초기화/재할당 가능
    // 2) 변수명
    // 3) : 자료형 = 데이터 값

    // 이름을 저장할 수 있는 변수 name 만들어보자
    // val name : String = "이선아"
    val name = "이선아"
    println(name)
    // 자료형 확인하는 단축키 : 확인하려는 데이터를 커서 놓고 ctrl + shift + p

    // Kotiln에서는 들어오는 데이터를 보고 자료형 추론이 가능함
    // 변수를 선언할 때 자료형을 생략할 수 있다.

    var age = 20
    age = 21

    // int age; 선언
    // age = 21; 초기화
    // 코틀린에서 선언과 초기화를 분리하고 싶으면 반드시
    // 선언 코드에 자료형이 명시되어 있어야한다 !
    val greet : String;
    greet = "안녕하세요"
    println(greet)
}