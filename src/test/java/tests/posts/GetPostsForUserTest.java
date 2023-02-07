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

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetPostsForUserTest extends TestEngine {

    @Test
    public void testGetPostsForUser() {
        Endpoint endpoint = Endpoint.POSTS;


        // Get the posts for a user from API
        Response response = given(reqSpec)
                .queryParam("userId", 1)
                .get(endpoint.getEndpoint());

        // Validate the response from API
        ResponseValidator.validateResponse(
                response,
                StatusCode.OK,
                endpoint.getSchemaPath(Method.GET)
        );

        // Parse the response to a list of objects
        List<Post> posts = ResponseParser.parseResponseAsList(response, Post[].class);

        // Assert the values
        for (Post post : posts) {
            assertEquals(1, post.getUserId());
        }
    }
}
