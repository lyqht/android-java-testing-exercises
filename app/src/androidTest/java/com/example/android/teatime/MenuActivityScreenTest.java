package com.example.android.teatime;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

/**
 * This test demos a user clicking on a GridView item in MenuActivity which opens up the
 * corresponding OrderActivity.
 *
 * This test does not utilize Idling Resources yet. If idling is set in the MenuActivity,
 * then this test will fail. See the IdlingResourcesTest for an identical test that
 * takes into account Idling Resources.
 */


@RunWith(AndroidJUnit4.class)
public class MenuActivityScreenTest {

    @Rule public ActivityScenarioRule<MenuActivity> activityScenarioRule = new ActivityScenarioRule<>(MenuActivity.class);

    @Test
    public void clickGridViewItem_OpensOrderActivity() {
        // method 1: good because you don't know what teas you can retrieve from APi
         onData(anything()).inAdapterView(withId(R.id.tea_grid_view)).atPosition(1).perform(click());

        // method 2: if you know exactly what should be the last item retrieved
//        onData(allOf(is(instanceOf(Tea.class)),
//                hasEntry(equalTo(MenuActivity.teas), is("Chamomile Tea")))) //last item is loaded
//                .atPosition(1).perform(click());

        String TEA_NAME = "Green Tea";
        onView(withId(R.id.tea_name_text_view)).check(matches(withText(TEA_NAME)));


    }

}