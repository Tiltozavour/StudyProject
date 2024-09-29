package com.example.studyproject.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class StateFlow():ViewModel() {
    //StateFlow - вид горячих потоков, где поток всегда хранит какое то значение

    data class State(
        val isSuccess:Boolean,
        val isError:Boolean
    )


    private val _state = MutableStateFlow<State>(State(isSuccess = true, isError = false))
    val state = _state.asStateFlow()

    fun getStateScreen(check:Int){
        when(check){
            1 -> _state.value.copy(isError = true)
            else -> _state.value.copy(isSuccess = true)
        }

    }


}