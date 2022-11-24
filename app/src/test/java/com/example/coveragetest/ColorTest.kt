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
class ColorTest {
    @Test
    fun checkColor() {
        assertEquals(Purple80, Color(0xFFD0BCFF))
        assertEquals(PurpleGrey80, Color(0xFFCCC2DC))
        assertEquals(Pink80, Color(0xFFEFB8C8))
        assertEquals(Purple40, Color(0xFF6650a4))
        assertEquals(PurpleGrey40, Color(0xFF625b71))
        assertEquals(Pink40, Color(0xFF7D5260))
    }
}