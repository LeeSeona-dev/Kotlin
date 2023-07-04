import java.util.Scanner
import kotlin.random.Random


fun main() {
    // Scanner sc = new Scanner(System.in);
    // 자료형 레퍼런스 변수명 = 생성자;

    // val / var 변수명 : 자료형 = 데이터값
   // val sc : Scanner = Scanner(System.`in`)
    val rd : Random = Random //import작업 필요
    // 자동완성 ---> 자동 import
    val num1 : Int = rd.nextInt(50)+1
    val num2 : Int = rd.nextInt(50)+1

    //kotlin에서는 서로 다른 자료형끼리의 연산이 불가능
    println("$num1 +$num2 = ?")
    print("Enter the Answer : ")
    // 내부적으로 설계되어있는 입력기능
    var answer = readLine()?.toInt() //String?
    // Int로 바꿔서 정답인지 아닌지 판단
    if(num1+ num2 == answer){
        println("정답입니다.")
    }else{
        println("오답입니다.")
    }
    //예제2
    print("Enter the number :")
    //val number = readLine()?.toInt() //Int?
    var number = readln().toInt() //Int
//    if(number > 0){
//        println("양수 값")
//    }else if(number == 0){
//        println("0")
//    }else{
//        println("음수 값")
//    }
    var result = if(number < 0) "음수 값 " else if(number> 0 ) "양수 값"
    else  "0입니다."
    println(result)
    // 코틀린에서는 null값이 발생하는 경우에 대해 조치를 취해줘야함
    // if문을 변수에 넣을 때에는 모든 조건을 만족하지 않았을때도 생각해야함
    // else문으로 닫아줘야한다!

}