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
import static ro.crownstudio.engine.logging.Assert.assertEquals;
import static ro.crownstudio.engine.logging.Assert.assertTrue;

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
        assertEquals(10, comment.getPostId(), "postId as expected");
        assertEquals(48, comment.getId(), "comment ID as expected");
        assertEquals(
                "consequatur animi dolorem saepe repellendus ut quo aut tenetur",
                comment.getName(),
                "name in comment as expected"
        );
        assertEquals(
                "Manuela_Stehr@chelsie.tv",
                comment.getEmail(),
                "email in comment as expected"
        );
        assertTrue(
                comment.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"),
                "Email format"
        );
        assertEquals(
                """
                        illum et alias quidem magni voluptatum
                        ab soluta ea qui saepe corrupti hic et
                        cum repellat esse
                        est sint vel veritatis officia consequuntur cum""",
                comment.getBody(),
                "Body of comment as expected."
        );
    }
}
