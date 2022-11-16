package org.auctionsense.resource;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.jboss.resteasy.reactive.RestResponse.StatusCode;

@QuarkusTest
@TestHTTPEndpoint(BalanceResource.class)
public class BalanceResourceTest {
    
    @Test
    @TestSecurity(user = "alice@gmail.com", roles = "user")
    @Order(1)
    public void When_Get_Balance_Succeeds_With_Correct_User()
    {
        given()
        .when().get("/alice@gmail.com")
        .then()
        .statusCode(StatusCode.OK)
        .body(is("38.55"));
    }

    @Test
    @TestSecurity(user = "alice@gmail.com", roles = "user")
    @Order(2)
    public void When_Put_Balance_Succeeds_With_Correct_User()
    {
        given()
		.header("Content-Type", "application/json")
		.when()
		.put("/alice@gmail.com/24")
		.then()
		.statusCode(StatusCode.OK);

    }
}
