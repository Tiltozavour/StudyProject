package com.example.studyproject.OOP

// Инкапсуляция
// Public и Private
class HiddenString(/*protected val protectedStringTest: String*/) { // Классы имеют модификатор public по умолчанию
    val listVisible =
        "Visible" // public-модификаторы видны по всему проекту, и обращаться к этим объектам тоже разрешается
    private val listHide =
        "Gone" // private-модификатор ограничивает доступ только для зоны видимости (в данном случае только в объявленном классе)

    protected val listProtected =
        "Invisible" // protected видны только на уровне класса или в классах-наследнках

    fun getHiddenList(): String {
        return listHide
    }

    private fun doSmthgWithHidden() {
        println(listVisible.hashCode())
        println(listHide.hashCode())
    }
}

private class HiddenPrivateString() {
    val secretString = "secret"
    private val superSecretString = "super_secret"
}


internal class VisibleModule() {
    internal val listEveryWhere = "Hello module" // internal видны на уровне всего модуля проекта
}

fun main() {
    println(HiddenString().listVisible)
    //println(HiddenList().listHide) // При попытке вызвать private-переменную возникает ошибка
    //println(HiddenString().doSmthgWithHidden()) // Как и при попытке вызвать private-метод
    //println(HiddenString().listSpecial) // функция main не наследник класса HiddenString, поэтому не видит protected строку
    println(HiddenString().getHiddenList()) // Вызов данных с private-модификатором с помощью функции
    println(HiddenPrivateString().secretString) // мы можем вызвать данные private - class_а в его области видимости
    // println(HiddenPrivateString().superSecretString) //опять же не можем  получить private - переменную
}


