package Study_42_Array

/*
배열에 다양한 타입의 값을 저장할 수는 있지만
같은 타입의 값만으로 저장하는걸 권장합니다.
자바에서 제공하는 기능보다 더 다양해서 편리하게 사용할 수 있습니다.
* */
class Array {
}

fun main() {
    val array1 = arrayOf(10, 20, 30, 40, 50)

    val array2 = arrayOf(10, "11", 12, true)

    val array3 = intArrayOf(10, 20, 30)
    val array4 = doubleArrayOf(1.1, 1.2, 1.3)
    val array5 = arrayOf<String>("aaa", "bbb", "ccc")
    println("array3 : ${array3.contentToString()}")
    println("array4 : ${array4.contentToString()}")
    println("array5 : ${array5.contentToString()}")

    val array11 = Array(5, {0})
    println("array11 : ${array11.contentToString()}")

    val array12 = Array(5, { it + 2 }) // == val array12 = Array(5) { it + 2 }
    println("array12 : ${array12.contentToString()}")


    for (item in array1) {
        println("array1 item : $item")
    }

    println("===============================================================================")

    val array21 = arrayOf(arrayOf(10, 20, 30), arrayOf(40, 50, 60), arrayOf(70, 80, 90))
    println("array21 : ${array21}") // 배열 주소값이 출력
    println("array21 : ${array21.contentToString()}") // 중첩 배열이라 주소값 출력
    println("array21 : ${array21.contentDeepToString()}") // 중첩 배열 안의 값을 출력

    for (item1 in array21) {
        for (item2 in item1) {
            println("array21 item2 : $item2")
        }
    }

    println("===============================================================================")
    // 배열 요소 접근
    println("array1 0 : ${array1[0]}")
    println("array1 1 : ${array1[1]}")
    println("array1 2 : ${array1.get(2)}")
    println("array1 3 : ${array1.get(3)}")

    println("===============================================================================")
    // 배열 내용 수정
    println("array1 : ${array1.contentToString()}")
    array1[0] = 100
    array1.set(1, 200)
    println("array1 : ${array1.contentToString()}")

    println("===============================================================================")
    // 배열 크기 측정
    println("array1 size : ${array1.size}")

    println("===============================================================================")
    // 배열은 기본적으로 크기를 변경 할 수 없습니다.
    // plus 함수를 사용하면 배열의 크기를 변경하는게 아니라 요소를 추가한 새로운 배열을 만드는 동작을 합니다.
    println("array1 : ${array1.contentToString()}")

    // plus
    val array101 = array1.plus(111)
    println("array1 plus? : ${array1.contentToString()}")
    println("array101 : ${array101.contentToString()}")

    // slice
    val array102 = array1.sliceArray(1..3)
    println("array1 sliceArray? : ${array1.contentToString()}")
    println("array102 : ${array102.contentToString()}")

    // first
    println("array1 첫번째 값 : ${array1.first()}")
    println("array1 마지막 값 : ${array1.last()}")
    println("array1 30 의 index 위치 : ${array1.indexOf(30)}")
    println("array1 평균 : ${array1.average()}")
    println("array1 합 : ${array1.sum()}")
    println("array1 개수 : ${array1.count()}") // == size
    println("array1 size : ${array1.size}")
    println("array1 40 포함하는가? : ${array1.contains(40)}")
    println("array1 900 포함하는가? : ${array1.contains(900)}")
    println("array1 40 포함하는가? : ${40 in array1}")
    println("array1 900 포함하는가? : ${900 in array1}")
    println("array1 최대 : ${array1.max()}")
    println("array1 최소 : ${array1.min()}")

    val array111 = arrayOf(8,5,32,8,9,4)
    val array112 = array111.sortedArray()
    val array113 = array111.sortedArrayDescending()
    println("array112 오름차순 : ${array112.contentToString()}")
    println("array113 내림차순 : ${array113.contentToString()}")

    // ===============================================================================
    //
}
