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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.codingtestorganize.R
import com.example.codingtestorganize.parsePointInput
import com.example.codingtestorganize.stringToMutableIntList
import com.example.codingtestorganize.stringToMutableStringList
import kotlin.math.abs

@Composable
fun Day20(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            /* TODO - 직사각형 넓이 구하기*/
            "1" -> {
                val result = remember { mutableStateOf(0) }
                var pointInput by remember { mutableStateOf(TextFieldValue()) }
                var pointsList by remember { mutableStateOf(emptyList<List<Int>>()) }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "2차원 좌표 평면에 변이 축과 평행한 직사각형이 있습니다. 직사각형 네 꼭짓점 의 좌표 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]가 담겨 있는 배열 dots 가 매개 변수로 주어질 때, 직사각형의 넓이를 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = pointInput,
                        onValueChange = {
                            pointInput = it
                        },
                        singleLine = true,
                        placeholder = { Text("x1, y1 | x2, y2 | x3, y3 | x4, y4 형태로 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        pointsList = parsePointInput(pointInput.text)
                        if(show) result.value = findTheAreaOfARectangle(pointsList)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "직사각형 넓이 구하기 : ${result.value}")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            result.value = 0
                        }
                    }
                }
            }
            "2" -> {
                val result = remember { mutableListOf<Int>() }
                var keyInput by remember { mutableStateOf("") }
                var board by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이는 RPG 게임을 하고 있습니다. 게임 에는 up, down, left, right 방향 키가 있으며 각 키를 누르면 위, 아래, 왼쪽, 오른쪽 으로 한 칸씩 이동 합니다. 예를 들어 [0,0]에서 up을 누른 다면 캐릭터의 좌표는 [0, 1], down 을 누른 다면 [0, -1], left를 누른다면 [-1, 0], right 를 누른 다면 [1, 0]입니다. 머쓱이가 입력한 방향 키의 배열 keyinput 와 맵의 크기 board 이 매개 변수로 주어 집니다. 캐릭터는 항상 [0,0]에서 시작할 때 키 입력이 모두 끝난 뒤에 캐릭터의 좌표 [x, y]를 return 하도록 solution 함수를 완성 해 주세요. \n[[0, 0]은 board 의 정 중앙에 위치 합니다. 예를 들어 board 의 가로 크기가 9라면 캐릭터는 왼쪽 으로 최대 [-4, 0]까지 오른쪽 으로 최대 [4, 0]까지 이동할 수 있습니다.]")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = keyInput,
                        onValueChange = { keyInput = it },
                        label = { Text(text = ", 기준 keyInput 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = board,
                        onValueChange = { board = it },
                        label = { Text(text = ", 기준 board 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) charactersCoordinates(stringToMutableStringList(keyInput), stringToMutableIntList(board), result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("캐릭터의 좌표 : $result")
                    LaunchedEffect(show) {
                        if(!show) {
                            keyInput = ""
                            board = ""
                            result.clear()
                        }
                    }
                }
            }
            "3" -> {
                val result = remember { mutableStateOf(0) }
                var numbers by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 배열 numbers 가 매개 변수로 주어 집니다. numbers 의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = numbers,
                        onValueChange = { numbers = it },
                        label = { Text(text = ", 기준 numbers 배열 입력") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) createMaximumValue2(stringToMutableIntList(numbers), result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("최댓값 만들기(2) : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            numbers = ""
                            result.value = 0
                        }
                    }
                }
            }
            "4" -> {
                val result = remember { mutableStateOf("") }
                var polynomial by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "한 개 이상의 항의 합으로 이루어진 식을 다항식 이라고 합니다. 다항식 을 계산할 때는 동류항 끼리 계산해 정리 합니다. 덧셈 으로 이루어진 다항식 polynomial 이 매개 변수로 주어질 때, 동류항 끼리 더한 결과 값을 문자 열로 return 하도록 solution 함수를 완성 해 보세요. 같은 식 이라면 가장 짧은 수식을 return 합니다.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = polynomial,
                        onValueChange = { polynomial = it },
                        label = { Text(text = "문자열 polynomial")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) addPolynomials(polynomial, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("다항식 더하기 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            polynomial = ""
                            result.value = ""
                        }
                    }
                }
            }
        }
    }
}

private fun findTheAreaOfARectangle(dots: List<List<Int>>): Int {
    println("직사각형 넓이 구하기")
    var answer = 0
    var w = 0
    var h = 0
    val x = dots[0][0]
    val y = dots[0][1]
    for(i in 1 until dots.size) {
        if(x != dots[i][0]) w = abs(x - dots[i][0])
        if(y != dots[i][1]) h = abs(y - dots[i][1])
    }
    answer = w * h
    return answer
}

/*private fun parsePointInput(input: String): List<List<Int>> {
    val pointStrings = input.split(" | ")
    return pointStrings.map { pointString ->
        val coordinates = pointString.split(",").map { it.toInt() }
        coordinates
    }
}*/

private fun charactersCoordinates(keyInput: MutableList<String>, board: MutableList<Int>, result: MutableList<Int>) {
    val answer = arrayOf(0, 0)
    for(i in keyInput) {
        when(i) {
            "left" -> {
                if(answer[0]-1 >= -(board[0]/2)) {
                    answer[0] -= 1
                }
            }
            "right" -> {
                if(answer[0]+1 <= board[0]/2) {
                    answer[0] += 1
                }
            }
            "up" -> {
                if(answer[1]+1 <= board[1]/2) {
                    answer[1] += 1
                }
            }
            "down" -> {
                if(answer[1]-1 >= -(board[1]/2)) {
                    answer[1] -= 1
                }
            }
        }
        if(-(board[0]/2) > answer[0]) answer[0] = -(board[0]/2)
        if(board[0]/2 < answer[0]) answer[0] = board[0]/2
        if(-(board[1]/2) > answer[1]) answer[1] = -(board[1]/2)
        if(board[1]/2 < answer[1]) answer[1] = board[1]/2
    }
    result.addAll(answer)
    println("캐릭터의 좌표 : $result")
}

private fun createMaximumValue2(numbers: MutableList<Int>, result: MutableState<Int>) {
    var answer = 0
    val sortedNumbers = numbers.sorted()
    answer = if(sortedNumbers[0] * sortedNumbers[1] > sortedNumbers[sortedNumbers.size - 1] * sortedNumbers[sortedNumbers.size - 2]) {
        sortedNumbers[0]*sortedNumbers[1]
    } else {
        sortedNumbers[sortedNumbers.size - 1] * sortedNumbers[sortedNumbers.size - 2]
    }
    result.value = answer
    println("최댓값 만들기(2) : ${result.value}")
}


private fun addPolynomials(polynomial: String, result: MutableState<String>) {
    var x = 0
    var num = 0
    for(i in polynomial.split(" ".toRegex())) {
        if(i.contains("x")) {
            x += if(i == "x") 1 else i.replace("x".toRegex(), "").toInt()
        }
        else if(i != "+") {
            num += i.toInt()
        }
    }
    result.value = if(num != 0 && x != 0) {
        "${x}x + $num"
    } else if(num == 0 && x != 0) {
        "${x}x"
    } else  {
        "null"
    }
    println("다항식 더하기 : ${result.value}" )
}