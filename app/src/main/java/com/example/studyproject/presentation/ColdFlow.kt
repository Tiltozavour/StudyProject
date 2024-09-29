package com.example.studyproject.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

//Потоки могут быть как холодными и горячими
private val scope = CoroutineScope(Dispatchers.IO)

//Холодные потоки
private fun coldFlowFirst(): Flow<String> {
    return flow {
        repeat(10) {
            println("first cold flow $it")
            emit("Hell0!") // При создании холодных flow, все данные должны быть известны изначально
            delay(1000) // Flow "под капотом" поддерживают корутины, поэтому такие методы вызываются без проблем
        }
    }
}

suspend fun main() {
    val flow = coldFlowFirst()
    val job1 = scope.launch {
        coldFlowFirst().collect { // Flow выполняются только есть подписка (вызов терминального оператора)
            println(it)
        }   //Если данные больше не нужны или они закончаться поток завершит свою работу
    }
    val job2 = scope.launch {
        coldFlowFirst().collect {// Для каждой подписки создасться новый поток
            println(it)
        }
    }

    job1.join()
    job2.join()
}




