package middlelevel.Study_05_CompanionAndInline

/*
1. object 클래스 : 프로그램 전체에서 공유 가능한 유일한 객체를 만들때 사용합니다. (싱글톤 패턴)
  - 클래스 생성 작업 없이 바로 클래스 식별자를 통해 프로퍼티 및 함수에 접근 하거나 실행할 수 있습니다.
  
2. Companion 객체
  - Companion Object 는 자바에서는 static 키워드를 붙인것과 동일합니다.
  - 일반적인 클래스 내에 모든 내용을 Companion Object 안에 구현하면 Object 클래스로 만든것과 동일합니다.

3. Inline 함수 : 함수 호출문이 함수 속에 들어있는 코드로 대체되는 것을 의미합니다.
  - 인라인 함수는 함수 호출간의 실행흐름 이동을 없앨 수 있으므로 약간의 성능 향상을 개선할 수 있습니다.
  - 단 컴파일 시 모든 인라인 함수가 구현부 코드로 대체되기 때문에 함수 재활용이 일어나지 않습니다.
  - 따라서 인라인 함수 구현부가 지나치게 크면 전체 코드양이 비대해지고 오히려 성능 저하를 일으킬 수 있습니다.
  - 인라인 함수는 구현부의 코드 양이 적고, 빈번하게 호출되는 함수에만 적용하는 것이 바람직 합니다.

* */

class CompanionAndInline {
}

fun main() {
    // error - object 는 생성자가 없습니다.
//    val singleton = SingletonClass()

    SingletonClass.info()

    SingletonClass.name = "222"
    SingletonClass.age = 2
    SingletonClass.info()

    // error - 생성자가 private 라서 기본으로 생성 불가능 합니다.
//    val person = Person()
    //
    // create() 라는 Person 클래스 내부의 동반객체 안에 있는 함수는 object 클래스 처럼 클래스 식별자로 바로 접근이 가능하며
    // 해당 create() 함수는 클래스 내부이므로 private 생성자 접근이 가능하기 때문에 객체 생성이 가능합니다.
    // person1 과 person2 는 다른 객체이지만 생성에 사용한 Person 의 Companion Object 객체 내부는 동일한 하나의 객체만으로 사용됩니다.
    val person1 = Person.create()
    println("person1 : ${Person.cnt}")
    val person2 = Person.create()
    println("person2 : ${Person.cnt}")

    // inline function
    inlineFunction() // 디컴파일 시 이 위치에 함수 대신 인라인 함수의 구현부로 대체되어 컴파일 됩니다.
    // inlineFunction() -> println("inline function")
}

object SingletonClass {
    var name: String = "111"
    var age: Int = 1
    fun info() {
        println("name : $name / age : $age")
    }
}

// 생성자에 접근제한자를 붙이려면 클래스 선언 시 생성자를 생략 할 수 없습니다.
// 기본 클래스 선언
//class Person constructor() {
//}
// 기본 생성자를 생략한 클래스 선언
//class Person {
//}

// 접근제한자 붙인 생성자를 포함한 클래스 선언
// Person 클래스는 동반자 객체로 인식됩니다.
class Person private constructor() {
    companion object { // 동반자 객체를 선언
        fun create(): Person {
            cnt += 1
            return Person()
        }

        var cnt = 0
            private set
    }
}

inline fun inlineFunction() {
    println("inline function")
}