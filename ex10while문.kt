fun main() {

    // 레이블(Label)
    outer@while(true){
        println("바깥쪽 while문이 동작")
        while (true){
            println("안쪽 while문이 동작")
            break@outer
            //원하는 제어문을 빠져나갈 수 있도록 도와 준다
            // @별칭을 작성해주면 원하는 곳으로 돌아간다.
        }
    }

    //예제 2 while문을 사용해서 팩토리얼 계산
    // 숫자 입력 받기
    // 결과값 print~
    print("숫자를 입력하세요 : ")
    var num  = readLine()?.toInt()

    // num = 5 --> 5*4*3*2*1
    var fac : Int = 1
    while(true){
        // num ---> Int?
        // 방법 4) 조건식을 사용해서 null 값을 처리
        if(num!= null){
            fac *= num
            num--
        }
        // num이 0이 되면 while문을 break
        if(num == 0){
            break
        }
    }

    println("결과 값 : $fac")
}