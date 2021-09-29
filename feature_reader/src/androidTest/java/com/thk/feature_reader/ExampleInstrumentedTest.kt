package com.thk.feature_reader

import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.thk.csvreader.presentation.NavHostActivity
import com.thk.feature_reader.presentation.list.LineListAdapter
import com.thk.feature_reader.test.EspressoIdlingResource
import com.thk.feature_reader.util.TestUtils.withRecyclerView
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get: Rule
    val activityRule: ActivityScenarioRule<NavHostActivity> =
        ActivityScenarioRule(NavHostActivity::class.java)

    @Before
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }

    @Test
    fun testIsFragmentInActivity() {
        Espresso.onView(withId(com.thk.csvreader.R.id.navHostFragment))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    // FIXME: Use view ids for matching. Used values on purpose to demonstrate resource idling.
    @Test
    fun testIsLineListRendered() {
        Espresso.onView(
            Matchers.allOf(
                withId(R.id.recyclerView),
                withRecyclerView(R.id.recyclerView).atPosition(0)
            )
        ).perform(
            actionOnItemAtPosition<LineListAdapter.ViewHolder>(0,
            ViewActions.scrollTo()
        ))
            .check(ViewAssertions.matches(ViewMatchers.hasDescendant(ViewMatchers.withText("First Name"))))
    }
}