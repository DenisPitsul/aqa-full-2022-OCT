package org.prog.web.pageobjects.homework.session4;

import org.openqa.selenium.WebDriver;
import org.prog.web.pageobjects.homework.session4.modules.RozetkaHeaderModule;
import org.prog.web.pageobjects.homework.session4.modules.RozetkaSearchResultsModule;
import org.prog.web.pageobjects.homework.session4.modules.RozetkaSideMenuModule;

public class RozetkaPage extends AbstractPage {

    private final static String URL = "https://rozetka.com.ua/";

    private RozetkaHeaderModule rozetkaHeaderModule;
    private RozetkaSearchResultsModule rozetkaSearchResultsModule;
    private RozetkaSideMenuModule rozetkaSideMenuModule;

    public RozetkaPage(WebDriver driver) {
        super(driver, URL);
        rozetkaHeaderModule = new RozetkaHeaderModule(driver);
        rozetkaSearchResultsModule = new RozetkaSearchResultsModule(driver);
        rozetkaSideMenuModule = new RozetkaSideMenuModule(driver);
    }

    public RozetkaPage performSearch(String text) {
        rozetkaHeaderModule.performSearch(text);
        return this;
    }

    public boolean isSearchResultsContainsKeyword(String keyword) {
        return rozetkaSearchResultsModule.isSearchResultsContainsKeyword(keyword);
    }

    public RozetkaPage openRozetkaSideMenu() {
        rozetkaHeaderModule.clickSideMenuButton();
        return this;
    }

    public String getCurrentCity() {
        if (!rozetkaSideMenuModule.isModuleOpened())
            openRozetkaSideMenu();
        return rozetkaSideMenuModule.getCurrentCity();
    }

    public RozetkaSelectCityPopupPage openSelectCityPopupPage() {
        if (!rozetkaSideMenuModule.isModuleOpened())
            openRozetkaSideMenu();
        rozetkaSideMenuModule.clickCurrentCityButton();
        return new RozetkaSelectCityPopupPage(driver);
    }

    public String getFirstSearchResultsGoodsName() {
        return rozetkaSearchResultsModule.getFirstSearchResultsGoodsName();
    }

    public void addFirstSearchResultsGoodsToBasket() {
        rozetkaSearchResultsModule.addFirstSearchResultsGoodsToBasket();
    }

    public RozetkaBasketPopupPage openBasketPopupPageFromSideHeader() {
        rozetkaHeaderModule.clickBasketButton();
        return new RozetkaBasketPopupPage(driver);
    }

    public RozetkaBasketPopupPage openBasketPopupPageFromSideMenu() {
        if (!rozetkaSideMenuModule.isModuleOpened())
            openRozetkaSideMenu();
        rozetkaSideMenuModule.clickBasketButton();
        return new RozetkaBasketPopupPage(driver);
    }
}
