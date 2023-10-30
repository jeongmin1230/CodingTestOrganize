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
    return  input.split(",").map { it.replace(" ", "") }.toMutableList()
}

fun parsePointInput(input: String): List<List<Int>> {
    val pointStrings = input.split("|")
    return pointStrings.map { pointString ->
        val coordinates = pointString.split(",").map { it.toInt() }
        coordinates
    }
}

fun convertListOfListsToArray(listOfLists: List<List<Int>>): Array<IntArray> {
    return listOfLists.map { it.toIntArray() }.toTypedArray()
}