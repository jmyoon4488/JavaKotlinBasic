package middlelevel.Level01_Absract

/*
추상 클래스(Abstract Class) : 추상 함수를 포함하는 클래스
추상 함수(abstract method) : 미완성 함수(실행 영역-body 가 없는 함수) / 선언부만 있음

fun 함수명()  // 선언부
{             // body, 실행 영역 , 구현부

}

- 일반적으로 객체지향언어는 추상클래스와 추상함수를 모두 제공합니다.
- 코틀린에서는 추상클래스, 추상함수 뿐만 아니라 추상property 도 제공합니다.

- 추상 클래스 자체만으로는 객체 생성이 불가능 합니다.
- 추상 클래스를 상속받은 클래스를 만들고 추상 함수, 프로퍼티를 override 한 후
  상속받은 자식 클래스로 객체를 생성합니다.

-
* */

fun main() {

}

abstract class MiddleAbstractClass {
    abstract fun abstractFunction() // 추상 함수
    fun basicFunction() {           // 일반 함수

    }
//    abstract fun basicFunction2() {} // body 가 있으면 불가능

//    val a: String // error
    val a1: String = "Hello World!"     // 일반 프로퍼티
    abstract val abstractMember: String // 추상 프로퍼티
}

// 추상 함수를 포함한 클래스는 abstract 클래스로 선언해야 합니다.
//class Test01 {
//    abstract fun abstractFunction()
//}

// 최상위 함수에는 사용할 수 없습니다. 클래스 내부의 함수에서만 사용 가능.
//abstract fun abstractFunction2()

