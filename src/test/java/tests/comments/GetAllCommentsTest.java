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

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetAllCommentsTest extends TestEngine {

    @Test(testName = "GET all comments")
    public void testGetAllComments() {
        Endpoint endpoint = Endpoint.COMMENTS;

        // Get the comments for a post from API
        Response response = given(reqSpec).get(endpoint.getEndpoint());
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
        assertEquals(
                500,
                comments.size(),
                "FAILED - The number of comments is different from the expected."
        );
    }
}
