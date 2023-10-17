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
fun Day12(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableStateOf("") }
                var myString by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "영어 에선 a, e, i, o, u 다섯 가지 알파벳 을 모음 으로 분류 합니다. 문자열 myString 이 매개 변수로 주어질 때 모음을 제거한 문자 열을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = myString,
                        onValueChange = { myString = it },
                        label = { Text(text = "문자열 myString")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) removeVowels(myString, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "모음 제거 : ${result.value}")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            myString = ""
                            result.value = ""
                        }
                    }
                }
            }
            "2" -> {
                val result = remember { mutableListOf<Int>() }
                var myString by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "문자열 myString 이 매개 변수로 주어질 때, myString 안에 있는 숫자만 골라 오름차 순 정렬한 리스트 를 return 하도록 solution 함수를 작성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = myString,
                        onValueChange = { myString = it },
                        label = { Text(text = "문자열 myString")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) sortingStrings1(myString, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("문자열 정렬 하기(1) : $result")
                    LaunchedEffect(show) {
                        if(!show) {
                            myString = ""
                            result.clear()
                        }
                    }
                }
            }
            "3" -> {
                val result = remember { mutableStateOf(0) }
                var myString by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "문자열 myString 이 매개 변수로 주어 집니다. myString 안의 모든 자연수 들의 합을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = myString,
                        onValueChange = { myString = it },
                        label = { Text(text = "문자열 myString") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) additionOfHiddenNumbers1(myString, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("숨어 있는 숫자의 덧셈(1) : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            myString = ""
                            result.value = 0
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
                    Text(text = "소인수 분해란 어떤 수를 소수 들의 곱으로 표현 하는 것 입니다. 예를 들어 12를 소인수 분해 하면 2 * 2 * 3 으로 나타낼 수 있습니다. 따라서 12의 소인수 는 2와 3입니다. 자연수 n이 매개 변수로 주어질 때 n의 소인수 를 오름차 순으로 담은 배열을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) factorization(n, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("소인수 분해 : $result")
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

private fun removeVowels(myString: String, result: MutableState<String>) {
    var answer = ""
    answer = myString
    val vowels = listOf("a", "e", "i", "o", "u")
    for(i in vowels) {
        answer = answer.replace(i, "")
    }
    result.value = answer
    println("모음 제거 : ${result.value}")
}

private fun sortingStrings1(myString: String, result: MutableList<Int>) {
    result.addAll(myString.filter { it.isDigit() }.toList().map { it.digitToInt() }.sorted())
    println("문자열 정렬하기(1) : $result")
}

/* TODO 숨어 있는 숫자의 덧셈(1) */
private fun additionOfHiddenNumbers1(myString: String, result: MutableState<Int>) {
    println("숨어 있는 숫자의 덧셈(1) : ${result.value}")
}


private fun factorization(n: String, result: MutableList<Int>) {
    var num = n.toInt()
    var i = 2
    while(num >= i) {
        if(num%i == 0){
            if(!result.contains(i)) result.add(i)
            num /= i
        } else {
            i++
        }
    }
    println("소인수 분해 : $result" )
}