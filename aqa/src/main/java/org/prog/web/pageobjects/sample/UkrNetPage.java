package org.prog.web.pageobjects.sample;

import org.openqa.selenium.WebDriver;
import org.prog.web.pageobjects.sample.modules.UkrNetNewsModule;
import org.prog.web.pageobjects.sample.modules.UkrNetPostModule;
import org.prog.web.pageobjects.sample.modules.UkrNetSearchModule;

public class UkrNetPage {

    private UkrNetNewsModule newsModule;
    private UkrNetPostModule postModule;
    private UkrNetSearchModule searchModule;

    public UkrNetPage(WebDriver driver) {
        this.newsModule = new UkrNetNewsModule(driver);
        this.postModule = new UkrNetPostModule(driver);
        this.searchModule = new UkrNetSearchModule(driver);
    }

    public void search(String value) {
        searchModule.search(value);
    }

}
