package com.epam.algorithms

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class ClosestSmallerNumberTest {

    private val closest = ClosestSmallerNumber()


    @Test
    fun `Find Closest Smaller Number by Brute Force`() {
        // Mixed numbers
        val mixed: IntArray = intArrayOf(33, 24, 12, 2, 5, 4, 3, 9, 24, 20, 3, 1, 54, 23, 11, 12, 44, 1, 23, 3, 1, 44, 3, 78, 2)
        val mixedExpected: IntArray = intArrayOf(-1, -1, -1, -1, 2, 2, 2, 3, 9, 9, 2, -1, 1, 1, 1, 11, 12, -1, 1, 1, -1, 1, 1, 3, 1)
        assertThat(closest.findClosestSmallerNumber(mixed), `is`(equalTo(mixedExpected)))

        // Numbers in ascending order
        val ascending = (1..100_000).toList().toIntArray()
        val ascSmallerExpected = (0..99_999).toList().toIntArray()
        ascSmallerExpected[0] = -1
        assertThat(closest.findClosestSmallerNumber(ascending), `is`(equalTo(ascSmallerExpected)))

        // Numbers in descending order
        val descending = (100_000 downTo 1).toList().toIntArray()
        val descSmallerExpected = List(100_000) { -1 }.toIntArray()
        assertThat(closest.findClosestSmallerNumber(descending), `is`(equalTo(descSmallerExpected)))
    }

    @Test
    fun `Find Closest Smaller Number using Stack`() {
        // Mixed numbers
        val mixed: IntArray = intArrayOf(33, 24, 12, 2, 5, 4, 3, 9, 24, 20, 3, 1, 54, 23, 11, 12, 44, 1, 23, 3, 1, 44, 3, 78, 2)
        val mixedExpected: IntArray = intArrayOf(-1, -1, -1, -1, 2, 2, 2, 3, 9, 9, 2, -1, 1, 1, 1, 11, 12, -1, 1, 1, -1, 1, 1, 3, 1)
        assertThat(closest.findClosestSmallerNumberImproved(mixed), `is`(equalTo(mixedExpected)))

        // Numbers in ascending order
        val ascending = (1..100_000).toList().toIntArray()
        val ascSmallerExpected = (0..99_999).toList().toIntArray()
        ascSmallerExpected[0] = -1
        assertThat(closest.findClosestSmallerNumberImproved(ascending), `is`(equalTo(ascSmallerExpected)))

        // Numbers in descending order
        val descending = (100_000 downTo 1).toList().toIntArray()
        val descSmallerExpected = List(100_000) { -1 }.toIntArray()
        assertThat(closest.findClosestSmallerNumberImproved(descending), `is`(equalTo(descSmallerExpected)))
    }
}