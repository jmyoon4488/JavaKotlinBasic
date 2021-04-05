package Study_35_OperatorOverloading

/*
* 코틀린은 기본적으로 클래스간의 기본 연산은 클래스 내에 정의된 연산 함수에 의해 수행됩니다.
* 연산 함수를 다르게 정의해서 사용할 수 있습니다.
*
* */

class StudyOperatorOverloading {
}

fun main() {
    val num1 = 100
    val num2 = 200
    val a1 = num1 + num2
    println("a1 : $a1")

    val a2 = num1.plus(num2)
    println("a2 : $a2")

    //
    val testObj1 = TestClass(100, 200)
    val testObj2 = TestClass(3000, 4000)

    // Plus -> `+` == class.plus()
    val testObj3 = testObj1 + testObj2
    println("obj3 a1 : ${testObj3.a1}")
    println("obj3 a2 : ${testObj3.a2}")

    // Minus -> `-` == class.minus()
    val testObj4 = testObj1 - testObj2
    println("obj4 a1 : ${testObj4.a1}")
    println("obj4 a2 : ${testObj4.a2}")
}

class TestClass(var a1: Int, var a2: Int) {
    operator fun plus(target: TestClass): TestClass {
        val r1 = this.a1 + target.a1
        val r2 = this.a2 + target.a2
        return TestClass(r1, r2)
    }

    operator fun minus(target: TestClass): TestClass {
        val r1 = this.a1 - target.a1
        val r2 = this.a2 - target.a2
        return TestClass(r1, r2)
    }
}