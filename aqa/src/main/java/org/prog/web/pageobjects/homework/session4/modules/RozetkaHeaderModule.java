package org.prog.web.pageobjects.homework.session4.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.prog.web.pageobjects.homework.session4.AbstractPage;

public class RozetkaHeaderModule extends AbstractPage {

    private By sideMenuButton = By.xpath("//rz-mobile-user-menu/button");

    private By searchInput = By.xpath("//input[@name='search']");

    private By basketButton = By.xpath("//rz-cart/button");

    public RozetkaHeaderModule(WebDriver driver) {
        super(driver);
    }

    public void performSearch(String text) {
        typeIntoElement(searchInput, text);
        pressEnterIntoElement(searchInput);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickSideMenuButton() {
        clickElement(sideMenuButton);
    }

    public void clickBasketButton() {
        clickElement(basketButton);
    }
}
