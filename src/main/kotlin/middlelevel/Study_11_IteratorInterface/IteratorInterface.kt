package middlelevel.Study_11_IteratorInterface

/*
- 자바의 List, Set, Map 이용
- 코틀린에서도 자바의 List, Set, Map 을 사용할 수 있습니다.

- Iterator(반복자) : Collection 타입의 데이터를 순회하면서 접근하는 인터페이스 입니다.
  - Iterator() 함수를 이용해서 각 컬렉션 타입의 Iterator 객체를 만들 수 있습니다.
  - hasNext(), next() 함수를 가지고 있습니다.
  - hasNext() : 다음값이 있는지 없는지 확인합니다.
  - next() : 다음값을 가져옵니다. 단, 다음 값이 있는지 없는지 상관없이 수행되며 없으면 오류가 발생합니다.
             즉 next() 로 가져올때는 항상 먼저 데이터가 있는지 확인부터 하고 가져와야 오류를 피할 수 있습니다.

* */

import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet

class IteratorInterfacer {

}

fun main() {

//    hashSetOf<Int>() - hashSetOf 의 return type 은 kotlin.collection.HashSet
    val list = ArrayList<String>()
    list.add("aaa")
    list.add("bbb")
    println("list : $list")

    val map = HashMap<String, String>()
    map.put("aaa", "bbb")
    map.put("ccc", "ddd")
    println("map : $map")

    val set = HashSet<String>()
    set.add("aaa")
    set.add("bbb")
    println("set : $set")

    // =======================================================================================================================
    val iterator1 = list.iterator() // list 의 Iterator 객체를 생성합니다.
    while(iterator1.hasNext()) {
        println("list iterator next : ${iterator1.next()}")
    }

    // Map 의 경우 entry 를 통해 ket 와 value 를 분리해서 가져올 수 있습니다.
    val iterator2: Iterator<Map.Entry<String, String>> = map.iterator()
    while(iterator2.hasNext()) {
//        println("map iterator next : ${iterator2.next()}")
        val entry = iterator2.next()
        println("entry key : ${entry.key} / value : ${entry.value}")
    }

}