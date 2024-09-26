package com.example.studyproject.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinesException : ViewModel() {
    //Обычный перехватчик ошибок выполняется черз блок try-catch
    private fun ordinaryError() {
        try {
            smtgMth() //попытка выполнить метод
        } catch (_: Exception) { //в случае ошибки, она обрабатывается
            Log.d(TAG, "Ошибка поймана")
        }
    }

    private fun smtgMth() {
        Log.d(TAG, "Метод с возможной ошибкой")
    }

    fun ordinaryFun() {
        ordinaryError()
    }

    //----------------------------------------------------------------------------------------------------------
    //В корутинах есть возможность обрабатывать ошибки не только в местах ее возможного возникновения (также через try/catch)
    // Но и с помощью Handlera, который передается в созданный скоуп
    private val exceptionHandler =
        CoroutineExceptionHandler { _, throwable -> Log.d(TAG, "Поймали ошибку") }
    private val ownScope = CoroutineScope(Dispatchers.Main + exceptionHandler)
    fun smtErrorMethod() {
        ownScope.launch {
            delay(1000)
            try {
                error()
            } catch (e: Exception) {
                Log.d(TAG, "Поймали ошибку")
            }
        }
        ownScope.launch {
            error()
        }

    }

    private fun error() {
        throw RuntimeException()
    }

    companion object {
        private const val TAG = "testException"
    }

    override fun onCleared() {
        super.onCleared()
        ownScope.cancel()
    }


}
