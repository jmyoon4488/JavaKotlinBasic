package basiclevel.Study_41_HighOrderFunction

/*
매개변수로 함수를 받거나 함수를 반환하는 함수를 고차 함수라고 합니다.
* */
class HighOrderFunction {
}

fun main() {

    val f1 = fun(x1: Int, x2: Int) : Int {
        return x1 + x2
    }

    testFunction(100,20, f1)
    testFunction1(f1,20, 100)

    //
    testFunction(200, 300, fun(x1: Int, x2: Int) : Int {
        return x1 + x2
    })
    testFunction1(fun(x1: Int, x2: Int) : Int {
        return x1 + x2
    }, 200, 300)

    //
    testFunction(300, 400) { x1: Int, x2: Int -> x1 + x2 }
    testFunction1({ x1: Int, x2: Int -> x1 + x2 }, 300, 400)

    //
    testFunction4({it + 10}, 100)
}

// 매개변수가 없고 반환타입이 없는 m1 정의
fun testFunction0(a1: Int, a2: Int, m1:() -> Unit) {

}

// 매개변수로 함수를 받는 함수
fun testFunction(a1: Int, a2: Int, m1:(Int, Int) -> Int) {
    val r1 = m1(a1, a2)
    println("r1 : $r1")
}

fun testFunction1(m1:(Int, Int) -> Int, a1: Int, a2: Int) {
    val r1 = m1(a1, a2)
    println("r1 : $r1")
}

// 함수를 반환하는 함수
fun testFunction2() : (Int, Int) -> Int {
    return fun(x1: Int, x2: Int) : Int {
        return x1 + x2
    }
}

// 람다(함수)를 반환하는 함수 (추천)
fun testFunction3() : (Int, Int) -> Int {
    return {x1: Int, x2: Int -> x1 + x2}
}

// 함수가 매개변수를 하나만 받을 경우 생략하고 it 으로 사용할 수 있습니다.
fun testFunction4(f1: (Int) -> Int, x1: Int) {
    f1(x1)
}

// 고차함수의 매개변수로 함수가 가장 마지막에 입력될 경우 호출 시 편하고 가독성 좋게 호출하는 방법을 지원한다
fun testFunction5(a1: Int, a2: Int, m1:(Int, Int) -> Int) {
    val r1 = m1(a1, a2)
    println("r1 : $r1")
}