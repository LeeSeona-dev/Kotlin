fun main() {

    //예제 : step을 사용하는 for문 활용해 1~100까지 홀수 합, 짝수합 구하기
    var sum1 : Int = 0
    var sum2 : Int = 0
    for(i in 1..100 step 2){
        sum1 += i
    }
    println("홀수의 합 : $sum1")
    for(i in 2..100 step 2  ){
        sum2 += i
    }
    println("짝수의 합 : $sum2")
}