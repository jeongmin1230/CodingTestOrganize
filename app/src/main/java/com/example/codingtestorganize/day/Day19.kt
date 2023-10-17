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
fun Day19(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableStateOf(0) }
                var array by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이는 행운의 숫자 7을 가장 좋아 합니다. 정수 배열 array 가 매개 변수로 주어질 때, 7이 총 몇 개 있는지 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = array,
                        onValueChange = { array = it },
                        label = { Text(text = ", 기준 array 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    val arrayValues = array.split(",").map { it.trim() }
                    val arrayValuesToArray = arrayValues.mapNotNull { it.toIntOrNull() }.toMutableList()
                    Button(onClick = {
                        show = !show
                        if(show) numberOf7(arrayValuesToArray, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "7의 개수 : ${result.value}")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            array = ""
                            result.value = 0
                        }
                    }
                }
            }
            "2" -> {
                val result = remember { mutableListOf<String>() }
                var myString by remember { mutableStateOf("") }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "문자열 myStr 과 n이 매개 변수로 주어질 때, myStr 을 길이 n씩 잘라서 저장한 배열을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = myString,
                        onValueChange = { myString = it },
                        label = { Text(text = "문자열 myStr")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) cutAndSaveAsArray(myString, n, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("잘라서 배열로 저장 하기 : $result")
                    LaunchedEffect(show) {
                        if(!show) {
                            myString = ""
                            n = ""
                            result.clear()
                        }
                    }
                }
            }
            "3" -> {
                val result = remember { mutableStateOf(0) }
                var array by remember { mutableStateOf("") }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수가 담긴 배열 array 와 정수 n이 매개 변수로 주어질 때, array 에 n이 몇 개 있는 지를 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = array,
                        onValueChange = { array = it },
                        label = { Text(text = ", 기준 array 배열 입력") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    val arrayValues = array.split(",").map { it.trim() }
                    val arrayValuesToArray = arrayValues.mapNotNull { it.toIntOrNull() }.toMutableList()
                    Button(onClick = {
                        show = !show
                        if(show) numberOfDuplicateNumbers(arrayValuesToArray, n, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("중복된 숫자 개수 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            array = ""
                            n = ""
                            result.value = 0
                        }
                    }
                }
            }
            "4" -> {
                val result = remember { mutableStateOf(9) }
                var array by remember { mutableStateOf("") }
                var height by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이는 학교 에서 키 순으로 줄을 설 때 몇 번째로 서야 하는지 궁금 해졌 습니다. 머쓱이네 반 친구 들의 키가 담긴 정수 배열 array 와 머쓱이의 키 height 가 매개 변수로 주어질 때, 머쓱이 보다 키 큰 사람 수를 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = array,
                        onValueChange = { array = it },
                        label = { Text(text = ", 기준 array 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = height,
                        onValueChange = { height = it },
                        label = { Text(text = "정수 height")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    val arrayValues = array.split(",").map { it.trim() }
                    val arrayValuesToArray = arrayValues.mapNotNull { it.toIntOrNull() }.toMutableList()
                    Button(onClick = {
                        show = !show
                        if(show) aPersonTallerThanAShyPerson(arrayValuesToArray, height, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("머쓱이 보다 키 큰 사람 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            array = ""
                            height = ""
                            result.value = 0
                        }
                    }
                }
            }
        }
    }
}

private fun numberOf7(array: MutableList<Int>, result: MutableState<Int>) {
    result.value = array.joinToString(""){ it.toString() }.split("".toRegex()).count{ it == "7" }
    println("7의 개수 : ${result.value}")
}

private fun cutAndSaveAsArray(myStr: String, n: String, result: MutableList<String>) {
    result.addAll(myStr.chunked(n.toInt()).toTypedArray())
    println("잘라서 배열로 저장 하기 : $result")
}

private fun numberOfDuplicateNumbers(array: MutableList<Int>, n: String, result: MutableState<Int>) {
    result.value = array.count{ it == n.toInt()}
    println("중복된 숫자 개수 : ${result.value}")
}


private fun aPersonTallerThanAShyPerson(array: MutableList<Int>, height: String, result: MutableState<Int>) {
    result.value = array.count { height.toInt() < it }
    println("머쓱이 보다 키 큰 사람 : ${result.value}" )
}