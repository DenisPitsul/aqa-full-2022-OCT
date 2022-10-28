package org.prog.homework.session4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.prog.BaseTest;
import org.prog.web.pageobjects.homework.session4.RozetkaPage;
import org.prog.web.pageobjects.homework.session4.RozetkaSelectCityPopupPage;
import org.prog.web.pageobjects.homework.session4.RozetkaSideMenuPage;

import java.util.stream.Stream;

public class RozetkaTests extends BaseTest {


    @BeforeEach
    public void preTest() {
        loadRozetkaPage();
    }

    @ParameterizedTest
    @MethodSource("rozetkaSearchProvider")
    public void allSearchResultsElementsContainsKeywordFromSearchTest(String searchKeyword) {
        RozetkaPage rozetkaPage = new RozetkaPage(driver);
        rozetkaPage.performSearch(searchKeyword);
        Assertions.assertTrue(rozetkaPage.isSearchResultsContainsKeyword(searchKeyword),
                "Not all search results contain expected searchKeyword " + searchKeyword);
    }

    private static Stream<Arguments> rozetkaSearchProvider() {
        return Stream.of(
                Arguments.of("iPhone"),
                Arguments.of("Samsung")
        );
    }

    @Test
    public void selectAnotherCityTest() {
        RozetkaPage rozetkaPage = new RozetkaPage(driver);
        RozetkaSideMenuPage rozetkaSideMenuPage = rozetkaPage.openRozetkaSideMenu();
        String beforeCity = rozetkaSideMenuPage.getCurrentCity();

        RozetkaSelectCityPopupPage rozetkaSelectCityPopupPage = rozetkaSideMenuPage.clickCurrentCityButton();
        String anotherCity = rozetkaSelectCityPopupPage.selectAnotherCity(beforeCity);
        rozetkaPage = rozetkaSelectCityPopupPage.apply();

        rozetkaSideMenuPage = rozetkaPage.openRozetkaSideMenu();
        String selectedAnotherCity = rozetkaSideMenuPage.getCurrentCity();

        Assertions.assertNotEquals(beforeCity, selectedAnotherCity, "Selected city was not changed!");
        Assertions.assertEquals(anotherCity, selectedAnotherCity, "Selected city was not changed to " + anotherCity);
    }

    private void loadRozetkaPage() {
        driver.get("about::blank");
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();
    }
}
