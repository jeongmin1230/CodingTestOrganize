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
fun Day15(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableStateOf("") }
                var numbers by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "영어가 싫은 머쓱이는 영어로 표기 되어 있는 숫자를 수로 바꾸려고 합니다. 문자열 number s가 매개 변수로 주어질 때, numbers 를 정수로 바꿔 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = numbers,
                        onValueChange = { numbers = it },
                        label = { Text(text = "문자열 numbers")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) result.value = hateEnglish(numbers)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "영어가 싫어요 : ${result.value}")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            numbers = ""
                            result.value = ""
                        }
                    }
                }
            }
            "2" -> {
                val result = remember { mutableStateOf("") }
                var myString by remember { mutableStateOf("") }
                var num1 by remember { mutableStateOf("") }
                var num2 by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "문자열 myString 과 정수 num1, num2가 매개 변수로 주어질 때, myString 에서 인덱스 num1과 인덱스 num2에 해당 하는 문자를 바꾼 문자 열을 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = myString,
                        onValueChange = { myString = it },
                        label = { Text(text = "문자열 myString")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = num1,
                        onValueChange = { num1 = it },
                        label = { Text(text = "정수 num1")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = num2,
                        onValueChange = { num2 = it },
                        label = { Text(text = "정수 num2")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = changeIndex(myString, num1.toInt(), num2.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("인덱스 바꾸기 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            myString = ""
                            num1 = ""
                            num2 = ""
                            result.value = ""
                        }
                    }
                }
            }
            "3" -> {
                val result = remember { mutableStateOf("") }
                var s by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "문자열 s가 매개 변수로 주어 집니다. s에서 한 번만 등장 하는 문자를 사전 순으로 정렬한 문자 열을 return 하도록 solution 함수를 완성 해 보세요. 한 번만 등장 하는 문자가 없을 경우 빈 문자 열을 return 합니다.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = s,
                        onValueChange = { s = it },
                        label = { Text(text = "문자열 s") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) result.value = characterThatAppearsOnlyOnce(s)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("한 번만 등장한 문자 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            s = ""
                            result.value = ""
                        }
                    }
                }
            }
            "4" -> {
                val result = remember { mutableListOf<Int>() }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 n이 매개 변수로 주어질 때, n의 약수를 오름차 순으로 담은 배열을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.addAll(findingDivisors(n.toInt()))
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("약수 구하기 : $result")
                    LaunchedEffect(show) {
                        if(!show) {
                            n = ""
                            result.clear()
                        }
                    }
                }
            }
        }
    }
}

private fun hateEnglish(numbers: String): String {
    println("영어가 싫어요")
    var answer = numbers
    val map = mapOf(
        "zero" to "0",
        "one" to "1",
        "two" to "2",
        "three" to "3",
        "four" to "4",
        "five" to "5",
        "six" to "6",
        "seven" to "7",
        "eight" to "8",
        "nine" to "9"
    )
    map.forEach {
        answer = answer.replace(it.key, it.value)
    }
    return answer
}

private fun changeIndex(myString: String, num1: Int, num2: Int): String {
    println("인덱스 바꾸기")
    val chars = myString.toCharArray()
    val tmp = chars[num1]
    chars[num1] = chars[num2]
    chars[num2] = tmp
    return String(chars)
}

private fun characterThatAppearsOnlyOnce(s: String): String {
    println("한 번만 등장한 문자")
    return s.toList().filter { unique ->
        s.count{ it == unique } == 1
    }.sorted().joinToString("")
}


private fun findingDivisors(n: Int): List<Int> {
    val answer = mutableListOf<Int>()
    println("약수 구하기")
    val list = (1..n).toList()
    for(i in list) {
        if(n % i == 0) {
            answer.add(i)
        }
    }
    return answer
}