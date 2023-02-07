package ro.crownstudio.enums;

import java.util.List;

import static org.testng.AssertJUnit.fail;


public enum Endpoint {

    POSTS(
            "/posts",
            List.of(
                    "schemas/posts/posts_get.json",
                    "schemas/posts/posts_post.json"
            )
    ),
    POSTS_ID(
            "/posts/%s",
            List.of(
                    "schemas/posts/post_get.json",
                    "schemas/posts/post_put.json",
                    "schemas/posts/post_patch.json",
                    "schemas/posts/post_delete.json"
            )
    ),
    POST_ID_COMMENTS(
            "/post/%s/comments",
            List.of(
                    "schemas/comments/comments_get.json"
            )
    ),

    COMMENTS(
            "/comments",
            List.of(
                    "schemas/comments/comments_get.json"
            )
    ),

    COMMENTS_ID(
            "/comments/%s",
            List.of(
                    "schemas/comments/comment_get.json"
            )
    ),

    ALBUM_ID_PHOTOS(
            "/albums/%s/photos",
            List.of(
                    "schemas/albums/albums_photos_get.json"
            )
    ),

    USERS(
            "/users",
            List.of("schemas/users/users_get.json")
    ),
    USER_ID(
            "/users/%s",
            List.of("schemas/users/user_get.json")
    );



    private final String endpoint;
    private final List<String> schemaPath;

    Endpoint(String endpoint, List<String> schemaPath) {
        this.endpoint = endpoint;
        this.schemaPath = schemaPath;
    }

    public String getEndpoint() {
        if (this.endpoint.contains("%s")) {
            fail("This endpoint accepts at least 1 parameter and 0 are provided. Please provide at least 1 parameter.");
        }
        return this.endpoint;
    }

    public String getEndpoint(Object... params) {
        return this.endpoint.formatted(params);
    }

    public String getSchemaPath(Method method) {
        return this.schemaPath.stream()
                .filter(path -> path.toLowerCase().endsWith("%s.json".formatted(method.toString().toLowerCase())))
                .findFirst()
                .orElse(schemaPath.get(0));
    }
}
