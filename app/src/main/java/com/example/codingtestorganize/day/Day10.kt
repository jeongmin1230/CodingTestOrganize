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
import java.util.*

@Composable
fun Day10(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableStateOf(0) }
                var dot by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "사분면은 한 평면을 x축과 y축을 기준 으로 나눈 네 부분 입니다. 사분면은 아래와 같이 1부터 4까지 번호를매깁니다.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = dot,
                        onValueChange = { dot = it },
                        label = { Text(text = ", 기준 dot 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    val inputValues = dot.split(",").map { it.trim() }
                    val intValues = inputValues.mapNotNull { it.toIntOrNull() }.toMutableList()
                    Button(onClick = {
                        show = !show
                        if(show) findTheLocationOfAPoint(intValues, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "점의 위치 구하기 : ${result.value}")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            dot = ""
                            result.value = 0
                        }
                    }
                }
            }
            "2" -> {
                val result = remember { mutableListOf(mutableListOf<Int>()) }
                var inputText by remember { mutableStateOf("") }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 배열 num list 와 정수 n이 매개 변수로 주어 집니다. num list 를 다음 설명과 같이 2차원 배열로 바꿔 return 하도록 solution 함수를 완성 해 주세요. num list 가 [1, 2, 3, 4, 5, 6, 7, 8] 로 길이가 8이고 n이 2이므로 num list 를 2 * 4 배열로 다음과 같이 변경 합니다. 2차원 으로 바꿀 때에는 num list 의 원소 들을 앞에서 부터 n개씩 나눠 2차원 배열로 변경 합니다.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = inputText,
                        onValueChange = { inputText = it },
                        label = { Text(text = ", 기준 num list 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    val inputValues = inputText.split(",").map { it.trim() }
                    val intValues = inputValues.mapNotNull { it.toIntOrNull() }.toMutableList()
                    Button(onClick = {
                        show = !show
                        if(show) makeItTwoDimensional(intValues, n, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("2차원 으로 만들기 : $result")
                    LaunchedEffect(show) {
                        if(!show) {
                            inputText = ""
                            n = ""
                            result.clear()
                        }
                    }
                }
            }
            "3" -> {
                val result = remember { mutableStateOf(0) }
                var numbers by remember { mutableStateOf("") }
                var k by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이는 친구들과 동그랗게 서서 공 던지기 게임을 하고 있습니다. 공은 1번부터 던지며 오른쪽 으로 한 명을 건너 뛰고 그다음 사람 에게만 던질 수 있습니다. 친구 들의 번호가 들어 있는 정수 배열 numbers 와 정수 K가 주어질 때, k 번째로 공을 던지는 사람의 번호는 무엇 인지 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = numbers,
                        onValueChange = { numbers = it },
                        label = { Text(text = ", 기준 numbers 배열 입력") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = k,
                        onValueChange = { k = it },
                        label = { Text(text = "정수 k") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    val inputValues = numbers.split(",").map { it.trim() }
                    val intValues = inputValues.mapNotNull { it.toIntOrNull() }.toMutableList()
                    Button(onClick = {
                        show = !show
                        if(show) throwABall(intValues, k, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("공 던지기 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            numbers = ""
                            k = ""
                            result.value = 0
                        }
                    }
                }
            }
            "4" -> {
                val result = remember { mutableListOf<Int>() }
                var numbers by remember { mutableStateOf("") }
                var direction by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수가 담긴 배열 numbers 와 문자열 direction 가 매개 변수로 주어 집니다. 배열 numbers 의 원소를 direction 방향 으로 한 칸씩 회전 시킨 배열을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = numbers,
                        onValueChange = { numbers = it },
                        label = { Text(text = ", 기준 numbers 배열 입력") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = direction,
                        onValueChange = { direction = it },
                        label = { Text(text = "direction") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    val inputValues = numbers.split(",").map { it.trim() }
                    val intValues = inputValues.mapNotNull { it.toIntOrNull() }.toMutableList()
                    Button(onClick = {
                        show = !show
                        if(show) rotatingAnArray(intValues, direction, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("배열 회전 시키기 : $result")
                    LaunchedEffect(show) {
                        if(!show) {
                            numbers = ""
                            direction = ""
                            result.clear()
                        }
                    }
                }
            }
        }
    }
}

private fun findTheLocationOfAPoint(dot: MutableList<Int>, result: MutableState<Int>) {
    result.value =
        if(dot[0] > 0 && dot[1] > 0) 1
        else if(dot[0] < 0 && dot[1] > 0) 2
        else if(dot[0] < 0 && dot[1] < 0) 3
        else 4
    println("점의 위치 구하기 : ${result.value}")
}
/* TODO - 2차원 으로 만들기 */
private fun makeItTwoDimensional(numList: MutableList<Int>, n: String, resultArray: MutableList<MutableList<Int>>) {
    var count = 0
    val answer = Array(numList.size/n.toInt()) { mutableListOf(n.toInt()) }
    for(i in 0 until (numList.size / n.toInt())) {
        for(j in 0 until n.toInt()) {
            answer[i][j] = numList[count]
            count++
        }
    }
    for(i in answer) {
        resultArray.add(i)
    }
    println("2차원 으로 만들기 : $resultArray")
}

private fun throwABall(numbers: MutableList<Int>, k: String, result: MutableState<Int>) {
    result.value = numbers[(k.toInt()-1)*2%numbers.size]
    println("공 던지기 : ${result.value}")
}

private fun rotatingAnArray(numbers: MutableList<Int>, direction: String, result: MutableList<Int>) {
    val list = numbers.toList()
    if(direction == "left") Collections.rotate(list, -1)
    else Collections.rotate(list, 1)
    result.addAll(list)
    println("배열 회전 시키기 : $result" )
}