package org.prog;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class W3SchooldTest extends BaseTest {
    @Test
    public void iFrameTest() {
        loadIframePage();

        WebElement iFrame = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iFrame);

        System.out.println(driver.findElement(By.xpath("//h1")).getText());

        driver.switchTo().defaultContent();
        System.out.println(iFrame.isDisplayed());
        SearchContext searchContext = iFrame.getShadowRoot();
        searchContext.findElements(By.xpath("//div"));
    }

    private static void loadIframePage() {
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_elements");
        driver.findElement(By.id("accept-choices")).click();
    }
}
