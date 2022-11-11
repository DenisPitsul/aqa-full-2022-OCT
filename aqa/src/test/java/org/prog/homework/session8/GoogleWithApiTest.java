package org.prog.homework.session8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.prog.dto.RandomUserResults;
import org.prog.web.BaseTest;
import org.prog.web.pageobjects.GooglePage;

import static io.restassured.RestAssured.given;

public class GoogleWithApiTest extends BaseTest {

    @Test
    public void getRandomUserMeAndSearchInGoogleTest() {
        RandomUserResults randomUserResults = given()
                .when()
                .get("https://randomuser.me/api/?inc=gender,name,nat&noinfo")
                .then().log().all()
                .statusCode(200)
                .extract().as(RandomUserResults.class);

        GooglePage page = new GooglePage(driver);
        page.loadPage();
        String firstName = randomUserResults.getResults().get(0).getName().getFirst();
        String lastName = randomUserResults.getResults().get(0).getName().getLast();
        page.setSearchValue(firstName + " " + lastName);
        page.performSearch(false);

        String firstSearchResult = page.getSearchResults().get(0);
        Assertions.assertTrue(firstSearchResult.contains(firstName), "First search result doesn't contains first name");
        Assertions.assertTrue(firstSearchResult.contains(lastName), "First search result doesn't contains last name");
    }
}
