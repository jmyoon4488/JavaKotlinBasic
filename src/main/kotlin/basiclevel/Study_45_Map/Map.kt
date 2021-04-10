package basiclevel.Study_45_Map

/*
[ Collection ]
- 이름을 통해서 객체를 관리하는 Collection 입니다.
- 가변형, 불변형

* */
class StudyFunction {
}

fun main() {

    //       generic <key, value> (key to value)
    val map1 = mapOf<String, Int>("key1" to 10, "key2" to 20, "key3" to 30)
    println("map1 : $map1")

    val map2 = mutableMapOf<String, Int>()
    println("map2 : $map2")

    val map3 = mapOf<String, Any>("key1" to 10, "key2" to 22.22, "key3" to true)
    println("map3 : $map3")

    println("================================================================================")
    // get
    println("map1 get(key1) : ${map1.get("key1")}")
    println("map1 [key1] : ${map1["key1"]}")

    println("================================================================================")
    // size : 크기 반환
    // keys : key 객체들을 배열로 반환
    // values : value 객체들을 배열로 반환
    // containsKey : 지정된 키로 저장된 객체가 있는지 확인
    // containsValue : 지정된 값으로 저장된 객체가 있는지 확인

    println("map1 size : ${map1.size}")
    println("map1 keys : ${map1.keys}")
    println("map1 values : ${map1.values}")

    println("map1 contains key1 : ${map1.containsKey("key1")}")
    println("map1 contains key100 : ${map1.containsKey("key100")}")

    println("map1 contains value 10 : ${map1.containsValue(10)}")
    println("map1 contains value 100 : ${map1.containsValue(100)}")

    println("================================================================================")
    // put : 객체 추가, 동일 키값이 있으면 덮어씁니다.
    // remove : 객체 삭제

    println("map2 : $map2")
    map2.put("key1", 100)
    println("map2 put() : $map2")
    map2["key2"] = 200
    println("map2 [key2] : $map2")
    map2["key1"] = 1000
    println("map2 key1 overwrite : $map2")

    map2.remove("key1")
    println("map2 remove key1 : $map2")

    println("================================================================================")
    // toMap <-> toMutableMap
    val map100 = map1.toMutableMap() // map1 을 바탕으로 새로운 객체를 생성하는 원리
    map100["key100"] = 1000
    println("map100 : $map100")

    val map200 = map100.toMap() // 불변형으로 변환
//    error
//    map200["key3"] = 2000
    println("map200 : $map200")

    println("================================================================================")
}
