package com.example.codingtestorganize.day

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.dp
import com.example.codingtestorganize.R
import com.example.codingtestorganize.convertListOfListsToArray
import com.example.codingtestorganize.parsePointInput
import com.example.codingtestorganize.stringToMutableIntList
import kotlin.math.abs

@Composable
fun Day22(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableStateOf(0) }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "3x 마을 사람 들은 3을 저주의 숫자 라고 생각 하기 때문에 3의 배수와 숫자 3을 사용 하지 않습니다. 3x 마을 사람 들의 숫자는 다음과 같습니다. 정수 n이 매개 변수로 주어질 때, n을 3x 마을 에서 사용 하는 숫자로 바꿔 return 하도록 solution 함수를 완성 해 주세요.")
                    Image(painter = painterResource(id = R.drawable.curse_number_3_explain), contentDescription = null)
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = curseNumber3(n.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "저주의 숫자 3 : ${result.value}")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            n = ""
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
                    Text(text = "점 네 개의 좌표를 담은 이차원 배열  dots 가 다음과 같이 매개 변수로 주어 집니다.\n" +
                            "[[x1, y1], [x2, y2], [x3, y3], [x4, y4]]\n" +
                            "주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = dots,
                        onValueChange = { dots = it },
                        label = { Text(text = "x1, y1| x2, y2| x3, y3| x4, y4 형태로 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        dotsList = parsePointInput(dots)
                        if(show) result.value = parallel(convertListOfListsToArray(dotsList))
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "평행 : ${result.value}")
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
                var lines by remember { mutableStateOf("") }
                var linesList by remember { mutableStateOf(emptyList<List<Int>>()) }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "선분 3개가 평행 하게 놓여 있습니다. " +
                            "세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]] 형태로 들어 있는 2차원 배열 lines 가 매개 변수로 주어질 때, " +
                            "두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = lines,
                        onValueChange = { lines = it },
                        label = { Text(text = "x1, y1| x2, y2| x3, y3 형식 입력") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        linesList = parsePointInput(lines)
                        if(show) result.value = lengthOfOverlappingLineSegments(convertListOfListsToArray(linesList))
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("겹치는 선분의 길이 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            lines = ""
                            result.value = 0
                        }
                    }
                }
            }
            "4" -> {
                val answer = remember { mutableStateOf(0) }
                var a by remember { mutableStateOf("") }
                var b by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "소수점 아래 숫자가 계속 되지 않고 유한개 인 소수를 유한 소수 라고 합니다. 분수를 소수로 고칠 때 유한 소수로 나타낼 수 있는 분수 인지 판별 하려고 합니다. 유한 소수가 되기 위한 분수의 조건은 다음과 같습니다.\n" +
                            "기약 분수로 나타 내었을 때, 분모의 소 인수가 2와 5만 존재 해야 합니다.\n" +
                            "두 정수 a와 b가 매개 변수로 주어질 때, a/b가 유한 소수 이면 1을, 무한 소수 라면 2를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = a,
                        onValueChange = { a = it },
                        label = { Text(text = "정수 a")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = b,
                        onValueChange = { b = it },
                        label = { Text(text = "정수 b")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) answer.value = identifyingFiniteDecimals(a.toInt(), b.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("유한 소수 판별 하기 : ${answer.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            a = ""
                            b = ""
                            answer.value = 0
                        }
                    }
                }
            }
        }
    }
}

private fun curseNumber3(n: Int): Int {
    println("저주의 숫자 3")
    var answer = n
    var i = 1
    while(i <= answer) {
        if((i % 3 == 0) || i.toString().contains("3")) {
            answer++
        }
        i++
    }
    return answer
}

private fun parallel(dots: Array<IntArray>): Int {
    println("평행")
    val x1 = dots[0][0]
    val y1 = dots[0][1]
    val x2 = dots[1][0]
    val y2 = dots[1][1]
    val x3 = dots[2][0]
    val y3 = dots[2][1]
    val x4 = dots[3][0]
    val y4 = dots[3][1]

    if (abs((x1 - x2) * (y3 - y4)) == abs((y1 - y2) * (x3 - x4))) {
        return 1
    }
    if (abs((x1 - x3) * (y2 - y4)) == abs((y1 - y3) * (x2 - x4))) {
        return 1
    }
    if (abs((x1 - x4) * (y2 - y3)) == abs((y1 - y4) * (x2 - x3))) {
        return 1
    }
    return 0
}

private fun lengthOfOverlappingLineSegments(lines: Array<IntArray>): Int {
    println("겹치는 선분의 길이")
    return lines.map { List(abs(it[1]-it[0])) { r ->
        List(2) { c -> (it[0] + r) + c } } }
        .flatten()
        .groupBy { it }
        .filter { it.value.size > 1 }
        .size
}

private fun gcd(a: Int, b: Int): Int{
    return if(b==0) {
        a
    } else {
        gcd(b, a % b)
    }
}

private fun identifyingFiniteDecimals(a: Int, b: Int): Int {
    var newB = b / gcd(a, b)
    while (newB != 1) {
        newB /= if (newB % 2 == 0) {
            2
        } else if (newB % 5 == 0) {
            5
        } else {
            return 2
        }
    }
    return 1
}