package tests.posts;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import ro.crownstudio.engine.logging.Logger;
import ro.crownstudio.utils.ResponseValidator;
import ro.crownstudio.engine.TestEngine;
import ro.crownstudio.enums.Endpoint;
import ro.crownstudio.enums.Method;
import ro.crownstudio.enums.StatusCode;
import ro.crownstudio.pojo.comment.Comment;
import ro.crownstudio.utils.ResponseParser;

import java.util.List;

import static io.restassured.RestAssured.given;
import static ro.crownstudio.engine.logging.Assert.*;

public class GetCommentsForPostTest extends TestEngine {

    @Test(testName = "GET comments for post", description = "This test gets all comments for a post by ID")
    public void testGetCommentsForPost() {
        Endpoint endpoint = Endpoint.POST_ID_COMMENTS;

        // Get the comments for a post from API
        Response response = given(reqSpec).get(endpoint.getEndpoint(1));
        Logger.info("Got response from endpoint: " + endpoint);

        // Validate the response
        ResponseValidator.validateResponse(
                response,
                StatusCode.OK,
                endpoint.getSchemaPath(Method.GET)
        );
        Logger.info("Validated response");

        // Parse the comments into a list of objects
        List<Comment> comments = ResponseParser.parseResponseAsList(response, Comment[].class);
        Logger.info("Parsed response to POJO");

        // Assert the values
        assertEquals(5, comments.size(), "Number of comments as expected");

        Logger.info("Asserting each element of comments");
        for (Comment comment : comments) {
            
            assertEquals(1, comment.getPostId(), "postId as expected");
            assertTrue(comment.getId() > 0, "comment ID as expected");
            assertFalse(comment.getName().isEmpty(), "name in comment as expected");
            assertFalse(comment.getEmail().isEmpty(), "email in comment as expected");
            assertTrue(
                    comment.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"),
                    "Email format"
            );
            assertFalse(comment.getBody().isEmpty(), "Body of comment as expected");
        }
    }
}
