package com.tests.podiun;

import com.tests.podiun.atom.ChromeBrowser;
import com.tests.podiun.pages.LoginPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.IOException;
import java.net.MalformedURLException;

public class LoginTest {
    private ChromeBrowser driver;
    private LoginPage loginPage;

    @BeforeClass
    public void beforeAll(){
        Reporter.log("Testing Login page",true);
    }

    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver = new ChromeBrowser();
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() throws IOException {
        Utils.takeScreenshot("lastTestSS", driver);
        driver.quit();
    }

    @Test(description = "Mandatory Email feature")
    public void verifyMandatoryEmail() {
        Reporter.log("Verifying Mandatory Email feature",true);
        Assert.assertTrue(loginPage.emailMandatory(driver));
    }

    @Test
    public void verifyPassowrdField() {
        Reporter.log("Verifying Password Field",true);
        loginPage.insertCorrectEmail(driver);
        Assert.assertTrue(loginPage.passwordInput(driver));
    }
}
