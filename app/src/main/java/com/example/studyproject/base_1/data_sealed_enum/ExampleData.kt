package com.example.studyproject.base_1.data_sealed_enum

//Data-классы данных
data class ExampleData(
    val name: String, // должны обязательно содержать хоть один параметр
    var age: Int, //значения внутри либо val, либо var
    val info: State
)

data class State(
    val isSuccess: Boolean = false,
    val isError: Boolean = false
)
/*open data class ErrorOne(val test:String)
abstract data class ErrorTwo(val test:String)
sealed data class ErrorThree(val test:String)
inner data class ErrorFour(val test:String)*/ //Data классы не могут быть open, abstract, sealed или inner.

// У data-классов переопределены методы toString(), equals(), hashcode(), copy(),componentN(), например:
fun main() {

    val dataPerson = ExampleData("NameOne", 0, State())
    val dataPersonTwo = ExampleData("NameOne", 0, State())
    println(dataPerson) // благодаря переопределенному методу toString() в консоль выыведется имя, возраст и состояние, а не ссылка на объект

    val ordinaryPerson = Test("NameTwo", 0)
    println(ordinaryPerson) //вызов через обычный класс для сравнения
    val ordinaryPersonTwo = Test("NameTwo", 0)

    //У data-классов один и тотже хэшкод даже если имена разные
    println(dataPersonTwo.hashCode())
    println(dataPerson.hashCode())

    //У обычных нет
    println(ordinaryPerson.hashCode())
    println(ordinaryPersonTwo.hashCode())
}


class Test(val name: String, var age: Int)