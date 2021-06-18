package com.hrs.pages;

import com.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

public class loginPage extends BasePage {

    public loginPage(WebDriver driver){
        super(driver);
    }

    By email = By.cssSelector("#loginEmail");
    By password = By.cssSelector("#password");
    By loginButton = By.cssSelector("#loginSubmitButton");
    By notifyMessage = By.cssSelector("span.ng-scope");
    By forgotPasswordLink = By.cssSelector(".qa-login--link-forgot_password");
    By usernameToReset = By.cssSelector("#resetPassword_username");
    By backButton = By.cssSelector("#resetPasswordBackButton");
    By resetPasswordButton = By.cssSelector("#resetPasswordSaveButton");

    public void openLogin(){
        loadPage("https://cc.healthrecoverysolutions.com/login");
    }

    public void inputValues(String email, String password){
        sendValues(this.email,email);
        sendValues(this.password,password);
    }

    public void submitLogin(){
        clickOnElement(loginButton);
    }

    public String getNotificationMessage(){
        return getTextElementBy(notifyMessage);
    }

    public boolean isSubmitEnabled(){
        return getElementBy(loginButton).isEnabled();
    }

    public void inputValueIn(String value, String field){
        if (field.equalsIgnoreCase("username"))
            sendValues(email,value);
        else
            sendValues(password,value);
    }

    public void clearTheField(String field){
        if (field.equalsIgnoreCase("username"))
            getElementBy(email).clear();
        else
            getElementBy(password).clear();
    }

    public void clickOnForgotPassword(){
        clickOnElement(forgotPasswordLink);
    }

    public void clickOnSubmitForgotPassword(){
        clickOnElement(resetPasswordButton);
    }

    public void inputValueInForgotForm(String value){
        sendValues(usernameToReset,value);
    }
}