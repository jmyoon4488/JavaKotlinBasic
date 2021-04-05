package Study_06_Function

/*
코드를 미리 작성해 놓고 필요할 때 불러다 쓰는 개념입니다.
자바의 경우 클래스에 메서드를 만들어 사용하지만
코틀린은 C언어 처럼 함수라는 개념을 제공하고 있습니다.
* */
class StudyFunction {
}

// main 함수는 코틀린 프로세스에서 자동으로 호출하도록 정해져 있는 함수입니다.
fun main() {
    // 기본 함수 호출
    printTest01()
    
    // 매개변수를 포함한 함수 호출
    // a1 , a2 : Intellij ide 의 기능. 매개변수 위치에 값이 들어가면 어떤 매개변수에 들어가는지 표시해줍니다.
    functionHasParameters(3, 4)
    var q1 = 4
    var q2 = 5
    // 매개변수 위치에 값이 아닌 변수가 들어가면 표시해주지 않습니다.
    functionHasParameters(q1, q2)
    // 매개변수 입력 시 함수에 전달받는 변수 이름을 지정하면 순서에 상관없이 입력 가능 합니다.
    functionHasParameters(a2 = 7, a1 = 4)
    // 함수의 매개변수에 기본값이 지정되어 있다면 생략하거나 매개변수 이름을 지정하여 원하는 매개변수만 입력 가능 합니다.
    functionHasDefaultParameters()
    functionHasDefaultParameters(4, 5)
    functionHasDefaultParameters(a2 = 6)
    functionHasDefaultParameters(a1 = 7)
    functionHasDefaultParameters(a2 = 8, a1 = 9)

    // return type
    println(functionHasReturnType(10, 10))

    // Unit 리턴 함수
    unitFunction()
    unitFunction2()

    // Overloading
    overloading()
    overloading("")
    overloading(3, 8.3)
    overloading(true, 1)

    // inner function
    outerFunction()
//    innerFunction() // outerFunction() 함수 안에서만 호출 가능
}

// 기본적인 함수 구조
/*
fun 함수이름(입력 파라미터: 파라미터 타입) : 함수 반환 타입 {
   함수 로직
}
*/
fun printTest01() {
    println("printTest01 Test")
}

/*
매개변수 = 함수 호출 시 전달해 주는 변수를 의미합니다.
호출 시 : 함수(매개변수)

fun 함수(매개변수) : 반환타입 {
   로직
}
* */
fun functionHasParameters(a1: Int, a2: Int) {
    println(a1 + a2)
}

fun functionHasDefaultParameters(a1: Int = 1, a2: Int = 2) {
    println(a1 + a2)
}

/*
- 반환 타입
함수의 결과를 반환하려면 반드시 반환 타입을 명시하고 로직의 결과를 반환 하는 위치에 return 문이 있어야 합니다.
반환 타입이 없는 함수는 Unit (생략 가능) 사용
fun 함수(매개변수) : 반환타입 {
   로직
   return 결과값
}
* */
fun functionHasReturnType(a1: Int, a2: Int) : Int {
    return a1 + a2
}

fun unitFunction() : Unit {
    println("Unit Function")
}

fun unitFunction2() {
    println("Unit Function - Unit 생략")
}

/*
- Function Overloading
fun overloading()
fun overloading(a1: String)
fun overloading(a1: Int, a2: Double)
fun overloading(a1: Boolean, a2: Int)
* */
fun overloading() = println("overloading()")
fun overloading(a1: String) = println("overloading(a1: String)")
fun overloading(a1: Int, a2: Double) = println("overloading(a1: Int, a2: Double)")
fun overloading(a1: Boolean, a2: Int) = println("overloading(a1: Boolean, a2: Int)")

/*
- 지역함수 : 함수를 정의한 함수 안에서만 호출 가능합니다.
fun 함수() {
    fun 지역함수() {
    }
}
* */
fun outerFunction() {
    println("outerFunction")
//    innerFunction() // 함수 정의 전에 호출 불가능
    fun innerFunction() {
        println("innerFunction")
    }
    innerFunction()
}