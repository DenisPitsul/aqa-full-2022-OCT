package org.prog.web.pageobjects.hotline.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.prog.web.pageobjects.commons.AbstractModule;

public class HeaderModule extends AbstractModule {
    private final By MENU_BTN = By.className("button-menu-main");
    private final By CITY = By.className("location__city");
    private final By LANG_SELECTOR = By.className("lang-button");
    private final By LANG_ITEM = By.className("lang-item");

    public HeaderModule(WebDriver driver) {
        super(driver);
    }

    public void openMenu() {
        driver.findElement(MENU_BTN).click();
    }

    public String getCurrentCity() {
        return driver.findElement(CITY).getText();
    }

    public void openLangSelection() {
        driver.findElement(LANG_SELECTOR).click();
    }

    public void selectLang(String value) {
        driver.findElements(LANG_ITEM).stream()
                .filter(webElement -> webElement.getText().contains(value))
                .findAny()
                .ifPresent(WebElement::click);
    }

}
