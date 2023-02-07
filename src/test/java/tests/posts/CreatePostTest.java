package tests.posts;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import ro.crownstudio.utils.ResponseValidator;
import ro.crownstudio.engine.TestEngine;
import ro.crownstudio.enums.Endpoint;
import ro.crownstudio.enums.Method;
import ro.crownstudio.enums.StatusCode;
import ro.crownstudio.pojo.post.Post;
import ro.crownstudio.utils.ResponseParser;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class CreatePostTest extends TestEngine {

    @Test
    public void testCreatePost() {
        Endpoint endpoint = Endpoint.POSTS;

        // Create a new post object without an ID
        Post post = Post.builder()
                .title("someTitle")
                .body("someBody")
                .userId(10)
                .build();

        // Create the object via API
        Response response = given(reqSpec)
                .body(post.toJson())
                .post(endpoint.getEndpoint());

        // Validate the response from API
        ResponseValidator.validateResponse(
                response,
                StatusCode.CREATED,
                endpoint.getSchemaPath(Method.POST)
        );

        // Set the ID of the Post object from the API
        post.setId(ResponseParser.parseResponse(response, Post.class).getId());

        // Assert the values
        assertTrue(post.getId() > 100, "FAILED - Unexpected post ID.");
    }
}
