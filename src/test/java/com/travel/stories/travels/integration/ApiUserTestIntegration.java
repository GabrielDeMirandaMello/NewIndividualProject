package com.travel.stories.travels.integration;



import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class ApiUserTestIntegration {

    @Test
    @Disabled
    public void whenCallingTheUserByIdApi_ReturnSuccess() {
        when().request("GET", "api/users/3").then().statusCode(200);
    }

    @Test
    @Disabled
    void whenCallingUserApiWithId_ReturnSucess() {
        get("/api/users/3").then().statusCode(200).assertThat()
                .body("name", equalTo("Gabriel Mello"));
    }
}
