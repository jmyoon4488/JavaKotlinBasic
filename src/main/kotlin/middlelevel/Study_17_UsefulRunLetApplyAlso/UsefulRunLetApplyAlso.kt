package middlelevel.Study_17_UsefulRunLetApplyAlso

import middlelevel.Study_14_Lambda.Student

/*
- 유용한 함수
 1. run
 2. let
 3. apply
 4. also
 5. with
 6. when

- run() 함수 사용 형태
  1. 람다함수를 실행하고 그 결과를 바로 어딕 위한 목적으로 하용하는 경우
    - inline fun <R> run(block: () -> R): R
  2. 객체의 멤버에 접근하기 위해서 사용하는 경우
    - inline fun <T, R> T.run(block: T.() -> R) : R

- 객체의 여러 멤버(함수, 변수)에 접근할 때에도 유용하게 사용할 수 있습니다.
- run, let, apply, also : 비슷한 용도의 함수들

- let, also : 함수자신을 호출한 객체를 람다함수의 매개변수로 전달하는 함수

- with : run 함수와 사용 방식은 약간 다르지만 목적은 동일합니다.

* */

class UsefulRunLetApplyAlso {
}

fun main() {
    // run 함수
    val result1 = run {
        println("call lambda")
        10 * 10
    }
    println("result1 : $result1")

    val student = Student()
    student.name = "student"
    student.age = 20
    student.speak()
    student.getInfo()

    val student2 = Student()
    val runFunc = student2.run {
        name = "student2"
        age = 30
        speak()
        getInfo()
        "run Func lambda return"
    }
    println(runFunc)

    // =======================================================================================================================
    // let
    val student3 = Student()
    val letReturn = student3.let {
        it.name = "student3"
        it.age = 40
        it.speak()
        it.getInfo()
        ""
    }
    println("letReturn : $letReturn")

    // =======================================================================================================================
    // apply
    val student4 = Student().apply {
        name = "student4"
        age = 15
        speak()
        getInfo()
    }

    // =======================================================================================================================
    // also
    val student5 = Student().also {
        it.name = "student5"
        it.age = 10
        it.speak()
        it.getInfo()
    }

    // =======================================================================================================================
    // with
    val a = 3
    val b = 7
    with(a * b - a + b) {
        println(this)
    }

    // =======================================================================================================================

}