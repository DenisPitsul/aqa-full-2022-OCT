package org.prog.web.pageobjects.homework.session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class RozetkaSelectCityPopupPage extends AbstractPage {

    private By cityNames = By.xpath("//ul[contains(@class, 'header-location__popular')]//a");
    private By applyButton = By.xpath("//div[@class='modal__content']//button");
    private String cityByName = "//ul[contains(@class, 'header-location__popular')]//a[contains(text(), '%s')]";

    public RozetkaSelectCityPopupPage(WebDriver driver) {
        super(driver);
    }

    public String selectAnotherCity(String currentCity) {
        List<String> cities = waitForElements(cityNames).stream()
                .map(webElement -> webElement.getText().trim())
                .collect(Collectors.toList());
        String anotherCity = "";
        for (String city: cities) {
            if (!currentCity.equals(city)) {
                anotherCity = city;
                break;
            }
        }
        clickElement(By.xpath(String.format(cityByName, anotherCity)));
        return anotherCity;
    }

    public RozetkaPage apply() {
        clickElement(applyButton);
        return new RozetkaPage(driver);
    }
}
