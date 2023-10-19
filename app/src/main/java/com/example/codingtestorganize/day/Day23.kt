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
import kotlin.math.abs

@Composable
fun Day23(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableListOf<Int>() }
                var numList by remember { mutableStateOf("") }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 n을 기준 으로 n과 가까운 수부터 정렬 하려고 합니다. " +
                            "이때 n으로 부터의 거리가 같다면 더 큰 수를 앞에 오도록 배치 합니다. " +
                            "정수가 담긴 배열 numList 와 정수 n이 주어질 때 numList 의 원소를 n으로 부터 가까운 순서 대로 " +
                            "정렬한 배열을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = numList,
                        onValueChange = { numList = it },
                        label = { Text(text = ", 기준 numList 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    val numListValue = numList.split(",").map { it.trim() }
                    val numListValueToArray = numListValue.mapNotNull { it.toIntOrNull() }.toMutableList()
                    Button(onClick = {
                        show = !show
                        if(show) unusualArrangement(numListValueToArray, n.toInt(), result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "특이한 정렬: $result")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            numList = ""
                            n = ""
                            result.clear()
                        }
                    }
                }
            }
            "2" -> {
                /* TODO - 등수 매기기 */
                val result = remember { mutableStateOf(0) }
                var dots by remember { mutableStateOf("") }
                var coordinates: Array<IntArray> by remember { mutableStateOf(emptyArray()) }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "영어 점수와 수학 점수의 평균 점수를 기준으로 학생 들의 등수를 매기려고 합니다. " +
                            "영어 점수와 수학 점수를 담은 2차원 정수 배열 score 가 주어질 때, " +
                            "영어 점수와 수학 점수의 평균을 기준으로 매긴 등수를 담은 배열을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = dots,
                        onValueChange = { dots = it },
                        label = { Text(text = "0, 0, 0, 0, 0 | 0, 0, 0, 0, 0 | 0, 0, 0, 0, 0 | 0, 0, 1, 0, 0 | 0, 0, 0, 0, 0 형태로 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    val pairs = dots.split(" | ")
                    val final = pairs.map { pair ->
                        val (x, y) = pair.split(", ").map { it.substring(1, it.length - 1).toInt() }
                        intArrayOf(x, y)
                    }.toTypedArray()
                    Button(onClick = {
                        show = !show
                        if(show) ranking(final, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "등수 매기기 : ${result.value}")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            dots = ""
                            result.value = 0
                        }
                    }
                }
            }
            "3" -> {
                val result = remember { mutableStateOf(0) }
                var babbling by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다. 조카는 아직 [aya, ye, woo, ma] 네 가지 발음을 최대 한 번씩 사용해 조합한(이어 붙인) 발음 밖에 하지 못합니다. " +
                            "문자열 배열 babbling 이 매개 변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = babbling,
                        onValueChange = { babbling = it },
                        label = { Text(text = ", 기준 babbling 배열 입력") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    val babblingValue = babbling.split(",").map { it.trim() }.toMutableList()
                    Button(onClick = {
                        show = !show
                        if(show) babbling(babblingValue, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("옹알이(1) : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            babbling = ""
                            result.value = 0
                        }
                    }
                }
            }
            "4" -> {
                /* TODO - 로그인 성공? */
                val result = remember { mutableStateOf(0) }
                var idPw by remember { mutableStateOf("") }
                var dic by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이는 프로그래머스에 로그인 하려고 합니다. " +
                            "머쓱이가 입력한 아이디 와 비밀 번호가 담긴 배열 idPw와 회원들의 정보가 담긴 2차원 배열 db가 주어질 때, " +
                            "다음과 같이 로그인 성공, 실패에 따른 메시지를 return 하도록 solution 함수를 완성 해 주세요.\n" +
                            "아이디 와 비밀 번호가 모두 일치 하는 회원 정보가 있으면 [login]을 return 합니다." +
                            "로그인이 실패 했을 때 아이디가 일치 하는 회원이 없다면 [fail]를, 아이디는 일치 하지만 비밀 번호가 일치 하는 회원이 없다면 [wrong pw]를 return 합니다.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = idPw,
                        onValueChange = { idPw = it },
                        label = { Text(text = ", 기준 idPw 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    val idPwValue = idPw.split(",").map { it.trim() }.toMutableList()
                    Button(onClick = {
                        show = !show
//                        if(show) loginSucceed(idPwValue, dicValue, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("로그인 성공? : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            idPw = ""
                            dic = ""
                            result.value = 0
                        }
                    }
                }
            }
        }
    }
}

private fun unusualArrangement(numList: MutableList<Int>, n: Int, result: MutableList<Int>) {
    result.addAll(numList.sortedWith { a, b ->
        if(abs(a-n) == abs(b-n)) b.compareTo(a) else abs(a-n).compareTo(abs(b-n))
    })
    println("특이한 정렬 : $result")
}

private fun ranking(board: Array<IntArray>, result: MutableState<Int>) {
    println("등수 매기기 : ${result.value}")
}

private fun babbling(babblingList: MutableList<String>, result: MutableState<Int>) {
    val regex = "aya|ye|woo|ma".toRegex()
    result.value = babblingList.map { it.replace(regex, "") }.count { it.isEmpty() }
    println("옹알이(1) : ${result.value}")
}

private fun loginSucceed(spell: MutableList<String>, dic: MutableList<String>, result: MutableState<Int>) {
    println("로그인 성공? : ${result.value}" )
}