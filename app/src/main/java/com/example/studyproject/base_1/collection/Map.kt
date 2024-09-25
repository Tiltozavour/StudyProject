package com.example.studyproject.base_1.collection

// Map- неизменяемая коллекция с где все элементы сохраняются как "ключ - значение"
fun main() {
    print("Map result: ")
    val listSimple: Map<Int,String> = mapOf(1 to "Hello", 2 to "World") // Map указывается с двумя параметрами, где 1тип - ключ, а 2тип - значение
    val listType = mapOf<Int, ListExample>() // с необходимым типами также работает
    with(listSimple) { //у map есть свои метотоды:
        keys // получение только ключей
        values // получение только значений
        containsKey(2) // проверить ключ
        containsValue("Kotlin") //проверить значение
    }
    for (i in listSimple) {
        print("${i.key} - ${i.value} ")
    }


    //Изменяемая версия map
    val listMutable: MutableMap<Int, String> = mutableMapOf(1 to "Hello", 2 to "World")
    with(listMutable) {
        put(3, "Kotlin") // вставляем новое значение
        remove(1) // удаляем
        set(2,"Wow") // обновляем старое значение

    }
    println()
    print("Mutable result:")
    for (i in listMutable) {
        print(" $i")
    }
    println()


}

