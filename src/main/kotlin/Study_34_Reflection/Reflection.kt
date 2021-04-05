package Study_34_Reflection

import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.primaryConstructor

fun main() {
    // 시작
    println("Reflection")

    // --------------------------------------------------------------
    // 클래스 타입
    println(String::class)
    println(String::class.java)

    val kotlinClassType: KClass<String> = String::class
    val javaClassType: Class<String> = String::class.java
    println("[kotlin] 기본 클래스 출력 : $kotlinClassType")
    println("[java] 기본 클래스 출력: $javaClassType")
    println("--------------------------------------------------------------")

    val str1 = "Hello"
    val kotlinClassType1: KClass<out String> = str1::class
    val javaClassType1: Class<out String> = str1::class.java
    println("[kotlin] out 으로 받아야함(Generic) : $kotlinClassType1")
    println("[java] out 으로 받아야함(Generic): $javaClassType1")
    println("--------------------------------------------------------------")

    val kotlinClassType2: KClass<*> = str1::class
    val javaClassType2: Class<*> = str1::class.java
    println("[kotlin] 모든 타입 다받음 : $kotlinClassType2")
    println("[java] 모든 타입 다받음: $javaClassType2")
    println("--------------------------------------------------------------")

    // --------------------------------------------------------------
    // 일반 클래스
    val reflection: Test001 = Test001()
    val reflectionClassKotlin: KClass<*> = reflection::class
    val reflectionClassJava: KClass<*> = reflection::class
    println("[kotlin] 클래스 타입 : $reflectionClassKotlin")
    println("[java] 클래스 타입: $reflectionClassJava")
    println("--------------------------------------------------------------")

    // 클래스 구조(정보) 파악
    println("[kotlin] isAbstract? : ${reflection::class.isAbstract}")
    println("[kotlin] isCompanion? : ${reflection::class.isCompanion}")
    println("[kotlin] isData? : ${reflection::class.isData}")
    println("[kotlin] isFinal? : ${reflection::class.isFinal}")
    println("[kotlin] isOpen? : ${reflection::class.isOpen}")
    println("[kotlin] isInner? : ${reflection::class.isInner}")
    println("[kotlin] isSealed? : ${reflection::class.isSealed}")
    println("--------------------------------------------------------------")

    // 생성자 정보
    val reflectionConstructors = reflection::class.constructors
    println("[kotlin] constructors : ${reflection::class.constructors}")
    for (con in reflectionConstructors) {
        println("constructors key : $con")

        for (param in con.parameters) {
            println("parameter index : ${param.index}")
            println("parameter type : ${param.type}")
            println("parameter name : ${param.name}")
        }
    }
    println("--------------------------------------------------------------")

    // 주 생성자
    val reflectionPrimaryConstructor = reflection::class.primaryConstructor
    reflectionPrimaryConstructor?.let {
        println(it)
        for (param in it.typeParameters) {
            println("primaty constructor params : $param")
        }
    }
    println("--------------------------------------------------------------")

    // properties
    val reflectionProperties = reflection::class.declaredMemberProperties
    for (prop in reflectionProperties) {
        println(prop.name)
    }
    println("--------------------------------------------------------------")

    // functions
    val reflectionFunctions = reflection::class.declaredMemberFunctions
    for (funs in reflectionFunctions) {
        println(funs.name)
    }
    println("--------------------------------------------------------------")

    // members
    val members = reflection::class.members
    for (member in members) {
        println("member : $member")
    }
    println("--------------------------------------------------------------")

}

class Test001() {
    val num1 = 1
    var num2 = 2

    constructor(a: Int): this() {

    }

    constructor(a: Int, b: Int): this() {

    }

    fun testMethod1() {

    }
}