package middlelevel.Study_18_DelegationPattern

/*

A -> B
위임자 -> 대리자(대행자)
Delegator -> Executor

- A 객체 가 할 일을 B, C, D 등의 다른 객체에게 위임하는 패턴입니다.

- Kotlin 에서는 이 패턴을 다른 방식으로 사용합니다.
  - 위임자 클래스에서 대행자를 호출할때는 by 키워드를 사용합니다.
  - 이때 위임자는 상속받는 추상함수를 구현할 필요가 없습니다.
  - by 에 입력된 대행자에 구현된 추상함수가 대신 수행되게 됩니다.

* */

class DelegationPattern {
}

fun main() {
    // 일반적인 사용방법
    val delegator = Delegator()
    delegator.output("haha")

    // 코틀린에서 사용방법
    val myDelegator = MyDelegator(Agent())
    myDelegator.out("gaga")

}

// ===================================
// 일반적인 사용방법
// 위임자 객체
class Delegator {
    val agent = Delegatee()

    fun output(str: String) {
        agent.output(str)
    }
}

// 대행자 객체
class Delegatee {
    fun output(str: String) {
        println("Delegatee / output : $str")
    }
}
// ===================================
// 코틀린에서 사용방법
interface Output {
    fun out(str: String)
}

class Agent: Output {
    override fun out(str: String) {
        println("Agent / out : $str")
    }
}

// Output 인터페이스의 함수를 구현하지 않아도 됩니다.
// 구현해야 하는 추상함수는 by agent 에 의해 agent 가 구현한 추상함수가 동작하게 됩니다.
// 다만 대행자가 수행하기 전에 위임자가 전처리를 해야한다면 결국 추상함수를 구현해주어야 합니다.
class MyDelegator(private val agent: Agent): Output by agent


// ===================================