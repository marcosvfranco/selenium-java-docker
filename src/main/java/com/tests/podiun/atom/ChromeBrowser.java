package com.tests.podiun.atom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ChromeBrowser extends RemoteWebDriver {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;
    public static ChromeOptions chromeOptions = new ChromeOptions();

    public ChromeBrowser() throws MalformedURLException {
        super(new URL("http://localhost:4444/wd/hub"), chromeOptions);

        this.manage().deleteAllCookies();
        this.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        this.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        this.manage().window().maximize();
    }

    public void safeClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(this, 3);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void safeType(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(this, 3);
        wait.until(ExpectedConditions.elementToBeClickable(element))
                .sendKeys(text);
    }

}
