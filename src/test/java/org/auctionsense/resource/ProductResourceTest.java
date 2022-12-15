package org.auctionsense.resource;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

import org.jboss.resteasy.reactive.RestResponse.StatusCode;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(ProductResource.class)
public class ProductResourceTest {

  @Test
  public void When_Get_Products_By_Category_Result_Is_Equal_To_Assertion() {
    given()
        .when().get("/category/Games")
        .then()
        .statusCode(StatusCode.OK)
        .body("size()", is(1),
            "[0].name", is("testItemOne"),
            "[0].description", is("This is the first item!"));
  }

  @Test
  public void When_Get_Product_By_Name_Result_Is_Equal_To_Assertion() {
    given()
    .when().get("/name/testItemTwo")
    .then()
    .statusCode(StatusCode.OK)
    .body("size()", is(5),
        "name", is("testItemTwo"),
        "description", is("This is the second item!"));
  }
}