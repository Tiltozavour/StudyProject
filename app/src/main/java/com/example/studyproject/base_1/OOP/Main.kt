package com.example.studyproject.base_1.OOP

fun main() {

// Инкапсуляция. Вызов вне класса
    println(HiddenString().listVisible)
    println(HiddenString().getHiddenList()) // Вызов данных с private-модификатором с помощью функции возможен и в другом месте программы, потому класс является Public
    //println(HiddenPrivateString().superSecretString) // Опять же нельзя вызвать private class  в другом месте программы
}


