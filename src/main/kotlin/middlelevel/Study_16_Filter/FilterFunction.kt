package middlelevel.Study_16_Filter

/*
- filter() / 필터링 함수 : 컬렉션 타입의 데이터 중 조건에 맞는 데이터만을 추출해주는 함수입니다.

- 필터함수도 고차함수 형태로 만들어져있습니다.
```
inline fun <T> Iterable<T>.filter(predicate: (T) -> Boolean): List<T> {
    return filterTo(ArrayList<T>(), predicate)
}
```

* */

class FilterFunction {
}

fun main() {
    val li = listOf(7, 8, 9, 10, 11, 12, 13, 14, 15)
    val liData = ArrayList<Int>()

    // 기본적으로
    for (i in li) {
        if ( i > 10 ) liData.add(i)
    }
    println("liData : ${liData.toString()}")

    // 필터링
    // it 변수에 리스트의 아이템이 차례로 하나씩 입력되어 입력된 조건을 비교하고 조건이 true 일 경우에만 새로운 리스트에 포함시킵니다.
    // it 부분은 원하는 변수 이름으로 변경할 수 있으며, 변경하려면 람다식 규칙대로 { custom -> custom 조건 } 형식으로 입력해야 합니다.
    val liData2 = li.filter { it > 10 }
    val liData3 = li.filter { listItem -> listItem > 10 } // it = listItem
    println("liData2 : ${liData2.toString()}")

    // Map 일 경우
    // Map 은 키와 값으로 이루어진 데이터이기 때문에 Map.Entry 타입으로 전달됩니다.
    val map = mapOf("key1" to 10, "key2" to 50, "key3" to 110, "key4" to 200)
    val mapData = map.filter { entry -> entry.value > 100 } // entry : keySet 의 원소가 하나씩 들어옵니다.
    println("mapData : ${mapData.toString()}")
}