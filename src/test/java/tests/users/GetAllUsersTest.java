package tests.users;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import ro.crownstudio.engine.logging.Logger;
import ro.crownstudio.utils.ResponseValidator;
import ro.crownstudio.engine.TestEngine;
import ro.crownstudio.enums.Endpoint;
import ro.crownstudio.enums.Method;
import ro.crownstudio.enums.StatusCode;
import ro.crownstudio.pojo.users.User;
import ro.crownstudio.utils.ResponseParser;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetAllUsersTest extends TestEngine {

    @Test(testName = "GET all users", description = "This test gets all users from API")
    public void testGetAllUsers() {
        Endpoint endpoint = Endpoint.USERS;

        // Get the comments for a post from API
        Response response = given(reqSpec).get(endpoint.getEndpoint());
        Logger.info("Got response from endpoint: " + endpoint);

        // Validate the response
        ResponseValidator.validateResponse(
                response,
                StatusCode.OK,
                endpoint.getSchemaPath(Method.GET)
        );
        Logger.info("Validated response");

        // Parse the comments into a list of objects
        List<User> users = ResponseParser.parseResponseAsList(response, User[].class);
        Logger.info("Parsed response to POJO");

        // Assert the values
        assertEquals(
                10,
                users.size(),
                "FAILED - The number of comments is different from the expected."
        );
    }
}
