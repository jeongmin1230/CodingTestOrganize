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

@Composable
fun Day2(choose: String) {
    val answer = remember { mutableStateOf(0) }
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                var show by remember { mutableStateOf(false) }
                var num1 by remember { mutableStateOf("") }
                var num2 by remember { mutableStateOf("") }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 num1과 num2가 매개 변수로 주어질 때, num1을 num2로 나눈 값에 1,000을 곱한 후 정수 부분을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = num1,
                        onValueChange = { num1 = it },
                        label = { Text(text = "정수 num1") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    TextField(
                        value = num2,
                        onValueChange = { num2 = it },
                        label = { Text(text = "정수 num2") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) divisionOfTwoNumbers(num1, num2, answer)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "두 수의 나눗셈 : ${answer.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            num1 = ""
                            num2 = ""
                            answer.value = 0
                        }
                    }
                }
            }
            "2" -> {
                var show by remember { mutableStateOf(false) }
                var num1 by remember { mutableStateOf("") }
                var num2 by remember { mutableStateOf("") }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 num1과 num2가 매개 변수로 주어 집니다. 두 수가 같으면 1 다르면 -1을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = num1,
                        onValueChange = { num1 = it },
                        label = { Text(text = "정수 num1") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = num2,
                        onValueChange = { num2 = it },
                        label = { Text(text = "정수 num2") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) compareTwoNumbers(num1, num2, answer)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "숫자 비교 하기 : ${answer.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            num1 = ""
                            num2 = ""
                            answer.value = 0
                        }
                    }
                }
            }
            "3" -> {
                val result = remember { mutableListOf<Int>() }
                var show by remember { mutableStateOf(false) }
                var nu1 by remember { mutableStateOf("") }
                var de1 by remember { mutableStateOf("") }
                var nu2 by remember { mutableStateOf("") }
                var de2 by remember { mutableStateOf("") }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1, 두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개 변수로 주어 집니다. 두 분수를 더한 값을 기약 분수로 나타 냈을 때 분자와 분모를 순서 대로 담은 배열을 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        TextField(
                            value = nu1,
                            onValueChange = { nu1 = it },
                            label = { Text(text = "nu1")},
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        TextField(
                            value = de1,
                            onValueChange = { de1 = it },
                            label = { Text(text = "de1")},
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        TextField(
                            value = nu2,
                            onValueChange = { nu2 = it },
                            label = { Text(text = "nu2")},
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        TextField(
                            value = de2,
                            onValueChange = { de2 = it },
                            label = { Text(text = "de2")},
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                    }

                    Button(onClick = {
                        show = !show
                        if(show) additionOfFractions(nu1, de1, nu2, de2, result)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "분수의 덧셈 : $result")
                    LaunchedEffect(show) {
                        if(!show) {
                            nu1 = ""
                            de1 = ""
                            nu2 = ""
                            de2 = ""
                            result.clear()
                        }
                    }
                }
            }
            "4" -> {
                val doubleArray = remember { mutableListOf<Int>() }
                var show by remember { mutableStateOf(false) }
                var inputText by remember { mutableStateOf("") }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수 배열 numbers 가 매개 변수로 주어 집니다. numbers 의 각 원소에 두배한 원소를 가진 배열을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = inputText,
                        onValueChange = { inputText = it },
                        label = { Text(text = ", 기준 numbers 배열 입력 ")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    val inputValues = inputText.split(",").map { it.trim() }
                    val intValues = inputValues.mapNotNull { it.toIntOrNull() }.toMutableList()
                    Button(onClick = {
                        show = !show
                        doubleTheArray(intValues, doubleArray)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "배열 두 배 만들기 $doubleArray")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            inputText = ""
                            intValues.clear()
                            doubleArray.clear()
                        }
                    }
                }
            }
        }
    }
}

private fun divisionOfTwoNumbers(num1: String, num2: String, answer: MutableState<Int>) {
    if(num1.isNotEmpty() && num2.isNotEmpty()) {
        answer.value = (num1.toFloat()/num2.toFloat()*1000).toInt()
        println("두 수의 나눗셈 : ${(num1.toFloat()/num2.toFloat()*1000).toInt()}")
    }
}

private fun compareTwoNumbers(num1: String, num2: String, answer: MutableState<Int>) {
    if(num1.isNotEmpty() && num2.isNotEmpty()) {
        answer.value = if(num1 == num2) 1 else -1
        println("숫자 비교 하기 : ${if(num1 == num2) 1 else -1}")
    }
}

private fun additionOfFractions(numer1: String, denom1: String, numer2: String, denom2: String, answer: MutableList<Int>) {
    val commonDenom = lcm(denom1.toInt(), denom2.toInt())
    val sumNumer = numer1.toInt() * (commonDenom / denom1.toInt()) + numer2.toInt() * (commonDenom / denom2.toInt())
    val gcd = gcd(sumNumer, commonDenom)
    answer.add(sumNumer/gcd)
    answer.add(commonDenom/gcd)
    println("분수의 덧셈 : $answer")
}

private fun lcm(a: Int, b: Int): Int {
    return a * b / gcd(a, b)
}
private fun gcd(a: Int, b: Int): Int {
    return if(b == 0) a else gcd(b, a % b)
}

private fun doubleTheArray(numbers: MutableList<Int>, doubleArray: MutableList<Int>) {
    if(numbers.toString().isNotEmpty()) {
        for(i in 0 until numbers.size) {
            doubleArray.add(numbers[i]*2)
        }
    }
    println("배열 두 배 만들기 : $doubleArray")
}