package es.ulpgc.eite.lhdez.tdddemo;


import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

  @Rule
  public ActivityTestRule<MainActivity> activityTestRule =
      new ActivityTestRule<>(MainActivity.class);

  @Test
  public void mainActivityTest() {

    onView(allOf(
        withParent(allOf(withId(R.id.action_bar),
        withParent(withId(R.id.action_bar_container)))),
        isDisplayed()
    )).check(matches(withText("Cucumber Espresso Demo")));

    onView(allOf(withId(R.id.button), isDisplayed()))
        .check(matches(withText("HELLO")));

    onView(withId(R.id.button)).perform(click());

    onView(allOf(withId(R.id.message), isDisplayed()))
        .check(matches(withText("Hello World!")));
  }


}
