package ly.generalassemb.espresso;

import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.Espresso.onView;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by jamesrondina on 7/21/16.
 */

@RunWith(AndroidJUnit4.class)

public class BalanceActivityTest {
    @Rule
    public ActivityTestRule<BalanceActivity> mActivityRule = new ActivityTestRule<BalanceActivity>(BalanceActivity.class);

    @Test
    public void testBalanceTest() throws Exception {
        //test code
        onView(withId(R.id.balanceTextView))
                .check(matches(isDisplayed()));
        
    }

    @Test
    public void testBalanceWithdraw() throws Exception {
        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText("Once Upon a Time in Shaolin bid"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText))
                .perform(typeText("2000000"), closeSoftKeyboard());
        onView(withId(R.id.withdrawButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText("-$2,000,000.00")));

    }

    @Test
    public void testBalanceDeposit() throws Exception {
        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText("Sale 1 x Daraprim Pill"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText))
                .perform(typeText("750"));
        onView(withId(R.id.depositButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText("$750.00")));

    }

    @Test
    public void testBalanceMultiple() throws Exception {

        buyBlackLotus();
        buyBlackLotus();
        buyBlackLotus();
        buyBlackLotus();
        buyBlackLotus();

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText("Sale 10,000 x Shares @ $100 each"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText))
                .perform(typeText("1000000"));
        onView(withId(R.id.depositButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText("$850,000.00")));

    }

    public void buyBlackLotus() {
        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText("Buy 1 x Black Lotus"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText))
                .perform(typeText("30000"));
        onView(withId(R.id.withdrawButton))
                .perform(click());
        //onView(withId(R.id.balanceTextView))
        //        .check(matches(withText("$30,000.00")));
    }
}
