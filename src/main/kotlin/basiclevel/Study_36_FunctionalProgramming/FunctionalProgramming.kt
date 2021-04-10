package basiclevel.Study_36_FunctionalProgramming

/*
* 자바는 기본적으로 클래스를 설계하고 메서드를 만들어주고
* 클래스를 통해 객체를 생성해서 사용해야 합니다.
*
* 코틀린은 함수만 만들어서 사용할 수 있습니다. (함수형 프로그래밍)
* 코틀린에서 클래스는 정말 객체의 목적 자체만(데이터 및 기능 관리)을 위해 사용하고
* 그 외 작성하는 코드는 모두 함수로 만들어 사용하는게 일반적입니다.
* 코틀린은 함수 사용을 보다 편리하게 사용할 수 있도록 다양한 개념들을 제공합니다.
*
* - 매개 변수로 받은 값을 연산하여 반환하는 함수를 만들 때 한 줄로 생략해서 만들 수 있다.
* - 만약 수식을 계산하는 함수의 코드를 특정 부분에서만 사용한다면 람다로 만들어 사용할 수 있다.
* */

class FunctionalProgramming {
}

fun main() {
    val r1 = testFunction1(10, 20)
    println("testFunction1 : $r1")

    val r2 = testFunction2(10, 20)
    println("testFunction2 : $r2")

    val r3 = testFunction3(10, 20)
    println("testFunction3 : $r3")

    // 람다식을 담을 변수 : 람다식의 타입 = { 타입에 맞춘 입력 파라미터 -> 결과값(마지막줄) }
    val lambda1 : (Int, Int) -> Int = { a1: Int, a2: Int -> a1 + a2 }
    val r4 = lambda1(10, 20)
    println("lambda1 : $r4")

    // lambda1 에서 로직상의 타입 추론이 가능하므로 타입 생략 가능
    val lambda2  = { a1: Int, a2: Int -> a1 + a2 }
    val lambda3 : (Int, Int) -> Int  = { a1, a2 -> a1 + a2 }

    val r5 = lambda2(51, 52)
    println("lambda2 : $r5")

    val r6 = lambda3(61, 62)
    println("lambda3 : $r6")

    val lambda4 : (Int, Int) -> Int  = { a1, a2 ->
        val r1 = a1 + a2
        val r2 = a1 - a2
        r1 * r2
    }
    println("testFunction4 : ${testFunction4(10, 20)}")
    println("lambda4 : ${lambda4(10, 20)}")
}

fun testFunction1(a1: Int, a2: Int) : Int {
    return a1 + a2
}

// 입력 파라미터와 반환 파라미터가 같아서 간략히 작성 가능
fun testFunction2(a1: Int, a2: Int) : Int = a1 + a2

// 입력 파라미터의 연산 결과를 추측 가능해서 반환 타입을 생략 가능
fun testFunction3(a1: Int, a2: Int) = a1 + a2

fun testFunction4(a1: Int, a2: Int): Int {
    val r1 = a1 + a2
    val r2 = a1 - a2
    return r1 * r2
}