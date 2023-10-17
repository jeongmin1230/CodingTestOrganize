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
import kotlin.math.sqrt

@Composable
fun Day18(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableStateOf(0) }
                var str1 by remember { mutableStateOf("") }
                var str2 by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "문자열 str1, str2가 매개 변수로 주어 집니다. str1 안에 str2가 있다면 1을 없다면 2를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = str1,
                        onValueChange = { str1 = it },
                        label = { Text(text = "문자열 str1")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = str2,
                        onValueChange = { str2 = it },
                        label = { Text(text = "문자열 str2")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) stringWithinString(str1, str2, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "문자열 안에 문자열 : ${result.value}")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            str1 = ""
                            str2 = ""
                            result.value = 0
                        }
                    }
                }
            }
            "2" -> {
                val result = remember { mutableStateOf(0) }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "어떤 자연 수를 제곱 했을 때 나오는 정수를 제곱 수라고 합니다. 정수 n이 매개 변수로 주어질 때, n이 제곱 수라면 1을 아니 라면 2를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) identifyingSquareNumbers(n, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("제곱 수 판별 하기 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            n = ""
                            result.value= 0
                        }
                    }
                }
            }
            "3" -> {
                val result = remember { mutableStateOf(0) }
                var n by remember { mutableStateOf("") }
                var t by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "어떤 세균은 1시간에 두배 만큼 증식 한다고 합니다. 처음 세균의 마리수 n과 경과한 시간 t가 매개 변수로 주어질 때 t시간 후 세균의 수를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = t,
                        onValueChange = { t = it },
                        label = { Text(text = "정수 t") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) bacterialGrowth(n, t, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("세균 증식 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            n = ""
                            t = ""
                            result.value = 0
                        }
                    }
                }
            }
            "4" -> {
                val result = remember { mutableStateOf("") }
                var myString by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "영어 대 소문자로 이루어진 문자열 myString 이 매개 변수로 주어질 때, myString 을 모두 소문자로 바꾸고 알파벳 순서 대로 정렬한 문자 열을 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = myString,
                        onValueChange = { myString = it },
                        label = { Text(text = "문자열 myString")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) sortingStrings2(myString, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("문자열 정렬 하기(2) : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            myString = ""
                            result.value = ""
                        }
                    }
                }
            }
        }
    }
}

private fun stringWithinString(str1: String, str2: String, result: MutableState<Int>) {
    result.value = if(str1.contains(str2)) 1 else 2
    println("문자열 안에 문자열 : ${result.value}")
}

private fun identifyingSquareNumbers(n: String, result: MutableState<Int>) {
    val sqrt = sqrt(n.toDouble()).toLong()
    result.value = if(sqrt * sqrt == n.toLong()) 1 else 2
    println("제곱 수 판별 하기 : ${result.value}")
}

private fun bacterialGrowth(n: String, t: String, result: MutableState<Int>) {
    var answer = n.toInt()
    repeat(t.toInt()) { answer *= 2}
    result.value = answer
    println("세균 증식 : ${result.value}")
}


private fun sortingStrings2(myString: String, result: MutableState<String>) {
    var string = ""
    for(i in myString) {
        if(i.isUpperCase()) {
            string += i.lowercase()
        } else {
            string += i
        }
    }
    result.value = string.toCharArray().sorted().joinToString("")
    println("문자열 정렬 하기(2) : ${result.value}" )
}