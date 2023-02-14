package ro.crownstudio.config;

import lombok.Getter;
import ro.crownstudio.utils.FileTools;

import java.util.Properties;

public class Config extends ConfigBase {

    private static Config INSTANCE;

    @Getter
    private final Environment environment;
    @Getter
    private final String apiKey;
    @Getter
    private final int maxResponseTimeInMs;
    @Getter
    private final boolean failForExceedingResponseTime;
    @Getter
    private final String reportPath;
    @Getter
    private final boolean logToConsole;
    @Getter
    private final boolean logToReporter;

    private Config() {
        Properties properties = loadProperties(FileTools.getFileFromResources("appConfig.properties"));

        // Set all fields here.
        this.environment = Environment.getInstance(properties.getProperty("environment"));
        this.apiKey = properties.getProperty("apiKey");
        this.maxResponseTimeInMs = Integer.parseInt(properties.getProperty("maxResponseTimeInMs"));
        this.failForExceedingResponseTime = Boolean.parseBoolean(properties.getProperty("failForExceedingResponseTime"));
        this.reportPath = properties.getProperty("reporter.reportPath");
        this.logToConsole = Boolean.parseBoolean(properties.getProperty("logger.logToConsole"));
        this.logToReporter = Boolean.parseBoolean(properties.getProperty("logger.logToReporter"));
    }

    public static Config getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Config();
        }

        return INSTANCE;
    }
}
