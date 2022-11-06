package org.prog;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;

public class NGBaseTest {

    protected WebDriver driver;

//    @BeforeTest
//    public void setUp() {
//        initDriver();
//    }
//
//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }

    private void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
