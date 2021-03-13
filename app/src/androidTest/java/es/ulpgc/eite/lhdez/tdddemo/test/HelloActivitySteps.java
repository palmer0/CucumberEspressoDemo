package es.ulpgc.eite.lhdez.tdddemo.test;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;

import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;

import org.junit.Rule;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.ulpgc.eite.lhdez.tdddemo.MainActivity;
import es.ulpgc.eite.lhdez.tdddemo.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SuppressWarnings("ALL")
public class HelloActivitySteps {

  @Rule
  public ActivityTestRule<MainActivity> activityTestRule =
      new ActivityTestRule(MainActivity.class, true, false);

  private Activity activity;

  @Before("@hello-feature")
  public void setUp() {
    try {

      UiDevice device = UiDevice.getInstance(getInstrumentation());
      device.setOrientationNatural();

    } catch (RemoteException e) {
    }

    activityTestRule.launchActivity(new Intent());
    activity = activityTestRule.getActivity();
  }

  @After("@hello-feature")
  public void tearDown() {
    try {

      UiDevice device = UiDevice.getInstance(getInstrumentation());
      device.setOrientationNatural();

    } catch (RemoteException e) {
    }

    activityTestRule.finishActivity();
  }

  @Given("^System starts hello screen$")
  public void systemStartsHelloScreen() {
    assertNotNull(activity);
  }

  @Then("^I should see hello screen$")
  public void iShouldSeeHelloScreen() {
    assertEquals(
        activity.getLocalClassName(),
        activity.getString(R.string.activity_name)
    );
  }

  @Given("^I am on hello screen$")
  public void iAmOnHelloScreen() {
    assertEquals(
        activity.getTitle(),
        activity.getString(R.string.app_name)
    );

  }

  @Then("^I should not see hello message$")
  public void iShouldNotSeeHelloMessage() {
    onView(withId(R.id.message)).check(matches(not(isDisplayed())));
  }

  @When("^I tap hello button$")
  public void iTapHelloButton() {
    onView(withId(R.id.button)).perform(click());
  }

  @Then("^I should see hello message$")
  public void iShouldSeeHelloMessage() {
    onView(withId(R.id.message)).check(matches(isDisplayed()));
    onView(withId(R.id.message))
        .check(matches(withText(activity.getString(R.string.message))));
  }
}
