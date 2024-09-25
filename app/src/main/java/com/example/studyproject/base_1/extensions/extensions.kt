package com.example.studyproject.base_1.extensions

fun main() {

    data class ExampleChoice(
        val name: String
    )

    //Расширяющие функции позволяют добавить новый функционал классов при необходимости
    fun ExampleChoice.helloGreetings(): String = "Hello $name" // Например нам нужна функция, которая здоровается с пользователем
    // для этого к эземпляру класса описывается функция которая выводит надпись приветствия

    fun output(name: ExampleChoice): String {
        return name.helloGreetings() //теперь класс имеет метод который мы можем вызвать в любой удобный момент
    }

    //println(output(ExampleChoice("Agatha")))
    println(ExampleChoice("Madela").helloGreetings()) //сокращенная запись

    // Расширяются не только созданные вручную классы, но и стандартные
    fun String.getHeart(): String = "$this♥"
    println("Hello".getHeart())

    //а также коллекции
    fun ArrayList<Int>.methodPrint() {
        for (i in this) {
            print("$i ")
        }
    }
    val arrayExample:ArrayList<Int> = arrayListOf(1,2,57,133)
        arrayExample.methodPrint()


}

