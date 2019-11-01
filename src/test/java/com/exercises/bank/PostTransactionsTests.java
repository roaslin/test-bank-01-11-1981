package com.exercises.bank;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static java.time.ZoneOffset.UTC;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostTransactionsTests {

    @LocalServerPort
    private int port;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Test
    public void return_http_status_201_for_a_valid_transaction() {
        String timestamp = String.valueOf(LocalDateTime.now().toEpochSecond(UTC));

        given()
                .contentType(JSON)
                .body("{\n" +
                        "  \"amount\": 12.3,\n" +
                        "  \"timestamp\": " + timestamp + "\n" +
                        "}")
                .post("http://localhost:" + this.port + "/transactions")
                .then()
                .statusCode(CREATED.value());
    }

    @Test
    public void return_http_status_204_for_an_invalid_transaction() {
        String timestamp = String.valueOf(LocalDateTime.now().minusHours(1).toEpochSecond(UTC));

        given()
                .contentType(JSON)
                .body("{\n" +
                        "  \"amount\": 12.3,\n" +
                        "  \"timestamp\": " + timestamp + "\n" +
                        "}")
                .post("http://localhost:" + this.port + "/transactions")
                .then()
                .statusCode(NO_CONTENT.value());
    }
}
