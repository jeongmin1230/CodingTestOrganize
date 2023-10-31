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
import com.example.codingtestorganize.stringToMutableIntList
import com.example.codingtestorganize.stringToMutableStringList

@Composable
fun Day17(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableStateOf(0) }
                var num by remember { mutableStateOf("") }
                var k by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 num 과 k가 매개 변수로 주어질 때, num 을 이루는 숫자 중에 k가 있으면 num 의 그 숫자가 있는 자리 수를 return 하고 없으면 -1을 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = num,
                        onValueChange = { num = it },
                        label = { Text(text = "정수 num")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = k,
                        onValueChange = { k = it },
                        label = { Text(text = "정수 k")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) result.value = findNumber(num, k)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "숫자 찾기 : ${result.value}")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            num = ""
                            k = ""
                            result.value = 0
                        }
                    }
                }
            }
            "2" -> {
                val result = remember { mutableListOf<Int>() }
                var n by remember { mutableStateOf("") }
                var numList by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 n과 정수 배열 numList 가 매개 변수로 주어질 때, numList 에서 n의 배수가 아닌 수들을 제거한 배열을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = numList,
                        onValueChange = { numList = it },
                        label = { Text(text = ", 기준 numList 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.addAll(chooseAMultipleOfN(n.toInt(), stringToMutableIntList(numList)))
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("n 의 배수 고르기 : $result")
                    LaunchedEffect(show) {
                        if(!show) {
                            n = ""
                            numList = ""
                            result.clear()
                        }
                    }
                }
            }
            "3" -> {
                val result = remember { mutableStateOf(0) }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 n이 매개 변수로 주어질 때 n의 각 자리 숫자의 합을 return 하도록 solution 함수를 완성 해 주세요")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) result.value = addDigits(n.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("자릿수 더하기 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            n = ""
                            result.value = 0
                        }
                    }
                }
            }
            "4" -> {
                val result = remember { mutableListOf<String>() }
                var quiz by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "덧셈, 뺄셈 수식 들이 'X [연산자] Y = Z' 형태로 들어 있는 문자열 배열 quiz 가 매개 변수로 주어 집니다. 수식이 옳다면 [O]를 틀리 다면 [X]를 순서 대로 담은 배열을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = quiz,
                        onValueChange = { quiz = it },
                        label = { Text(text = ", 기준 quiz 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.addAll(oxQuiz(stringToMutableStringList(quiz)))
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("OX 퀴즈 : $result")
                    LaunchedEffect(show) {
                        if(!show) {
                            quiz = ""
                            result.clear()
                        }
                    }
                }
            }
        }
    }
}

private fun findNumber(num: String, k: String): Int {
    println("숫자 찾기")
    return if(num.contains(k)) num.indexOf(k)+1 else -1
}

private fun chooseAMultipleOfN(n: Int, numList: MutableList<Int>): List<Int> {
    println("n 의 배수 고르기")
    val answer = mutableListOf<Int>()
    for(i in numList) {
        if(i % n == 0) {
            answer.add(i)
        }
    }
    return answer
}

private fun addDigits(n: Int):Int {
    println("자릿수 더하기")
    var input = n
    var answer = 0
    while (input != 0) {
        answer += input % 10
        input /= 10
    }
    return answer
}


private fun oxQuiz(quiz: MutableList<String>): List<String> {
    println("OX 퀴즈")
    val answer = mutableListOf<String>()
    quiz.map { s: String ->
        val arr = s.trim().split(" ".toRegex())
        if(arr[1] == "+" && arr[0].toInt() + arr[2].toInt() == arr[4].toInt() || arr[0].toInt() - arr[2].toInt() == arr[4].toInt()) answer.add("O") else answer.add("X")
    }.toTypedArray()
    return answer
}