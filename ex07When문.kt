//ex07When문
fun main() {

    // 사용자로부터 국어, 영어, 수학, 과탐 점수 입력받는다
    // 국어 점수 >>
    // 영어 점수 >>
    // 수학 점수 >>
    // 과탐 점수 >>
    print("국어 점수 >> ")
    var num1 : Int = readln().toInt()
    print("영어 점수 >> ")
    var num2 : Int = readln().toInt()
    print("수학 점수 >> ")
    var num3 : Int = readln().toInt()
    print("과탐 점수 >> ")
    var num4 : Int = readln().toInt()

    var sum = num1+num2+num3+num4
    println("총합 : $sum" )
    var avg = sum/4
    println("평균 : $avg")


    // 평균을 구하고 , 총합을 구해서
    // Run 창에 평균 : 90 총합 : 350
    // 평균의 값에 따라서 등급 출력
    // 90이상 'A'
    // 80이상 'B'
    // 70이상 'C'
    // 60이상 'D'
    // 그 외 'F'
    // 출력형태 등급 : 'A'
    when(avg){
        in 90..100 -> println("등급 : A")
        in 80..89 -> println("등급 : B")
        in 70..79 -> println("등급 : C")
        in 60..69 -> println("등급 : D")
        else -> println(" 등급 : F")
    }
}