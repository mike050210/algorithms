package com.epam.algorithms

import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class CorrectHoursTest {
    private val correctHours = CorrectHours()

    @Test
    fun `Find correct hours from set of numbers`() {
        assertThat(correctHours.solution(1, 8, 3, 2), `is`(equalTo(6)))
        assertThat(correctHours.solution(2, 3, 3, 2), `is`(equalTo(3)))
        assertThat(correctHours.solution(6, 2, 4, 7), `is`(equalTo(0)))
    }
}