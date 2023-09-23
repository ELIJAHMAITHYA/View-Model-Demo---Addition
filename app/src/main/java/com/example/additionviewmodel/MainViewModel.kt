package com.example.additionviewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(UiState())
    val uistate = _uiState.asStateFlow()

    fun findSum() {
        var output =_uiState.value.number1.toInt() + _uiState.value.number2.toInt()
        _uiState.update {
            it.copy(
                outPut = output.toString()
            )
        }
    }

    fun UpDateNum1(number1: String) {
        _uiState.update {
            it.copy(
                number1 = number1
            )
        }
    }

    fun UpdateNum2(number2: String) {
        _uiState.update {
            it.copy(
                number2 = number2
            )
        }
    }
}

