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
import com.example.codingtestorganize.*
import com.example.codingtestorganize.R
import kotlinx.coroutines.handleCoroutineException
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
                    Button(onClick = {
                        show = !show
                        if(show) unusualArrangement(stringToMutableIntList(numList), n.toInt(), result)
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
                val result = remember { mutableListOf<Int>() }
                var score by remember { mutableStateOf("") }
                var scoreList by remember { mutableStateOf(emptyList<List<Int>>()) }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "영어 점수와 수학 점수의 평균 점수를 기준으로 학생 들의 등수를 매기려고 합니다. " +
                            "영어 점수와 수학 점수를 담은 2차원 정수 배열 score 가 주어질 때, " +
                            "영어 점수와 수학 점수의 평균을 기준으로 매긴 등수를 담은 배열을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = score,
                        onValueChange = { score = it },
                        label = { Text(text = "영어, 수학 점수| 영어, 수학 점수| 영어, 수학 점수| 영어, 수학 점수 형태로 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        scoreList = parsePointInput(score)
                        if(show) result.addAll(ranking(convertListOfListsToArray(scoreList)))
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "등수 매기기 : $result")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            score = ""
                            result.clear()
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
                    Button(onClick = {
                        show = !show
                        if(show) babbling(stringToMutableStringList(babbling), result)
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
                val result = remember { mutableStateOf("") }
                var idPw by remember { mutableStateOf("") }
                var db by remember { mutableStateOf("") }
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
                    TextField(
                        value = db,
                        onValueChange = { db = it },
                        label = { Text(text = "id1, pw1| id2, pw2| id3, pw3 형식 으로 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        val idPwArray = idPw.split(",").map { it.trim() }.toTypedArray()
                        val dbArray = db.split("|").map { it.trim() }
                            .map { db -> db.split(",").map { it.trim() }.toTypedArray() }
                            .toTypedArray()
                        if(show) result.value = loginSucceed(idPwArray, dbArray)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("로그인 성공? : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            idPw = ""
                            db = ""
                            result.value = ""
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

fun ranking(score: Array<IntArray>): MutableList<Int> {
    println("등수 매기기")
    val ranks = MutableList(score.size) { 1 }

    for (i in score.indices) {
        for (j in score.indices) {
            if (i != j && (score[i][0] + score[i][1]) < (score[j][0] + score[j][1])) {
                ranks[i]++
            }
        }
    }

    return ranks
}
private fun babbling(babblingList: MutableList<String>, result: MutableState<Int>) {
    val regex = "aya|ye|woo|ma".toRegex()
    result.value = babblingList.map { it.replace(regex, "") }.count { it.isEmpty() }
    println("옹알이(1) : ${result.value}")
}

fun loginSucceed(id_pw: Array<String>, db: Array<Array<String>>): String {
    val inputId = id_pw[0]
    val inputPw = id_pw[1]

    for (userInfo in db) {
        val userId = userInfo[0]
        val userPw = userInfo[1]

        if (inputId == userId) {
            return if (inputPw == userPw) {
                "login"
            } else {
                "wrong pw"
            }
        }
    }

    return "fail"
}