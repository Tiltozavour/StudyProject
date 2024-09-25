package com.example.studyproject.base_1.data_sealed_enum

// Enum класс перечисление, когда известны все возможные варианты(константы)
enum class ExampleEnum {
    TOP, MID, BOTTOM
}

fun main() {
    val pos = ExampleEnum.BOTTOM
    when (pos) { //обработка enum с помощью when
        ExampleEnum.MID -> println("Это центр")
        ExampleEnum.TOP -> println("Это верх") //ругается потому что определенный енам уже указан
        ExampleEnum.BOTTOM -> println("Это низ")
        else -> println() //else не нужен потому что enum обеспечивает все варианты
    }
        //enumы неплохо дружат с интерфейсами и абстрактными методами
        EnumWithInterfaces.MID.getClarity()
        EnumWithAbstract.TOP.smthAbst()
}

 enum class EnumWithInterfaces : SmthMethod {
    TOP {
        override fun getClarity() {
            println("getIt")
        }
    },
    MID {
        override fun getClarity() {
            println("Nope")
        }
    }
}
interface SmthMethod {
    fun getClarity()
}


 enum class EnumWithAbstract {
 TOP {
     override fun smthAbst() {
         println("hello")
     }
 },
 MID {
     override fun smthAbst() {
         println("world")
     }
 },
     BOTTOM{
         override fun smthAbst() {
             println("again")
         }
     };
     abstract fun smthAbst()

}





