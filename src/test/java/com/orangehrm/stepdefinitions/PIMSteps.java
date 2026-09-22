package com.orangehrm.stepdefinitions;

import com.orangehrm.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.orangehrm.pages.PimPage;

public class PIMSteps
{
    PimPage pimPage = new PimPage(DriverFactory.getDriver());

    // Create cucumber step definitions for Add Employee scenario

    @Then("User navigates to the PIM module")
    public void user_navigates_to_the_pim_module() {
        // Code to navigate to the PIM module
        pimPage.clickPIM();
    }


    @When("User clicks on Add Employee")
    public void user_clicks_on_add_employee() {
        // Code to click on Add Employee button
        pimPage.clickAddEmployee();
    }

    @Then("User fills in the employee details")
    public void user_fills_in_the_employee_details() {
        // Code to fill in employee details
        pimPage.enterFirstName("Adminst1");
        pimPage.enterLastName("st2");
        try {
            pimPage.enterEmployeeId("12345");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("User clicks on Save")
    public void user_clicks_on_save() {
        // Code to click on Save button
        pimPage.clickSave();

    }

    @And("User should see the new employee added to the list")
    public void user_should_see_the_new_employee_added_to_the_list() {
        // Code to verify the new employee is added to the list
    }

}
