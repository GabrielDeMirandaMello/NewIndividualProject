package com.travel.stories.travels;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HistoryApiTestIntegration {

    @Test
    public void whenCallingTheUserByIdApi_ReturnSuccess() {
        when().request("GET", "/api/history/2").then().statusCode(200);
    }
}
