package middlelevel.Study_13_SealedClass

/*
- Sealed Class : 몇개의 타입을 하나로 묶어 주는 클래스 입니다.
  - Sealed Class 는 enum 클래스의 사용 목적과 같습니다.
  - Sealed 클래스의 사용 이유는 열거형 클래스는 모든 열거 상수에 같은 형태의 데이터만을 추가 할 수 있지만
    Sealed 클래스는 내부의 서브클래스를 일반 클래스처럼 사용할 수 있도록 되어 있어서 서브 클래스를 다양하게 구성할 수 있습니다.

- 일반 클래스를 이용해서 내부에 서브 클래스를 사용하는 것과
  sealed 클래스를 이용해서 서브 클래스를 사용하는 것은 차이가 있습니다.
- 일반 클래스는 자신을 직접 이용하는 것을 목적으로 하지만,
  sealed 클래스는 자신안에 열거된 객체 중의 하나를 사용하는 것이 목적이기 때문에 열거 클래스 자신의 클래스를 생성할 수 없습니다.

* */

class SealedClass {

}

fun main() {
    val rec: Shape = Shape.Rectangle(10, 10)
    val tri: Shape = Triangle(10, 10)

    // sealed 클래스는 자기 자신의 객체를 생성 할 수 없습니다.
    // 내부에 열거된 서브클래스들로만 객체를 생성 할 수 있습니다.
//    val shape: Shape = Shape() - error
}

sealed class Shape {
    class Rectangle(val width: Int, val height: Int) : Shape()
    class Circle(val radius: Double) : Shape()
}

class Triangle(val bottom: Int, val height: Int) : Shape()