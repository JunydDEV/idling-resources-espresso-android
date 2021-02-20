package com.uiautomation_android

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.endsWith
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.IdlingRegistry
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.IdlingResource
import org.junit.After

@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    val mainScreen = MainScreen()

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var mIdlingResource: IdlingResource

    @Before
    fun setUp(){
        activityRule.scenario.onActivity {
            mIdlingResource = it.getIdlingResource()
            IdlingRegistry.getInstance().register(mIdlingResource)
        }
    }

    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(mIdlingResource)
    }

    @Test
    fun executeJob_happily(){
        mainScreen{
            goToListingScreen()
            goToDetails()
            assertDetails()
        }
    }


}