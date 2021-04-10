package basiclevel.Study_39_ExtensionFunction

/*
기존 클래스에 임시적으로 새로운 함수를 추가하고자 할 때 사용합니다.
확장함수를 전역으로 구현하지 않고 특정 클래스 안에서 구현해 놓으면
해당 클래스 안에서만 확장함수를 사용할 수 있습니다.
디컴파일을 통해 소스를 확인해보면 객체를 매개변수로 넘겨 로직을 수행하는 방식입니다.
* */
class ExtensionFunction {
}

fun main() {
    val str1 = "test1"
    println("${str1.toUpperString()}")

}

fun String.toUpperString(): String {
    return this.toUpperCase()
}