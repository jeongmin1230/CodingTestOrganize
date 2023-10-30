package com.example.codingtestorganize.day

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.codingtestorganize.R
import com.example.codingtestorganize.stringToMutableIntList

@Composable
fun Day25(choose: String) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        when(choose) {
            "1" -> {
                val result = remember { mutableStateOf(0) }
                var a by remember { mutableStateOf("") }
                var b by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "문자열 [hello]에서 각 문자를 오른쪽 으로 한 칸씩 밀고 마지막 문자는 맨 앞으로 이동 시키면 [ohell]이 됩니다. " +
                            "이것을 문자열 을 민다고 정의 한다면 문자열 A와 B가 매개 변수로 주어질 때, A를 밀어서 B가 될 수 있다면 밀어야 하는 최소 횟수를 return 하고 밀어서 B가 될 수 없으면 -1을 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = a,
                        onValueChange = { a = it },
                        label = { Text(text = "문자열 A")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = b,
                        onValueChange = { b = it },
                        label = { Text(text = "문자열 B")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) result.value = stringPush(a, b)
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "문자열 밀기: ${result.value}")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            a = ""
                            b = ""
                            result.value = 0
                        }
                    }
                }
            }
            "2" -> {
                val result = remember { mutableStateOf(0) }
                var m by remember { mutableStateOf("") }
                var n by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "머쓱이는 큰 종이를 1 x 1 크기로 자르 려고 합니다. 예를 들어 2 x 2 크기의 종이를 1 x 1 크기로 자르 려면 최소 가위질 세 번이 필요 합니다." +
                            "정수 M, N이 매개 변수로 주어질 때, M x N 크기의 종이를 최소로 가위질 해야 하는 횟수를 return 하도록 solution 함수를 완성 해 보세요." +
                            "종이는 겹쳐서 자를 수 없습니다. ")
                    Spacer(modifier = Modifier.height(10.dp))
                    Image(painter = painterResource(id = R.drawable.paper_cutting_explain), contentDescription = null)
                    TextField(
                        value = m,
                        onValueChange = { m = it },
                        label = { Text(text = "정수 m") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = n,
                        onValueChange = { n = it },
                        label = { Text(text = "정수 n") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.value = paperCutting(m.toInt(), n.toInt())
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) {
                        Text(text = "종이 자르기 : ${result.value}")
                    }
                    LaunchedEffect(show) {
                        if(!show) {
                            m = ""
                            n = ""
                            result.value = 0
                        }
                    }
                }
            }
            "3" -> {
                val result = remember { mutableListOf<Int>() }
                var num by remember { mutableStateOf("") }
                var total by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "연속된 세 개의 정수를 더해 12가 되는 경우는 3, 4, 5입니다. " +
                            "두 정수 num 과 total 이 주어 집니다. " +
                            "연속된 수 num 개를 더한 값이 total 이 될 때, 정수 배열을 오름차 순 으로 담아 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = num,
                        onValueChange = { num = it },
                        label = { Text(text = "정수 num") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = total,
                        onValueChange = { total = it },
                        label = { Text(text = "정수 total") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(onClick = {
                        show = !show
                        if(show) result.addAll(sumOfConsecutiveNumbers(num.toInt(), total.toInt()))
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("연속된 수의 합 : $result")
                    LaunchedEffect(show) {
                        if(!show) {
                            num = ""
                            total = ""
                            result.clear()
                        }
                    }
                }
            }
            "4" -> {
                val result = remember { mutableStateOf(0) }
                var common by remember { mutableStateOf("") }
                var j by remember { mutableStateOf("") }
                var k by remember { mutableStateOf("") }
                var show by remember { mutableStateOf(false) }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "등차 수열 혹은 등비 수열 common 이 매개 변수로 주어질 때, 마지막 원소 다음 으로 올 숫자를 return 하도록 solution 함수를 완성 해 보세요.")
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = common,
                        onValueChange = { common = it },
                        label = { Text(text = ", 기준 common 배열 입력")},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        show = !show
                        if(show) result.value = theNumberThatComesNext(stringToMutableIntList(common))
                    }) {
                        Text(text = if(!show) stringResource(id = R.string.enter) else stringResource(id = R.string.enter_again))
                    }
                    if(show) Text("다음에 올 숫자 : ${result.value}")
                    LaunchedEffect(show) {
                        if(!show) {
                            common = ""
                            result.value = 0
                        }
                    }
                }
            }
        }
    }
}

private fun stringPush(A: String, B: String): Int {
    println("문자열 밀기")
    var a = A
    var answer = 0
    while (a != B) {
        answer++
        val sb = StringBuilder(a)
        val tmp = sb.substring(sb.length - 1)
        sb.insert(0, tmp)
        sb.deleteCharAt(sb.length - 1)
        a = sb.toString()
        if (answer > a.length) {
            answer = -1
            break
        } else {
            continue
        }
    }
    return answer
}

private fun paperCutting(m: Int, n: Int): Int {
    println("종이 자르기")
    return m*n-1
}

private fun sumOfConsecutiveNumbers(num: Int, total: Int): List<Int> {
    println("연속된 수의 합")
    val answer = mutableListOf<Int>()
    var data = total/num
    for(i in 0 until num) {
        data += if(i%2 == 0) -i else i
        answer.add(data)
    }
    return answer.sorted()
}

private fun theNumberThatComesNext(common: MutableList<Int>): Int {
    println("다음에 올 숫자")
    var answer = 0
    var num = 0
    if(common[2]-common[1] == common[1]-common[0]) {
        num = common[2]-common[1]
        answer = common.last() + num
    }
    else {
        num = common[1]/common[0]
        answer = common.last() * num
    }
    return answer
}