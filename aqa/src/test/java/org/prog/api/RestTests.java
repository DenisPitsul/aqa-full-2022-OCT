package org.prog.api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.prog.dto.RandomUserResults;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class RestTests {

    @Test
    public void restTest() {
        Response resp = RestAssured.given()
                .get("https://randomuser.me/api/?inc=gender,name,nat&noinfo&results=20");

        resp.body().prettyPrint();

        List<String> genders =
                JsonPath.from(resp.body().asString())
                        .getList("results")
                        .stream()
                        .filter(jsonElement -> ((LinkedHashMap<?, ?>) jsonElement).get("gender").equals("female"))
                        .map(json -> ((LinkedHashMap<?, ?>) json).get("name"))
                        .map(name -> String.valueOf(((LinkedHashMap<?, ?>) name).get("first")))
                        .collect(Collectors.toList());
        System.out.println(genders.size());
    }

    @Test
    public void conversionTest() {
        Response resp = RestAssured.given()
                .get("https://randomuser.me/api/?inc=gender,name,nat&noinfo&results=20");
        RandomUserResults dto = resp.as(RandomUserResults.class);
        dto.getResults().stream().forEach(r -> System.out.println(r.getName().getFirst()));
    }
}
