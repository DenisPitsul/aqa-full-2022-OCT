package org.prog.web.pageobjects.homework.session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class RozetkaSelectCityPopupPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By cityNames = By.xpath("//ul[contains(@class, 'header-location__popular')]//a");
    private By applyButton = By.xpath("//div[@class='modal__content']//button");
    private String cityByName = "//ul[contains(@class, 'header-location__popular')]//a[contains(text(), '%s')]";

    public RozetkaSelectCityPopupPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(applyButton));
    }

    public String selectAnotherCity(String currentCity) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<String> cities = driver.findElements(cityNames).stream()
                .map(webElement -> webElement.getText().trim())
                .collect(Collectors.toList());
        String anotherCity = "";
        for (String city: cities) {
            if (!currentCity.equals(city)) {
                anotherCity = city;
                break;
            }
        }
        driver.findElement(By.xpath(String.format(cityByName, anotherCity))).click();
        return anotherCity;
    }

    public RozetkaPage apply() {
        driver.findElement(applyButton).click();
        return new RozetkaPage(driver);
    }
}
