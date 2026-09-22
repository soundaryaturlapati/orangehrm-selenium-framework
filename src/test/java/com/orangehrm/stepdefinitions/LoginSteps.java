package com.orangehrm.stepdefinitions;

import com.orangehrm.factory.DriverFactory;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class LoginSteps {

    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("User launches ORangeHRM application")
    public void user_launches_ORangeHRMapplication() {
        loginPage.launchApplication();
    }

    @When("User enters username")
    public void user_enters_username() {
        loginPage.enterUsername(ConfigReader.getProperty("username"));

    }

    @And("User enters the password")
    public void user_enters_the_password() {
        loginPage.enterPassword(ConfigReader.getProperty("password"));

    }

    @And("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();

    }

    @Then("User verify the Dashboard page")
    public void user_verify_the_dashboard_page() {
        String Expectedtitle = loginPage.getDashboardTitle();
        String ActualTitle ="Dashboard";

        Assert.assertEquals(Expectedtitle, ActualTitle);
    }
}
