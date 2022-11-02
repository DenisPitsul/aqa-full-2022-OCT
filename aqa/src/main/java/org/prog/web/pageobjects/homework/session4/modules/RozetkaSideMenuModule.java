package org.prog.web.pageobjects.homework.session4.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.prog.web.pageobjects.homework.session4.AbstractPage;

public class RozetkaSideMenuModule extends AbstractPage {

    private By currentCity = org.openqa.selenium.By.xpath("//span[@class='city-toggle__text']");

    private By currentCityButton = org.openqa.selenium.By.xpath("//span[@class='city-toggle__text']/parent::button");

    private By basketButton = By.xpath("(//button[contains(@class, 'side-menu__button')])[2]");

    public RozetkaSideMenuModule(WebDriver driver) {
        super(driver);
    }

    public boolean isModuleOpened() {
        return isModuleOpened(currentCity);
    }

    public String getCurrentCity() {
        return waitForElement(currentCity).getText().trim();
    }

    public void clickCurrentCityButton() {
        clickElement(currentCityButton);
    }

    public void clickBasketButton() {
        clickElement(basketButton);
    }
}
