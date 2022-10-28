package org.prog;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RozetkaTests extends BaseTest {

    private final static String EXPECTED_TEXT = "PCR-test visar om du har covid-19 - Folkhälsomyndigheten";

    @BeforeEach
    public void preTest() {
        loadRozetkaPage();
    }

    @AfterEach
    public void postTest() {
        System.out.println("post any test");
    }

    @Test
    public void otherTest() {
        System.out.println("i am another test!");
    }


    private void loadRozetkaPage() {
        driver.get("about::blank");
        driver.get("https://google.com/");
        driver.manage().window().maximize();
    }

}
