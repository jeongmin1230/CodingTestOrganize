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
import com.example.codingtestorganize.lcm
import com.example.codingtestorganize.stringToMutableIntList

@Composable
fun Day4(choose: String) {
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
                    Text(text = "머쓱이네 피자 가게는 피자를 일곱 조각 으로 잘라 줍니다. 피자를 나눠 먹을 사람의 수 n이 주어질 때, 모든 사람이 피자를 한 조각 이상 먹기 위해 필요한 피자의 수를 return 하는 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = sharingPizza1(n.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "피자 나눠 먹기(1) : ${result.value}")
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
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이네 피자 가게는 피자를 여섯 조각 으로 잘라 줍니다. 피자를 나눠 먹을 사람의 수 n이 매개 변수로 주어질 때, n명이 주문한 피자를 남기지 않고 모두 같은 수의 피자 조각을 먹어야 한다면 최소 몇 판을 시켜야 하는 지를 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n") },
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = sharingPizza2(n.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "피자 나눠 먹기(2) : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            n = ""
                            result.value = 0
                        }
                    }
                }
            }
            "3" -> {
                val result = remember { mutableStateOf(0) }
                var slice by remember { mutableStateOf("") }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이네 피자 가게는 피자를 두 조각 에서 열 조각 까지 원하는 조각 수로 잘라 줍니다. 피자 조각 수 slice 와 피자를 먹는 사람의 수 n이 매개 변수로 주어질 때, n명의 사람이 최소 한 조각 이상 피자를 먹으 려면 최소 몇 판의 피자를 시켜야 하는 지를 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = slice,
                        onValueChange = { slice = it },
                        label = { Text(text = "정수 slice") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n") },
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = sharingPizza3(slice.toInt(), n.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "피자 나눠 먹기(3) : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            slice = ""
                            n = ""
                            result.value = 0
                        }
                    }
                }
            }
            "4" -> {
                val floatAnswer = remember { mutableStateOf(0.0) }
                var numbers by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 배열 numbers 가 매개 변수로 주어 집니다. numbers 의 원소의 평균 값을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = numbers,
                        onValueChange = { numbers = it },
                        label = { Text(text = ", 기준 numbers 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) floatAnswer.value = averageValueOfArray(stringToMutableIntList(numbers))
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "배열의 평균 값 : ${floatAnswer.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            numbers = ""
                            floatAnswer.value = 0.0
                        }
                    }
                }
            }
        }
    }
}

private fun sharingPizza1(n: Int): Int {
    println("피자 나눠 먹기(1)")
    var answer = 0
    answer = if(n%7 == 0) n/7 else n/7+1
    return answer
}

private fun sharingPizza2(n: Int): Int {
    println("피자 나눠 먹기(2)")
    var answer = 0
    val lcmValue = lcm(n, 6)
    answer = lcmValue/6
    return answer
}

private fun sharingPizza3(slice: Int, n: Int): Int {
    println("피자 나눠 먹기(3)")
    var answer = 0
    answer = if(n%slice == 0) n/slice else n/slice+1
    return answer
}

private fun averageValueOfArray(numbers: MutableList<Int>): Double {
    println("배열의 평균값")
    var sum = 0.0
    var answer = 0.0
    if(numbers.isNotEmpty()) {
        for(i in 0 until numbers.size) {
            sum += numbers[i]
        }
        answer = sum/numbers.size
    }
    return answer
}