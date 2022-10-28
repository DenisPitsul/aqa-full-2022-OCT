package org.prog.web.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class GooglePage {

    private final static String COOKIES_WRAPPER = "CXQnmb";
    private final static String GOOGLE_SEARCH_BAR_NAME = "q";
    private final static String GOOGLE_SEARCH_RESULTS = "//div[@id='rso']/div//a/h3";

    private WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookies() {
        List<WebElement> cookiesWrapper = driver.findElements(By.id(COOKIES_WRAPPER));
        if (!cookiesWrapper.isEmpty() && cookiesWrapper.get(0).isDisplayed()) {
            List<WebElement> buttons =
                    driver.findElements(By.tagName("button"));
            buttons.get(3).click();
        }
    }

    public void setSearchValue(String searchValue) {
        driver.findElement(By.name(GOOGLE_SEARCH_BAR_NAME)).clear();
        driver.findElement(By.name(GOOGLE_SEARCH_BAR_NAME)).sendKeys(searchValue);
    }

    public void performSearch(boolean usingMouse) {
        if (usingMouse) {

        } else {
            driver.findElement(By.name(GOOGLE_SEARCH_BAR_NAME)).sendKeys(Keys.RETURN);
        }
    }

    public List<String> getSearchResults() {
        return driver.findElements(By.xpath(GOOGLE_SEARCH_RESULTS))
                .stream()
                .map(webElement -> webElement.getText())
                .collect(Collectors.toList());
    }

    public String getHeaderText() {
        return driver.findElement(By.xpath("//span[@role='heading']")).getText();
    }

    public void openGoogleApps() {

    }

    public void selectGoogleApp() {

    }
}
