package com.example.studyproject.presentation

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

private val scope = CoroutineScope(Dispatchers.IO)

//Горячие потоки
suspend fun main(){
    val hotFlow = MutableSharedFlow<String>() //Горячие потоки могут быть созданы через интерфейс Shared
    hotFlow.emit("Outside") //Мы можем заэммитеть данные для горячего флоу снаружи

    scope.launch {
        repeat(10){
            println("Hello $it")
            hotFlow.emit("$it")
            delay(1000)
        }
    }

    val job0 = scope.launch {
        println("cancel hot flow ${hotFlow.first()}" )
    // Горячие потоки эммитят данные не смотря на то что есть подписчики или нет (при холодных программа здесь завершилась)
    }

    val job1 = scope.launch {
        hotFlow.collect { //
            println("first hotFlow $it" )
        } // HotFlow завершит свою работу только при завершении программы, а не после того как завершаться работа над потоками

    }
    delay(5000)
    val job2 = scope.launch {
        hotFlow.collect {//
            println("second hotflow $it" ) // Все подписчики деляться значением эммитов (работают с одном и тем же потоком) при создании, а не создает поток заново (поэтому вывод второго потока будет с цифры 5, а не 0)
        }
    }
    job0.join()
    job1.join()
    job2.join()

}







