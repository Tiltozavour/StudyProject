/*
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

}


    sealed interface stateInterface{
        fun getFirstState()
        fun getSecondState()
    }

sealed class ViewState(){
    class One():stateInterface {
        override fun getFirstState() {
            println("такой стейт")
        }
        override fun getSecondState() {
            println("другой стейт")
        }
    }

}

class Another() :
    ExampleSealed() //sealed классы открыты для наследования по умолчанию (без open), но только в файле

fun main() {
    val choice = ExampleSealed.One()
    choice.greetings()

    val state = ViewState.One()

    fun anotherChoice(sealedTest: ViewState) { // также через when оператор
        return when (sealedTest) {
            is -> println("Hello")
            else -> (println("nope"))
        }
    }
    anotherChoice(state)


}
*/
