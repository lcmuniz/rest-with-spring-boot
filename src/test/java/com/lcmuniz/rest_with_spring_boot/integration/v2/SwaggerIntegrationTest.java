package com.lcmuniz.rest_with_spring_boot.integration.v2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerIntegrationTest extends AbtsractIntegrationTest {

    @Value("${server.port}")
    private int port;

    @Test
    void shouldisplaySwaggerUI() {
        String body = given().basePath("/swagger-ui/index.html").port(port)
                .when().get()
                .then().statusCode(200)
                .extract().body().asString();
        assertTrue(body.contains("Swagger UI"));
    }
}
