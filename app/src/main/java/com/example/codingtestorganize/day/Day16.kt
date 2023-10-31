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
fun Day16(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableStateOf(0) }
                var message by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이는 할머니께 생신 축하 편지를 쓰려고 합니다. 할머니가 보시기 편하 도록 글자 한 자 한 자를 가로 2cm 크기로 적으려고 하며, 편지를 가로 로만 적을 때, 축하 문구 message 를 적기 위해 필요한 편지지의 최소 가로 길이를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = message,
                        onValueChange = { message = it },
                        label = { Text(text = "문자열 message")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) result.value = letter(message)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "편지 : ${result.value}")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            message = ""
                            result.value = 0
                        }
                    }
                }
            }
            "2" -> {
                val result = remember { mutableListOf<Int>() }
                var array by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 배열 array 가 매개 변수로 주어질 때, 가장 큰 수와 그 수의 인덱스 를 담은 배열을 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = array,
                        onValueChange = { array = it },
                        label = { Text(text = ", 기준 array 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.addAll(findTheLargestNumber(stringToMutableIntList(array)))
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("가장 큰 수 찾기 : $result")
                    LaunchedEffect(show) {
                        if(!show) {
                            array = ""
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
                    Text(text = "myString 은 [3 + 5]처럼 문자 열로 된 수식 입니다. 문자열 myString 이 매개 변수로 주어질 때, 수식을 계산한 값을 return 하는 solution 함수를 완성 해 주세요.")
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
                        if(show) result.value = computingStrings(myString)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("문자열 계산 하기 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            myString = ""
                            result.value = 0
                        }
                    }
                }
            }
            "4" -> {
                val result = remember { mutableStateOf(0) }
                var s1 by remember { mutableStateOf("") }
                var s2 by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "두 배열이 얼마나 유사 한지 확인 해 보려고 합니다. 문자열 배열 s1과 s2가 주어질 때 같은 원소의 개수를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = s1,
                        onValueChange = { s1 = it },
                        label = { Text(text = ", 기준 s1 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = s2,
                        onValueChange = { s2 = it },
                        label = { Text(text = ", 기준 s2 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = similarityOfArrays(stringToMutableStringList(s1), stringToMutableStringList(s2))
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("배열의 유사도 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            s1 = ""
                            s2 = ""
                            result.value = 0
                        }
                    }
                }
            }
        }
    }
}

private fun letter(message: String): Int {
    println("편지")
    return  message.length * 2
}

private fun findTheLargestNumber(array: MutableList<Int>): List<Int> {
    println("가장 큰 수 찾기")
    val answer = mutableListOf<Int>()
    array.maxOrNull().let {
        answer.add(it ?: 0)
        answer.add(array.indexOf(it ?: 0))
    }
    return answer
}

private fun computingStrings(myString: String): Int {
    println("문자열 계산 하기")
    val stringArr = myString.split(" ".toRegex()).toTypedArray()
    var answer = stringArr[0].toInt()
    var i = 1
    while(i < stringArr.size) {
        if(stringArr[i] == "+") {
            answer += stringArr[i+1].toInt()
        } else {
            answer -= stringArr[i+1].toInt()
        }
        i += 2
    }
    return answer
}


private fun similarityOfArrays(s1: MutableList<String>, s2: MutableList<String>): Int {
    println("배열의 유사도")
    var count = 0
    for(i in s1) {
        for(j in s2) {
            if(i == j) count++
        }
    }
    return count
}