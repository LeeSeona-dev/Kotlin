fun main() {

    // Array() 사용하기
    // 1) Array() 생성하기
    // var array = Array(사이즈, {들어갈 데이터 값})
    // var array = Array(사이즈){들어갈 데이터 값}

    // 1-1) 사이즈는 10이고 각 자리에는 지금 빈값이라고 할 수 있는
    //      0이 들어가 있는 상태
    var array1 = Array(10){0}

    for(i in array1){
        println("$i")
    }
    // 1-2) 사이즈는 10이고 각 자리에 인덱스값 *3의 값이 들어가도록
    var array2 = Array(10){i -> i*3}
    // 1-3) 사이즈는 5이고 각자리에는 공백이 들어가게 만들자!
    var array3 = Array(5){" "}

    // 2) Array에 들어갈 타입을 지정하고 싶을 경우
    // <> : 제네릭
    var array4 = Array<Int> (10){0}
    // 코틀린이 제공하는 기본타입 배열을 사용 할 수 있음
    var array5 = IntArray(10){0}
    // ByteArray, CharArray
    // set(index, value)
    array4.set(0,1)
    array4.set(1,5)
    // get(index)
    println(array4.get(1))

    // arrayOf() 사용하기
    // : 배열을 특정값으로 초기화를 시킬때 사용
    // int[] arr = {1,2,3,4}
    var arr1 = arrayOf(1,"가", "a", 3.145, true)

    // 특정 타입을 지정하지 않은 상태로 arrayOf를 생성하면
    // 어떤 값이 들어가도 상관이 없다!

    // 특정 데이터 타입을 지정할 때 <> 제네릭 기호 사용
    var arr2 = arrayOf<String>("가","나")

    // 데이터타입이 이미 지정이 되어있는 arrayOf
    var arr3 = intArrayOf(1,3,5,6)

    // arrayOf를 비어있는 상태로 만들고 싶다면
    arrayOfNulls<String>(10)

    // mutableList만들기 : 가변배열
    // ArrayList<>();
    //val mutable = MutableList(5, {0})
    val list : MutableList<Int> = mutableListOf(1,2,3,4,5)
    // add(value), add(index, value)
    list.add(5)
    list.add(2,6)

    //clear : 전체 내용 삭제
    // list.clear()

    // remove
    list.remove(3)
    // index값을 통해서 삭제하는 건 불가능
    // 배열에 해당 요소값을 찾아 삭제하는 기능을 가지고 있음
    // removeAt : 인덱스 값을 입력받아서 해당 요소를 제거
    list.removeAt(2)

    // remainAll : 공통된 요소를 제외한 나머지 삭제
    var list2 = listOf<Int>(1,2)
    list.retainAll(list2)
    //1과 2를 제외한 나머지 요소들은 모두 삭제

}