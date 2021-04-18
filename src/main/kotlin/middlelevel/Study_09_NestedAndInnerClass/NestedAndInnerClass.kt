package middlelevel.Study_09_NestedAndInnerClass

/*
1. 중첩 클래스 (Nested Class) : 클래스 안에 선언된 클래스 입니다.
  1. 내부 클래스에서 외부 클래스의 멤버 프로퍼티에 접근이 불가능 합니다.
  2. Nested 클래스는 Static 이므로 Outer 클래스 생성 없이 Outer 클래스 식별자만으로 바로 생성 가능합니다.


2. 내부 클래스 (Inner Class) :
  1. 내부 클래스 안에서는 외부 클래스의 멤버 프로퍼티에 접근할 수 있습니다.
  2. Inner 클래스는 Static 이 아니라서 Outer 클래스를 생성해서 접근해야 합니다.
  3. 내부 클래스와 외부 클래스의 함수 및 변수명이 같을 경우 기본적으로는 내부 클래스의 요소가 호출됩니다.
     외부 클래스의 요소를 호출하려면 this@{외부클래스명}.{변수 or 함수} 를 통해서 호출할 수 있습니다.
* */

class NestedAndInnerClass {
}

fun main() {
    val nested: Outer.Nested = Outer.Nested()
    nested.greeting()

    // Inner 클래스는 Static 이 아니라서 Outer 클래스를 생성해서 접근해야 합니다.
    // error
//    val inner: Outer.Inner = Outer.Inner()
    val inner: Outer.Inner = Outer().Inner()
    println("inner num : ${inner.innerNum}")
    inner.innerFun()
    inner.innerCallOuterFun()
    // =======================================================================================================================
    val outer2 = Outer2(100)
    val inner2 = outer2.Inner2(50)
    outer2.getInfo()
    inner2.getInfo()
    inner2.getOuteraa()
    inner2.callOuterFunInInner()
    // =======================================================================================================================
    // =======================================================================================================================
    // =======================================================================================================================
    // =======================================================================================================================
}

class Outer {
    var outerNum = 100
    fun outerFun() = println("Outer / outerFun")

    class Nested {
        var nestedNum = 200
        fun greeting() = println("Nested / greeting")
        // error - 1.1
//        fun nestedFun() = println("Nested / num : $outerNum")
    }

    inner class Inner {
        var innerNum = 300
        fun innerFun() = println("Inner / outerNum : $outerNum")
        fun innerCallOuterFun() {
            outerFun()
        }
    }

    fun createInner1(): Inner {
        return Inner()
    }

    companion object {
        fun createInner2(): Inner {
            return Outer().Inner()
        }
    }
}

class Outer2(private var aa: Int) {
    fun getInfo() = println("outer this.aa : ${this.aa}")

    inner class Inner2(private val bb: Int) {
        fun getInfo() = println("inner this.bb : $bb")
        fun getOuteraa() = println("call outer this.aa : $aa")
        fun callOuterFunInInner() = this@Outer2.getInfo()
    }
}