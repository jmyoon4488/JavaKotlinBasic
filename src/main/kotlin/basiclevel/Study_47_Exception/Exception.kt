package basiclevel.Study_47_Exception

import java.lang.NullPointerException
import java.lang.NumberFormatException

/*
- 예측이 가능한 오류들을 예외라고 합니다.
- 예외가 발생하면 코드의 수행이 중단됩니다.
- 예외 처리 : 예외가 발생했을 때 프로그램이 수행되는 것을 막고 예외 발생 시 동작해야 하는 코드를 수행시켜
              프로그램이 강제종료등 문제 없이 동작하게 하기 위한 처리
* */
class StudyFunction {
}

fun main() {

    // 나누기 오류 - ArithmeticException
//    val a1 = 10 / 0
//    println("이 부분은 실행되지 않습니다.")

    try {
        val a1 = 10 / 0  // 예외 발생시 다음 소스는 실행 되지 않고 catch 블록으로 넘어갑니다.
        println("이 부분은 실행되지 않습니다.")
    } catch (e: ArithmeticException) {
        println("수학적 오류가 발생했습니다.")
    }
    println("이 부분은 실행됩니다.")
    println("================================================================================")
    // null safe
    try {
//        val str: String? = null
//        println(str!!.length) // NullPointerException : null 인데 !! 으로 null 이 아니라고 잘못 지정함
//
//        val str2 = "test"
//        val a2 = str2.toInt()  // NumberFormatException
//        println("a2 : $a2")
    } catch (e: ArithmeticException) {          // 예외 별 exception 지정
        println("수학적 오류가 발생했습니다.")
    } catch (e: NullPointerException) {          // 예외 별 exception 지정
        println("null 오류가 발생했습니다.")
    } catch (e: NumberFormatException) {          // 예외 별 exception 지정
        println("숫자 변환 오류가 발생했습니다.")
    } catch (e: Exception) {           // 상위 Exception 으로 모든 exception 캐치
        println("오류가 발생했습니다.")
    }


    println("================================================================================")

    println("================================================================================")

    println("================================================================================")

    println("================================================================================")

    println("================================================================================")

    println("================================================================================")

    println("================================================================================")

}
