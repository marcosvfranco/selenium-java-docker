package com.tests.podiun.pages;

import com.tests.podiun.atom.ChromeBrowser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "emailOrPhoneInput")
    WebElement emailInput;

    @FindBy(id = "passwordInput")
    WebElement passwordInput;

    @FindBy(id = "signInButton")
    WebElement signInButton;

    @FindBy(id = "forgotPasswordText")
    WebElement forgotPasswordLink;

    @FindBy(css = "input#emailOrPhoneInput + div")
    WebElement errorMessage;

    @FindBy(css = "div[class=\"sc-eNQAEJ gwJZgr\"]")
    WebElement showPasswordButton;

    public LoginPage(ChromeBrowser driver) {
        driver.get("https://app.podium.com/");
        PageFactory.initElements(driver, this);
    }

    public boolean emailMandatory(ChromeBrowser driver){
        driver.safeType(emailInput, "wrongEmail");
        driver.safeClick(signInButton);
        return errorMessage.getText().equals("Invalid email address");
    }

    public void insertCorrectEmail(ChromeBrowser driver) {
        driver.safeType(emailInput, "sample@bla.com");
        driver.safeClick(signInButton);
    }

    public boolean passwordInput(ChromeBrowser driver) {
        driver.safeType(passwordInput, "psw");
        if(!passwordInput.getAttribute("type").equals("password")) return false;
        driver.safeClick(showPasswordButton);
        return passwordInput.getAttribute("type").equals("text");
    }
}
