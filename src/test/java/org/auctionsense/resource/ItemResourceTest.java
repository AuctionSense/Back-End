package org.auctionsense.resource;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

import org.jboss.resteasy.reactive.RestResponse.StatusCode;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;

@QuarkusTest
@TestHTTPEndpoint(ItemResource.class)
public class ItemResourceTest {
    @Test
    public void Test_Item_Endpoint() {
        given()
          .when().get()
          .then()
             .statusCode(StatusCode.OK);
    }

    @Test
    public void When_Get_Items_Result_Is_Not_Zero_Or_Null() {
        given()
          .when().get()
          .then()
             .statusCode(StatusCode.OK)
             .body("size()", not(0));
    }

}