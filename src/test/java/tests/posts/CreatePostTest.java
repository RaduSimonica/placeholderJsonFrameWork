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
import static ro.crownstudio.engine.logging.Assert.assertTrue;

public class CreatePostTest extends TestEngine {

    @Test(testName = "Create post", description = "This test creates a new post")
    public void testCreatePost() {
        Endpoint endpoint = Endpoint.POSTS;

        // Create a new post object without an ID
        Post post = Post.builder()
                .title("someTitle")
                .body("someBody")
                .userId(10)
                .build();
        Logger.info("Created Post object");

        // Create the object via API
        Response response = given(reqSpec)
                .body(post.toJson())
                .post(endpoint.getEndpoint());
        Logger.info("Got response from endpoint: " + endpoint);

        // Validate the response from API
        ResponseValidator.validateResponse(
                response,
                StatusCode.CREATED,
                endpoint.getSchemaPath(Method.POST)
        );
        Logger.info("Validated response");

        // Set the ID of the Post object from the API
        post.setId(ResponseParser.parseResponse(response, Post.class).getId());
        Logger.info("Set id to Post object");

        // Assert the values
        assertTrue(post.getId() > 100, "Post ID as expected");
    }
}
