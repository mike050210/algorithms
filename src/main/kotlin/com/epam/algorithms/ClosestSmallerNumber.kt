package com.epam.algorithms

fun main() {

    val originalArray = intArrayOf(33, 24, 12, 2, 5, 4, 3, 9, 24, 20, 3, 1, 54, 23, 11, 12, 44, 1, 23, 3, 1, 44, 3, 78, 2)
    println(ClosestSmallerNumber().findClosestSmallerNumber(originalArray).asList())
    // println(ClosestSmallerNumber().findClosestSmallerNumberImproved(originalArray).asList())
}

class ClosestSmallerNumber {
    fun findClosestSmallerNumber(numbers: IntArray): IntArray {
        val smallerNumbers = IntArray(numbers.size)
        for (i in 0..numbers.lastIndex) {
            var smaller = -1
            for (j in i - 0 downTo 0) {
                if (numbers[j] < numbers[i]) {
                    smaller = numbers[j]
                    break;
                }
            }

            smallerNumbers[i] = smaller
        }

        return smallerNumbers
    }

    fun findClosestSmallerNumberImproved(numbers: IntArray): IntArray {
        val smallerNumbers = IntArray(numbers.size)
        val stack = IntArray(numbers.size)
        var stackIndex = -1 // Empty Stack

        for (i in 0..numbers.lastIndex) {

            // Pop all elements from stack that are greater than the current element
            while (stackIndex != -1 && stack[stackIndex] >= numbers[i]) {
                stackIndex--
            }

            // If all elements in S were greater than arr[i]
            smallerNumbers[i] = if (stackIndex == -1) -1 else stack[stackIndex]

            // Push current element to the stack
            stackIndex++
            stack[stackIndex] = numbers[i]
        }

        return smallerNumbers
    }
}