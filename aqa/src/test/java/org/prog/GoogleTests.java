package org.prog;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.prog.web.pageobjects.GooglePage;
import org.prog.web.pageobjects.UkrNetPage;

import java.util.stream.Stream;

public class GoogleTests extends BaseTest {

    private final static String EXPECTED_COVID_TEXT = "PCR-test visar om du har covid-19 - Folkhälsomyndigheten";
    private final static String EXPECTED_MUSK_TEXT = "Elon Musk - Wikipedia";
    private final static String HENDRIX = "Jimi Hendrix - Wikipedia";
    private static GooglePage googlePage;

    @BeforeAll
    public static void setUpPageObject() {
        googlePage = new GooglePage(driver);
    }

    @BeforeEach
    public void preTest() {
        loadGooglePage();
        googlePage.acceptCookies();
    }

    @AfterEach
    public void postTest() {
        System.out.println("post any test");
    }

    @ParameterizedTest
    @MethodSource("googleSearchProvider")
    public void googleSearchCovidTest(String searchValue, String searchResultValue, String headerValue) {
        googlePage.setSearchValue(searchValue);
        googlePage.performSearch(false);
        Assertions.assertTrue(googlePage.getSearchResults().contains(searchResultValue),
                "search results did not contain expected text");
        if (headerValue != null) {
            Assertions.assertEquals(googlePage.getHeaderText(), headerValue);
        }
    }

    private static Stream<Arguments> googleSearchProvider() {
        return Stream.of(
                Arguments.of("Jimi Hendrix", HENDRIX, "Jimi Hendrix"),
                Arguments.of("test", EXPECTED_COVID_TEXT, null),
                Arguments.of("Musk", EXPECTED_MUSK_TEXT, "Elon Musk")
        );
    }

//    @Test
//    public void googleSearchMuskTest() {
//        googlePage.setSearchValue("Musk");
//        googlePage.performSearch(false);
//        Assertions.assertTrue(googlePage.getSearchResults().contains(EXPECTED_MUSK_TEXT),
//                "search results did not contain expected text");
//
//    }

    // null user name && null pwd
    // null pwd
    // null user name
    // not null name && pwd

//    @Test
    public void mailTest(String userName, String userPassword) {
        UkrNetPage ukrNetPage = new UkrNetPage();
        ukrNetPage.setUserName(userName);
        ukrNetPage.setPwd(userPassword);

        if (userName == null) {
            Assertions.assertTrue(ukrNetPage.getUserNameFieldError());
        } else {
            Assertions.assertFalse(ukrNetPage.getUserNameFieldError());
        }

        if (userPassword == null) {
            Assertions.assertTrue(ukrNetPage.getPwdFieldError());
        } else {
            Assertions.assertFalse(ukrNetPage.getPwdFieldError());
        }
    }

    private void loadGooglePage() {
        driver.get("about::blank");
        driver.get("https://google.com/");
        driver.manage().window().maximize();
    }
}
