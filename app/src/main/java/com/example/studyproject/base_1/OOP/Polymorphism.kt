package com.example.studyproject.base_1.OOP

// Полиморфиз как перегрузка
class PolimorfPeregruz {
    fun polimorf() {}
    fun polimorf(name: String) {
        println("World")
    }
    fun polimorf(name: String, age: Int) {}
}

open class PolymorphismClass() {
    val typeFirst = "Hello"
    open fun getSmth() {
        // }
    }
}

class overridePoly() : PolymorphismClass() {
    override fun getSmth() {
        super.getSmth()  // мы можем изменять поведение родительского класса на свое усмотрение
    }
}


interface Polymorphism { // Интерфейсы позволяют определелить функции для дальнейшего переопределения
    fun hello()
    fun world()
}

// Полиморфизм как переопределение
class GetPolimorfism() : Polymorphism {
    override fun hello() { // интерфейсы не имеют своей реализации, поэтому при их вызове необходимо их определение
        println("Hello")
    }

    override fun world() {
        println("World")
    }
}


fun main() {
    PolimorfPeregruz().polimorf("Anna") // нужный метод выбирается по переданным аргументам, не смотря на то что методы имеют одно и тоже имя
}
