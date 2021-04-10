package basiclevel.Study_05_VariableAndType

class VariableAndType {
}

fun main() {
    /*
    리터럴 : Literal 은 변수 선언 없이 지정한 값 그 자체를 의미합니다.

    정수 : 100 , 100L , 100_000_000
    실수 : 1.1 , 2.2F
    문자 : 'A' , 'B'
    문자열 : "asdf"
    불리언 : true , false
    * */

    // 정수 리터럴
    println(100)

    // 100억의 경우 Int 범위를 넘어가는데...?
    println(10000000000) // 자동으로 Long 캐스팅 - long var3 = 10000000000L;

    // 숫자 가독성 높이기 위해 underbar 사용 가능
    println(123_456_789)

    // 실수 리터럴
    println(11.11) // 8byte 사용
    println(22.22f) // 4byte 사용

    // 문자 리터럴 - character
    println('A')
    println('가')

    // 문자열 리터럴
    println("sentence")

    // 논리 리터럴 (불리언)
    println(true)
    println(false)

    // Raw string -> """ddd"""
    // Nothing : 함수가 정상적으로 끝나지 않는다를 의미
    // Unit : void 와 같은 의미

    // Raw string - 디컴파일시 \n 형태로 변환됨
    println("가나다라\n마바사아\n자차카타\n파하")
    println("""
        가나다
        라마바
        사아자
        차카타
        파하""".trimIndent())

    /*
    코틀린의 모든 자료형은 기본형이 아닌 Wrapper Class 로 감싼 자료형 클래스 형태로 사용한다.
    (기본 자료형의 경우 소문자로 사용, 클래스 형태이므로 첫문자가 대문자임)
    - 정수 : Long(8) , Int(4) , Short(2) , Byte(1)
    - 부호가 없는 정수형 : ULong(8) , UInt(4) , UShort(2) , UByte(1)
    - 실수 : Double(8) , Float(4)
    - 논리 : Boolean(1)
    - 문자 : Char(2)
    - 문자열 : String
    * */

    /*
    변수 선언 시 var , val 두가지 키워드 사용
    var : 변수 - 초기화 후 값 변경 가능
    val : 상수 - 초기화 후 값 변경 불가능
    {var / val} 변수명 : 타입 = 값
    타입 생략 시 변수 초기화를 바로 해준다면 타입 생략 가능 (타입 추론 기능)
    * */
    var test1: String = "qwer"
    test1 = "asdf"
    val test2 = "zxcv"
//    test2 = "bnmg" // error - val 이므로 변경 불가

    // 코틀린은 타입 추론이 가능하다면 타입을 생략하는 방향을 추천합니다.
    var t1: Int = 2 // 상관없지만...
    var t2 = 3 // 추천!

    /*
    - null 허용 변수
    변수 선언 시 타입? <- 문자로 표기
    nullable 변수를 notNull 변수로 변경 가능 = 변수!! <- 느낌표 2개 사용
    * */
    var nullTest1: String? = null // null 가능
    var nullTest2: String? = "test2" // null 아니어도 가능

//    var notNullTest: String = null // error - 타입에 ? 가 없으므로 무조건 null 불가능
    var notNullTest: String = "test"

//    notNullTest = nullTest1 // not null 변수에 nullable 변수 대입 불가능 하지만...
    notNullTest = nullTest1!! // 느낌표 두개로 해당 변수가 절대로 null 이 아니라고 표시해주면 대입 가능
    // 단, 변수!! 으로 사용할 때 로직으로 확실하게 null 이 아님을 보장해주지 못하면 NullPointException 발생

    nullTest1 = null
    notNullTest = nullTest1!! // <- nullTest 는 null 이지만 개발자가 절대 null 이 오지 않을거라고 생각해서 !! 붙였으나
                              // 로직상의 빈틈으로 null 이 오게 되면 exception 발생
}