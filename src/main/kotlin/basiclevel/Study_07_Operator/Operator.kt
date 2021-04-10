package basiclevel.Study_07_Operator

/*
일부를 제외한 대부분의 특수 문자를 연산자로 사용합니다.
주어진 값을 정해진 방식에 따라 계산하고 그 값을 되돌려줍니다.
코틀린은 연사자와 함수 두가지 방법을 제공하고 있습니다.

+a = a.unaryPlus() / 음 <-> 양
-a = a.unaryMinus() / 양 <-> 음
!a = a.not() / true <-> false

* */
class Operator {
}

fun main() {

    // 단항 연산자

    val a1 = 10
    val a2 = -10

    val p1 = +a1
    val p2 = +a2
    println("a1 : $a1 / p1 : $p1")
    println("a2 : $a2 / p2 : $p2")

    val m1 = -a1
    val m2 = -a2
    println("a1 : $a1 / m1 : $m1")
    println("a2 : $a2 / m2 : $m2")


    val b1 = true
    val b2 = false
    val r1 = !b1
    val r2 = !b2
    println("b1 : $b1 / b2 : $b2")
    println("r1 : $r1 / r2 : $r2")
    println("==================================================")

    // 증감 연산자
    var a3 = 10
    var a4 = 10
    a3++  // ==  a3 = a3 + 1
    a4--  // ==  a4 = a4 - 1
    println("a3 : $a3 / a4 : $a4")

    var a5 = 10
    var a6 = 10
    ++a5  // ==  a3 = a3 + 1
    --a6  // ==  a4 = a4 - 1
    println("a5 : $a5 / a6 : $a6")

    var a7 = 10
    var a8 = 10
    println("a7 : ${a7} / a8 : ${a8}")
    println("a7 : ${a7++} / a8 : ${a8--}")
    println("a7 : ${a7} / a8 : ${a8}")

    var a9 = 10
    var a10 = 10
    println("a7 : ${a9} / a8 : ${a10}")
    println("a9 : ${++a9} / a8 : ${--a10}")
    println("a7 : ${a9} / a8 : ${a10}")
    println("==================================================")


    val r11 = 10 + 3
    val r12 = 10 - 3
    var r13 = 10 * 3
    var r14 = 10 / 3
    var r15 = 10 % 3
    println("$r11 / $r12 / $r13 / $r14 / $r15")

    val r16 = 10..20 // 10 ~ 20 사이의 값을 관리해줍니다.
    println("$r16")
    for (num in r16) {
        print("$num / ")
    }

    println("==================================================")

    var q1 = 10
    var q2 = 10
    var q3 = 10
    var q4 = 10
    var q5 = 10

    q1 += 3
    q2 -= 3
    q3 *= 3
    q4 /= 3
    q5 %= 3
    println("$q1 / $q2 / $q3 / $q4 / $q5")
    println("==================================================")

    val n10 = 10
    val b10 = n10 == 10
    val b11 = n10 != 10
    println("$b10 / $b11")
}
