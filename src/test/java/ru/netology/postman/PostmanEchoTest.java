package ru.netology.postman;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PostmanEchoTest {

    @Test
    public void checkPostDataResponse() {
        given()
                .baseUri("https://postman-echo.com")
                .body("some data")
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("some data"))
                .body(matchesJsonSchemaInClasspath("postmanecho.schema.json"));

    }
}
