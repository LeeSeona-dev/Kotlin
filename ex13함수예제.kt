//최상위함수
fun main() {
    var num1 = 24
    var num2 = 13
    val result = largerNumber(num1, num2)
    println(result)

}
//예제2. 두 수 중에서 더 큰수를 반환해주는 함수 만들기
fun largerNumber(num1:Int, num2:Int):Int {
    if(num1>num2){
        return num1
    }else if(num2>num1){
        return num2
    }else{
        return 0
    }
} //최상위 레벨 함수