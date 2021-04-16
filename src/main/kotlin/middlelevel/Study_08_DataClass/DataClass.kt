package middlelevel.Study_08_DataClass

/*
1. Data Class : 객체지향 프로그래밍에서 VO (Value Object) 를 만들어 사용하는데
                해당 클래스에 필요한 boilerplate 코드를 자동으로 만들어 주는 역할을 하는 클래스 입니다.
- VO 클래스(객체) : 여러개의 데이터를 묶어서 사용하기 위한 목적으로 만든 클래스 입니다.
                    오직 객체를 표현하는 변수만 있고 어떠한 처리를 수행하는 함수는 없습니다.

- 일반 클래스와 data 클래스 비교
  1. data 키워드 사용합니다.
  2. 주 생성자를 선언합니다.
  3. 주 생성자의 매개 변수는 최소 하나 이상입니다.
  4. 모든 주 생성자의 매개 변수는 var 또는 val 로 선언 해야합니다.
  5. abstract, open, sealed, inner 등의 예약어를 사용할 수 없습니다.
  6. open 키워드를 사용할 수 없으므로 다른 클래스를 상속하여 부모클래스가 될 수 없습니다.

- 데이터 클래스에서 제공하는 componentN() 함수가 있습니다. (N 은 1 부터 증가하는 숫자)
  - 데이터 클래스의 프로퍼티 이름으로 값을 가져올 수도 있지만, componentN() 함수로 가져올 수도 있습니다.
  - 첫번째 프로퍼티는 component1(), 두번째 프로퍼티는 component2() 이런식입니다.

- 데이터 분해 선언 (Destructuring declarations)
  - 데이터 클래스의 주생성자에 주입되는 프로퍼티의 경우 내부적으로 componentN() 가 활용되어 한번에 추출되어 변수에 대입할 수 있습니다.
  - val (property1, property2) = dataClass
    => val property1 = dataClass.component1()
    => val property2 = dataClass.component2()

- copy() 함수 : 객체를 복사해서 다른 객체를 만들어주는 함수
  - 객체의 일부분의 데이터만 변경해서 다른 객체를 만들 때 유용하게 사용할 수 있습니다.


* */

class DataClass {
}

fun main() {
    // 일반 클래스는 아무리 프로퍼티가 동일해도 equals 를 수동으로 override 해주지 않으면 다른 객체로 인식합니다.
    var prod1 = Product("prod1", 100)
    var prod2 = Product("prod1", 100)
    println(prod1.equals(prod2))
    println(prod1 == prod2)

    // data 클래스는 equals 를 자동으로 override 해주기 때문에 프로퍼티가 같으면 동일한 객체로 인식합니다.
    var user1 = User("user1", 10)
    var user2 = User("user1", 10)
    println(user1.equals(user2))
    println(user1 == user2)

    // =======================================================================================================================
    // equals() 함수는 서로 다른 객체의 데이터를 비교하지 않고 같은 클래스의 객체일 때만 데이터를 비교합니다.
    val student = Student("test1", 10)
    val employee = Employee("test1", 10)
    println(student.equals(employee))
    // =======================================================================================================================
    // data 클래스는 주생성자에 포함된 프로퍼티만으로 동일한 객체인지 비교합니다.
    // (data 클래스 작성 후 디컴파일 해서 자바코드로 만들어진 equals 함수를 확인해보시면 됩니다.)
    val professor1 = Professor("pro1", "computer")
    println(professor1.email)
    val professor2 = Professor("pro1", "computer")
    professor2.email = "bbb@bbb.com"
    println(professor2.email)
    println(professor1.equals(professor2))
    // =======================================================================================================================
    // 데이터 클래스의 toString() 함수는 자동으로 재정의 되어 객체의 주생성자의 프로퍼티 값을 반환해줍니다.
    // 주로 데이터가 정상적으로 입력되었는지 확인하는 로그 출력용으로 많이 쓰입니다.
    val teacher1 = Teacher("teacher1", 50)
    println(teacher1.toString()) // 객체의 메모리 주소가 출력됩니다.
    println(professor1.toString()) // 클래스 이름과 주생성자 프로퍼티가 key=value 형태로 출력됩니다. - data 클래스의 단순 멤버 프로퍼티는 출력되지 않습니다.
    // =======================================================================================================================
    println(professor1.name)
    println(professor1.component1())
    println(professor1.subject)
    println(professor1.component2())
    // 클래스 멤버 프로퍼티는 componentN() 이 자동 생성되지 않습니다.
    println(professor1.email)
//    println(professor1.component3())
    // =======================================================================================================================
    var flower1 = Flower(price = 2000,name = "flower1")
    // 주생성자에 선언된 프로퍼티 순서대로 변수에 분리되어 대입됩니다.
    val (name, price) = flower1
    println("name : $name / price : $price")
    val (price1, name1) = flower1
    println("name : $name1 / price : $price1")
    // =======================================================================================================================
    // copy() 함수로 객체를 복사할 수 있습니다. 단 멤버 프로퍼티는 복사되지 않습니다.
    val professor3 = professor2.copy(name = "pro3")
    println("${professor2.toString()} / ${professor2.email}")
    println("${professor3.toString()} / ${professor3.email}")
    // =======================================================================================================================
    // =======================================================================================================================
    // =======================================================================================================================
}

class Product(val name: String, val proce: Int)
data class User(val name: String, val age: Int)

data class Student(val name: String, val age: Int)
data class Employee(val name: String, val age: Int)

data class Professor(val name: String, val subject: String) {
    var email: String = "aaa@aaa.net"
}

class Teacher(val name: String, val age: Int)
data class Flower(val name: String, val price: Int)

// 아래 VO 클래스와 같은 기능을 자동으로 해준다.
data class Person(
    var name: String = "",
    var age: Int
)

// 일반적인 VO 클래스 (코틀린이라 오류가 발생하지만... )
//class Person {
//    var name: String = ""
//    var age: Int = 0
//
//    // 기본 빈 생성자와 모든 매개변수를 포함한 생성자 모두 생성해야 합니다.
//    fun Person() {}
//    fun Person(name: String, age: Int) {
//        this.name = name
//        this.age = age
//    }
//
//    // 각 변수의 getter, setter - 내용은 생략
//    fun getName(): String {}
//    fun setName() {}
//    fun getAge(): Int {}
//    fun setAge() {}
//
//    // equals, hashcode, toString 메소드 자동 override - 내용은 생략
//    override fun equals(other: Any?): Boolean {}
//    override fun hashCode(): Int {}
//    override fun toString(): String {}
//}
