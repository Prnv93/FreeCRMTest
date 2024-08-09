package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        initialization();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 2)
    public void verifyHomePageTitleTest(){
        String title = homePage.verifyHomePageTitle();
        Assert.assertEquals(title, "CRMPRO", "Home page title is not matched");
    }

    @Test(priority = 3)
    public void verifyUserNameLabelTest()  {
        testUtil.switchToFrame();
        boolean flag = homePage.verifyUserNameLabel();
        Assert.assertTrue(flag);
    }

    @Test(priority = 1)
    public void verifyContactsLinkTest(){
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
