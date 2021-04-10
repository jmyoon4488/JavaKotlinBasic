package basiclevel.Study_38_InlineFunction

/*
함수 내용을 컴파일 시 호출 위치에 복사해서 구현해 놓는 방식입니다.

fun main() {
    test01()
    test02()
}

inline fun test01() {
    println("test01")
}

inline fun test02() {
    println("test02")
}
---------------------------------------------------------
컴파일시 아래와 같이 변경됩니다.

fun main() {
    println("test01")
    println("test02")
}

----------------------------------------------
극한의 성능을 요구할때 사용합니다.
함수의 이동이 없기 때문에 소스의 중복이나 양은 늘어나지만
이동에 드는 코스트가 줄어들어 약간의 성능이 상승합니다.
게임 같은 개발에 주로 사용됩니다.

* */
class InlineFunction {
}

fun main() {
    test01()
    test02()
}

inline fun test01() {
    println("test01")
}

inline fun test02() {
    println("test02")
}
