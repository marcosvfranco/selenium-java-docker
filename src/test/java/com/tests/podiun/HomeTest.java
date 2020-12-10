package com.tests.podiun;

import com.tests.podiun.atom.ChromeBrowser;
import com.tests.podiun.pages.HomePage;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;


public class HomeTest {

    private ChromeBrowser driver;
    private HomePage homePage;
    private static final String homeTitle = "Messaging Tools for Local Business | Customer Review Software, Webchat, Payments | Podium";
    public static final String reviewTitle = "Podium Reviews - Customer Review Software & Online Reputation Management";

    @BeforeClass
    public void beforeAll() {
        Reporter.log("Verifying Home Page",true);
    }

    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver = new ChromeBrowser();
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() throws IOException {
        Utils.takeScreenshot("lastTestSS", driver);
        driver.quit();
    }

    @Test
    public void verifyHomePage () {
        Assert.assertEquals(driver.getTitle(), homeTitle);
        Assert.assertTrue(homePage.verifyMenuDisplayed());
    }

    @Test
    public void verifySubMenuDisplayed() {
        Reporter.log("Verifying SubMenu displayed",true);
        Assert.assertTrue(homePage.verifySubMenuDisplayed(driver));
    }

    @Test
    public void verifySubMenuReviewLink () throws IOException {
        Reporter.log("Verifying SubMenu ReviewsLink",true);
        homePage.clickSubMenuLink("Reviews", driver);
        driver.findElementByXPath("//h1[text()=\"Contact-free business starts with \"]")
                .isDisplayed();
        Assert.assertEquals(driver.getTitle(), reviewTitle);

        // Remove the comment to get the screenshot baseline
        // Utils.takeScreenshot("reviewsPage", driver);
        Assert.assertTrue(Utils.compareScreenshot("reviewsPage", driver) > (float) 90);
    }
}
