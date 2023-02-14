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
import static org.testng.Assert.assertEquals;

public class UpdatePostTest extends TestEngine {

    @Test(testName = "Update post", description = "This test updates a single post by ID")
    public void testUpdatePost() {
        Endpoint endpoint = Endpoint.POSTS_ID;

        // Get a post from API
        Response getResponse = given(reqSpec).get(endpoint.getEndpoint(2));
        Logger.info("Got response from endpoint: " + endpoint);

        // Validate the response from API
        ResponseValidator.validateResponse(
                getResponse,
                StatusCode.OK,
                endpoint.getSchemaPath(Method.GET)
        );
        Logger.info("Validated response");

        // Parse the response to an object
        Post post = ResponseParser.parseResponse(getResponse, Post.class);
        Logger.info("Parsed response to POJO");

        // Modify the post object
        post.setBody("Modified body");
        post.setTitle("Modified title");
        post.setUserId(300);
        Logger.info("Changed values in the Post object");

        // Update the post via API
        Response putResponse = given(reqSpec)
                .body(post.toJson())
                .put(endpoint.getEndpoint(2));
        Logger.info("Got response from endpoint: " + endpoint);

        // Validate the response from API
        ResponseValidator.validateResponse(
                putResponse,
                StatusCode.OK,
                endpoint.getSchemaPath(Method.PUT)
        );
        Logger.info("Validated response");

        // Assert the values
        assertEquals(
                2,
                ResponseParser.parseResponse(putResponse, Post.class).getId(),
                "FAILED - The returned post ID does not match the expected one."
        );
    }
}
