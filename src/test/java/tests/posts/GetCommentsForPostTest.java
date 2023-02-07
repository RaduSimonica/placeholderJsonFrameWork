package tests.posts;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import ro.crownstudio.utils.ResponseValidator;
import ro.crownstudio.engine.TestEngine;
import ro.crownstudio.enums.Endpoint;
import ro.crownstudio.enums.Method;
import ro.crownstudio.enums.StatusCode;
import ro.crownstudio.pojo.comment.Comment;
import ro.crownstudio.utils.ResponseParser;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class GetCommentsForPostTest extends TestEngine {

    @Test
    public void testGetCommentsForPost() {
        Endpoint endpoint = Endpoint.POST_ID_COMMENTS;

        // Get the comments for a post from API
        Response response = given(reqSpec).get(endpoint.getEndpoint(1));

        // Validate the response
        ResponseValidator.validateResponse(
                response,
                StatusCode.OK,
                endpoint.getSchemaPath(Method.GET)
        );

        // Parse the comments into a list of objects
        List<Comment> comments = ResponseParser.parseResponseAsList(response, Comment[].class);

        // Assert the values
        assertEquals(5, comments.size(), "FAILED - The number of comments is incorrect.");
        
        for (Comment comment : comments) {
            
            assertEquals(1, comment.getPostId(), "FAILED - The postId is incorrect.");
            assertTrue(comment.getId() > 0, "FAILED - The comment ID is 0.");
            assertFalse(comment.getName().isEmpty(), "FAILED - Name in comment is empty.");
            assertFalse(comment.getEmail().isEmpty(), "FAILED - email in comment is empty.");
            assertTrue(
                    comment.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"),
                    "FAILED - Email has invalid format."
            );
            assertFalse(comment.getBody().isEmpty(), "FAILED - Body of comment is empty.");
        }
    }
}
