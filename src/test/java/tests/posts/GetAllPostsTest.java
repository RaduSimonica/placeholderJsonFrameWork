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
import static ro.crownstudio.engine.logging.Assert.*;

public class GetAllPostsTest extends TestEngine {

    @Test(testName = "GET all posts", description = "This test gets all posts from API")
    public void testGetAllPosts() {
        Endpoint endpoint = Endpoint.POSTS;

        // Get all posts from API
        Response response = given(reqSpec).get(endpoint.getEndpoint());
        Logger.info("Got response from endpoint: " + endpoint);

        // Validate the API response
        ResponseValidator.validateResponse(
                response,
                StatusCode.OK,
                endpoint.getSchemaPath(Method.GET)
        );
        Logger.info("Validated response");

        // Parse the response to a list of objects
        List<Post> posts = ResponseParser.parseResponseAsList(response, Post[].class);
        Logger.info("Parsed response to POJO");

        // Assert the values
        assertEquals(
                100,
                posts.size(),
                "Number of posts from API as expected."
        );

        Logger.info("Asserting each element of posts");
        for (Post post : posts) {
            assertTrue(post.getId() != 0, "Post ID as expected");
            assertFalse(post.getTitle().isEmpty(), "Post title as expected");
            assertFalse(post.getBody().isEmpty(), "Post body as expected");
            assertTrue(post.getUserId() > 0, "Post userId as expected");
        }
    }
}
