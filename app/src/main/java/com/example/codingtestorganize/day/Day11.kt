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
fun Day11(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableStateOf(0) }
                var box by remember { mutableStateOf("") }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이는 직 육면체 모양의 상자를 하나 가지고 있는데 이 상자에 정 육면체 모양의 주사위를 최대한 많이 채우고 싶습니다. 상자의 가로, 세로, 높이가 저장 되어 있는 배열 box 와 주사위 모서리의 길이 정수 n이 매개 변수로 주어 졌을 때, 상자에 들어갈 수 있는 주사위의 최대 개수를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = box,
                        onValueChange = { box = it },
                        label = { Text(text = ", 기준 box 배열 입력")},
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
                        if(show) result.value = numberOfDice(stringToMutableIntList(box), n.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "주사위의 개수 : ${result.value}")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            box = ""
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
                    Text(text = "약수의 개수가 세 개 이상인 수를 합성수 라고 합니다. 자연수 n이 매개 변수로 주어질 때 n 이하의 합성 수의 개수를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = findCompositeNumbers(n.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("합성수 찾기 : ${result.value}")
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
                        if(show) result.value = createMaximumValue1(stringToMutableIntList(numbers))
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("최댓값 만들기(1) : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            numbers = ""
                            result.value = 0
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
                    Text(text = "i 팩토리얼 (i!)은 1부터 i까지 정수의 곱을 의미 합니다. 예를 들어 5! = 5 * 4 * 3 * 2 * 1 = 120 입니다. 정수 n이 주어질 때 다음 조건을 만족 하는 가장 큰 정수 i를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = factorial(n.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("팩토리얼 : ${result.value}")
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

private fun numberOfDice(box: MutableList<Int>, n: Int): Int {
    println("주사위의 개수")
    return (box[0]/n) * (box[1]/n) * (box[2]/n)
}

private fun findCompositeNumbers(n: Int): Int {
    println("합성수 찾기")
    return (1..n).filter { i -> (1..i).filter { i % it == 0 }.size >= 3 }.size
}

private fun createMaximumValue1(numbers: MutableList<Int>): Int {
    println("최댓값 만들기(1)")
    val list = numbers.sorted()
    val a = list.last()
    val b = list[list.size-2]
    return a*b
}

private fun factorialFunction(n: Int): Int {
    return if(n==0) 1 else n * factorialFunction(n-1)
}
// ↓ 사용

private fun factorial(n: Int): Int {
    println("팩토리얼")
    var answer = 0
    for(i in 10 downTo 1) {
        if(factorialFunction(i) <= n) {
            answer = i
            break
        }
    }
    return answer
}