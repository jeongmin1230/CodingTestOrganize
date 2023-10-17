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

@Composable
fun Day13(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableStateOf(0) }
                var s by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "숫자와 \"Z\"가 공백 으로 구분 되어 담긴 문자 열이 주어 집니다. 문자 열에 있는 숫자를 차례 대로 더하려고 합니다. 이 때 \"Z\"가 나오면 바로 전에 더했던 숫자를 뺀다는 뜻 입니다. 숫자와 \"Z\"로 이루어 진 문자열 s가 주어질 때, 머쓱이가 구한 값을 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = s,
                        onValueChange = { s = it },
                        label = { Text(text = "문자열 s")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) controlZ(s, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "컨트롤 제트 : ${result.value}")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            s = ""
                            result.value = 0
                        }
                    }
                }
            }
            "2" -> {
                val result = remember { mutableListOf<Int>() }
                var strList by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "문자열 배열 strList 가 매개 변수로 주어 집니다. strList 각 원소의 길이를 담은 배열을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = strList,
                        onValueChange = { strList = it },
                        label = { Text(text = "문자열 myString")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    val inputValues = strList.split(" ").map { it.trim() }.toMutableList()
                    Button(onClick = {
                        show = !show
                        if(show) lengthOfArrayElements(inputValues, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("배열 원소의 길이 : $result")
                    LaunchedEffect(show) {
                        if(!show) {
                            strList = ""
                            result.clear()
                        }
                    }
                }
            }
            "3" -> {
                val result = remember { mutableStateOf("") }
                var myString by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "문자열 myString 이 매개 변수로 주어 집니다. myString 에서 중복된 문자를 제거 하고 하나의 문자만 남긴 문자 열을 return 하도록 solution 함수를 완성 해 주세요.")
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
                        if(show) removeDuplicateCharacters(myString, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("중복된 문자 제거 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            myString = ""
                            result.value = ""
                        }
                    }
                }
            }
            "4" -> {
                val result = remember { mutableStateOf(0) }
                var sides by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족 해야 합니다.\n" +
                            "[가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.]\n" +
                            "삼각형의 세 변의 길이가 담긴 배열 sides 이 매개 변수로 주어 집니다. 세 변으로 삼각형을 만들 수 있다면 1, 만들 수 없다면 2를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = sides,
                        onValueChange = { sides = it },
                        label = { Text(text = ", 기준 sides 배열 입력") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    val inputValues = sides.split(",").map { it.trim() }
                    val intValues = inputValues.mapNotNull { it.toIntOrNull() }.toMutableList()
                    Button(onClick = {
                        show = !show
                        if(show) conditionsForCompletingATriangle(intValues, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("삼각형의 완성 조건(1) : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            sides = ""
                            result.value = 0
                        }
                    }
                }
            }
        }
    }
}

private fun controlZ(s: String, result: MutableState<Int>) {
    val list = s.split(" ")
    for(i in list.indices) {
        if(list[i] == "Z") {
            result.value -= list[i-1].toInt()
        }
        else {
            result.value += list[i].toInt()
        }
    }
    println("컨트롤 제트 : ${result.value}")
}

private fun lengthOfArrayElements(myString: MutableList<String>, result: MutableList<Int>) {
    for(i in myString) {
        result.add(i.length)
    }
    println("배열 원소의 길이 : $result")
}

private fun removeDuplicateCharacters(myString: String, result: MutableState<String>) {
    result.value = myString.split("").distinct().joinToString("")
    println("중복된 문자 제거 : ${result.value}")
}


private fun conditionsForCompletingATriangle(sides: MutableList<Int>, result: MutableState<Int>) {
    sides.sorted().let { (x, y, z) ->  if(x + y > z) result.value = 1 else result.value = 2 }
    println("삼각형의 완성 조건(1) : ${result.value}" )
}