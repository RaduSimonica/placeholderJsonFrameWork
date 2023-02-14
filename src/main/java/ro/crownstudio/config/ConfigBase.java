package ro.crownstudio.config;

import ro.crownstudio.engine.logging.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigBase {

    protected Properties loadProperties(File configFile) {
        Properties properties = new Properties();

        try (FileInputStream is = new FileInputStream(configFile)) {
            properties.load(is);
        } catch (IOException e) {
            Logger.log("Cannot load config file: " + configFile.getPath(), e);
        }

        return properties;
    }
}
