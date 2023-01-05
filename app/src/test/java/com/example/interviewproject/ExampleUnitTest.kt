package com.example.interviewproject

import android.content.res.Resources
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.eq
import org.mockito.kotlin.whenever


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun mockK() {
        val res = mockk<Resources>()
        every { res.getString(1) } returns "Test"

        assertEquals("Test", res.getString(1))
    }

    @Test
    fun mockito() {
        val res = mock(Resources::class.java)
        doReturn("Test").whenever(res).getString(eq(1))

        assertEquals("Test", res.getString(1))
    }
}