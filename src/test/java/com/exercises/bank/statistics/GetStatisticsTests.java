package com.exercises.bank.statistics;

import com.exercises.bank.Application;
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
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetStatisticsTests {

    @LocalServerPort
    private int port;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Test
    public void return_empty_statistics() {
        given()
                .contentType(JSON)
                .body("{\n" +
                        "  \"sum\": 0,\n" +
                        "  \"avg\": 0,\n" +
                        "  \"max\": 0,\n" +
                        "  \"min\": 0,\n" +
                        "  \"count\": 0\n" +
                        "}\n")
                .get("http://localhost:" + this.port + "/statistics")
                .then()
                .statusCode(OK.value());
    }
}
