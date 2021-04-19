package middlelevel.Study_10_Collections

/*
1. Array
  - get, set, size 등의 함수를 제공
  - 빈 배열 생성하기 : arrayOfNulls

2. List
  - 순서가 있는 데이터의 집합
  - 중복 허용
  - listOf(), mutableListOf()

3. Set
  - 순서가 없음
  - 중복 허용하지 않음

4. Map
  - 순서가 없음
  - 키 : 값 으로 데이터 저장
  - 키는 중복 불가능, 값은 중복 가능

- 코틀린은 클래스도 가변 클래스(mutable class) 와 불변 클래스(immutable class)가 있습니다.
  - kotlin.collection.List : 불변(immutable)
    - size, get 함수만 제공
  - kotlin.collection.MutableList : 가변(mutable)
    - size, get, set, add

5. Iterable 인터페이스

6. ArrayList

* */

class CollectionsType {
}

fun main() {
    // arrayOf() 함수를 이용해서 배열을 초기화 합니다.
    // 기본적인 배열은 타입을 지정하여 한가지 타입에 대한 데이터만 저장할 수 있습니다.
    // 단, 코틀린에서는 하나의 배열에 다양한 타입의 데이터를 저장할 수 있습니다.
    // 오류...?
//    var array1 = arrayOf(100, "aaa", true)
//
//    array1[0] = 10
//    array1[2] = "bbb"
//
//    println("${array1[0]} / ${array1[1]} / ${array1[2]}")
//    println("size : ${array1.size}")

    // 한종류의 타입만 저장할 수 있는 배열
    // Generic 은 <> 안에 타입을 명시해서 사용하는 것 입니다.
    var arrayInt = arrayOf<Int>(100, 200, 300)
    arrayInt[0] = 40 // ok
//    arrayInt[1] = "ccc" // error
    println("arrayInt[0] : ${arrayInt[0]}")

    // Generic 을 사용하지 않고 배열을 만드는 방법은 제공되는 함수를 사용하면 됩니다.
    // xxxArrayOf() : intArrayOf(), booleanArrayOf(), byteArrayOf(), charArrayOf(), longArrayOf() 등등
    var arrayInt1 = intArrayOf() // 매개변수가 없으면 빈 배열, 아니면 초기화 값을 입력해주면 됩니다.

    // ArrayOf() 함수는 Array 클래스 타입의 배열 객체를 만들어 반환해줍니다.
    // 따라서 Array 클래스로도 생성 가능합니다.
    var array2 = Array(3, { a -> a * 100 })
    println("array2 : ${array2.contentToString()}")
    // { a -> a * 100 }
    // fun a(a: Int): Int {
    //     return a * 100
    // }

    // 빈 배열 생성
    var array3 = arrayOfNulls<Int>(3) // Int 타입만 저장 가능
    
    // 다양한 타입
    var array4 = arrayOfNulls<Any>(3) // 모든 데이터 타입 저장 가능

    // 빈 문자열이 들어가 있는 배열 초기화 방법입니다.
    var array5 = Array<String>(3, {""})
    array5[0] = "aaa"
    array5[0] = "bbb"
    array5[0] = "ccc"

    // =======================================================================================================================
    
    val immutableList = listOf("aaa", "bbb")
    println("immutableList get(0), [0] : ${immutableList.get(0)} / ${immutableList[0]}")

    val mutableList = mutableListOf("aaa", "bbb")
    mutableList.add("ccc")
    mutableList.add("ddd")
    println("mutableList : ${mutableList.toString()}")
    // =======================================================================================================================

    val arrayList = ArrayList<String>()
    arrayList.add("aaa")
    arrayList.add("bbb")
    println("arrayList : $arrayList")
//    arrayList.set(1, "ccc")
    arrayList[1] = "ccc"
    println("arrayList : $arrayList")
    // =======================================================================================================================

    val immutableMap = mapOf<String, String>(Pair("key1", "val1"), "key2" to "val2")
    println("immutableMap key1 : ${immutableMap.get("key1")} / ${immutableMap["key1"]}")
    println("immutableMap : $immutableMap")
    // error - 불변
//    immutableMap.set()
    // =======================================================================================================================

    val immutableSet = setOf("aaa", "Bbb", "ccc", "aaa")
    println("immutableSet : ${immutableSet.size} / $immutableSet")
    // Set 은 데이터 접근시 get 또는 [0] 위치 정보를 사용하지 않습니다.
    // elementAt() 함수를 사용해서 데이터를 가져올 수 있습니다.
    println("immutableSet : ${immutableSet.elementAt(0)}")

    // =======================================================================================================================
    val set2 = mutableSetOf<Int>(3,3,1,2)
    set2.remove(2)
    set2.add(5)
    println("set2 : $set2")

    // hashset 의 경우에는 값의 hash code 순서에 따라 출력됩니다. (오름차순?)
    val set3 = hashSetOf<Int>(3,3,1,2)
    set3.remove(2)
    set3.add(5)
    println("set3 : $set3")
}