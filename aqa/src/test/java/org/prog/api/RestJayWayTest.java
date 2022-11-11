package org.prog.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.prog.dto.NameDto;
import org.prog.dto.PersonDto;

import java.util.List;

import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;

public class RestJayWayTest {

    @Test
    public void restTest() {
        Response resp = RestAssured.given()
                .get("https://randomuser.me/api/?inc=gender,name,nat&noinfo&results=20");

        resp.body().prettyPrint();

        JsonPath maleNamePath = JsonPath.compile("$.results[?].name.first",
                filter(where("gender").eq("male")));
        JsonPath femaleNamePath = JsonPath.compile("$.results[?].name.first",
                filter(where("gender").eq("female")));

        List<String> maleNames = JsonPath.using(NEW_PATH_CONFIGURATION).parse(resp.body().asString()).read(maleNamePath);
        List<String> femaleNames = JsonPath.using(NEW_PATH_CONFIGURATION).parse(resp.body().asString()).read(femaleNamePath);

        System.out.println(maleNames.size());
        System.out.println(femaleNames.size());
    }

    public static final Configuration NEW_PATH_CONFIGURATION = Configuration.builder()
            .options(Option.DEFAULT_PATH_LEAF_TO_NULL, Option.SUPPRESS_EXCEPTIONS)
            .jsonProvider(new JacksonJsonProvider(new ObjectMapper()))
            .mappingProvider(new JacksonMappingProvider(new ObjectMapper()))
            .build();
}
