package org.prog.web.pageobjects.sample.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UkrNetSearchModule extends BaseModule {
    public UkrNetSearchModule(WebDriver driver) {
        super(driver);
    }

    public void search(String value) {
        driver.findElement(By.name("search")).sendKeys(value);
    }
}
