package ro.crownstudio.utils;

import ro.crownstudio.engine.logging.Logger;

import java.io.File;
import java.net.URL;

public class FileTools {

    public static File getFileFromResources(String path) {
        URL url = Thread.currentThread()
                .getContextClassLoader()
                .getResource(path);

        if (url == null) {
            Logger.warn("Cannot get config file with name: " + path);
            return null;
        }

        return new File(url.getFile());
    }
}
