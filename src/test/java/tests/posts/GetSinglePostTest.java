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

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class GetSinglePostTest extends TestEngine {

    @Test(testName = "GET single post", description = "This test gets a single post by ID")
    public void testGetSinglePost() {
        Endpoint endpoint = Endpoint.POSTS_ID;

        // Get a single post from API
        Response response = given(reqSpec).get(endpoint.getEndpoint(42));
        Logger.info("Got response from endpoint: " + endpoint);

        // Validate the API response
        ResponseValidator.validateResponse(
                response,
                StatusCode.OK,
                endpoint.getSchemaPath(Method.GET)
        );
        Logger.info("Validated response");

        // Parse the response to an object
        Post post = ResponseParser.parseResponse(response, Post.class);
        Logger.info("Parsed response to POJO");

        // Assert the values of the object.
        assertEquals(42, post.getId(), "FAILED - The Post id does not match the expected one.");
        assertFalse(post.getTitle().isEmpty(), "FAILED - Post title is empty");
        assertFalse(post.getBody().isEmpty(), "FAILED - Post body is empty");
        assertTrue(post.getUserId() > 0, "FAILED - Post userId is 0");
    }
}
