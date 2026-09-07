package com.orangehrm.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WebdriverWaits {

    private WebDriver driver;

    public WebdriverWaits(WebDriver driver) {
        this.driver = driver;
    }
    public void implictWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

    }

    public void explicitWait(int seconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void fluentWait(int seconds, int pollingSeconds , By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofSeconds(pollingSeconds))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
}
