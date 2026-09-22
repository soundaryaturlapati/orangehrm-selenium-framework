package com.orangehrm.pages;

import com.orangehrm.utils.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PimPage {

    WebDriver driver;
    WebdriverWaits waits;

    // Create locators for PIM menu and Add Employee button
    By pimMenu = By.xpath("//a[@class='oxd-main-menu-item']//*[contains(.,'PIM')]");
    By addEmployeeButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    By firstNameField = By.xpath("//input[@name='firstName']");
    By lastNameField = By.xpath("//input[@name='lastName']");
    By employeeIdField = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']");
    By saveButton = By.xpath("//button[@type='submit']");

    public PimPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new WebdriverWaits(driver);
    }

    public void clickPIM() {
        driver.findElement(pimMenu).click();

    }
    public void clickAddEmployee() {
        waits.implictWait(5);
        driver.findElement(addEmployeeButton).click();

    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmployeeId(String employeeId) throws InterruptedException {
        driver.findElement(employeeIdField).clear(); // Clear the field before entering new value
       waits.implictWait(4);
        driver.findElement(employeeIdField).sendKeys(employeeId);
    }

    public void clickSave() {
        waits.implictWait(4);
        driver.findElement(saveButton).click();
    }

    public void verifyEmployeeAdded() {
        // Implement verification logic to check if the employee is added to the list
        // This could involve searching for the employee in the employee list and asserting their presence

        WebDriverWait waitexp = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement eleCl = waitexp.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-toast-content oxd-toast-content--success']")));
        String message = eleCl.getText();
        if (message.contains("Successfully Saved")) {
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Failed to add employee.");
        }
    }
}
