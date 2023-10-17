package com.example.codingtestorganize.day

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.codingtestorganize.R

@Composable
fun Day1(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val answer = remember { mutableStateOf(0) }
                var show by remember { mutableStateOf(false) }
                var num1 by remember { mutableStateOf("") }
                var num2 by remember { mutableStateOf("") }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text("정수 num1과 num2가 주어질 때, num1과 num2의 합을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = num1,
                        onValueChange = { num1 = it },
                        label = { Text(text = "정수 num1") },
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .fillMaxWidth()
                    )
                    TextField(
                        value = num2,
                        onValueChange = { num2 = it },
                        label = { Text(text = "정수 num2") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) sumOfTwoNumbers(num1, num2, answer)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "두 수의 합 : ${answer.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            num1 = ""
                            num2 = ""
                            answer.value = 0
                        }
                    }
                }
            }
            "2" -> {
                val answer = remember { mutableStateOf(0) }
                var show by remember { mutableStateOf(false) }
                var num1 by remember { mutableStateOf("") }
                var num2 by remember { mutableStateOf("") }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 num1과 num2가 주어질 때, num1에서 num2를 뺀 값을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = num1,
                        onValueChange = { num1 = it },
                        label = { Text(text = "정수 num1") },
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .fillMaxWidth()
                    )
                    TextField(
                        value = num2,
                        onValueChange = { num2 = it },
                        label = { Text(text = "정수 num2") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) differenceBetweenTwoNumbers(num1, num2, answer)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "두 수의 차 : ${answer.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            num1 = ""
                            num2 = ""
                            answer.value = 0
                        }
                    }
                }
            }
            "3" -> {
                val answer = remember { mutableStateOf(0) }
                var show by remember { mutableStateOf(false) }
                var num1 by remember { mutableStateOf("") }
                var num2 by remember { mutableStateOf("") }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 num1과 num2가 주어질 때, num1에서 num2를 뺀 값을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = num1,
                        onValueChange = { num1 = it },
                        label = { Text(text = "정수 num1") },
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .fillMaxWidth()
                    )
                    TextField(
                        value = num2,
                        onValueChange = { num2 = it },
                        label = { Text(text = "정수 num2") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) productOfTwoNumbers(num1, num2, answer)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "두 수의 곱 : ${answer.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            num1 = ""
                            num2 = ""
                            answer.value = 0
                        }
                    }
                }
            }
            "4" -> {
                val answer = remember { mutableStateOf(0) }
                var show by remember { mutableStateOf(false) }
                var num1 by remember { mutableStateOf("") }
                var num2 by remember { mutableStateOf("") }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 num1, num2가 매개 변수로 주어 집니다. num1과 num2를 곱한 값을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = num1,
                        onValueChange = { num1 = it },
                        label = { Text(text = "정수 num1") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = num2,
                        onValueChange = { num2 = it },
                        label = { Text(text = "정수 num2") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) findTheQuotient(num1, num2, answer)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "몫 구하기 : ${answer.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            num1 = ""
                            num2 = ""
                            answer.value = 0
                        }
                    }
                }
            }
        }
    }
}

private fun sumOfTwoNumbers(num1: String, num2: String, answer: MutableState<Int>) {
    if(num1.isNotEmpty() && num2.isNotEmpty()) {
        answer.value = num1.toInt() + num2.toInt()
        println("두 수의 합 : ${num1.toInt()+num2.toInt()}")
    }
}

private fun differenceBetweenTwoNumbers(num1: String, num2: String, answer: MutableState<Int>) {
    if(num1.isNotEmpty() && num2.isNotEmpty()) {
        answer.value = num1.toInt() - num2.toInt()
        println("두 수의 차 : ${num1.toInt()-num2.toInt()}")
    }
}

private fun productOfTwoNumbers(num1: String, num2: String, answer: MutableState<Int>) {
    if(num1.isNotEmpty() && num2.isNotEmpty()) {
        answer.value = num1.toInt() * num2.toInt()
        println("두 수의 곱 : ${num1.toInt()*num2.toInt()}")
    }
}

private fun findTheQuotient(num1: String, num2: String, answer: MutableState<Int>) {
    if(num1.isNotEmpty() && num2.isNotEmpty()) {
        answer.value = num1.toInt()/num2.toInt()
        println("몫 구하기 : ${num1.toInt()/num2.toInt()}")
    }
}