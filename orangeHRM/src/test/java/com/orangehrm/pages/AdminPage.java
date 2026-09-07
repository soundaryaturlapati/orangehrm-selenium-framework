package com.orangehrm.pages;

import com.orangehrm.utils.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {
    private WebDriver driver;
    private WebdriverWaits wait;

    public AdminPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebdriverWaits(driver);
    }
    private By adminTitle= By.xpath("//a[@class='oxd-main-menu-item']//*[contains(.,'Admin')]");
    private By adminSearchUser = By.xpath("//div[@class='oxd-form-row']//input[@class='oxd-input oxd-input--active']");
    private By adminClickOnSearchButton = By.xpath("//button[@type='submit']");
    private By adminUserRoleDD = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    private By adminStatusDD = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
    private By adminAddBtn = By.xpath("//*[@class='orangehrm-paper-container']//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private By adminEmployeeNameTxt = By.xpath("//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']//input");
    private By adminUserNameTxt = By.xpath("(//div[@class='oxd-form-row']//input[@class='oxd-input oxd-input--active'])");
    private By adminPasswordTxt = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//input[@type='password']");
    private By adminCnfrmPasswordTxt = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']//input[@type='password']");
    private By adminSaveBtn = By.xpath("//div[@class='oxd-form-actions']//button[@type='submit']");
    private By adminEditBtn = By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space']//i[@class='oxd-icon bi-pencil-fill']");
    private By adminDelBtn = By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space']//i[@class='oxd-icon bi-trash']");


    public void clickOnAdmin(){
        wait.explicitWait(5, adminTitle);
        driver.findElement(adminTitle).click();
    }

    public void clickOnAdminSearchUser(String username){
        wait.explicitWait(5, adminSearchUser);
        driver.findElement(adminSearchUser).sendKeys(username);
    }
    public void clickOnAdminUserRoleDD(String role){
        wait.explicitWait(5, adminUserRoleDD);
        driver.findElement(adminUserRoleDD).click();
        wait.implictWait(2);
        driver.findElement(By.xpath("//div[@role='listbox']//span[contains(text(),'"+role+"')]")).click();
        wait.implictWait(5);


    }
    public void clickOnAdminStatusDD(String status){
        wait.explicitWait(5, adminStatusDD);
        driver.findElement(adminStatusDD).click();
        wait.implictWait(3);
        WebElement adminStatusDisabled = driver.findElement(By.xpath("//div[@role='listbox']//span[text()='"+status+"']"));
        Actions action = new Actions(driver);
        action.moveToElement(adminStatusDisabled).click().perform();
        wait.implictWait(10);


    }
    public void clickOnAdminClickOnSearchButton(){
        wait.explicitWait(10, adminClickOnSearchButton);
        driver.findElement(adminClickOnSearchButton).click();
    }

    public String getStatusMessageAfterSearch(String status){
        wait.implictWait(5);
        WebElement validationStatus = driver.findElement(By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border']//div[contains(text(),'"+status+"')]"));

        String StatusMsg =validationStatus.getText();
        return StatusMsg;
    }

    public void clickOnAddButton(){
        wait.implictWait(5);
        driver.findElement(adminAddBtn).click();
    }

    public void enterEmployeeName(){
        wait.explicitWait(5, adminEmployeeNameTxt);
        driver.findElement(adminEmployeeNameTxt).sendKeys("FName L");
        wait.implictWait(10);
        //WebElement employeNAmeDD = driver.findElement(By.xpath("//div[@class='oxd-autocomplete-option']//span[contains(text(),'FName LName')]"));
//        Actions action = new Actions(driver);
//        action.moveToElement(employeNAmeDD).click().perform();

        WebDriverWait waitexp = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement eleCl = waitexp.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-autocomplete-option']//span[contains(text(),'FName ')]")));

        eleCl.click();
       // driver.findElement(By.xpath("//div[@class='oxd-autocomplete-option']//span[contains(text(),'Sam B Brown')]")).click();
        wait.implictWait(5);
    }

    public void enterUserName(){
        driver.findElement(adminUserNameTxt).sendKeys("Adminst");
    }
    public void enterPassword(){
        driver.findElement(adminPasswordTxt).sendKeys("Asdf@1234qrt");
    }

    public void enterConfirmPassword(){
        driver.findElement(adminCnfrmPasswordTxt).sendKeys("Asdf@1234qrt");
    }

    public void clickOnSaveButton(){
        wait.implictWait(5);
        driver.findElement(adminSaveBtn).click();
    }

    public void clicOnEditButton(){
        wait.implictWait(5);
        driver.findElement(adminEditBtn).click();
    }

    public void clickOnDelButton(){
        wait.implictWait(5);
        driver.findElement(adminDelBtn).click();
    }


}
