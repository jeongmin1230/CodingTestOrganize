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
fun Day7(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableStateOf("") }
                var myString by remember { mutableStateOf("") }
                var letter by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "문자열 my string 과 문자 letter 이 매개 변수로 주어 집니다. " +
                            "my string 에서 letter 를 제거한 문자 열을 return 하도록 solution 함수를 완성 해 주세요.")
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
                        value = letter,
                        onValueChange = { letter = it },
                        label = { Text(text = "문자열 letter") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = removeSpecificCharacters(myString, letter)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("특정 문자 제거 하기 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            myString = ""
                            letter = ""
                            result.value = ""
                        }
                    }
                }
            }
            "2" -> {
                val result = remember { mutableStateOf(0) }
                var angle by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "각에서 0도 초과 90도 미만은 예각, 90도는 직각, 90도 초과 180도 미만은 둔각 180도는 평각 으로 분류 합니다. " +
                            "각 angle 이 매개 변수로 주어질 때 예각일 때 1, 직각일 때 2, 둔각일 때 3, 평각일 때 4를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = angle,
                        onValueChange = { angle = it },
                        label = { Text(text = "정수 angle") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = protractor(angle.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("각도기 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            angle = ""
                            result.value = 0
                        }
                    }
                }
            }
            "3" -> {
                val result = remember { mutableStateOf(0) }
                var n by remember { mutableStateOf("") }
                var k by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이네 양꼬치 가게는 10인분을 먹으면 음료수 하나를 서비스 로 줍니다. " +
                            "양꼬치 는 1인분에 12,000원, 음료수 는 2,000원 입니다. 정수 n과 k가 매개 변수로 주어 졌을 때, " +
                            "양꼬치 n 인분과 음료수 k개를 먹었 다면 총 얼마를 지불 해야 하는지 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = k,
                        onValueChange = { k = it },
                        label = { Text(text = "정수 k") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = lambSkewers(n.toInt(), k.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("양꼬치 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            n = ""
                            k = ""
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
                    Text(text = "정수 n이 주어질 때, n 이하의 짝수를 모두 더한 값을 return 하도록 solution 함수를 작성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = sumOfEvenNumbers(n.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("짝수의 합 : ${result.value}")
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

private fun removeSpecificCharacters(myString: String, letter: String): String {
    println("특정 문자 제거 하기")
    return myString.replace(letter, "")
}

private fun protractor(angle: Int): Int {
    println("각도기")
    return if(angle in 1..89) 1
        else if(angle == 90) 2
        else if(angle in 91 .. 179) 3
        else 4
}

private fun lambSkewers(n: Int, k: Int): Int {
    println("양꼬치")
    return (12000 * n) + (k - n/10) * 2000
}

private fun sumOfEvenNumbers(n: Int): Int {
    println("짝수의 합")
    var answer = 0
    (1..n).forEach {
        if(it%2==0) {
            answer += it
        }
    }
    return answer
}