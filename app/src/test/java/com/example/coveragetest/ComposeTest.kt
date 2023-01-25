package com.example.coveragetest

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.core.app.ActivityScenario
import com.example.coveragetest.ui.theme.CoverageTestTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricRunner::class)
class ComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out // Redirect Logcat to console
    }

    @Test
    fun checkGreeting() {
        composeTestRule.setContent {
            CoverageTestTheme {
                Greeting(name = "Test")
            }
        }
        composeTestRule.onNodeWithText("Hello Test!").assertIsDisplayed()
    }
    
    @Test
    fun checkNotDisplay() {
        composeTestRule.setContent {
            CoverageTestTheme {
                Greeting(name = "KKKK")
            }
        }
        composeTestRule.onNodeWithText("Hello Test!").assertIsNotDisplayed()
    }

    @Test
    fun `when I test with activity, then it works`() {

        ActivityScenario.launch(MainActivity::class.java)
            .use { scenario ->
                scenario.onActivity {
                    composeTestRule.onNodeWithText("Hello Android!").assertIsDisplayed()
                }
            }
    }
}
