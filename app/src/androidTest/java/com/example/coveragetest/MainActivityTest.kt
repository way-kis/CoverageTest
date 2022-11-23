package com.example.coveragetest

import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenResumed
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.*
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()


    @Test
    fun test() {
        val scenario = activityScenarioRule.scenario
        scenario.onActivity {
            it.lifecycleScope.launch {
                it.lifecycle.whenResumed {
                    onView(withText("Hello Android!")).check(matches(isDisplayed()))
                }
            }
        }
    }

    @After
    fun close(){
        activityScenarioRule.scenario.close()
    }
}