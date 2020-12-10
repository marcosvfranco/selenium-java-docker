package com.tests.podiun.pages;

import com.tests.podiun.atom.ChromeBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HomePage {

    private Actions action;

    @FindBy(css = "div.menu-wrapper")
    WebElement menuWrapper;

    @FindBy(xpath = "//li[@class='menu-item']/span[text()='Products']")
    WebElement firstMenuItem;

    public HomePage(ChromeBrowser driver) {
        driver.get("https://www.podium.com/");
        PageFactory.initElements(driver, this);
    }

    public boolean verifyMenuDisplayed() {
        return menuWrapper.isDisplayed();
    }

    public boolean verifySubMenuDisplayed(ChromeBrowser driver) {
        action = new Actions(driver);
        action.moveToElement(firstMenuItem).perform();
        List<WebElement> subMenuItems = driver
                .findElements(By.cssSelector("ul.submenu > li.product-items"));
        return subMenuItems.stream().allMatch(webElement -> webElement.isDisplayed());
    }

    public void clickSubMenuLink(String name, ChromeBrowser driver) {
        String path = "//div[@class='product-text']/span[text()='"+name+"']";
        action = new Actions(driver);
        action.moveToElement(firstMenuItem).perform();
        WebElement subItem = driver.findElementByXPath(path);
        driver.safeClick(subItem);
    }
}
