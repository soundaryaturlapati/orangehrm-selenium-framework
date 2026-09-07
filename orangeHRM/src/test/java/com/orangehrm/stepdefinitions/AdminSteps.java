package com.orangehrm.stepdefinitions;

import com.orangehrm.factory.DriverFactory;
import com.orangehrm.pages.AdminPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AdminSteps {

 AdminPage adminPage = new AdminPage(DriverFactory.getDriver());

   @When("User navigates to Admin module")
    public void user_navigates_to_Admin_module() {
       adminPage.clickOnAdmin();

   }

   @Then("Search with Admin {string}")
    public void search_with_Admin(String username) {
       adminPage.clickOnAdminSearchUser(username);

   }


   @Then("Click on Search button")
    public void click_on_Search_button() {
       adminPage.clickOnAdminClickOnSearchButton();

   }

//   @And("Validate the fields")
//    public void validate_the_fields() {
//      String expected=  adminPage.getStatusMessageAfterSearch();
//      String actual = "Enabled";
//      Assert.assertEquals(expected, actual);
//   }

   @Then("Search with user {string}")
    public void search_with_user(String status) {
       adminPage.clickOnAdminStatusDD(status);
   }

    @And("Validate the fields with {string}")
    public void validate_the_fields_with(String status) {
        String expected=  adminPage.getStatusMessageAfterSearch(status);
        Assert.assertEquals(expected, status);
    }

    @Then("Search with user role {string}")
    public void search_with_user_role(String role) {
        adminPage.clickOnAdminUserRoleDD(role);
    }

    @When("User click on Add button")
    public void user_click_on_Add_button() {
       adminPage.clickOnAddButton();

    }

    @Then("User inputs Employee name")
    public void user_inputs_employee_name() {
        adminPage.enterEmployeeName();
    }
    @Then("User selects {string}")
    public void user_selects(String status) {

    }
    @Then("User enter username")
    public void user_enter_username() {
        adminPage.enterUserName();
    }
    @Then("User provide input to the password field")
    public void user_provide_input_to_the_password_field() {
        adminPage.enterPassword();
    }
    @Then("User enter the Confirm password")
    public void user_enter_the_Confirm_password() {
        adminPage.enterConfirmPassword();
    }
    @And("Click on Save button")
    public void click_on_Save_button() {
        adminPage.clickOnSaveButton();
    }
    @Then("User Clicks on edit")
    public void user_clicks_on_edit() {
       adminPage.clicOnEditButton();
    }
    @Then("click on Delete button")
    public void click_on_delete_button() {
       adminPage.clickOnAddButton();
    }

}


