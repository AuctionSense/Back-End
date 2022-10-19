package org.auctionsense.resource;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.auctionsense.domain.User;
import org.auctionsense.service.UserService.Result;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestResponse.StatusCode;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;

@QuarkusTest
@TestHTTPEndpoint(UserResource.class)
public class UserResourceTest {
    private static final String JSON = "application/json";

    private static final String DEFAULT_PASSWORD = "testPassword";
    private static final String NAME_EXISTS = "testUser";

    private static final Logger logger = Logger.getLogger(UserResourceTest.class);

    @Test
    public void Cannot_Create_User_That_Exists()
    {
        // Arrange
        User user = new User();
        user.setUsername(NAME_EXISTS);
        user.setPassword(DEFAULT_PASSWORD);

        // Act
        Result result = given()
            .body(user)
            .header(CONTENT_TYPE, JSON)
            .header(ACCEPT, JSON)
            .when()
            .post()
            .then()
            .statusCode(StatusCode.OK)
            .extract().body().as(getResultTypeRef());

        //logger.info("LOGGING MESSAGE:" + result.getMessage()); THIS IS HOW YOU LOG TO CONSOLE IN TESTS, MAKE SURE Toggle test output IS ON
        // Assert
        assertTrue(result.getMessage().contains("Username already exists."));
    }

    private TypeRef<Result> getResultTypeRef() {
        return new TypeRef<Result>() {

        };
    }
}
