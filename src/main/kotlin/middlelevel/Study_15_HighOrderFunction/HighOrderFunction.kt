package middlelevel.Study_15_HighOrderFunction

/*
- 고차 함수(고계 함수) : 일반 함수와 다르게 매개변수 또는 반환값이 일반적인 값이 아닌 함수를 사용할 수 있습니다.

- 일반 함수
```
fun test( a: Int ) : Int {
    return a
}
```

- 고차함수 (람다 표현식에서 alias 항목 확인)
```
fun hoFun( a: Int, ff:(Int) -> Int ) : Unit {
    val result = ff(200)
    println("a : $a , result : $result")
}

// 호출 방법
hoFun(10, { x -> x * 20 })
```

- 고차 함수 반환

- 고차함수에서매개변수와 리턴값에 람다함수를 많이 이용합니다.
  람다함수 이외에도 함수 참조나 익명 함수를 이용할 수도 있습니다.
  - 함수참조 연산자 => `::` 이용


* */

class HighOrderFunctionAndFiltering {
}

fun main() {
    highTest1( { x, y -> x * y } )
    // =======================================================================================================================

    // 함수가 매개변수로 고차함수 하나만 받을 경우 매개변수을 입력하는 영역인 () 를 생략할 수 있습니다.
    highTest1 { x, y -> x * y }

    // =======================================================================================================================
    // 함수의 마지막 매개변수가 고차함수라면 이전 매개변수까지만 () 안에 적고 그 다음 고차함수를 적을 수 있습니다.
    highTest2(4, 5, {x, y -> x * y})
    highTest2(4, 5) {x, y -> x * y}

    // =======================================================================================================================
    highTest3(1, { it - 3 }, { x, y -> x + y })
    highTest3(1, { it - 3 }) { x, y -> x + y }
//    highTest3(1) { it - 3 } { x, y -> x + y }   // 외부로 뺄 수 있는 고차함수는 마지막 하나만 가능합니다.
    // =======================================================================================================================
}

fun highTest1(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("result : $result")
}

fun highTest2(a: Int, b: Int, operation: (Int, Int) -> Int) {
    val result = operation(a, b)
    println("result : $result")
}

fun highTest3(a: Int, test: (Int) -> Int, operation: (Int, Int) -> Int) {
    val result = operation(a, 5) + test(8)
    println("result : $result")
}