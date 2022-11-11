package org.prog.web.pageobjects.hotline.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.prog.web.pageobjects.commons.AbstractModule;

public class CategoriesModule extends AbstractModule {

    private By HOTLINE_FINANCE = By.xpath("//a[@data-eventlabel='HOTLINE.FINANCE']");
    private By AUTO_MOTO = By.xpath("//a[@data-eventlabel='Авто і Мото']");
    private By TECH = By.xpath("//a[@data-eventlabel='Побутова техніка']");

    public CategoriesModule(WebDriver driver) {
        super(driver);
    }

    public WebElement getHotlineFinance() {
        return driver.findElement(HOTLINE_FINANCE);
    }

    public WebElement getAutoMoto() {
        return driver.findElement(AUTO_MOTO);
    }

    public WebElement getTech() {
        return driver.findElement(TECH);
    }
}
