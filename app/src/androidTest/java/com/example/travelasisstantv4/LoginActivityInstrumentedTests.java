package com.example.travelasisstantv4;

import android.content.Context;
import android.os.Build;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.travelasisstantv4.login.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityInstrumentedTests {

    private static final String stringToBeTyped = "abc";

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule(LoginActivity.class);

    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.travelasisstantv4", appContext.getPackageName());
    }

    @Test
    public void useTargetLollipop() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals(Build.VERSION_CODES.LOLLIPOP, appContext.getApplicationInfo().minSdkVersion);
    }

    @Test
    public void buttonsEnabled() {
        onView(withId(R.id.et_email)).perform(typeText(stringToBeTyped), closeSoftKeyboard());
        onView(withId(R.id.et_password)).perform(typeText(stringToBeTyped), closeSoftKeyboard());

        onView(withId(R.id.btn_register)).check(matches(isEnabled()));
        onView(withId(R.id.btn_sign_in)).check(matches(isEnabled()));
    }

    @Test
    public void buttonsDisabled() {
        onView(withId(R.id.et_email))
                .perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(typeText(""), closeSoftKeyboard());

        onView(withId(R.id.btn_register)).check(matches(not(isEnabled())));
        onView(withId(R.id.btn_sign_in)).check(matches(not(isEnabled())));
    }
}