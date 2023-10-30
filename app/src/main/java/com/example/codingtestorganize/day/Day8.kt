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
fun Day8(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableListOf<Int>() }
                var numbers by remember { mutableStateOf("") }
                var num1 by remember { mutableStateOf("") }
                var num2 by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 배열 numbers 와 정수 num1, num2가 매개 변수로 주어질 때, " +
                            "numbers 의 num1번 째 인덱스 부터 num2번째 인덱스 까지 자른 정수 배열을 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = numbers,
                        onValueChange = { numbers = it },
                        label = { Text(text = ", 기준 numbers 배열 입력 ")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = num1,
                        onValueChange = { num1= it },
                        label = { Text(text = "num1 입력 ")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = num2,
                        onValueChange = { num2 = it },
                        label = { Text(text = "num2 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.addAll(trimArray(stringToMutableIntList(numbers), num1.toInt(), num2.toInt()))
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "배열 자르기 : $result")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            numbers = ""
                            num1 = ""
                            num2 = ""
                            result.clear()
                        }
                    }
                }
            }
            "2" -> {
                val result = remember { mutableStateOf("") }
                var age by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "우주 여행을 하던 머쓱이는 엔진 고장 으로 PROGRAMMERS-962 행성에 불시착 하게 됐습니다. " +
                            "입국 심사 에서 나이를 말해야 하는데, PROGRAMMERS-962 행성 에서는 나이를 알파벳 으로 말하고 있습니다. " +
                            "a는 0, b는 1, c는 2, ..., j는 9입니다. 예를 들어 23살은 cd, 51살은 fb로 표현 합니다. " +
                            "나이 age 가 매개 변수로 주어질 때 PROGRAMMER-962식 나이를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = age,
                        onValueChange = { age = it },
                        label = { Text(text = "age") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = ageOfExoPlanets(age)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("외계 행성의 나이 : ${result.value.removePrefix("null").removeSuffix("null")}")
                    LaunchedEffect(show) {
                        if(!show) {
                            age = ""
                            result.value = ""
                        }
                    }
                }
            }
            "3" -> {
                val resultArray = remember { mutableListOf<Int>() }
                var emergency by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "외과 의사 머쓱이는 응급실 에 온 환자의 응급도 를 기준 으로 진료 순서를 정하 려고 합니다." +
                            " 정수 배열 emergency 가 매개 변수로 주어질 때 응급 도가 높은 순서 대로 진료 순서를 정한 배열을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = emergency,
                        onValueChange = { emergency = it },
                        label = { Text(text = ", 기준 emergency 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) resultArray.addAll(decidingTheOrderOfTreatment(stringToMutableIntList(emergency)))
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "진료 순서 정하기 : $resultArray")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            emergency = ""
                            resultArray.clear()
                        }
                    }
                }
            }
            "4" -> {
                val result = remember { mutableStateOf(0) }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "순서쌍 이란 두 개의 숫자를 순서를 정하여 짝지어 나타낸 쌍으로 (a, b)로 표기 합니다. " +
                            "자연수 n이 매개 변수로 주어질 때 두 숫자의 곱이 n인 자연수 순서 쌍의 개수를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = numbersOfOrderedPairs(n.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("순서 쌍의 개수 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            n = ""
                            result.value = 0
                        }
                    }
                }
            }
        }
    }
}

private fun trimArray(numbers: MutableList<Int>, num1: Int, num2: Int): MutableList<Int> {
    println("배열 자르기")
    val list = mutableListOf<Int>()
    list.addAll(numbers.toList().subList(num1, num2+1))
    return list
}

private fun ageOfExoPlanets(age: String): String {
    println("외계 행성의 나이 ")
    var answer = ""
    val map = mapOf(
        "0" to "a",
        "1" to "b",
        "2" to "c",
        "3" to "d",
        "4" to "e",
        "5" to "f",
        "6" to "g",
        "7" to "h",
        "8" to "i",
        "9" to "j"
    )
    age.split("").forEach {
        answer += map[it]
    }
    return answer
}

private fun decidingTheOrderOfTreatment(emergency: MutableList<Int>): MutableList<Int> {
    println("진료 순서 정하기")
    val list = mutableListOf<Int>()
    list.addAll(emergency.map { emergency.sortedDescending().indexOf(it) + 1 })
    return list
}

private fun numbersOfOrderedPairs(n: Int): Int {
    println("순서쌍의 개수")
    var answer = 0
    for(i in 1 .. n) {
        if(n % i == 0) {
            answer++
        }
    }
    return answer
}