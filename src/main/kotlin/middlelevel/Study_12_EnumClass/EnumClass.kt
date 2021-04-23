package middlelevel.Study_12_EnumClass

/*
- Enum Class (열거형 클래스, 열거형 상수)
  - 하나의 상수형 의미에 여러가지 반환 값을 가질 수 있도록 열거해놓는 클래스 입니다.

- Enum 클래스는 기본적으로 name, ordinal 프로퍼티를 제공합니다.
  - name : 열거상수의 문자열을 표현
  - ordinal : 열거한 순서를 나타내는 인덱스 번호

- values(), valuesOf() 함수를 제공합니다.
  - values() : Enum 클래스에 있는 상수들을 리스트로 반환해주는 함수입니다.
  - valueOf(String) : 매개변수로 들어온 문자열과 동일한 열거형 상수를 반환해 줍니다.

- enum class 안에 있는 열거 상수는 사실상 객체입니다.
  - 열거 상수는 enum class 를 상속받는 서브 클래스 입니다.
  - 서브 클래스 이름이 없는 익명 클래스이기도 합니다.

---
enum class Mode { SELECTION } <= 이런 형식으로 선언 했다면...
SELECTION 은 Mode 클래스를 상속받는 하위 클래스 입니다.
따라서, enum class Mode(val str: String) 이런식으로 생성자를 추가해 선언한다면
하위 클래스는 상위 클래스의 생성자에 맞추기 때문에 SELECTION("str") 형태로 표현하는 겁니다.
---
* */

class EnumClass {
}

fun main() {
    val mode = Mode.PEN
    when (mode) {
        Mode.PEN -> println("PEN")
        Mode.ERASER -> println("ERASER")
        Mode.PAINT -> println("PAINT")
        Mode.SHAPE -> println("SHAPE")
        Mode.SELECTION -> println("SELECTION")
    }

    println("name : ${mode.name} / ordinal : ${mode.ordinal}")
    // =======================================================================================================================

    val modeValues = Mode.values()
    println("values : $modeValues")
    // foreach
    modeValues.forEach { eachVal ->
        println("modeValue foreach : $eachVal")
    }
    // for in
    for (value in modeValues) {
        println("modeValue for-in : $value")
    }

    // =======================================================================================================================
    val modeValueOf = Mode.valueOf("PEN")
    println("valueOf(PEN) : $modeValueOf")
    println("check : ${modeValueOf == Mode.PEN}")
    println("modeValueOf name / ordinal : ${modeValueOf.name} / ${modeValueOf.ordinal}")

    val direction = Direction.SOUTH
    println("direction num, str : ${direction.num} / ${direction.str}")

    direction.str = "남쪽"
    direction.num = 100
    println("direction num, str : ${direction.num} / ${direction.str}")
}

enum class Mode {
    PEN,
    ERASER,
    PAINT,
    SHAPE,
    SELECTION
}

enum class Direction(var num: Int, var str: String) {
    NORTH(1, "북"),
    SOUTH(2, "남"),
    EAST(3, "동"),
    WEST(4, "서");

    // enum class 안에도 열거 상수 외에 다른 변수를 사용할 수 있습니다.
    // 다만 열거 상수와 그 외 맴버변수를 구분하기 위해서는 마지막 열거상수를 세미콜론(;) 으로 마쳐야 합니다.
    val data: Int = 0
}

enum class Test(var num: Int) {
    TEST1(1) {
        override val absData: Int = 0
        override fun enumFunc() {
            println("Test / TEST1 / enumFunc")
        }
    },
    TEST2(2) {
        override val absData: Int = 0
        override fun enumFunc() {
            println("Test / TEST2 / enumFunc")
        }
    };

    // abstract 변수 또는 상수는 열거상수에서도 override 해주어야 합니다. (열거상수는 부모 클래스를 상속받은 익명 클래스이므로)
    abstract val absData: Int
    abstract fun enumFunc()
}