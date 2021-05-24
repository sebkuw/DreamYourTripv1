package com.example.travelasisstantv4;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.travelasisstantv4.maps.MapsActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MapsActivityInstrumentedTests {
    @Rule
    public ActivityScenarioRule<MapsActivity> activityRule =
            new ActivityScenarioRule(MapsActivity.class);

    @Test
    public void imgBtnSavePoint() {
        onView(withId(R.id.img_btn_save_point)).perform(click());

        onView(withId(R.id.add_point)).check(matches(isDisplayed()));
    }

    @Test
    public void imgBtnAdd() {
        onView(withId(R.id.img_btn_add_to_trip)).perform(click());

        onView(withId(R.id.add_trip_stop)).check(matches(isDisplayed()));
    }
}