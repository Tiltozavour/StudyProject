package com.example.studyproject.base_1.collection



// List - неизменяемая коллекция с последовательными неуникальными элементами
fun main() {
    val listSimple: List<Int> = listOf<Int>(1, 2, 3, 1, 1)// мы можем создать пустую коллекцию с указанным "стандартным" типом
    val listType = listOf<ListExample>() // или с необходимым типом
    with(listSimple) { //мы можем взаимодействовать с лист через встроенные методы, например:
        get(0) //получение элемента
        getOrNull(1) // получение элемента или null
    }

    print("List result:")
    for (i in listSimple) {
        print(" $i")
    }
    println()
    //Изменяемая версия представлена с помощью mutableList
    val listMutable: MutableList<Int> = mutableListOf()
    val listTypeMutable = mutableListOf<ListExample>() // также и для собственных типов
    with(listMutable) { //теперь мы можем и добавлять и удалять элементы из коллекции
        add(3)
        addAll(listSimple)
        get(0)
        remove(4)
        sort()
    }

    print("Mutable result:")
    for (i in listMutable) {
        print(" $i")
    }
    println()
    val listArr = ArrayList<Int>()  // mutable версию также можно записать через Array
    with(listArr) {
        addAll(listSimple)
        sort()
    }
    print("Array result:")

    for (i in listArr) {
        print(" $i")
    }

}
data class ListExample(
    val element: Int,
    val name: String,
    val state: Boolean
)
