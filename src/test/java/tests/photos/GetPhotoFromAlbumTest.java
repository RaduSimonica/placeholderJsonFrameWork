package tests.photos;

import com.google.common.hash.Hashing;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import ro.crownstudio.config.PhotoSha256;
import ro.crownstudio.engine.logging.Logger;
import ro.crownstudio.utils.ResponseValidator;
import ro.crownstudio.engine.TestEngine;
import ro.crownstudio.enums.Endpoint;
import ro.crownstudio.enums.Method;
import ro.crownstudio.enums.StatusCode;
import ro.crownstudio.pojo.photo.Photo;
import ro.crownstudio.utils.ResponseParser;
import ro.crownstudio.utils.Tools;

import java.util.List;

import static io.restassured.RestAssured.given;
import static ro.crownstudio.engine.logging.Assert.*;

public class GetPhotoFromAlbumTest extends TestEngine {

    @Test(testName = "GET photos for album", description = "This test gets photos from an album")
    public void testGetPhotoFromAlbum() {
        Endpoint endpoint = Endpoint.ALBUM_ID_PHOTOS;

        // Create photo via API
        Response response = given(reqSpec)
                .queryParam("id", 2)
                .queryParam("id", 3)
                .get(endpoint.getEndpoint(1));
        Logger.info("Got response from endpoint: " + endpoint);

        // Validate the response from API
        ResponseValidator.validateResponse(
                response,
                StatusCode.OK,
                endpoint.getSchemaPath(Method.GET)
        );
        Logger.info("Validated response");

        // Parse the response in a list of objects
        List<Photo> photos = ResponseParser.parseResponseAsList(response, Photo[].class);
        Logger.info("Parsed response to POJO");

        // Assert values
        assertEquals(2, photos.size(), "Size of photos list");

        Logger.info("Asserting each element of photos");
        for (Photo photo : photos) {

            assertEquals(1, photo.getAlbumId(), "Album ID");
            assertTrue(photo.getId() != 0, "Photo ID different than 0");
            assertFalse(photo.getTitle().isEmpty(), "Photo title is not empty");
            assertFalse(photo.getUrl().isEmpty(), "Photo url is not empty");
            assertFalse(photo.getThumbnailUrl().isEmpty(), "Photo thumbnail url is not empty.");

            byte[] photoBytes = Tools.getBytesFromURL(photo.getUrl());
            assertNotNull(photoBytes, "Downloaded photo is");
            assertEquals(
                    PhotoSha256.getInstance().getSha256ForPhotoId(photo.getId()),
                    Hashing.sha256().hashBytes(photoBytes).toString(),
                    "Photo sha256 matches the expected."
            );
        }
    }
}
