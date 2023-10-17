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
fun Day9(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableStateOf(0) }
                var hp by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "개미 군단이 사냥을 나가려고 합니다. 개미 군단은 사냥 감의 체력에 딱 맞는 병력을 데리고 나가려고 합니다. 장군 개미는 5의 공격 력을, 병정 개미는 3의 공격력 을 일 개미는 1의 공격 력을 가지고 있습니다. 예를 들어 체력 23의 여치를 사냥 하려고 할 때, 일개미 23마리를 데리고 가도 되지만, 장군 개미 네 마리와 병정 개미 한 마리를 데리고 간다면 더 적은 병력 으로 사냥할 수 있습니다. 사냥감 의 체력 hp가 매개 변수로 주어질 때, 사냥감 의 체력에 딱 맞게 최소 한의 병력을 구성 하려면 몇 마리의 개미가 필요 한지를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = hp,
                        onValueChange = { hp = it },
                        label = { Text(text = "정수 hp") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) antArmy(hp, result)
                    }) {
                        Text(if(!show) "hp 입력" else "다시 입력")
                    }
                    if(show) Text("개미 군단 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            hp = ""
                            result.value = 0
                        }
                    }
                }
            }
            "2" -> {
                val result = remember { mutableStateOf("") }
                var letter by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이는 친구 에게 모스 부호를 이용한 편지를 받았습니다. 그냥은 읽을 수 없어 이를 해독 하는 프로 그램을 만들 려고 합니다. 문자열 letter 가 매개 변수로 주어질 때, letter 를 영어 소 문자로 바꾼 문자 열을 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = letter,
                        onValueChange = { letter = it },
                        label = { Text(text = "문자열 letter") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) morseCode1(letter, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("모스 부호(1) : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            letter = ""
                            result.value = ""
                        }
                    }
                }
            }
            "3" -> {
                val result = remember { mutableStateOf("") }
                var rsp by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "가위는 2 바위는 0 보는 5로 표현 합니다. 가위 바위 보를 내는 순서 대로 나타낸 문자열 rsp 가 매개 변수로 주어질 때, rsp 에 저장된 가위 바위 보를 모두 이기는 경우를 순서 대로 나타낸 문자 열을 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = rsp,
                        onValueChange = { rsp = it },
                        label = { Text(text = "문자열 rsp") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) rockPaperScissors(rsp, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("가위 바위 보 : ${result.value.removePrefix("null").removeSuffix("null")}")
                    LaunchedEffect(show) {
                        if(!show) {
                            rsp = ""
                            result.value = ""
                        }
                    }
                }
            }
            "4" -> {
                val result = remember { mutableStateOf(0) }
                var balls by remember { mutableStateOf("") }
                var share by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이는 구슬을 친구들 에게 나누어 주려고 합니다. 구슬은 모두 다르게 생겼 습니다. 머쓱이가 갖고 있는 구슬의 개수 balls 와 친구들 에게 나누어 줄 구슬 개수 share 이 매개 변수로 주어질 때, balls 개의 구슬 중 share 개의 구슬을 고르는 가능한 모든 경우의 수를 return 하는 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = balls,
                        onValueChange = { balls = it },
                        label = { Text(text = "정수 balls") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = share,
                        onValueChange = { share = it },
                        label = { Text(text = "정수 share") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) numberOfWaysToDivideBeads(balls, share, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("구슬을 나누는 경우의 수 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            balls = ""
                            share = ""
                            result.value = 0
                        }
                    }
                }
            }
        }
    }
}

private fun antArmy(hp:  String, answer: MutableState<Int>) {
    answer.value = hp.toInt()/5 + (hp.toInt() % 5 / 3) + (hp.toInt() % 5 % 3)
    println("개미 군단 : ${answer.value}")
}

private fun morseCode1(letter:  String, result: MutableState<String>) {
    val morse = mapOf(
        ".-" to "a",
        "-..." to "b",
        "-.-." to "c",
        "-.." to "d",
        "." to "e",
        "..-." to "f",
        "--." to "g",
        "...." to "h",
        ".." to "i",
        ".---" to "j",
        "-.-" to "k",
        ".-.." to "l",
        "--" to "m",
        "-." to "n",
        "---" to "o",
        ".--." to "p",
        "--.-" to "q",
        ".-." to "r",
        "..." to "s",
        "-" to "t",
        "..-" to "u",
        "...-" to "v",
        ".--" to "w",
        "-..-" to "x",
        "-.--" to "y",
        "--.." to "z"
    )
    letter.split(" ").forEach {
        result.value += morse[it]
    }
    println("모스 부호(1) : ${result.value}")
}

private fun rockPaperScissors(rsp: String, result: MutableState<String>) {
    val winRsp = mapOf(
        "2" to "0",
        "0" to "5",
        "5" to "2"
    )
    rsp.split("").forEach {
        result.value += winRsp[it]
    }
    println("가위 바위 보 : ${result.value}")
}

private fun numberOfWaysToDivideBeads(balls: String, share: String, result: MutableState<Int>) {
    result.value = combination(balls.toInt(), share.toInt())
    println("구슬을 나누는 경우의 수 : ${result.value}")
}

private fun combination(n: Int, r: Int): Int {
    return if(r==0 || n == r) 1 else combination(n-1, r-1) + combination(n-1, r)
}