package middlelevel.Study_06_ConstAndLateinit

/*
- const : Inline 함수와 비슷하게 컴파일 시 const 변수가 사용된 위치에 const 변수에 저장된 값으로 대체해서 컴파일 됩니다.
- const 는 프로그램 어디서나 사용할 수 있는 변수에 붙이거나 object 의 프로퍼티에 붙일 수 있습니다.
  - final static 과 비슷.
- const 가 붙은 변수는 리터럴로 이루어진 표현식만 저장 가능합니다.
- 코틀린에서는 리터럴만 와야하는.. 요소가 있습니다. const 변수가 리터럴로 대체되기 때문에 이러한 경우 사용합니다.
- const 키워드는 val 변수에만 붙일 수 있습니다.

2. lateinit : 프로퍼티의 초기화를 유예하는 키워드 입니다.
- 클래스의 프로퍼티는 반드시 선언과 동시에 초기화해야하거나 init 블록 안에서 초기화 해야합니다.
- 이러한 강제성은 사용상 불편한 점이 많이 때문에 유예 기능을 지원합니다.
- lateinit 키워드는 var 변수에만 붙일 수 있습니다.
- lateinit 키워드를 사용하지 않고 기본값이나 쓰레기값을 넣어서 사용할 수는 있지만
  초기화를 미루고 사용시 강제로 초기화 하게 하므로써 프로그램 동작 중간에 어떠한 변화로 인해
  불필요하거나 예상하지 못한 값으로 초기화되는 불상사를 막을 수 있습니다.

* */

class ConstAndLateInit {

}

fun main() {
    println("str1 : $str1")
    println("AA.ab : ${AA.ab}")
    println("str2 : $str2")

    val rectangle = Rectangle()
    // error - lateinit 으로 유예한 변수를 초기화 하지 않아서 오류가 발생합니다.
//    println("width : ${rectangle.width}")
//    println("height : ${rectangle.height}")
//    println("size : ${rectangle.size}")

    // 유예한 변수를 늦게 초기화 시킬 수 있습니다.
    rectangle.v1 = Point(4,3)
    rectangle.v2 = Point(2,1)
    println("width : ${rectangle.width}")
    println("height : ${rectangle.height}")
    println("size : ${rectangle.size}")
}

val str1 = "normal str"
const val str2 = "const val"
object AA {
    val ab = "AA ab"
}

// error - 객체는 불가능 하고 리터럴만 가능합니다.
//const val aa: BB = BB()
class BB {
}

class Point(val x: Int, val y: Int)
class Rectangle {
    // 기본적으로는 생성과 동시에 초기화 해야하지만..
//    var v1: Point = Point(1,2)
//    var v2 = Point(3, 4)
    // 초기화를 유예해줍니다.
    lateinit var v1: Point
    lateinit var v2: Point

    val width get() = v1.x - v2.x
    val height get() = v1.y - v2.y

    val size get() = width * height
}