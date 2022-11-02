package org.prog.web.pageobjects.homework.session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RozetkaBasketPopupPage extends AbstractPage {

    private By goodsTitle = By.xpath("//div[@class='cart-product__body']//a[@data-testid='title']");

    private By closeButton = By.xpath("//button[@class='modal__close']");

    public RozetkaBasketPopupPage(WebDriver driver) {
        super(driver);
    }

    public String getGoodsTitle() {
        return waitForElement(goodsTitle).getAttribute("title");
    }

    public RozetkaPage closeRozetkaBasketPopupPage() {
        clickElement(closeButton);
        return new RozetkaPage(driver);
    }
}
