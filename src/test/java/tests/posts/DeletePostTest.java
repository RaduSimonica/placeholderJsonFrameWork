package tests.posts;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import ro.crownstudio.utils.ResponseValidator;
import ro.crownstudio.engine.TestEngine;
import ro.crownstudio.enums.Endpoint;
import ro.crownstudio.enums.StatusCode;

import static io.restassured.RestAssured.given;

public class DeletePostTest extends TestEngine {

    @Test
    public void testDeletePost() {
        Endpoint endpoint = Endpoint.POSTS_ID;

        // Request a deletion of a post from the API
        Response response = given(reqSpec).delete(endpoint.getEndpoint(4));

        // Validate the response
        ResponseValidator.validateResponse(response, StatusCode.OK);
    }
}
