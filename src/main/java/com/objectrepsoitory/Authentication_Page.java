package com.objectrepsoitory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Authentication_Page {
    @FindBy(id = "email_create")
    WebElement emailCreate_EditBox;

    @FindBy(id = "SubmitCreate")
    WebElement createAccount_Button;

    @FindBy(id = "email")
    WebElement email_EditBox;

    @FindBy(id = "passwd")
    WebElement password_EditBox;

    @FindBy(id = "SubmitLogin")
    WebElement login_Button;

    @FindBy(xpath = "//*[@id='login_form']/div/p[1]/a")
    WebElement forgotYourPassword;

    public void createAnAccount(String emailAddress) {
        emailCreate_EditBox.sendKeys(emailAddress);
        createAccount_Button.click();
    }

    public void alreadyRegisterd(String emailaddress, String password) {
        email_EditBox.sendKeys(emailaddress);
        password_EditBox.sendKeys(password);
        login_Button.click();
    }
}
