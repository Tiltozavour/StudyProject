package com.example.studyproject.OOP

//Наследование

open class Parent() {  // По умолчанию классы в котлин private, для наследования базового класса используется ключевое слово open
    val firstNumberForExample = 10
    open fun doSmthg() {
        println("Do something")
    }
}

class Child() : Parent() { // класс -наследник может взаимодействовать и расширять функции базового класа

    fun printParentNumber(){
        println("Parent " + Parent().firstNumberForExample)
    }
    override fun doSmthg() { // либо изменять поведение(полиморфизм)
        println("Nope")
    }
}

fun main() {
    Child().doSmthg() //
    println(Child().firstNumberForExample)
    Child().printParentNumber()
}

