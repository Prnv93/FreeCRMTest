package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil = new TestUtil();
    ContactsPage contactsPage;
    String sheetName = "contacts";

    public ContactsPageTest(){
        super();
    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        initialization();
        testUtil =new TestUtil();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password") );
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    }

    @Test(priority=1)
    public void verifyConatctsTitleTest(){
        boolean flag =contactsPage.verifyContactsTitle();
        Assert.assertTrue(flag);
    }

    @Test(priority = 2)
    public void clickOnContactCheckboxTest(){
        contactsPage.clickOnTheContact("Asima Sahoo");
    }

    @Test
    public void validateClickOnNewContact(){
        contactsPage = homePage.clickOnNewContactLink();
        boolean flag = contactsPage.checkContactInformation();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3, dataProvider = "getCRMTestData")
    public void validateCreateNewContactTest(String title, String firstName, String lastName, String company){
        contactsPage = homePage.clickOnNewContactLink();
        boolean flag = contactsPage.checkContactInformation();
        if(flag){
            contactsPage.createNewContact(title,firstName,lastName,company);
        }
    }

    @DataProvider
    public Object[][] getCRMTestData(){
        return testUtil.getTestData(sheetName);
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
