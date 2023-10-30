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

@Composable
fun Day6(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableStateOf("") }
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
                        if(show) result.value = flipString(myString)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("문자열 뒤집기 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            myString = ""
                            result.value = ""
                        }
                    }
                }
            }
            "2" -> {
                val resultArray = remember { mutableListOf<String>() }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "*의 높이와 너비를 1이라고 했을 때, *을 이용해 직각 이등변 삼각형 을 그리려고 합니다. " +
                            "정수 n 이 주어 지면 높이와 너비가 n 인 직각 이등변 삼각형 을 출력 하도록 코드를 작성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n 입력") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) printingARightTriangle(n.toInt(), resultArray)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text("직각 삼각형 출력 하기 : 결과는 콘솔창 확인")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            n = ""
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
                    Text(text = "정수가 담긴 리스트 num list 가 주어질 때, " +
                            "num list 의 원소 중 짝수와 홀수의 개수를 담은 배열을 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = numList,
                        onValueChange = { numList = it },
                        label = { Text(text = ", 기준 num list 배열 입력 ")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) resultArray.addAll(evenOddNumber(stringToMutableIntList(numList)))
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
                val result = remember { mutableStateOf("") }
                var myString by remember { mutableStateOf("") }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "문자열 my string 과 정수 n이 매개 변수로 주어질 때, " +
                            "my string 에 들어 있는 각 문자를 n만큼 반복한 문자 열을 return 하도록 solution 함수를 완성 해 보세요.")
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
                        if(show) result.value = printingRepeatedCharacters(myString, n.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("문자 반복 출력 하기 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            myString = ""
                            n = ""
                            result.value = ""
                        }
                    }
                }
            }
        }
    }
}

private fun flipString(myString: String): String {
    println("문자열 뒤집기")
    return myString.reversed()
}

/** TODO - 직각 삼각형 출력 하기 콘솔 에만 출력 되는 거 수정 */
private fun printingARightTriangle(n: Int, resultArray: MutableList<String>) {
    println("직각 삼각형 출력 하기")
    for(i in 0 until n) {
        for(j in 0..i) {
            print("*")
        }
        println()
    }
}

private fun evenOddNumber(numList: MutableList<Int>): MutableList<Int> {
    println("짝수 홀수 개수")
    val resultArray = mutableListOf<Int>()
    resultArray.add(numList.filter { it % 2 == 0 }.size)
    resultArray.add(numList.filter { it % 2 == 1 }.size)
    return resultArray
}

private fun printingRepeatedCharacters(myString: String, n: Int): String {
    println("문자 반복 출력 하기")
    return myString.map { it.toString().repeat(n) }.joinToString().replace(", ", "")
}