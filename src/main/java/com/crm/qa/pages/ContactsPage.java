package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//td[contains(text(),'Contacts')]")
    @CacheLookup
    WebElement contactsTitle;
    @FindBy(name = "title")
    WebElement title;
    @FindBy(id = "first_name")
    WebElement firstName;
    @FindBy(id = "surname")
    WebElement lastName;
    @FindBy(name = "client_lookup")
    WebElement company;
    @FindBy(xpath = "//input[@type='submit' and @value='Save']")
    WebElement saveBtn;
    @FindBy(xpath = "//legend[@class='fieldset' and contains(text(),'Contact Information')]")
    WebElement contactInformation;

    public ContactsPage(){
        PageFactory.initElements(driver, this);
    }

    public boolean verifyContactsTitle(){
        return contactsTitle.isDisplayed();
    }

    public void clickOnTheContact(String name){
        WebElement checkBox = driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"));
        if(checkBox.isEnabled()){
            checkBox.click();
        }else System.out.println("No element found");

    }

    public void createNewContact(String contactTitle, String contactFirstName, String contactLastName, String contactCompany){
        Select select = new Select(title);
        select.selectByVisibleText(contactTitle);
        firstName.sendKeys(contactFirstName);
        lastName.sendKeys(contactLastName);
        company.sendKeys(contactCompany);
        saveBtn.click();
    }

    public boolean checkContactInformation(){
        return contactInformation.isDisplayed();
    }

}
