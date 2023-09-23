package com.example.additionviewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(UiState())
    val uistate = _uiState.asStateFlow()

    fun findSum() {
        var output = uistate.value.number1.toInt() + uistate.value.number2.toInt()
        _uiState.update {
            it.copy(
                outPut = output.toString()
            )
        }
    }

    fun UpDateNum1() {
        _uiState.update {
            it.copy(
                number1 = uistate.value.number1.toString()
            )
        }
    }

    fun UpdateNum2() {
        _uiState.update {
            it.copy(
                number2 = uistate.value.number2.toString()
            )
        }
    }
}

