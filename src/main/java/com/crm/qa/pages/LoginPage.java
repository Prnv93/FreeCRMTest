package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends TestBase {

    //Page factory or Object repository
    @FindBy(name="username")
    WebElement username;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath="//input[@type='submit']")
    WebElement loginBtn;
    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement signUpBtn;
    @FindBy(xpath = "//img[contains(@alt, 'Free CRM Software for customer relationship management, sales and support')] ")
    WebElement crmLogo;

    //Initializing page objects
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateCRMImage(){
        return crmLogo.isDisplayed();
    }

    public HomePage login(String un, String pwd) throws InterruptedException {
        Thread.sleep(5000);
        username.sendKeys(prop.getProperty("username"));
        password.sendKeys(prop.getProperty("password"));
        loginBtn.click();

        return new HomePage();
    }
}
