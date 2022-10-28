package org.prog.web.pageobjects.homework.session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RozetkaSideMenuPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By currentCity = By.xpath("//span[@class='city-toggle__text']");
    private By currentCityButton = By.xpath("//span[@class='city-toggle__text']/parent::button");

    public RozetkaSideMenuPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(currentCityButton));
    }

    public String getCurrentCity() {
        return driver.findElement(currentCity).getText().trim();
    }

    public RozetkaSelectCityPopupPage clickCurrentCityButton() {
        driver.findElement(currentCityButton).click();
        return new RozetkaSelectCityPopupPage(driver);
    }
}
