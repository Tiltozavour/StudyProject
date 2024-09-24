package com.example.studyproject.lamda

// Функции высшего порядка, это функции которые принимают функцию как параметр...
fun funHighParametr(firstNum:Int, secondNm:Int, someFun:(Int,Int) -> Int){ // функция принимает два параметра и функцию-параметр
    val result = someFun(firstNum,secondNm) // прописываем какими данными может пользоваться функция
    println(result)
}

fun anotherHigh(name:String, latestName:String, anotherFun:(String,String)->String) {
    println(anotherFun(name, latestName)) // вывод двух строк в одну
}

fun sum(firstNum: Int,secondNm: Int):Int {
    return firstNum + secondNm  // функция для функции
}
fun divide(firstNum: Int, secondNm: Int):Int {
    return firstNum / secondNm  // функция для функции 2
}
fun fullName(name: String, latestName: String):String{
    return "$name $latestName" //функция для функции 3
}


// ... или имеют возращаемый тип как функцию

fun receiveFun(num:Int):(Int,Int)-> Int{  // в данном случае при определенном значении Int функция должна вернуть функцию
   return when(num) {
        1 ->  ::divide
        else -> ::sum
    }
    }

fun main(){
    funHighParametr(3,5, ::sum) // вызов высшей функции, передача параметров и функции для реализации
    anotherHigh("John", "Gold", ::fullName)
    val result = receiveFun(2)
    println(result(4,5)) // получаем результат функции

}



