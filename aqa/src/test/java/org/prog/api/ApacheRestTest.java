package org.prog.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.junit.jupiter.api.Test;
import org.prog.dto.RandomUserResults;

import java.io.IOException;

public class ApacheRestTest {

    @Test
    public void apacheRestTest() throws IOException, ParseException {
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(request());
        String personsJson = EntityUtils.toString(response.getEntity());
        System.out.println(personsJson);
        RandomUserResults randomUserResults =
                getMapper().readValue(personsJson, RandomUserResults.class);
    }

    private ClassicHttpRequest request() {
        return new HttpGet("https://randomuser.me/api/?inc=gender,name,nat&noinfo&results=20");
    }

    private ObjectMapper getMapper() {
        return new ObjectMapper();
    }
}
