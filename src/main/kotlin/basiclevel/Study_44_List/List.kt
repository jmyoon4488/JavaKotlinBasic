package basiclevel.Study_44_List

/*
Java 의 Collection 과 거의 동일합니다.
List - 배열과 동일하게 Index 번호를 통해 관리합니다.
배열과 달리 추가 삭제가 가능합니다.

listOf : 불변 리스트 생성 (
mutableListOf : 가변형 리스트를 생성
emptyList : 비어있는 불변형 리스트를 생성
listOfNotNull : null 을 제외한 나머지만으로 리스트를 생성

- 불변형 객체가 성능상 이점(데이터 접근 속도가 빠름, 메모리 이점(?))이 있어서 기본적으로 불변형으로 사용하고
  데이터 조작이 필요할 경우 가변형으로 변환해서 작업 후 다시 불변형으로 사용하는 것을 추천합니다.

* */
class StudyFunction {
}

fun main() {

    // 불변형 리스트
    // 초기화 시 입력 데이터가 있다면 타입 추론이 가능하므로 generic 생략 가능
    val list1 = listOf(10, 20, 30, 40, 50)
    val list2 = listOf("test1", "test2", "test3", "test4", "test5")
    println("list1 : $list1")
    println("list2 : $list2")
    println("================================================================================")

    // 가변형 리스트
    // 빈 리스트를 만들 경우 타입 추론이 불가능 하므로 generic 필요
    val list3 = mutableListOf<Int>()
    val list4 = mutableListOf("test6", "test7", "test8", "test9", "test10")
    println("list3 : $list3")
    println("list4 : $list4")
    println("================================================================================")

    // 리스트에 add 사용 불가 - 초기화 시 입력 값에 null 이 포함되어 생성됨
    val list5 = emptyList<Int>()
    println("list5 : $list5")
    println("================================================================================")

    // 입력 값에서 null 을 제외하고 리스트를 생성함
    val list6 = listOfNotNull(10, 20, null, 30, null, 40, 50)
    println("list6 : $list6")
    println("================================================================================")

    // 기본적으로 원소를 가져올 때는 list.get(index) 사용하지만 배열처럼 list[index] 사용 가능 (코틀린만)
    println("list1 0 : ${list1.get(0)}")
    println("list1 1 : ${list1.get(0)}")
    println("list1 0 : ${list1[0]}")
    println("list1 1 : ${list1[1]}")
    println("================================================================================")

    // indexOf : 지정된 값을 인덱스 번호를 반환합니다. 없으면 -1 반환합니다.
    // lastIndexOf : 지전된 값이 마지막에 해당하는 값의 인덱스 번호를 반환합니다.
    // subList
    val list7 = listOf(10, 20, 30, 10, 20, 30)
    val index1 = list7.indexOf(20)
    println("index1 : $index1") // 1

    val index2 = list7.lastIndexOf(20)
    println("index2 : $index2") // 4

    val list8 = list1.subList(1,3)
    println("list8 : $list8")
    println("================================================================================")

    // 가변형 리스트의 Method
    // add : 객체 추가 / index 가 있으면 해당 index 위치에 추가
    // remove : 지정된 객체 제거
    // removeAt : index 위치의 객체 제거
    // set : 지정된 위치의 객체 수정(변경)

    println("list3 : $list3")  // empty list
    list3.add(10)
    list3.add(20)
    list3.add(30)
    println("list3 add : $list3")
    list3.addAll(listOf(40, 50, 60))
    println("list3 addAll : $list3")
    list3.add(1, 100)
    println("list3 add by index : $list3")
    list3.addAll(2, listOf(200, 300, 400))
    println("list3 addAll by index : $list3")

    list3.remove(100)
    println("list3 remove : $list3")

    list3.removeAll(listOf(200, 300))
    println("list3 removeAll : $list3")

    list3.removeAt(1)
    println("list3 removeAt : $list3")

    list3.set(1, 200)
    println("list3 set : $list3")
    list3[1] = 300
    println("list3 set == [] : $list3")

    println("================================================================================")
    // 리스트의 상호 변경
    // toMutableList <-> toList
    val list100 = list1.toMutableList() // list1 은 그대로
    list100.add(1000)
    println("list100 : $list100")

    val list200 = list100.toList()
    // error
//    list200.add(3000)
    println("list200 : $list200")

    println("================================================================================")
}
