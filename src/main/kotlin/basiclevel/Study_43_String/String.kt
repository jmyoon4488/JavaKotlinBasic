package basiclevel.Study_43_String

/*
Java 와 동일하게 String 클래스로 관리합니다.
코틀린은 추가로 몇가지 method 를 더 제공합니다.
* */
class String {
}

fun main() {

    // 코틀린은 문자열을 배열로 관리합니다. (문자열은 불변형)
    val str1 = "hello"
    println("str1[0] : ${str1[0]}")
    println("str1[1] : ${str1[1]}")

    // error
//    str1[0] = 'w'

    // substring
    // compareTo : 각 문자열의 unicode 값을 비교해서 판단합니다. 0 : 같음, -1,1 : 다름
    // split
    println("================================================================================")
    val str2 = str1.substring(1..3)
    println("str2 : $str2")

    println("================================================================================")
    var str3 = "Hello World"
    var str4 = "hello world"
    println("compare : ${str3.compareTo(str4)}")
    println("compare ignore : ${str3.compareTo(str4, ignoreCase = true)}")
    println("compare equals : ${str3.contentEquals(str4)}")

    println("================================================================================")
    var str5 = "ab cd ef gh"
    val r1 = str5.split(" ")
    println("r1 : $r1")

    println("================================================================================")
    //
    // String 은 불변형이므로 + 연산자로 문자열을 계속 합치면 객체가 계속 생성됩니다.
    // StringBuffer 는 문자열을 직접 관리하여 객체가 계속 생성되는 것을 막을 수 있습니다.
    // 객체가 계속 생성되는 메모리 낭비를 막을 수 있는 대신 원본 문자열을 유지할 수 없습니다.
    val str6 = "abc"
    val str7 = str6 + "def"
    println("str6 : $str6")
    println("str7 : $str7")

    val buffer1 = StringBuffer()
    buffer1.append("abc")
    buffer1.append("100")
    buffer1.append("22.22")
    println("buffer1 : $buffer1")
    buffer1.insert(2, "test")
    println("buffer1 insert : $buffer1")
    buffer1.delete(2,5)
    println("buffer1 delete(2,5) : $buffer1")

    println("================================================================================")
}
