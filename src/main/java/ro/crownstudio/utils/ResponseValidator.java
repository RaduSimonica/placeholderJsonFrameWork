package ro.crownstudio.utils;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import ro.crownstudio.config.Config;
import ro.crownstudio.engine.logging.Logger;
import ro.crownstudio.enums.StatusCode;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.describedAs;
import static ro.crownstudio.engine.logging.Assert.assertEquals;
import static ro.crownstudio.engine.logging.Assert.fail;

public class ResponseValidator {

    private static final Config CONFIG = Config.getInstance();

    public static void validateResponse(Response response, StatusCode expectedStatus) {
        validateResponse(response, expectedStatus, (File) null);
    }

    public static void validateResponse(Response response, StatusCode expectedStatus, String schema) {
        validateResponse(response, expectedStatus, FileTools.getFileFromResources(schema));
    }

    public static void validateResponse(Response response, StatusCode expectedStatus, File schema) {
        ValidatableResponse validatableResponse = response.then();
        // Assert status code to be as expected.
        assertEquals(
                expectedStatus.getCode(),
                validatableResponse.extract().statusCode(),
                "Status code as expected"
        );

        // Warn if the response time exceeds the max allowed time in config.
        // Just a warning. Not failing the test.
        if (validatableResponse.extract().time() >= CONFIG.getMaxResponseTimeInMs()) {
            String warnMessage = "Response time exceeded the threshold (actual: %s / expected: %s".formatted(
                    validatableResponse.extract().time(),
                    CONFIG.getMaxResponseTimeInMs()
            );

            Logger.warn(warnMessage);

            if (CONFIG.isFailForExceedingResponseTime()) {
                fail(warnMessage);
            }
        }

        // Assert that the Json schema is matching
        if (schema != null) {
            validatableResponse.assertThat()
                    .body(
                            describedAs(
                                    "Json schema as expected: " + schema.getPath(),
                                    matchesJsonSchema(schema)
                            )
                    );
        }
    }
}
