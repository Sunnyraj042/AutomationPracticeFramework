package com.objectrepsoitory;

import com.genericlibrary.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccount_Page {
    Utility select = new Utility();

    @FindBy(id = "id_gender1")
    WebElement mr_radioButton;

    @FindBy(id = "id_gender")
    WebElement mrs_radioButton;

    @FindBy(xpath = "//*[@id='customer_firstname']")
    WebElement customerFirstName_editBox;

    @FindBy(id = "customer_lastname")
    WebElement customerLastName_editBox;

    @FindBy(id = "passwd")
    WebElement password_editBox;

    @FindBy(id = "days")
    WebElement days_dropDown;

    @FindBy(id = "months")
    WebElement months_dropDown;

    @FindBy(id = "years")
    WebElement years__dropDown;

    @FindBy(id = "newsletter")
    WebElement SignupForNewsletter_checkBox;

    @FindBy(id = "optin")
    WebElement receiveSpecialOffers_checkBox;

    @FindBy(id = "firstname")
    WebElement firstName_editBox;

    @FindBy(id = "lastname")
    WebElement lastName_editBox;

    @FindBy(id = "company")
    WebElement company_editBox;

    @FindBy(id = "address1")
    WebElement address1_editBox;

    @FindBy(id = "address2")
    WebElement address2_editBox;

    @FindBy(id = "city")
    WebElement city_editBox;

    @FindBy(id = "id_state")
    WebElement state_dropDown;

    @FindBy(id = "postcode")
    WebElement postcode_edit_Box;

    @FindBy(id = "id_country")
    WebElement country_dropDown;

    @FindBy(id = "other")
    WebElement additionalInformation_editBox;

    @FindBy(id = "phone")
    WebElement homePhone_editBox;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhone_editBox;

    @FindBy(id = "alias")
    WebElement assignAnAddress_editBox;

    @FindBy(xpath = "//*[@id='submitAccount']/span")
    WebElement register_button;

    public void personalInformation(String firstName, String lastName, String password) {
        customerFirstName_editBox.sendKeys(firstName);
        customerLastName_editBox.sendKeys(lastName);
        password_editBox.sendKeys(password);
    }

    public void address(String address_1, String city, String state, String postalCode, String country, String phone, String assignedAddress) {
        address1_editBox.sendKeys(address_1);
        city_editBox.sendKeys(city);
        select.selectbyVisibleText(state_dropDown, state);
        postcode_edit_Box.sendKeys(postalCode);
        select.selectbyVisibleText(country_dropDown, country);
        mobilePhone_editBox.sendKeys(phone);
        assignAnAddress_editBox.sendKeys(assignedAddress);
    }

    public void dateOfBirth(String DOB)
    {
        String[] dat = DOB.split("-");
        select.selectbyVisibleText(days_dropDown,dat[0]);
        select.selectbyVisibleText(months_dropDown,dat[1]);
        select.selectbyVisibleText(years__dropDown,dat[2]);
    }

    public void cliconRegister() {
        register_button.click();
    }
}
