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
import com.example.codingtestorganize.stringToMutableIntList

@Composable
fun Day6(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val answer = remember { mutableStateOf("") }
                var myString by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "문자열 my string 이 매개 변수로 주어 집니다. my string 을 거꾸로 뒤집은 문자열 을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = myString,
                        onValueChange = { myString = it },
                        label = { Text(text = "문자열 my string") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) flipString(myString, answer)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("문자열 뒤집기 : ${answer.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            myString = ""
                            answer.value = ""
                        }
                    }
                }
            }
            "2" -> {
                val resultArray = remember { mutableListOf<String>() }
                var inputN by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "*의 높이와 너비를 1이라고 했을 때, *을 이용해 직각 이등변 삼각형 을 그리려고 합니다. 정수 n 이 주어 지면 높이와 너비가 n 인 직각 이등변 삼각형 을 출력 하도록 코드를 작성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = inputN,
                        onValueChange = { inputN = it },
                        label = { Text(text = "정수 n 입력") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) printingARightTriangle(inputN, resultArray)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text("직각 삼각형 출력 하기 : 결과는 콘솔창 확인")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            inputN = ""
                            resultArray.clear()
                        }
                    }
                }
            }
            "3" -> {
                val resultArray = remember { mutableListOf<Int>() }
                var numList by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수가 담긴 리스트 num list 가 주어질 때, num list 의 원소 중 짝수와 홀수의 개수를 담은 배열을 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = numList,
                        onValueChange = { numList = it },
                        label = { Text(text = ", 기준 num list 배열 입력 ")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) evenOddNumber(stringToMutableIntList(numList), resultArray)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "짝수 홀수 개수 : $resultArray")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            numList = ""
                            resultArray.clear()
                        }
                    }
                }
            }
            "4" -> {
                val answer = remember { mutableStateOf("") }
                var myString by remember { mutableStateOf("") }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "문자열 my string 과 정수 n이 매개 변수로 주어질 때, my string 에 들어 있는 각 문자를 n만큼 반복한 문자 열을 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = myString,
                        onValueChange = { myString = it },
                        label = { Text(text = "문자열 my string") },
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .fillMaxWidth()
                    )
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) printingRepeatedCharacters(myString, n, answer)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("문자 반복 출력 하기 : ${answer.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            myString = ""
                            n = ""
                            answer.value = ""
                        }
                    }
                }
            }
        }
    }
}

private fun flipString(myString: String, answer: MutableState<String>) {
    answer.value = myString.reversed()
    println("문자열 뒤집기 : ${answer.value}")
}

/** TODO - 직각 삼각형 출력 하기 콘솔 말고 화면에서도 결과 나오게 */
private fun printingARightTriangle(inputN: String, resultArray: MutableList<String>) {
    println("직각 삼각형 출력 하기")
    for(i in 0 until inputN.toInt()) {
        for(j in 0..i) {
            print("*")
        }
        println()
    }
}

private fun evenOddNumber(numList: MutableList<Int>, resultArray: MutableList<Int>) {
    resultArray.add(numList.filter { it % 2 == 0 }.size)
    resultArray.add(numList.filter { it % 2 == 1 }.size)
    println("짝수 홀수 개수 : $resultArray")
}

private fun printingRepeatedCharacters(myString: String, n: String, answer: MutableState<String>) {
    answer.value = myString.map { it.toString().repeat(n.toInt()) }.joinToString().replace(", ", "")
    println("문자 반복 출력 하기 : ${answer.value}")
}