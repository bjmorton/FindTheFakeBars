package com.brian.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.brian.utilities.Driver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class BalanceScalePage {

    private WebDriver driver = Driver.getDriver();

    private By weighButton = By.id("weigh");
    private By resetButton = By.xpath("/html/body/div/div/div[1]/div[4]/button[1]");
    private By weighingList = By.cssSelector(".game-info ol li");
    private By weighingList2 = By.xpath("//div[5]/ol/li[2]");



    public void enterNumbersInLeftBowl(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            String cellId = "left_" + i;
            driver.findElement(By.id(cellId)).sendKeys(String.valueOf(numbers[i]));
        }
    }
    public void enterNumbersInLeftBowl(int number) {

            driver.findElement(By.id("left_0")).sendKeys(String.valueOf(number));

    }

    public void enterNumbersInRightBowl(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            String cellId = "right_" + i;
            driver.findElement(By.id(cellId)).sendKeys(String.valueOf(numbers[i]));
        }
    }
    public void enterNumbersInRightBowl(int number) {
            driver.findElement(By.id("right_0")).sendKeys(String.valueOf(number));

    }

    public void clickWeighButton() {
        driver.findElement(weighButton).click();
    }

    public void clickResetButton() {
        driver.findElement(resetButton).click();
    }

    public String getWeighingResult() {
        return driver.findElement(weighingList).getText();
    }
    public String getSecondWeighingResult() {
        return driver.findElement(weighingList2).getText();
    }

    public void clickOnBar(int barNumber) {
        driver.findElement(By.id("coin_" + barNumber)).click();
    }

    public String getAlertMessage() {
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertText;
    }

    public List<String> getWeighings() {
        return driver.findElements(weighingList).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
