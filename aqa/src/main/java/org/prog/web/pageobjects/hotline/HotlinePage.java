package org.prog.web.pageobjects.hotline;

import org.openqa.selenium.WebDriver;
import org.prog.web.pageobjects.commons.AbstractPage;
import org.prog.web.pageobjects.hotline.modules.AdvertismentModule;
import org.prog.web.pageobjects.hotline.modules.CategoriesModule;
import org.prog.web.pageobjects.hotline.modules.HeaderModule;

public class HotlinePage extends AbstractPage {
    private static final String URL = "https://hotline.ua/";

    private final AdvertismentModule advertismentModule;
    private final HeaderModule headerModule;
    private final CategoriesModule categoriesModule;

    public HotlinePage(WebDriver driver) {
        super(driver, URL);
        advertismentModule = new AdvertismentModule(driver);
        headerModule = new HeaderModule(driver);
        categoriesModule = new CategoriesModule(driver);
    }

    public AdvertismentModule onAds() {
        return advertismentModule;
    }

    public HeaderModule onHeader() {
        return headerModule;
    }

    public CategoriesModule onCats() {
        return categoriesModule;
    }
}
