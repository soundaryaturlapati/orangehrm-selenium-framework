package com.orangehrm.pages;

import com.orangehrm.utils.ConfigReader;
import com.orangehrm.utils.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private  WebdriverWaits wait;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebdriverWaits(driver);
    }

    private By usernameField = By.xpath("//input[@placeholder ='Username']");
    private By passwordField = By.xpath("//input[@placeholder ='Password']");
    private By loginButton = By.xpath("//button[contains(. ,'Login')]");
    private By dashboardTitle = By.xpath("//h6[contains(. ,'Dashboard')]");


    public void launchApplication(){
        driver.get(ConfigReader.getProperty("url"));
    }
    public void enterUsername(String username) {
       //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
       // wait.implictWait(2);
        wait.explicitWait(50,usernameField);
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        //Instead of contains(text()), we can also write .
        driver.findElement(loginButton).click();
    }

    public String getDashboardTitle() {
        wait.explicitWait(50,dashboardTitle);
        String title= driver.findElement(dashboardTitle).getText();
        return title;
    }
}
