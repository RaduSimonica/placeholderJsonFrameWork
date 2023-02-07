package ro.crownstudio.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URL;

public class FileTools {

    private static final Logger LOGGER = LogManager.getLogger(FileTools.class);

    public static File getFileFromResources(String path) {
        URL url = Thread.currentThread()
                .getContextClassLoader()
                .getResource(path);

        if (url == null) {
            LOGGER.error("Cannot get config file with name: " + path);
            return null;
        }

        return new File(url.getFile());
    }
}
