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

@Composable
fun Day21(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableStateOf(0) }
                var myString by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "문자열 myString 이 매개 변수로 주어 집니다. myString 은 소문자, 대문자, 자연수 로만 구성 되어 있습니다. myString 안의 자연수 들의 합을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = myString,
                        onValueChange = { myString = it },
                        label = { Text(text = "문자열 myString")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = additionOfHiddenNumbers2(myString)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "숨어 있는 숫자의 덧셈(2): ${result.value}")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            myString = ""
                            result.value = 0
                        }
                    }
                }
            }

            "2" -> {
                val result = remember { mutableStateOf(0) }
                var dots by remember { mutableStateOf("") }
                var dotsList by remember { mutableStateOf(emptyList<List<Int>>()) }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "다음 그림과 같이 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험 지역 으로 분류 합니다. " +
                            "지뢰는 2차원 배열 board 에 1로 표시 되어 있고 boar 에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재 합니다." +
                            "지뢰가 매설된 지역의 지도 board 가 매개 변수로 주어질 때, 안전한 지역의 칸 수를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = dots,
                        onValueChange = { dots = it },
                        label = { Text(text = "0, 0, 0, 0, 0 | 0, 0, 0, 0, 0 | 0, 0, 0, 0, 0 | 0, 0, 1, 0, 0 | 0, 0, 0, 0, 0 형태로 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        dotsList = parsePointInput(dots)
                        if(show) result.value = safeZone(dotsList)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "안전 지대 : ${result.value}")
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
                var sides by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족 해야 합니다. " +
                            "가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다." +
                            "삼각형의 두 변의 길이가 담긴 배열 sides 이 매개 변수로 주어 집니다. 나머지 한 변이 될 수 있는 정수의 개수를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = sides,
                        onValueChange = { sides = it },
                        label = { Text(text = ", 기준 sides 배열 입력") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) result.value = conditionsForCompletionOfATriangle(stringToMutableIntList(sides))
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("삼각형의 완성 조건(2) : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            sides = ""
                            result.value = 0
                        }
                    }
                }
            }
            "4" -> {
                val result = remember { mutableStateOf(0) }
                var spell by remember { mutableStateOf("") }
                var dic by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "PROGRAMMERS-962 행성에 불시착 한 우주 비행사 머쓱이는 외계 행성의 언어를 공부 하려고 합니다. 알파벳이 담긴 배열 spell 과 외계어 사전 dic 이 매개 변수로 주어 집니다. spell 에 담긴 알파벳을 한 번씩만 모두 사용한 단어가 dic 에 존재 한다면 1, 존재 하지 않는 다면 2를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = spell,
                        onValueChange = { spell = it },
                        label = { Text(text = ", 기준 spell 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = dic,
                        onValueChange = { dic = it },
                        label = { Text(text = ", 기준 dic 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) result.value = alienLanguageDictionary(stringToMutableStringList(spell), stringToMutableStringList(dic))
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("외계어 사전 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            spell = ""
                            dic = ""
                            result.value = 0
                        }
                    }
                }
            }
        }
    }
}

private fun additionOfHiddenNumbers2(myString: String): Int {
    println("숨어 있는 숫자의 덧셈(2)")
    var answer = 0
    val split = myString.split("[a-zA-z]+".toRegex()).toTypedArray()
    for(i in split.indices) {
        if(split[i].matches("\\d+".toRegex())) {
            answer += split[i].toInt()
        }
    }
    return answer
}

fun safeZone(board: List<List<Int>>): Int {
    println("안전 지대")
    var answer = 0
    val convertBoard = convertListOfListsToArray(board)

    for (i in board.indices) {
        for (j in 0 until board[i].size) {
            if (board[i][j] == 1) {
                boomPoint(convertBoard, i, j)
            }
        }
    }
    convertBoard.forEach { answer += it.count { i -> i == 0 } }
    return answer
}


private fun boomPoint(boomBoard: Array<IntArray>, row: Int, col: Int) {
    val fromRow = if(row - 1 < 0) row else row - 1
    val toRow = if(row + 1 >= boomBoard.size) row else row + 1
    val fromCol = if(col - 1 < 0) col else col - 1
    val toCol = if(col + 1 >= boomBoard.size) col else col + 1

    for(i in fromRow..toRow) {
        for(j in fromCol..toCol) {
            if(boomBoard[i][j] == 0) {
                boomBoard[i][j] = -1
            }
        }
    }
}

// ↓ 아래 함수 에서 사용

private fun conditionsForCompletionOfATriangle(sides: MutableList<Int>): Int {
    println("삼각형의 완성 조건(2)")
    val sortedSides = sides.sortedDescending()
    val highLimit = sortedSides[0] + sortedSides[1]
    val lowLimit = sortedSides[0] - sortedSides[1]
    return highLimit - lowLimit - 1
}


private fun alienLanguageDictionary(spell: MutableList<String>, dic: MutableList<String>): Int {
    println("외계어 사전")
    var answer = 2
    for(i in dic) {
        var right = true
        for(j in spell) {
            if(i.indexOf(j) == -1){
                right = false
                break
            }
        }
        if(right) {
            answer = 1
            break
        }
    }
    return answer
}