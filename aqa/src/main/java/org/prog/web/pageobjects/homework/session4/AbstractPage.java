package org.prog.web.pageobjects.homework.session4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.web.pageobjects.homework.session4.modules.BaseModule;

import java.time.Duration;
import java.util.List;

public abstract class AbstractPage {

    protected WebDriver driver;

    private String url;

    public final static String BLANK_PAGE = "about:blank";

    public AbstractPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get(BLANK_PAGE);
        driver.get(url);
    }

    public boolean isModuleOpened(By elementOnPage) {
        return driver.findElements(elementOnPage).size() > 0;
    }

    protected WebElement waitForElement(By selector) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    protected List<WebElement> waitForElements(By selector) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
    }

    protected void clickElement(By selector) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(selector))
                .click();
    }

    protected void typeIntoElement(By selector, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(selector))
                .sendKeys(text);
    }

    protected void pressEnterIntoElement(By selector) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(selector))
                .sendKeys(Keys.RETURN);
    }
}
