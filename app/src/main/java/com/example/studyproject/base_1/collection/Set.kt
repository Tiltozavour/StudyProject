package com.example.studyproject.base_1.collection

// Set - неизменяемая коллекция с последовательными уникальными элементами
fun main() {
    val listSimple: Set<Int> = setOf<Int>(1, 2, 3, 1, 1)// мы можем создать пустую коллекцию с указанным "стандартным" типом
    val listType = listOf<ListExample>() // или с необходимым типом
    print("Set result:")
    for (i in listSimple) {
        print(" $i") // даже если мы добавим в коллекцию повторные значения, в коллекции повторов не будет
    }
    println()
    // Также как и у list, есть изменяемая версия
    val listMutable: MutableSet<Int> = mutableSetOf()
    val listTypeMutable = mutableSetOf<ListExample>()
    with(listMutable) { //теперь снова мы можем взаимодействовать на элементы коллекции
        add(3)
        addAll(listSimple)
        remove(4)
    }

    print("Mutable result:")
    for (i in listMutable) {
        print(" $i")
    }
    println()
}

