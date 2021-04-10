package basiclevel.Study_40_InFixFunction

/*
함수를 연산자처럼 사용할 수 있는 함수입니다.
* */
class InfixFunction {
}

fun main() {

    //      this add a1
    val r1 = 100 add 50

    val r2 = 100
    r2.add1(50)
}

inline fun Int.add1(a1: Int) : Int {
    return this + a1
}

infix fun Int.add(a1: Int) : Int {
    return this + a1
}