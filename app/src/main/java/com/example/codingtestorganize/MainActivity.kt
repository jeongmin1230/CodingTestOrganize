package com.example.codingtestorganize

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.codingtestorganize.day.*
import com.example.codingtestorganize.ui.theme.CodingTestOrganizeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodingTestOrganizeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    EnterDayIndex()
                }
            }
        }
    }
}

@Composable
fun EnterDayIndex() {
    var doSearch by remember { mutableStateOf(false) }
    var day by remember { mutableStateOf("") }
    var choose by remember { mutableStateOf("") }
    Column(modifier = Modifier
        .padding(horizontal = 10.dp)
        .fillMaxSize()) {
        Text(text = stringResource(id = R.string.enter_day))
        Spacer(modifier = Modifier.height(10.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = day,
                onValueChange = {
                    doSearch = false
                    day = it
                                },
                modifier = Modifier
                    .padding(end = 10.dp, bottom = 10.dp)
                    .weight(1f)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = stringResource(id = R.string.enter_index))
            TextField(
                value = choose,
                onValueChange = { choose = it },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                if(doSearch) {
                    day = ""
                    choose = ""
                }
                doSearch = !doSearch
            }) {
                Text(text = if(!doSearch) stringResource(id = R.string.confirm) else stringResource(id = R.string.enter_again))
            }
        }
        if(doSearch) {
            when(day) {
                "1" -> Day1(choose)
                "2" -> Day2(choose)
                "3" -> Day3(choose)
                "4" -> Day4(choose)
                "5" -> Day5(choose)
                "6" -> Day6(choose)
                "7" -> Day7(choose)
                "8" -> Day8(choose)
                "9" -> Day9(choose)
                "10" -> Day10(choose)
                "11" -> Day11(choose)
                "12" -> Day12(choose)
                "13" -> Day13(choose)
                "14" -> Day14(choose)
                "15" -> Day15(choose)
                "16" -> Day16(choose)
                "17" -> Day17(choose)
                "18" -> Day18(choose)
                "19" -> Day19(choose)
                "20" -> Day20(choose)
                "21" -> Day21(choose)
                "22" -> Day22(choose)
                "23" -> Day23(choose)
                "24" -> Day24(choose)
            }
        }
    }
}