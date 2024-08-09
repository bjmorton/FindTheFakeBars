package com.brian.step_defs;

import com.brian.pages.BalanceScalePage;
import com.brian.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

public class Scale_StepDefinitions {

    private BalanceScalePage balanceScalePage;



    public Scale_StepDefinitions() {
        this.balanceScalePage = new BalanceScalePage();
    }

    @Given("I am on the gold bar challenge page")
    public void i_am_on_the_gold_bar_challenge_page() {
        Driver.getDriver().get("http://sdetchallenge.fetch.com/");
    }

    @When("I weigh the gold bars to find the fake one")
    public void i_weigh_the_gold_bars_to_find_the_fake_one() throws InterruptedException {
        Thread.sleep(3000);
        int fakeBar = findFakeBar(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
        balanceScalePage.clickOnBar(fakeBar);
    }

    private int findFakeBar(int[] bars) throws InterruptedException {

        System.out.println("Current bars to evaluate: " + Arrays.toString(bars));

        if (bars.length == 3) {
            balanceScalePage.clickResetButton();
            balanceScalePage.enterNumbersInLeftBowl(bars[0]);
            balanceScalePage.enterNumbersInRightBowl(bars[1]);
            balanceScalePage.clickWeighButton();
            String result2 = balanceScalePage.getSecondWeighingResult();
            if (result2.contains("<")) {
                System.out.println("Identified fake bar: " + bars[0]);
                return bars[0];

            } else if (result2.contains(">")) {
                System.out.println("Identified fake bar: " + bars[1]);
                return bars[1];
            } else {
                System.out.println("Identified fake bar: " + bars[2]);
                return bars[2];
            }

        }

        int third = bars.length / 3;
        int[] group1 = Arrays.copyOfRange(bars, 0, third);
        int[] group2 = Arrays.copyOfRange(bars, third, 2 * third);
        int[] group3 = Arrays.copyOfRange(bars, 2 * third, bars.length);

        balanceScalePage.clickResetButton();
        balanceScalePage.enterNumbersInLeftBowl(group1);
        balanceScalePage.enterNumbersInRightBowl(group2);
        balanceScalePage.clickWeighButton();
      //  Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".game-info ol li")));

        String result = balanceScalePage.getWeighingResult();
        System.out.println("Weighing result for group1 vs group2: " + result);

        if (result.contains("<")) {
            System.out.println("Group 1 is lighter, focusing on group 1.");
            return findFakeBar(group1);
        } else if (result.contains(">")) {
            System.out.println("Group 2 is lighter, focusing on group 2.");
            return findFakeBar(group2);
        } else {
            System.out.println("Groups are equal, focusing on group 3.");
            return findFakeBar(group3);
        }
    }

    @Then("I should see the alert with the message {string}")
    public void i_should_see_the_alert_with_the_message(String expectedMessage) throws InterruptedException {
        Thread.sleep(3000);

        String actualMessage = balanceScalePage.getAlertMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Then("I should see the list of weighings")
    public void i_should_see_the_list_of_weighings() throws InterruptedException {
        Thread.sleep(3000);

        List<String> weighings = balanceScalePage.getWeighings();
        assertTrue("Weighings list should not be empty", !weighings.isEmpty());
        for (String weighing : weighings) {
            System.out.println(weighing);
        }

        Driver.closeDriver();
    }
}