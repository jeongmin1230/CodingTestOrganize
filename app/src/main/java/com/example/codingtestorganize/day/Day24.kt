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
fun Day24(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableStateOf(0) }
                var chicken by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "프로그래머스 치킨은 치킨을 시켜 먹으면 한 마리당 쿠폰을 한 장 발급 합니다. " +
                            "쿠폰을 열 장 모으면 치킨을 한 마리 서비스로 받을 수 있고, 서비스 치킨 에도 쿠폰이 발급 됩니다. " +
                            "시켜 먹은 치킨의 수 chicken 이 매개 변수로 주어질 때 받을 수 있는 최대 서비스 치킨의 수를 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = chicken,
                        onValueChange = { chicken = it },
                        label = { Text(text = "정수 chicken")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) result.value = chickenCoupon(chicken.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "치킨 쿠폰: ${result.value}")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            chicken = ""
                            result.value = 0
                        }
                    }
                }
            }
            "2" -> {
                val result = remember { mutableStateOf("") }
                var bin1 by remember { mutableStateOf("") }
                var bin2 by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "이진수를 의미 하는 두 개의 문자열 bin1과 bin2가 매개 변수로 주어질 때, " +
                            "두 이진수의 합을 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = bin1,
                        onValueChange = { bin1 = it },
                        label = { Text(text = "이진수 bin1") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = bin2,
                        onValueChange = { bin2 = it },
                        label = { Text(text = "이진수 bin2") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = addBinaryNumbers(bin1, bin2)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "이진수 더하기 : ${result.value}")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            bin1 = ""
                            bin2 = ""
                            result.value = ""
                        }
                    }
                }
            }
            "3" -> {
                val result = remember { mutableStateOf(0) }
                var before by remember { mutableStateOf("") }
                var after by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "문자열 before 와 after 가 매개 변수로 주어질 때, " +
                            "before 의 순서를 바꾸어 after 를 만들 수 있으면 1을, 만들 수 없으면 0을 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = before,
                        onValueChange = { before = it },
                        label = { Text(text = "문자열 before") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = after,
                        onValueChange = { after = it },
                        label = { Text(text = "문자열 after") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = makeBWithA(before, after)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("A로 B 만들기 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            before = ""
                            after = ""
                            result.value = 0
                        }
                    }
                }
            }
            "4" -> {
                val result = remember { mutableStateOf(0) }
                var i by remember { mutableStateOf("") }
                var j by remember { mutableStateOf("") }
                var k by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "1부터 13까지의 수에서, 1은 1, 10, 11, 12, 13 이렇게 총 6번 등장 합니다. " +
                            "정수 i, j, k가 매개 변수로 주어질 때, i부터 j까지 k가 몇 번 등장 하는지 return 하도록 solution 함수를 완성 해 주세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = i,
                        onValueChange = { i = it },
                        label = { Text(text = "정수 i")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = j,
                        onValueChange = { j = it },
                        label = { Text(text = "정수 j")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = k,
                        onValueChange = { k = it },
                        label = { Text(text = "정수 k")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = numberOfK(i.toInt(), j.toInt(), k.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("k 의 개수 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            i = ""
                            j = ""
                            k = ""
                            result.value = 0
                        }
                    }
                }
            }
        }
    }
}

private fun chickenCoupon(chicken: Int): Int {
    println("치킨 쿠폰")
    var coupon = chicken
    var answer = 0

    while(coupon>9) {
        answer += coupon/10
        val serviceChicken = coupon/10
        val leftCoupon = coupon%10
        coupon = leftCoupon + serviceChicken
    }
    return answer
}

private fun addBinaryNumbers(bin1: String, bin2: String): String {
    println("이진수 더하기")
    var answer = ""
    answer = Integer.toBinaryString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2))
    return answer
}

private fun makeBWithA(before: String, after: String): Int {
    println("A로 B 만들기")
    var answer = 0
    answer = if(before.toList().sorted() == after.toList().sorted()) 1 else 0
    return answer
}

private fun numberOfK(i: Int, j: Int, k: Int): Int {
    println("k 의 개수" )
    var answer = 0
    answer = (i .. j).joinToString("").count{ it.digitToInt() == k }
    return answer
}