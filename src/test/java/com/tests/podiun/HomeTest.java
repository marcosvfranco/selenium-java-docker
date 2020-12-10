package com.tests.podiun;

import com.tests.podiun.atom.ChromeBrowser;
import com.tests.podiun.pages.HomePage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class HomeTest {

    private ChromeBrowser driver;
    private HomePage homePage;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver = new ChromeBrowser();
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void homePage () {
        Assert.assertTrue(homePage.verifyTitle());
    }

    @Test
    public void menu() {
        Assert.assertTrue(homePage.verifyMenu(driver));
    }
}
