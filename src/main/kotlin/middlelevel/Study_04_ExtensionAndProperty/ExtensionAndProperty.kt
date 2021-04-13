package middlelevel.Study_04_ExtensionAndProperty

/*
- 확장 함수 & 확장 프로퍼티
1. 확장 함수
  - 클래스 외부에서 멤버함수를 추가할 수 있도록 코틀린에서 제공해주는 내장함수 입니다.
  - String 클래스는 open 키워드가 붙어있지 않아서 상속받지 못하고, custom 할 수 없습니다. (멤버함수 추가 불가능)
  - 코틀린의 내장된 클래스는 사용자가 마음대로 멤버함수를 추가할 수 없습니다.
  - 확장함수를 사용하면 상속 없이 클래스 외부에서 멤버함수를 추가할 수 있습니다.

    fun {함수를 주입할 클래스명}.{함수명}() : {반환타입} {
        // body
    }

  - 리시버 타입의 멤버 함수(프로퍼티)에 접근하려면 this 키워드를 사용하면 됩니다.
    단, 멤버가 private, protected 인 경우에는 접근 불가능 합니다.
  - checkNumber() 함수는 String 클래스 내부에 있는 함수가 아니고 외부에서 주입한 함수입니다.
  - 이렇게 주입하면 마치 String 클래스 내에 있는 함수를 사용하는 것 처럼 사용할 수 있습니다.
  - 만약 주입한 함수명과 멤버 함수명이 같을 경우에는 주입한 확장 함수는 감춰지게 됩니다.
    즉, 확장함수가 아니라 멤버함수만 호출됩니다. 오류도 발생하지 않습니다. (확장 함수의 의미가 없음)

2. 확장 프로퍼티
  - 확장 프로퍼티에는 field 식별자가 존재하지 않습니다. 즉, field 식별자는 사용 불가능합니다.

* */
class ExtensionProperty {
}

fun main() {
    println("check : ${"235234a".checkNumber()}")
//    println("check : ${"3432".isNullOrEmpty()}")

    println("isLarge property : ${"1234".isLarge}")
    println("isLarge property : ${"123456".isLarge}")
}

// 문자열이 숫자로만 이루어져있는지 판단하는 함수
fun String.checkNumber(): Boolean {
    for (ch in this) {
        if (ch !in '0'..'9') return false
    }
    return true
}

fun String.isNullOrEmpty(): Boolean {
    for (ch in this) {
        if (ch !in '0'..'9') return false
    }
    return true
}

// Extention Properties
val String.isLarge: Boolean
    get() = this.length >= 5