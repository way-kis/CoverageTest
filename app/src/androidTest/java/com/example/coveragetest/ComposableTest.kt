package com.example.coveragetest

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.lifecycleScope
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.coveragetest.ui.theme.CoverageTestTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ComposableTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun greetingTest() {
        // Start the app

        composeTestRule.setContent {
            CoverageTestTheme {
                Greeting("Android")
            }
        }
        composeTestRule.activity.lifecycleScope.launchWhenResumed {
            withContext(Dispatchers.Main){
                composeTestRule.onNodeWithText("Hello Android!").assertIsDisplayed()
            }
        }
    }

    @After
    fun close(){
        composeTestRule.activity.finish()
    }
}