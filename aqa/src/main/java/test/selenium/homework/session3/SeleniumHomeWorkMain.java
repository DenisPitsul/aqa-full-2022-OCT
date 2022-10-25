package test.selenium.homework.session3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumHomeWorkMain {

    private static final String EMAIL = "denis.pitsul@ukr.net";
    private static final String PASSWORD = "test261298";

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        initDriver();
        switchToLoginIframe();

        WebElement emailInput = driver.findElement(By.id("id-input-login"));
        emailInput.sendKeys(EMAIL);
        WebElement passwordInput = driver.findElement(By.id("id-input-password"));
        passwordInput.sendKeys(PASSWORD);
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='form__submit']"));
        loginButton.click();

        WebElement emailElem = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("id-user-email")));

        if (emailElem.getText().equals(EMAIL))
            System.out.println("Test passed!");
        else
            System.out.println("Test failed!");

        quitDriver();
    }

    private static void initDriver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ukr.net/");
        Thread.sleep(5000);
    }

    private static void quitDriver() {
        driver.quit();
    }

    private static void switchToLoginIframe() {
        WebElement loginIframe = driver.findElement(By.xpath("//*[@id='login-frame-wraper']/iframe"));
        driver.switchTo().frame(loginIframe);
    }
}
