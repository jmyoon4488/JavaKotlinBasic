package basiclevel.Study_04_BasicSyntax

/*
* 주석은 자바와 동일
* print(), println() 제공
* 세미콜론(;) 은 선택사항
* */

class BasicSyntax {
}

fun main() {

    // 한줄 주석
    /*
    * 여러줄 주석
    * 여러줄 주석
    * 여러줄 주석
    */
    // 코틀린이 자바 파일로 변환된때 주석은 모두 제거된다. ( .kt -> .java )

    // print()
    print("한줄 문자열1")
    print("한줄 문자열2")
    print("한줄 문자열3")

    // println()
    println("줄바꿈 문자열1")
    println("줄바꿈 문자열2")
    println("줄바꿈 문자열3")

    // 문자열 템플릿 - Kotlin String Templates
    // 문자열 안에서 변수, 객체, 함수 등에 접근이 가능합니다.
    // chain 이 있는 변수, 객체, 함수 등의 경우 중괄호{} 로 감싸주어야 합니다.
    val testClass = TestClass()
    val test1 = 4
    println("자바 형식 : " + 3)
    println("코틀린 형식 : ${6}")

    println("코틀린 형식 : $test1")
//    println("코틀린 형식 : $testClass.testFun()") // error - 중활호 필요
    println("코틀린 형식 : ${test1}") // chain 이 없는 변수나 객체의 경우 중괄호{} 를 생략 할 수 있지만 안전하게 씁시다.
    println("코틀린 형식 : ${testClass.testFun()}")
}

class TestClass() {
    fun testFun(): Int {
        return 5
    }
}