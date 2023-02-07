package tests.users;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import ro.crownstudio.utils.ResponseValidator;
import ro.crownstudio.engine.TestEngine;
import ro.crownstudio.enums.Endpoint;
import ro.crownstudio.enums.Method;
import ro.crownstudio.enums.StatusCode;
import ro.crownstudio.pojo.users.User;
import ro.crownstudio.utils.ResponseParser;


import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GetSingleUserTest extends TestEngine {

    @Test
    public void testGetSingleUser() {
        Endpoint endpoint = Endpoint.USER_ID;

        // Get the comments for a post from API
        Response response = given(reqSpec).get(endpoint.getEndpoint(4));

        // Validate the response
        ResponseValidator.validateResponse(
                response,
                StatusCode.OK,
                endpoint.getSchemaPath(Method.GET)
        );

        // Parse the comments into a list of objects
        User user = ResponseParser.parseResponse(response, User.class);

        // Assert the values
        assertEquals(
                4,
                user.getId(),
                "FAILED - The user ID does not match the expected."
        );
        assertEquals(
                "Patricia Lebsack",
                user.getName(),
                "FAILED - The user name does not match the expected."
        );
        assertEquals(
                "Karianne",
                user.getUsername(),
                "FAILED - The user username does not match the expected."
        );
        assertEquals(
                "Julianne.OConner@kory.org",
                user.getEmail(),
                "FAILED - The user email does not match the expected."
        );
        assertTrue(
                user.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"),
                "FAILED - The user email has invalid format."
        );
        assertEquals(
                "Hoeger Mall",
                user.getAddress().getStreet(),
                "FAILED - The user's address street does not match the expected."
        );
        assertEquals(
                "Apt. 692",
                user.getAddress().getSuite(),
                "FAILED - The user's address suite does not match the expected."
        );
        assertEquals(
                "South Elvis",
                user.getAddress().getCity(),
                "FAILED - The user's address city does not match the expected."
        );
        assertEquals(
                "53919-4257",
                user.getAddress().getZipcode(),
                "FAILED - The user's address city does not match the expected."
        );
        assertEquals(
                "29.4572",
                user.getAddress().getGeo().getLat(),
                "FAILED - The user's address geo latitude does not match the expected."
        );
        assertEquals(
                "-164.2990",
                user.getAddress().getGeo().getLng(),
                "FAILED - The user's address geo longitude does not match the expected."
        );
        assertEquals(
                "493-170-9623 x156",
                user.getPhone(),
                "FAILED - The user's phone does not match the expected."
        );
        assertEquals(
                "kale.biz",
                user.getWebsite(),
                "FAILED - The user's website does not match the expected."
        );
        assertEquals(
                "Robel-Corkery",
                user.getCompany().getName(),
                "FAILED - The user's company name does not match the expected."
        );
        assertEquals(
                "Multi-tiered zero tolerance productivity",
                user.getCompany().getCatchPhrase(),
                "FAILED - The user's company catch phrase does not match the expected."
        );
        assertEquals(
                "transition cutting-edge web services",
                user.getCompany().getBs(),
                "FAILED - The user's company business does not match the expected."
        );
    }
}
