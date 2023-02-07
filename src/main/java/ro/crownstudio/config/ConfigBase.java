package ro.crownstudio.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigBase {

    private static final Logger LOGGER = LogManager.getLogger(ConfigBase.class);

    protected Properties loadProperties(File configFile) {
        Properties properties = new Properties();

        try (FileInputStream is = new FileInputStream(configFile)) {
            properties.load(is);
        } catch (IOException e) {
            LOGGER.error("Cannot load config file: " + configFile.getPath(), e);
        }

        return properties;
    }
}
