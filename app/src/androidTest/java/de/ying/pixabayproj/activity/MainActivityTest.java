package de.ying.pixabayproj.activity;

import android.support.test.espresso.Espresso;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.ying.pixabayproj.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * author : yingli
 * time   : 8/20/17
 * desc   : Tests for the MainActivity screen, the de.ying.pixabayproj.main screen which contains a grid of all notes.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    /**
     * Prepare your test fixture for this test. In this case we register an IdlingResources with
     * Espresso. IdlingResource resource is a great way to tell Espresso when your app is in an
     * idle state. This helps Espresso to synchronize your test actions, which makes tests significantly
     * more reliable.
     */
    @Before
    public void registerIdlingResource() {
        Espresso.registerIdlingResources(
                mMainActivityActivityTestRule.getActivity().getCountingIdlingResource());
    }

    @Test
    public void editQueryTextAndClickButton() throws Exception{
        onView(withId(R.id.query_edit)).perform(typeText("carrot"), closeSoftKeyboard());
        onView(withId(R.id.go_btn)).perform(click());
    }

    /**
     * Unregister your Idling Resource so it can be garbage collected and does not leak any memory.
     */
    @After
    public void unregisterIdlingResource() {
        Espresso.unregisterIdlingResources(
                mMainActivityActivityTestRule.getActivity().getCountingIdlingResource());
    }
}
