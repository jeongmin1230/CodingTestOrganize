package com.example.codingtestorganize

fun lcm(a: Int, b: Int): Int {
    return a * b / gcd(a, b)
}

fun gcd(a : Int, b: Int): Int {
    return if(a < b) {
        if(a == 0) b else gcd(a, b % a)
    } else {
        if(b == 0) a else gcd(b, a % b)
    }
}

fun stringToMutableIntList(input: String): MutableList<Int> {
    val inputValues = input.split(",").map { it.trim() }

    return inputValues.mapNotNull { it.toIntOrNull() }.toMutableList()
}

fun stringToMutableStringList(input: String): MutableList<String> {
    return  input.split(",").map { it.trim() }.toMutableList()
}

fun stringToIntArray(input: String): IntArray {
    val inputValues = input.split(",").map { it.trim() }
    return inputValues.mapNotNull { it.toIntOrNull() }.toIntArray()
}