fun main() {

    // 1~10까지 숫자를 출력
    for(i in 1..10){
        print("$i ")
    }

    // 10~1까지 출력
    // in downTo
    for(i in 10 downTo 1){
        print("$i ")
    }

    // step : i의 증가 보폭을 정해 줄 수 있다!
    for(i in 1..20 step 3){
        print("$i ")
    }
}