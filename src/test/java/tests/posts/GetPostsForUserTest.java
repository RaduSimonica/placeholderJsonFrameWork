package tests.posts;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import ro.crownstudio.engine.logging.Logger;
import ro.crownstudio.utils.ResponseValidator;
import ro.crownstudio.engine.TestEngine;
import ro.crownstudio.enums.Endpoint;
import ro.crownstudio.enums.Method;
import ro.crownstudio.enums.StatusCode;
import ro.crownstudio.pojo.post.Post;
import ro.crownstudio.utils.ResponseParser;

import java.util.List;

import static io.restassured.RestAssured.given;
import static ro.crownstudio.engine.logging.Assert.assertEquals;

public class GetPostsForUserTest extends TestEngine {

    @Test(testName = "GET posts for user", description = "This test gets all posts by user")
    public void testGetPostsForUser() {
        Endpoint endpoint = Endpoint.POSTS;

        // Get the posts for a user from API
        Response response = given(reqSpec)
                .queryParam("userId", 1)
                .get(endpoint.getEndpoint());
        Logger.info("Got response from endpoint: " + endpoint);

        // Validate the response from API
        ResponseValidator.validateResponse(
                response,
                StatusCode.OK,
                endpoint.getSchemaPath(Method.GET)
        );
        Logger.info("Validated response");

        // Parse the response to a list of objects
        List<Post> posts = ResponseParser.parseResponseAsList(response, Post[].class);
        Logger.info("Parsed response to POJO");

        Logger.info("Asserting each element of posts");
        // Assert the values
        for (Post post : posts) {
            assertEquals(1, post.getUserId(), "User ID as expected");
        }
    }
}
