package com.example.studyproject.base_1.data_sealed_enum

sealed class ExampleSealed() { //Sealed-классы позвляют асширит возможности enum, чтобы описывать несколько состояний, а не только константы
    class One() : ExampleSealed() {
        fun greetings() {
            println("Hello")
        }
    }

    class Two() : ExampleSealed() {
        fun anotherGreetings() {
            println("AnotherHello")
        }
    }

    data class Three(val name: String)
}

class Another() :
    ExampleSealed() //sealed классы открыты для наследования по умолчанию (без open), но только в файле

fun main() {
    val choice = ExampleSealed.One()
    choice.greetings()

    fun anotherChoice(sealedTest: ExampleSealed) { // также через when оператор
        return when (sealedTest) {
            is ExampleSealed.One -> println("Hello")
            is ExampleSealed.Two -> println("World")
            else -> (println("nope"))
        }
    }
    anotherChoice(choice)


}
