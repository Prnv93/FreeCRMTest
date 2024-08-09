package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {


    @FindBy(xpath = "//td[contains(text(),'User: Gagan Khanna')]")
    WebElement userNameLabel;
    @FindBy(xpath =  "//a[@title='Contacts']")
    WebElement contactsLink;
    @FindBy(xpath = " //a[@title='Deals']")
    WebElement dealsLink;
    @FindBy(xpath = " //a[@title='Tasks']")
    WebElement tasksLink;
    @FindBy(xpath = "//a[@title='New Contact']")
    WebElement newContactLink;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle(){
        return driver.getTitle();
    }

    public boolean verifyUserNameLabel() {
        return userNameLabel.isDisplayed();
    }

    public ContactsPage clickOnContactsLink(){
        contactsLink.click();

        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink(){
        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickOnTasksLink(){
        tasksLink.click();
        return new TasksPage();
    }

    public ContactsPage clickOnNewContactLink(){
        Actions actions = new Actions(driver);
        actions.moveToElement(contactsLink).build().perform();
        newContactLink.click();
        return new ContactsPage();
    }
}
