package org.auctionsense;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ItemResourceTest {

    @Test
    public void testItemsEndpoint() {
        given()
          .when().get("/api/items")
          .then()
             .statusCode(200);
    }

}