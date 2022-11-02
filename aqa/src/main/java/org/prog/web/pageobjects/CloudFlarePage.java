package org.prog.web.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CloudFlarePage extends AbstractPage {

    private final static String URL = "https://www.cloudflare.com/";

    private final static String ACCEPT_COOKIES_BTN = "onetrust-accept-btn-handler";

    public CloudFlarePage(WebDriver webDriver) {
        super(webDriver, URL);
    }

    public void waitForCookies() {
        waitForElement(By.id(ACCEPT_COOKIES_BTN));
    }

    public void acceptCookies() {
        clickElement(By.id(ACCEPT_COOKIES_BTN));
    }
}
