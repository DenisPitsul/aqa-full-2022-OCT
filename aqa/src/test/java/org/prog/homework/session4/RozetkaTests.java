package org.prog.homework.session4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.prog.web.BaseTest;
import org.prog.web.pageobjects.homework.session4.RozetkaBasketPopupPage;
import org.prog.web.pageobjects.homework.session4.RozetkaPage;
import org.prog.web.pageobjects.homework.session4.RozetkaSelectCityPopupPage;

import java.util.stream.Stream;

public class RozetkaTests extends BaseTest {

    private static RozetkaPage rozetkaPage;

    @BeforeAll
    public static void setUpPageObject() {
        rozetkaPage = new RozetkaPage(driver);
    }

    @BeforeEach
    public void preTest() {
        rozetkaPage.loadPage();
    }

    @ParameterizedTest
    @MethodSource("rozetkaSearchProvider")
    public void allSearchResultsElementsContainsKeywordFromSearchTest(String searchKeyword) {
        rozetkaPage = new RozetkaPage(driver);
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
        rozetkaPage = new RozetkaPage(driver);
        String beforeCity = rozetkaPage.getCurrentCity();

        RozetkaSelectCityPopupPage rozetkaSelectCityPopupPage = rozetkaPage.openSelectCityPopupPage();
        String anotherCity = rozetkaSelectCityPopupPage.selectAnotherCity(beforeCity);
        rozetkaPage = rozetkaSelectCityPopupPage.apply();

        String selectedAnotherCity = rozetkaPage.getCurrentCity();

        Assertions.assertNotEquals(beforeCity, selectedAnotherCity, "Selected city was not changed!");
        Assertions.assertEquals(anotherCity, selectedAnotherCity, "Selected city was not changed to " + anotherCity);
    }

    @Test
    public void goodsTitleInTheBasketTheSameFromHeaderAndSideMenuTest() {
        rozetkaPage = new RozetkaPage(driver);
        rozetkaPage.performSearch("Стиральная машина");
        rozetkaPage.addFirstSearchResultsGoodsToBasket();

        RozetkaBasketPopupPage rozetkaBasketPopupPage = rozetkaPage.openBasketPopupPageFromSideHeader();
        String goodsNameFromHeader = rozetkaBasketPopupPage.getGoodsTitle();
        rozetkaPage = rozetkaBasketPopupPage.closeRozetkaBasketPopupPage();

        rozetkaBasketPopupPage = rozetkaPage.openBasketPopupPageFromSideMenu();
        String goodsNameFromSideMenu = rozetkaBasketPopupPage.getGoodsTitle();

        Assertions.assertEquals(goodsNameFromHeader, goodsNameFromSideMenu);
    }
}
