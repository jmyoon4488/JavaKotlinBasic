package Study_37_AnonymousFunction

class AnonymousFunction {

}

fun main() {
    // error
//    val test1 = testFunction1

    // 익명함수 - 이름이 없기 때문에 변수에 담지 않으면 접근할 수 있는 방법이 없다.
    val testFun1 = fun() {
        println("is testFun1")
    }
}

fun testFunction1() {
    println("testFunctions1")
}