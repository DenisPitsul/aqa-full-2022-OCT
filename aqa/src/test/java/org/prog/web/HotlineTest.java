package org.prog.web;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.prog.web.pageobjects.hotline.HotlinePage;

public class HotlineTest extends BaseTest {

    private static HotlinePage hotlinePage;

    @BeforeAll
    public static void setup() {
        hotlinePage = new HotlinePage(driver);
    }

    @BeforeEach
    public void reloadPage() {
        hotlinePage.loadPage();
    }

    @Test
    public void validateLanguage() {
        hotlinePage.onHeader().openLangSelection();
        hotlinePage.onHeader().selectLang("RU");
//        Assert.assertEquals("City name mismatch!", "Киев",
//                hotlinePage.onHeader().getCurrentCity());
    }

    @Test
    public void validateAdTexts() {
        hotlinePage.onAds().getAdTopics().forEach(System.out::println);
    }
}
