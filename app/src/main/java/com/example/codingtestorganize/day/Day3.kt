package com.example.codingtestorganize.day

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.codingtestorganize.R

@Composable
fun Day3(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val answer = remember { mutableStateOf(0) }
                var show by remember { mutableStateOf(false) }
                var num1 by remember { mutableStateOf("") }
                var num2 by remember { mutableStateOf("") }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "정수 num1, num2가 매개 변수로 주어질 때, num1를 num2로 나눈 나머지 를 return 하도록 solution 함수를 완성 해 주세요.")
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
                    if(show) answer.value = findTheRemainder(num1.toInt(), num2.toInt())
                }) {
                    Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                }
                if(show) Text(text = "나머지 구하기 : ${answer.value}")
                LaunchedEffect(show) {
                    if(!show) {
                        num1 = ""
                        num2 = ""
                        answer.value = 0
                    }
                }
            }
            "2" -> {
                val result = remember { mutableStateOf(0) }
                var show by remember { mutableStateOf(false) }
                var inputText by remember { mutableStateOf("") }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "중앙 값은 어떤 주어진 값들을 크기의 순서 대로 정렬 했을 때 가장 중앙에 위치 하는 값을 의미 합니다. 예를 들어 1, 2, 7, 10, 11의 중앙 값은 7입니다. 정수 배열 array 가 매개 변수로 주어질 때, 중앙 값을 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = inputText,
                        onValueChange = { inputText = it },
                        label = { Text(text = ", 기준 array 배열 입력 ")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    val inputValues = inputText.split(",").map { it.trim() }
                    val intValues = inputValues.mapNotNull { it.toIntOrNull() }.toMutableList()
                    Button(onClick = {
                        show = !show
                        if(show) result.value = findTheMedian(intValues)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "중앙값 구하기 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            inputText = ""
                            intValues.clear()
                            result.value = 0
                        }
                    }
                }
            }
            "3" -> {
                val result = remember { mutableStateOf(0) }
                var show by remember { mutableStateOf(false) }
                var inputText by remember { mutableStateOf("") }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "최빈 값은 주어진 값 중에서 가장 자주 나오는 값을 의미 합니다. 정수 배열 array 가 매개 변수로 주어질 때, 최빈 값을 return 하도록 solution 함수를 완성 해 보세요. 최빈 값이 여러 개면 -1을 return 합니다.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = inputText,
                        onValueChange = { inputText = it },
                        label = { Text(text = ", 기준 array 배열 입력 ")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    val inputValues = inputText.split(",").map { it.trim() }
                    val intValues = inputValues.mapNotNull { it.toIntOrNull() }.toMutableList()
                    Button(onClick = {
                        show = !show
                        if(show) result.value = findTheMode(intValues)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "최빈값 구하기 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            inputText = ""
                            intValues.clear()
                            result.value = 0
                        }
                    }
                }
            }
            "4" -> {
                val hateEvenNumbers = remember { mutableListOf<Int>() }
                var show by remember { mutableStateOf(false) }
                var inputNumber by remember { mutableStateOf("") }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 n이 매개 변수로 주어질 때, n 이하의 홀수가 오름차 순으로 담긴 배열을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = inputNumber,
                        onValueChange = { inputNumber = it },
                        label = { Text(text = "정수 n")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) hateEvenNumbers.addAll(hateEvenNumbers(inputNumber.toInt()))
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "짝수는 싫어요 : $hateEvenNumbers")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            inputNumber = ""
                            hateEvenNumbers.clear()
                        }
                    }
                }
            }
        }
    }
}

private fun findTheRemainder(num1: Int, num2: Int): Int {
    println("나머지 구하기")
    var answer = 0
    answer = num1%num2
    return answer
}

private fun findTheMedian(array: MutableList<Int>): Int {
    println("중앙값 구하기")
    var answer = 0
    array.sort()
    answer = array[array.size/2]
    return answer
}

private fun findTheMode(array: MutableList<Int>): Int {
    println("최빈값 구하기")
    var answer = 0
    val arrayGroupValue = array.groupBy { it }.entries.sortedByDescending { (_, value) -> value.size }
    val returnValue = if(arrayGroupValue.size > 1 && arrayGroupValue[0].value.size == arrayGroupValue[1].value.size) -1 else arrayGroupValue[0].key
    answer = returnValue
    return answer
}

private fun hateEvenNumbers(n: Int): MutableList<Int> {
    println("짝수는 싫어요")
    val mutableList = mutableListOf<Int>()
    (0..n).filter { it % 2 == 1 }.toIntArray().forEach {
        mutableList.add(it)
    }
    return mutableList
}