package org.prog.web.pageobjects.homework.session4.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.prog.web.pageobjects.homework.session4.AbstractPage;

public class RozetkaSearchResultsModule extends AbstractPage {

    private By searchResultElements = By.xpath("//span[@class='goods-tile__title']");

    private By searchResultElementsBuyButtons = By.xpath("//app-buy-button/button");

    public RozetkaSearchResultsModule(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchResultsContainsKeyword(String keyword) {
        return waitForElements(searchResultElements)
                .stream()
                .map(WebElement::getText)
                .allMatch(searchResultText -> searchResultText.contains(keyword));
    }

    public String getFirstSearchResultsGoodsName() {
        return waitForElements(searchResultElements).get(0).getText();
    }

    public void addFirstSearchResultsGoodsToBasket() {
        waitForElements(searchResultElementsBuyButtons).get(0).click();
    }


}
