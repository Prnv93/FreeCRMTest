package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
    }

    @Test(priority = 2)
    public void cmrLogoImageTest(){
        boolean flag = loginPage.validateCRMImage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest() throws InterruptedException {
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
