package middlelevel.Study_07_ExtendsWithReceiver

/*
- `?` (Nullable 연산자) : null 값을 저장할 수 있는 변수를 지정할때 사용하는 연산자입니다. (타입 뒤에 붙입니다.)
1. Nullable Receiver


2. 동반자 객체의 확장함수 : companion 키워드를 이용해서 확장함수를 사용하기
- 동반자 객체의 확장함수 형식
fun 클래스이름.Companion.함수이름() {
}
- 동반자 객체는 클래스 이름만으로 접근 가능하지만
  확장함수를 만들때 클래스 이름만 적을 경우 동반자 객체가 아닌 클래스 자체의 멤버함수가 추가되기 때문에
  반드시 Companion 키워드를 사용해야 합니다.

* */

class ExtendsWithReceiver {
}

fun main() {
    //           `?` 연산자에 의해 null 을 저장할 수 있습니다.
    var aa: String? = null
    // isNumber2 확장 함수의 리시버 타입이 nullable 이기 때문에 (String?.함수이름) null 값으로 확장함수를 호출 할 수  있습니다.
    aa.isNumber2()

    // ========================================================================================================================

    CompanionClass.extensionFunction()
    val companionClass: CompanionClass = CompanionClass.createClass()

    // ========================================================================================================================

    // 상속관계에 있는 확장함수의 경우에는 멤버함수와는 다르게 참조변수(인스턴스)가 실제로 가리키는 자식타입을 따르지 않고 부모 타입을 따릅니다.
    // 부모 타입을 따른다....? 객체 생성시 지정된 타입을 따르는 걸로 보입니다...
    // 다만 '실제로 가리키는' 이라는 얘기가 지정된 객체 타입을 가리키는 것일 수도 있겠습니다.

    // BB 클래스를 사용해서 객체를 생성했지만 해당 객체의 타입은 AA 이기 때문에 확장함수는 객체의 타입에 따라 실행됩니다.
    val obj: AA = BB()
    obj.greeting()

    // 만약 상속관계에 있는 클래스의 확장함수를 사용할때 부모 타입을 따른다고 한다면...
    // AA 클래스의 extension 을 출력하게 되어야 하는데..?
    val obj2: BB = BB()
    obj2.greeting()

    // ========================================================================================================================
}

//       `?` 연산자에 의해 null 값에 확장함수를 주입할 수 있습니다.
fun String?.isNumber2() {
    if (this == null) println("this is null")
}

// 생성자 없는 테스트 클래스
class CompanionClass {
    companion object
}

// Companion 을 붙여야 동반자 객체에 확장함수를 주입하여 객체 생성 없이 클래스 식별자로 확장함수를 사용할 수 있습니다.
fun CompanionClass.Companion.extensionFunction() {
    println("CompanionClass - extensionFunction")
}

fun CompanionClass.Companion.createClass() = CompanionClass()

// 리시버가 상속관계에 있을 때
open class AA
class BB : AA()

fun AA.greeting() = println("AA extension greeting()")
fun BB.greeting() = println("BB extension greeting()")