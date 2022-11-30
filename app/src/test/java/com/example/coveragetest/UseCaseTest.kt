package com.example.coveragetest

import androidx.compose.ui.graphics.Color
import com.example.coveragetest.ui.theme.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UseCaseTest {
    @Test
    fun checkAdd() {
        assertEquals(AddUseCase().add(1, 2), 3)
    }
}