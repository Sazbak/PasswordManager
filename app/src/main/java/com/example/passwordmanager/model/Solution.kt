package com.example.passwordmanager.model

class Solution {
    fun intoRoman(num: Int): String {
        val romanIntValueOrder = listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        var result = ""
        var input = num

        for (unitValue in romanIntValueOrder) {
            while (input / unitValue > 0) {
                result += intUnitValueToRoman(unitValue)
                input -= unitValue
            }
        }

        return result
    }

    fun intUnitValueToRoman(num: Int) = when (num) {
        1000 -> "M"
        900 -> "CM"
        500 -> "D"
        400 -> "CD"
        100 -> "C"
        90 -> "XC"
        50 -> "L"
        40 -> "XL"
        10 -> "X"
        9 -> "IX"
        5 -> "V"
        4 -> "IV"
        1 -> "I"
        else -> ""
    }

    //test change
}