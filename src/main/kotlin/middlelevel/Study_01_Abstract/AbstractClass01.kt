package middlelevel.Level01_Absract

class AbstractClass01 : MiddleAbstractClass() {
    override fun abstractFunction() {
        println("AbstractClass01 / abstractFunction")
    }

    override val abstractMember: String
        get() = "AbstractClass01 / abstractMember"
}

fun main() {
    // error
//    val testClass = MiddleAbstractClass()

    val absClass = AbstractClass01()
    println("absClass.abstractMember : ${absClass.abstractMember}")
    absClass.abstractFunction()
}