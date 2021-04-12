package middlelevel.Study_02_InterfaceAndProperty

/*
인터페이스 주목적은 추상함수를 선언하는 것.
프로퍼티를 선언 할 수는 있지만.. 주목적과는 조금 다릅니다.

인터페이스만으로 객체 생성은 불가능 합니다.
따라서 클래스에서 인터페이스를 구현(재정의=override)해서 사용해야 합니다.

- 추상클래스와 인터페이스의 차이점?
추상클래스 : 클래스. 특정 객체 생성을 목적으로 해당 클래스를 표현하는 클래스
인터페이스 : 클래스가 아님. 객체 생성이 목적이 아니라 구현될 클래스가 어떤 기능을 가져야 하는지 명세하기 위해 존재.
추상클래스는 상속하고, 인터페이스는 구현한다.(?)

- 인터페이스를 객체의 타입으로 사용할 수 있습니다.

- 인터페이스의 프로퍼티를 정의할 때 규칙
1. 추상형(추상 프로퍼티)으로 선언합니다.
2. 추상형이 아니라면 get() , set() 함수를 반드시 선언해야 합니다.
  - var 변수는 get() , set() 함수를 반드시 선언합니다.
  - val 변수는 get() 함수를 반드시 선언합니다.
3. 인터페이스의 프로퍼티로 사용하기 위해 get() , set() 함수에 field 를 사용할 수 없습니다.
  - setter 에서 field 를 사용할 수 없다는 의미는 해당 property 의 값을 setter 로 설정할 수 없다는 의미 입니다.
  - 일반적인 setter 와는 다르게 해당 property 의 setter 가 호출될 때 특정한 다른 기능을 수행하기 위해 사용됩니다.

* */

// 상속은 1개만 가능, 구현은 여러개 가능
// 인터페이스는 클래스가 아니므로 생성자가 필요없어 상속이 아니라 구현 형태로 적용.
// 추상클래스는 클래스이므로 구현할때 생성자가 필요하며 상속 형태로 적용.
class InterfaceAndProperty : AbsTest1(),/* AbsTest2(),*/ InterfaceTest1, InterfaceTest2, InterfaceForType {
    override var a1: String = ""
    override var a2: String = ""
    override var b1: String = ""
    override var cc: String = "cc"

    override fun absTest1() {
        println("InterfaceAndProperty / AbsTest1 / absTest1")
    }

    // 여러 인터페이스의 중복 함수는 하나만 구현하면 된다. 인터페이스는 단순히 명세서이므로.
    override fun duplicateFun() {
        println("InterfaceAndProperty / InterfaceTest1 or InterfaceTest2 / duplicateFun()")
    }

    override fun interTest1() {
        println("InterfaceAndProperty / InterfaceTest1 / interTest1")
    }

    override fun interTest2() {
        println("InterfaceAndProperty / InterfaceTest2 / interTest2")
    }

    override fun interfaceType() {
        println("InterfaceAndProperty / InterfaceForType / interfaceType")
    }
}

fun main() {
    // error
//    val interfaceClass = InterfaceTest1()

    val testClass: InterfaceAndProperty = InterfaceAndProperty()
    testClass.absTest1()
    testClass.duplicateFun()
    testClass.interTest1()
    testClass.interTest2()
    println("c1 : ${testClass.c1}")
    println("c2 : ${testClass.c2}")
    // c1 is val
//    testClass.c1 = ""
    testClass.c2 = "hahaha"
    println("c2 : ${testClass.c2}")
    testClass.c2 = "111"
    println("c2 : ${testClass.c2}")

    println("cc : ${testClass.cc}")

    // 기본적으로는 생성하는 클래스의 타입으로 변수가 지정되어 인터페이스 함수 및 클래스 함수 모두 접근 가능
    val interfaceType: InterfaceTypeTest1 = InterfaceTypeTest1()
    interfaceType.interfaceType()
    interfaceType.classFunction1()

    // 아래처럼 클래스를 구현한 인터페이스를 타입으로 생성하는것도 가능합니다.
    // 3개의 클래스는 같은 인터페이스 기능을 구현하지만 구현 내용은 다를 수 있고
    // 다른 구현부를 가진 클래스이지만 같은 타입을 가지게 될 수 있습니다.
    val interfaceType1: InterfaceForType = InterfaceTypeTest1()
    val interfaceType2: InterfaceForType = InterfaceTypeTest3()
    val interfaceType3: InterfaceForType = InterfaceTypeTest2()

    // 단 인터페이스를 타입으로 클래스를 생성하게 되면 인터페이스의 함수를 호출할 수는 있지만...
    interfaceType1.interfaceType()
    interfaceType2.interfaceType()
    interfaceType3.interfaceType()

    // 생성에 사용한 클래스의 함수는 호출할 수 없습니다.
    // error
//    interfaceType1.classFunction1()
//    interfaceType2.classFunction2()
//    interfaceType3.classFunction3()

    // 어떤 함수의 매개변수로 클래스를 받게 될 경우 동일 인터페이스로 구현되어 있다고 하더라도 해당 클래스만 전달 받을 수 있습니다.
    fun doSomething1(someClass: InterfaceTypeTest1) {
        someClass.interfaceType()
    }
    doSomething1(interfaceType)
    // error
//    doSomething1(interfaceType1)
//    doSomething1(interfaceType2)
//    doSomething1(interfaceType3)

    // 어떤 함수의 매개변수로 인터페이스 타입을 받으면 해당 인터페이스를 구현한 모든 클래스를 전달 받을 수 있습니다.
    fun doSomething2(someClass: InterfaceForType) {
        someClass.interfaceType()
    }
    doSomething2(interfaceType)
    doSomething2(interfaceType1)
    doSomething2(interfaceType2)
    doSomething2(interfaceType3)

}

// 명세서이므로 구현부 또는 초기값을 지정하지 않는다. (가능은 함)
interface InterfaceTest1 {
    var a1: String
    var b1: String
    fun duplicateFun()
    fun interTest1()

    // error
//    val c1: String = ""
//    var c1: String = ""

    // field 사용 불가
//    val c1: String
//        get() = field

    // var 는 set() 도 반드시 필요, 없어서 error
//    var c1: String
//        get() = ""

    // val 은 get() 만 사용하므로 set() 불필요
    val c1: String
        get() = "val getter in interface"

    // var 변수는 get() , set() 둘다 필요
    // 단 setter 에서 자기자신을 다시 set 하게하여 recursive 하게 자기 자신을 무한 호출하지 않도록 조심헤야합니다.
    // field 를 사용하지 않는다는것은 해당 property 를 다른 값으로 설정할 수는 없고
    // setter 에서 어떤 다른 기능을 수행하기 위해서만 사용하는 용도입니다.
    var cc: String
    var c2: String
        get() = "var getter in interface"
        set(value) {
            if (value == "111") cc = "if 111 - setter"
            else cc = "else setter"
        }
}

interface InterfaceTest2 {
    var a2: String
    var b1: String
    fun duplicateFun()
    fun interTest2()
}

abstract class AbsTest1 {
    abstract fun absTest1()
}

abstract class AbsTest2 {
    abstract fun absTest2()
}

interface InterfaceForType {
    fun interfaceType()
}

class InterfaceTypeTest1 : InterfaceForType {
    override fun interfaceType() {
        println("InterfaceTypeTest1 / InterfaceForType / interfaceType")
    }
    fun classFunction1() {
        println("InterfaceTypeTest1 / classFunction1")
    }
}

class InterfaceTypeTest2 : InterfaceForType {
    override fun interfaceType() {
        println("InterfaceTypeTest2 / InterfaceForType / interfaceType")
    }
    fun classFunction2() {
        println("InterfaceTypeTest1 / classFunction2")
    }
}

class InterfaceTypeTest3 : InterfaceForType {
    override fun interfaceType() {
        println("InterfaceTypeTest3 / InterfaceForType / interfaceType")
    }
    fun classFunction3() {
        println("InterfaceTypeTest1 / classFunction3")
    }
}