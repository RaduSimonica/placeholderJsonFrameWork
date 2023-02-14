package tests.comments;

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


import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GetCommentTest extends TestEngine {

    @Test(testName = "GET Single Comment", description = "This test gets a single comment by ID.")
    public void testGetComment() {
        Endpoint endpoint = Endpoint.COMMENTS_ID;

        // Get the comments for a post from API
        Response response = given(reqSpec).get(endpoint.getEndpoint(48));
        Logger.info("Got response from endpoint: " + endpoint);

        // Validate the response
        ResponseValidator.validateResponse(
                response,
                StatusCode.OK,
                endpoint.getSchemaPath(Method.GET)
        );
        Logger.info("Validated response");

        // Parse the comments into a list of objects
        Comment comment = ResponseParser.parseResponse(response, Comment.class);
        Logger.info("Parsed response to POJO");

        // Assert the values
        assertEquals(10, comment.getPostId(), "FAILED - The postId is incorrect.");
        assertEquals(48, comment.getId(), "FAILED - The comment ID does not match the expected.");
        assertEquals(
                "consequatur animi dolorem saepe repellendus ut quo aut tenetur",
                comment.getName(),
                "FAILED - Name in comment does not match the expected."
        );
        assertEquals(
                "Manuela_Stehr@chelsie.tv",
                comment.getEmail(),
                "FAILED - email in comment is empty."
        );
        assertTrue(
                comment.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"),
                "FAILED - Email has invalid format."
        );
        assertEquals(
                """
                        illum et alias quidem magni voluptatum
                        ab soluta ea qui saepe corrupti hic et
                        cum repellat esse
                        est sint vel veritatis officia consequuntur cum""",
                comment.getBody(),
                "FAILED - Body of comment does not match the expected."
        );
    }
}
