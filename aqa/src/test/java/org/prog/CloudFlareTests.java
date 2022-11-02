package org.prog;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.prog.web.pageobjects.CloudFlarePage;

public class CloudFlareTests extends BaseTest {

    private static CloudFlarePage cloudFlarePage;

    @BeforeAll
    public static void setUpPageObject() {
        cloudFlarePage = new CloudFlarePage(driver);
    }

    @BeforeEach
    public void preTest() {
        cloudFlarePage.loadPage();
    }

    @AfterEach
    public void postTest() {

    }

    @Test
    public void acceptCookies() {
        cloudFlarePage.waitForCookies();
        cloudFlarePage.acceptCookies();
        System.out.println("done");
    }

}
