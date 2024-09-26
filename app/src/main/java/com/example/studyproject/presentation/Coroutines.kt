package com.example.studyproject.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Coroutines : ViewModel() {

    private fun ordinaryFun() {
        Log.d(
            TAG,
            "SimpleMethod"
        ) //"простая" операция не заблокирует UI и может выполнятся на главном потоке
    }

    // Многопоточность в Kotlin, обеспечивается с помощью корутин и прерываемых функций
    private suspend fun smthHeavyMethod() {  //Прерываемые функции помечены как suspend
        delay(3000) // "Тяжелые" методы, те что потенциально могут заблокировать главный поток (такие как обращение к интренету или бд) следует выносить в фоновый
        Log.d(TAG, "Heavy method")
    }

    // Scope  для запуска suspend-функций
    // Мы можем создать собственный scope
    //для этого в скоуп передается один из четырех составляющих coroutineContext
    private val ownScope =
        CoroutineScope(Dispatchers.Main) // В данном случае передается диспатчер(поток), где Main - Главный, IO - фоновый (потоки сохдаются по задачам), Default - фоновый, количество потоков завист от пргоцессора устройства и Unconfned - любой поток
    // также возможно передать объект job(), ExceptionHandler, и название корутины. Их также можно добавить в скоуп к диспатчеру
    // Скоупы могут быть и программными
    // viewModelScope - с ЖЦ VM(нужна библиотека)
    // lifeCycleScope - для активити или фрагментов

    fun getAll() {
        ordinaryFun()
        // smthHeavyMethod() // при попытке вызова suspend-метода в другом месте, возникнет ошибка, такие функции должны запускаться только из под другой такой функции или Scope
        // Scope является точкой входа для корутин и suspend функции
        ownScope.launch {
            smthHeavyMethod() //ошибки не возникает, потому что корутина запущена из под скоупа
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------
    // launch и acync
    fun getAcyncOrLaunch() {
        //возращаемый тип в launch - job(), одна из многих ее полезных функций дождаться выполнение корутины
        ownScope.launch {
            ownScope.launch {
                waitingCoroutines()
            }.join() // тут мы уверены что точно дождемся что корутина выполнит свои функции
        }
        Log.d(TAG, "Корутина выполнилась")
        // возращаемый тип в acync - Deffered<>,  что позволяет нам получать значения из-под корутины,
        //await() используется для получения значений
        ownScope.async {
            val string = ownScope.async {
                getSmth()
            }.await()
            Log.d(TAG, "$string")
        }
    }

    private suspend fun getSmth(): String {
        delay(3000)
        return "String here"
    }

    private suspend fun waitingCoroutines() {
        delay(3000)
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------
    // Переключение потоков
    //Ответсвенность за переклчение потоков при использовании собственных скоупов лежит так же на нас
    //переключить поток возможно с помощью coroutineContext
    private suspend fun anotherHeavyMethod() {
        withContext(Dispatchers.IO){ // режим Диспатчера выбирается исходя из задачи
            Log.d("testCoroutines", "Поток переключен на фоновый")
            // мы можем также вернутся на главный поток обратно
            withContext(Dispatchers.Main){
                Log.d(TAG, "Поток вернулся на главный")
            }
        }
    }

    fun getStream(){
            ownScope.launch {
                anotherHeavyMethod()
            }

    }



    //----------------------------------------------------------------------------------------------------------

    override fun onCleared() {
        super.onCleared()
        ownScope.cancel() //собственные скоупы нужно не забывать отменять, т.к они не привязаны ни к какому жц и будут висеть в памяти
        // для библиотечных скоупов в этом нет необходимости
    }


    companion object {

        private const val TAG = "testCoroutines"


    }

}


