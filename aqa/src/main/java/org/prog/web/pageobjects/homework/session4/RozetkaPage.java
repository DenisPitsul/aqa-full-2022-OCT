package org.prog.web.pageobjects.homework.session4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RozetkaPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By searchInput = By.xpath("//input[@name='search']");

    private By searchResultElements = By.xpath("//span[@class='goods-tile__title']");

    private By sideMenuButton = By.xpath("//rz-mobile-user-menu/button");

    public RozetkaPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
    }

    public void performSearch(String text) {
        driver.findElement(searchInput).sendKeys(text);
        driver.findElement(searchInput).sendKeys(Keys.RETURN);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isSearchResultsContainsKeyword(String keyword) {
        return driver.findElements(searchResultElements)
                .stream()
                .map(WebElement::getText)
                .allMatch(searchResultText -> searchResultText.contains(keyword));
    }

    public RozetkaSideMenuPage openRozetkaSideMenu() {
        driver.findElement(sideMenuButton).click();
        return new RozetkaSideMenuPage(driver);
    }
}
