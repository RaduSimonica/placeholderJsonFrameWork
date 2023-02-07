package ro.crownstudio.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Tools {

    private static final Logger LOGGER = LogManager.getLogger(Tools.class);

    public static byte[] getBytesFromURL(String url) {
        try {
            return getBytesFromURL(new URL(url));
        } catch (MalformedURLException e) {
            LOGGER.error("Invalid url: " + url);
        }
        return null;
    }

    public static byte[] getBytesFromURL(URL url) {
        try (BufferedInputStream inputStream = new BufferedInputStream(url.openStream())) {
            return inputStream.readAllBytes();
        } catch (IOException e) {
            LOGGER.error("Cannot download bytes from url: " + url, e);
        }
        return null;
    }
}
