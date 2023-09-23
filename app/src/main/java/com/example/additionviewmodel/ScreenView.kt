package com.example.additionviewmodel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppScreen(
    viewModel: GameViewModel// = androidx.lifecycle.viewmodel.compose.viewModel(),
) {
    val uistate = viewModel.uistate.collectAsState().value
    calculator(
        number1 = uistate.number1,
        number2 = uistate.number2,
        onNumberOneChange = {
            viewModel.UpDateNum1(it)
        },
        onNumberTwoChange = {
            viewModel.UpdateNum2(it)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun calculator(
    number1: String,
    number2: String,
    uiState: UiState,
    onNumberOneChange: (String) -> Unit,
    onNumberTwoChange: (String) -> Unit,
    viewModel: GameViewModel

) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        OutlinedTextField(value = number1,
            onValueChange = onNumberOneChange,
            label = {
                Text(text = "Number 1")
            }

        )
        OutlinedTextField(
            value = number2,
            label = {
                Text(text = "Number Two")
            },
            onValueChange = onNumberTwoChange
        )
        Button(onClick = { viewModel.findSum() }) {
            Text(text = "Find Sum")
        }
        Text(text = "${uiState.outPut}")
    }
}