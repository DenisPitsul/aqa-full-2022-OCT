package org.prog.web.pageobjects.hotline.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.prog.web.pageobjects.commons.AbstractModule;

import java.util.List;
import java.util.stream.Collectors;

public class AdvertismentModule extends AbstractModule {
    private final By AD_BUTTONS = By.xpath("//nav/button");

    public AdvertismentModule(WebDriver driver) {
        super(driver);
    }

    public List<String> getAdTopics() {
        return driver.findElements(AD_BUTTONS).stream()
                .map(webElement -> webElement.getAttribute("data-eventlabel"))
                .collect(Collectors.toList());
    }
}
