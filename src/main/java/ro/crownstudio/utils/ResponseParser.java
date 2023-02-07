package ro.crownstudio.utils;

import com.google.gson.Gson;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

public class ResponseParser {

    public static <T> T parseResponse(Response response, Class<T> type) {
        return parseJson(
                response.then()
                        .extract()
                        .body()
                        .asString(),
                type
        );
    }

    public static <T> List<T> parseResponseAsList(Response response, Class<T[]> type) {
        return parseJsonList(
                response.then()
                        .extract()
                        .body()
                        .asString(),
                type
        );
    }

    public static <T> T parseJson(String input, Class<T> type) {
        return new Gson().fromJson(input, type);
    }

    public static <T> List<T> parseJsonList(String input, Class<T[]> type) {
        return Arrays.asList(new Gson().fromJson(input, type));
    }
}
