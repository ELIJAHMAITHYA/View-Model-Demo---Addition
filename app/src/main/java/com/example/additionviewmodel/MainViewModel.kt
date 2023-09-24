package com.example.additionviewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(UiState())
    val uistate = _uiState.asStateFlow()

    fun findSum() {
        val num1 = _uiState.value.number1.toIntOrNull() ?: 0
        val num2 =  _uiState.value.number2.toIntOrNull() ?: 0
        var output = num1 + num2
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

