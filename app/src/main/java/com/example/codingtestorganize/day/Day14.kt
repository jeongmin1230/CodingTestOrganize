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
import kotlin.math.abs

@Composable
fun Day14(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableStateOf(0) }
                var array by remember { mutableStateOf("") }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 배열 array 와 정수 n이 매개 변수로 주어질 때, array 에 들어 있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = array,
                        onValueChange = { array = it },
                        label = { Text(text = ", 기준 array 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) result.value = closeNumber(stringToMutableIntList(array), n.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "가까운 수 : ${result.value}")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            array = ""
                            n = ""
                            result.value = 0
                        }
                    }
                }
            }
            "2" -> {
                val result = remember { mutableStateOf(0) }
                var order by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이는 친구들과 369게임을 하고 있습니다. 369게임은 1부터 숫자를 하나씩 대며 3, 6, 9가 들어 가는 숫자는 숫자 대신 3, 6, 9의 개수 만큼 박수를 치는 게임 입니다. 머쓱이가 말해야 하는 숫자 order 가 매개 변수로 주어질 때, 머쓱이가 쳐야할 박수 횟수를 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = order,
                        onValueChange = { order = it },
                        label = { Text(text = "정수 order")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = game369(order)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("369게임 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            order = ""
                            result.value = 0
                        }
                    }
                }
            }
            "3" -> {
                val result = remember { mutableStateOf("") }
                var cipher by remember { mutableStateOf("") }
                var code by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "군 전략가 머쓱이는 전쟁 중 적군이 다음과 같은 암호 체계를 사용 한다는 것을 알아 냈습니다. 암호화 된 문자열 cipher 를 주고 받습니다. 그 문자열 에서 code 의 배수 번째 글자만 진짜 암호 입니다. 문자열 cipher 와 정수 code 가 매개 변수로 주어질 때 해독된 암호 문자 열을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = cipher,
                        onValueChange = { cipher = it },
                        label = { Text(text = "문자열 cipher") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = code,
                        onValueChange = { code = it },
                        label = { Text(text = "정수 code") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) result.value = decryption(cipher, code.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("암호 해독 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            cipher = ""
                            code = ""
                            result.value = ""
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
                    Text(text = "문자열 myString 이 매개 변수로 주어질 때, 대문자는 소문자로 소문자는 대문자로 변환한 문자 열을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = myString,
                        onValueChange = { myString = it },
                        label = { Text(text = "문자열 myString") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = uppercaseAndLowerCaseLetters(myString)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("대문자와 소문자 : ${result.value}")
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

private fun closeNumber(array: MutableList<Int>, n: Int): Int {
    println("가까운 수")
    return array.sorted().minWithOrNull(compareBy { abs(it-n) }) ?: 0
}

private fun game369(order: String): Int {
    println("369게임")
    var count = 0
    order.split("").forEach { if(it == "3" || it == "6" || it == "9") count++ }
    return count
}

private fun decryption(cipher: String, code: Int): String {
    println("암호 해독")
    var answer = ""
    for(i in cipher.indices) {
        if((i+1) % code == 0) {
            answer += cipher[i]
        }
    }
    return answer
}


private fun uppercaseAndLowerCaseLetters(myString: String): String {
    println("대문자와 소문자")
    var answer = ""
    for(i in myString) {
        answer += if(i.isUpperCase()) i.lowercase()
        else i.uppercase()
    }
    return answer
}