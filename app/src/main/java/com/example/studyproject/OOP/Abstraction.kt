package com.example.studyproject.OOP

abstract class AbstractExample(val name:String){ //Абстрактные классы определяют поведение для классов наследников.
    fun doSmthg(){
        println("Hello world и $name")
    }
        abstract fun doSmthAbstract() //абстрактные функции не имеют реализации
}

 class GetAbstract(name: String):AbstractExample(name) {
     fun  anotherFunction(){
         println("Hello?")
     }
    override fun doSmthAbstract() {  // т.к. функции не имела реавлизации, мы должны ее переопределить
        println("Hello world, again")
    }
}

fun main() {
   // AbstractExample("John") //Абстрактные классы можно только унаследовать, создавать экземпляры данного класса нельзя
    GetAbstract("John").anotherFunction()
    GetAbstract("John").doSmthg()
    GetAbstract("John").doSmthAbstract()
}




