package com.epam.algorithms

class CorrectHours {
    fun solution(A: Int, B: Int, C: Int, D: Int): Int {
        val numbers = intArrayOf(A, B, C, D)
        val validTimes = mutableSetOf<Int>()
        val indexTotalSum = 6


        for (i in 0..3) {
            for (j in 0..3) {
                if (j == i) continue

                for (k in 0..3) {
                    if (k == i || k == j) continue
                    val l = indexTotalSum - i - j - k

                    if (isValidTime(numbers[i], numbers[j], numbers[k], numbers[l])) {
                        validTimes.add(numbers[i] * 1000 + numbers[j] * 100 + numbers[k] * 10 + numbers[l])
                    }
                }


            }
        }

        return validTimes.size
    }

    private fun isValidTime(A: Int, B: Int, C: Int, D: Int): Boolean {
        val validHour = (A * 10 + B) < 24
        val validMinute = (C * 10 + D) < 60
        return validHour && validMinute
    }


}