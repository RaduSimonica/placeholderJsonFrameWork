package ro.crownstudio.config;

import lombok.Getter;
import ro.crownstudio.utils.FileTools;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.StringJoiner;

@Getter
public class Environment extends ConfigBase {

    private static Environment INSTANCE;

    private final String name;
    private final String description;
    private final int id;
    private final URI baseUrl;

    private Environment(String path) {
        Properties properties = loadProperties(FileTools.getFileFromResources(path));

        this.name = properties.getProperty("name");
        this.description = properties.getProperty("description");
        this.id = Integer.parseInt(properties.getProperty("id"));

        try {
            this.baseUrl = new URI(properties.getProperty("baseUrl"));
        } catch (NullPointerException | URISyntaxException e) {
            throw new RuntimeException("Cannot parse baseUrl from environment file: " + path, e);
        }
    }

    public static Environment getInstance(String name) {
        if (INSTANCE == null) {
            StringJoiner joiner = new StringJoiner("/")
                    .add("environments")
                    .add(name + ".properties");
            INSTANCE = new Environment(joiner.toString());
        }
        return INSTANCE;
    }
}
