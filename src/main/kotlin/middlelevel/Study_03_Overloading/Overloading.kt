package middlelevel.Study_03_Overloading

/*
- 함수 식별
1. 같은 이름의 추상함수가 여러개 일때
  - 동일한 이름을 가진 함수는 해당 함수 하나만 override 해서 구현하면 됩니다.
2. 같은 이름의 추상함수와 구현함수가 같이 있을 때
  - super 키워드를 통해 인터페이스의 함수를 호출할 수 있습니다.
  - 동일 함수가 여러 인터페이스에 있을 경우 super<인터페이스이름> 으로 사용할 수 있습니다.

* */
class Overloading {
}

fun main() {
    val childClass = ChildClass()
    childClass.dupFun()
    childClass.hasBody()
    childClass.callInterface1Func()
    childClass.callInterface2Func()
}

class ChildClass : ParentClass(), Interface1, Interface2 {
    override fun dupFun() {
        println("dup Fun")
    }

    override fun hasBody() {
        println("ChildClass / hasBody Fun")
    }

    fun callInterface1Func() {
        super.distFun()
        super<Interface1>.hasBody()
    }

    fun callInterface2Func() {
        super<Interface2>.hasBody()
    }
}

interface Interface1 {
    fun dupFun()
    fun distFun() {
        println("Interface1 / distFun")
    }
    fun hasBody() {
        println("Interface1 / hasBody Fun")
    }
}

interface Interface2 {
    fun dupFun()
    fun hasBody() {
        println("Interface2 / hasBody Fun")
    }
}

abstract class ParentClass {
    abstract fun dupFun()
}