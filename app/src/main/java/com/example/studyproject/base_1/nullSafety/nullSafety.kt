package com.example.studyproject.base_1.nullSafety

fun main() {
    //Kotin ограничивает возможность нарваться на NPE, объекты являются не нуллабельнными по умолчанию
    //val notNull:String = null // при попытке присвоить null не ненулабельном объекте будет ошибка
    val thisNull: String? =
        null // если мы не уверены что объект будет не нуллабельный, для этого исп-ют ?, тогда при вызове краша не пройизойдет
    // Например при получении токена от сервера, если он не null придет токен, если null выбрасывается ошибка
    // val refreshToken = responseAnswerServer.body()?.refreshToken ?: throw RuntimeException("RefreshToken does`t have exist")
    //удобно использовать метод let, который выполнит функцию если значение не null,
    // или не будет выполнять функцию вовсе
    val thisIsNotNull = "null"
    thisIsNotNull.let {
        println(it.length) //выполнится, т.к переменная не null
    }
    //если нам всё таки необходимо вызвать небезопасные местоды используется !! (считается плохой практикой)
    //Например:
    //private fun currentViewState(): ViewState = viewState.value!! //был необходим для обработки дефолт состояни
}