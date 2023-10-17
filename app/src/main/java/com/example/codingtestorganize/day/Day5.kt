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
fun Day5(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val answer = remember { mutableStateOf(0) }
                var price by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이네 옷 가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만 원 이상 사면 20%를 할인 해 줍니다. 구매한 옷의 가격 price 가 주어질 때, 지불 해야 할 금액을 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = price,
                        onValueChange = { price = it },
                        label = { Text(text = "정수 price") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) getADiscountAtAClothingStore(price, answer)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "옷가게 할인 받기 : ${answer.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            price = ""
                            answer.value = 0
                        }
                    }
                }
            }
            "2" -> {
                val resultArray = remember { mutableListOf<Int>() }
                var money by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이는 추운 날에도 아이스 아메리카노 만 마십 니다. 아이스 아메리카노 는 한잔에 5,500원 입니다. 머쓱이가 가지고 있는 돈 money 가 매개 변수로 주어질 때, 머쓱이가 최대로 마실 수 있는 아메리카노의 잔 수와 남는 돈을 순서 대로 담은 배열을 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = money,
                        onValueChange = { money = it },
                        label = { Text(text = "정수 money") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) iceAmericano(money, resultArray)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "아이스 아메리카노: $resultArray")
                    LaunchedEffect(show) {
                        if(!show) {
                            money = ""
                            resultArray.clear()
                        }
                    }
                }
            }
            "3" -> {
                val answer = remember { mutableStateOf(0) }
                var age by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이는 40살인 선생님 이 몇 년도에 태어 났는지 궁금 해 졌습니다. 나이 age 가 주어질 때, 2022년을 기준 출생 연도를 return 하는 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = age,
                        onValueChange = { age = it },
                        label = { Text(text = "정수 age") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) ageOutput(age, answer)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text(text = "나이 출력: ${answer.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            age = ""
                            answer.value = 0
                        }
                    }
                }
            }
            "4" -> {
                val resultArray = remember { mutableListOf<Int>() }
                var inputText by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "정수가 들어 있는 배열 num list 가 매개 변수로 주어 집니다. num list 의 원소의 순서를 거꾸로 뒤집은 배열을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = inputText,
                        onValueChange = { inputText = it },
                        label = { Text(text = ", 기준 num list 배열 입력 ")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    val inputValues = inputText.split(",").map { it.trim() }
                    val intValues = inputValues.mapNotNull { it.toIntOrNull() }.toMutableList()
                    Button(onClick = {
                        show = !show
                        if(show) flipArray(intValues, resultArray)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "배열 뒤집기 : $resultArray")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            inputText = ""
                            resultArray.clear()
                        }
                    }
                }
            }
        }
    }
}

private fun getADiscountAtAClothingStore(price: String, answer: MutableState<Int>) {
    if(price.toInt() >= 500000) {
        answer.value = (price.toInt() * 0.8).toInt()
    } else if(price.toInt() >= 300000) {
        answer.value = (price.toInt() * 0.9).toInt()
    } else if(price.toInt() >= 100000) {
        answer.value = (price.toInt() * 0.95).toInt()
    } else {
        answer.value = price.toInt()
    }
    println("옷가게 할인 받기 : ${answer.value}")
}

private fun iceAmericano(money: String, resultArray: MutableList<Int>) {
    resultArray.add(money.toInt()/5500)
    resultArray.add(money.toInt() % 5500)
    println("아이스 아메리카노 : $resultArray")
}

private fun ageOutput(age: String, answer: MutableState<Int>) {
    answer.value = 2022 - (age.toInt()-1)
    println("나이 출력 : ${answer.value}")
}

private fun flipArray(numList: MutableList<Int>, resultArray: MutableList<Int>) {
    resultArray.addAll(numList.reversed())
    println("배열 뒤집기 : $resultArray")
}