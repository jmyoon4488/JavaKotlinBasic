package basiclevel.Study_46_Set

/*
[ Collection ]
- 값으로만 객체를 관리하는 Collection 입니다.
- 이름이나 순서등으로 관리하는 주체가 없기 때문에 원하는 값을 바로 꺼내올 수 없습니다.
- 중복된 객체를 담을 수 없습니다.
- 순서에 관계 없고 중복된 객체를 담지 않고 싶을때 Set 을 사용합니다.
- 가변형, 불변형

* */
class StudyFunction {
}

fun main() {

    // 기본
    val set1 = setOf(1, 5, 10, 1, 5, 10)
    println("set1 : $set1")

    val set2 = mutableSetOf<Int>()
    println("set2 : $set2")

    println("================================================================================")
    // 객체 관리 주체가 없으므로 반드시 반복문을 통해서 확인해야 합니다.
    // error
//    println("set1 get(0) : ${set1.get(0)}")
//    println("set1 [0] : ${set1[0]}")

    for (item in set1) {
        println("set1 item : $item")
    }

    println("================================================================================")
    // size
    println("set1 size : ${set1.size}")

    println("================================================================================")
    // add : 객체 추가, 같은 객체일 경우 추가되지 않습니다. (따라서 해당 객체가 덮어씌어져 맨뒤로 변경되지 않음. 순서 없음)
    // remove : 객체 제거
    println("set2 : $set2")
    set2.add(10)
    set2.add(20)
    set2.addAll(listOf(30, 40, 50))
    println("set2 add, addAll : $set2")

    set2.add(20)
    println("set2 already exist : $set2")

    set2.addAll(listOf(40, 50, 60, 70))
    println("set2 addAll if exist : $set2")

    // 순서가 없어서 removeAt 불가능
    set2.remove(30)
    println("set2 remove 30 : $set2")

    println("================================================================================")
    // Set => toSet <-> toMutableSet
    // Set -> List => toList, toMutableList
    // List -> Set => toSet, toMutableSet // 단 리스트의 순서가 Set 으로 변형될때 보장되지 않습니다.

    val set3 = mutableSetOf<Int>()
    set3.add(1000)
    println("set3 : $set3")

    val set4 = set3.toSet()
    // error
//    set4.add(2000)
    println("set4 : $set4")

    val list100 = listOf(10,20,30)
    println("list100 : $list100")

    val set5 = list100.toSet()
    val set6 = list100.toMutableSet()

    println("set5 : $set5")
    println("set6 : $set6")

    val set7 = set5.toList()
    val set8 = set5.toMutableList()
    println("set7[0] : ${set7[0]}")
    println("set8[0] : ${set8[0]}")

    println("================================================================================")
    println("================================================================================")
}
