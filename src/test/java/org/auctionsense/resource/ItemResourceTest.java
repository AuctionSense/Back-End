package org.auctionsense.resource;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

import org.jboss.resteasy.reactive.RestResponse.StatusCode;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(ItemResource.class)
public class ItemResourceTest {

    @Test
    public void testItemsEndpoint() {
        int expectedResponseSize = 3;

        given()
          .when().get()
          .then()
             .statusCode(StatusCode.OK).body("size()", is(expectedResponseSize));
    }

}