package com.tests.podiun.pages;

import com.tests.podiun.atom.ChromeBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    @FindBy(css = "div #main-heading")
    WebElement firstTitle;

    @FindBy(css = "div.menu-wrapper")
    WebElement menuWrapper;

    @FindBy(xpath = "//li[@class='menu-item']/span[text()='Products']")
    WebElement firstMenuItem;

    @FindBy(xpath = "//div[@class='product-text']/span[text()='Reviews']")
    WebElement subMenuReviews;

    public HomePage(ChromeBrowser driver) {
        driver.get("https://www.podium.com/");
        PageFactory.initElements(driver, this);
    }

    public boolean verifyTitle() {
        return firstTitle.isDisplayed();
    }

    public boolean verifyMenu(ChromeBrowser driver) {

        Actions action = new Actions(driver);
        action.moveToElement(firstMenuItem).perform();
        List<WebElement> subMenuItems = driver
                .findElements(By.cssSelector("ul.submenu > li.product-items"));

        return subMenuItems.stream().allMatch(webElement -> webElement.isDisplayed());
    }
}
