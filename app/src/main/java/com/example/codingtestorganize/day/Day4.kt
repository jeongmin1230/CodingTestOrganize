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
fun Day4(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val answer = remember { mutableStateOf(0) }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이네 피자 가게는 피자를 일곱 조각 으로 잘라 줍니다. 피자를 나눠 먹을 사람의 수 n이 주어질 때, 모든 사람이 피자를 한 조각 이상 먹기 위해 필요한 피자의 수를 return 하는 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) sharingPizza1(n, answer)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "피자 나눠 먹기(1) : ${answer.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            n = ""
                            answer.value = 0
                        }
                    }
                }
            }
            "2" -> {
                val answer = remember { mutableStateOf(0) }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이네 피자 가게는 피자를 여섯 조각 으로 잘라 줍니다. 피자를 나눠 먹을 사람의 수 n이 매개 변수로 주어질 때, n명이 주문한 피자를 남기지 않고 모두 같은 수의 피자 조각을 먹어야 한다면 최소 몇 판을 시켜야 하는 지를 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n") },
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) sharingPizza2(n, answer)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "피자 나눠 먹기(2) : ${answer.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            n = ""
                            answer.value = 0
                        }
                    }
                }
            }
            "3" -> {
                val answer = remember { mutableStateOf(0) }
                var slice by remember { mutableStateOf("") }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이네 피자 가게는 피자를 두 조각 에서 열 조각 까지 원하는 조각 수로 잘라 줍니다. 피자 조각 수 slice 와 피자를 먹는 사람의 수 n이 매개 변수로 주어질 때, n명의 사람이 최소 한 조각 이상 피자를 먹으 려면 최소 몇 판의 피자를 시켜야 하는 지를 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = slice,
                        onValueChange = { slice = it },
                        label = { Text(text = "정수 slice") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n") },
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) sharingPizza3(slice, n, answer)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "피자 나눠 먹기(3) : ${answer.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            slice = ""
                            n = ""
                            answer.value = 0
                        }
                    }
                }
            }
            "4" -> {
                val floatAnswer = remember { mutableStateOf(0.0) }
                var inputNumbers by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 배열 numbers 가 매개 변수로 주어 집니다. numbers 의 원소의 평균 값을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = inputNumbers,
                        onValueChange = { inputNumbers = it },
                        label = { Text(text = ", 기준 numbers 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    val inputValues = inputNumbers.split(",").map { it.trim() }
                    val intValues = inputValues.mapNotNull { it.toIntOrNull() }.toMutableList()
                    Button(onClick = {
                        show = !show
                        if(show) averageValueOfArray(intValues, floatAnswer)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "배열의 평균 값 : ${floatAnswer.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            inputNumbers = ""
                            intValues.clear()
                            floatAnswer.value = 0.0
                        }
                    }
                }
            }
        }
    }
}

private fun sharingPizza1(n: String, answer: MutableState<Int>) {
    if(n.isNotEmpty()) {
        answer.value = if(n.toInt()%7 == 0) n.toInt()/7 else n.toInt()/7+1
        println("피자 나눠 먹기(1) : ${answer.value}")
    }
}

private fun sharingPizza2(n: String, answer: MutableState<Int>) {
    val lcmValue = lcm(n.toInt(), 6)
    answer.value = lcmValue/6
    println("피자 나눠 먹기(2) : ${answer.value}")
}

private fun lcm(a: Int, b: Int): Int {
    return a * b / gcd(a, b)
}
private fun gcd(a : Int, b: Int): Int {
    return if(a < b) {
        if(a == 0) b else gcd(a, b % a)
    } else {
        if(b == 0) a else gcd(b, a % b)
    }
}

private fun sharingPizza3(slice: String, n: String, answer: MutableState<Int>) {
    if(slice.isNotEmpty() && n.isNotEmpty()) {
        answer.value = if(n.toInt()%slice.toInt() == 0) n.toInt()/slice.toInt() else n.toInt()/slice.toInt() + 1
        println("피자 나눠 먹기(3) : ${answer.value}")
    }
}

private fun averageValueOfArray(numbers: MutableList<Int>, answer: MutableState<Double>) {
    var sum = 0.0
    if(numbers.isNotEmpty()) {
        for(i in 0 until numbers.size) {
            sum += numbers[i]
        }
        answer.value = sum/numbers.size
        println("배열의 평균값 : ${answer.value}")
    }
}