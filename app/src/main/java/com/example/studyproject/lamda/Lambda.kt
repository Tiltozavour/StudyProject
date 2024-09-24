package com.example.studyproject.lamda


// лямбды - сокращенные виды высших функции

//Удобно комбинировать со связкой when
fun receiveFunTwo(num: Int) {
    return when (num) {
        1 -> { println("Hello") } // лямбды выполняющие действия в зависимости от переданного значения
        else -> { println("World") }
    }
}

fun main() {
    //теже записи только с использованием лямбд
    val greetings = { firstName: String, secondName: String -> println(firstName + secondName) }
    val result = { firstNum: Int, second: Int -> println(firstNum + second) }

    receiveFunTwo(2)
    greetings("John ", "Gold") // вызов функций
    result(3, 5)

}