fun main() {
    //main
    // python dictionary, Json --> key, value
    val K = mutableMapOf<Int, String>()
    // 데이터를 입력하는 기능 : put
    // put : key, value
    K.put(1,"예진")
    K.put(2,"자연")
    // key값만 확인해보기
    // value값만 확인해보기
    // key와 value 확인해보기
    for( i in K){
        println(i)
        println(i.key)
        println(i.value)
    }
    // Set : 중복되는 데이터를 없애주는 기능을 가지고 있음
    val list = mutableListOf("a","b","c")
    // add
    list.add("d")
    list.add("c")
    list.add("a")
    print(list)

}