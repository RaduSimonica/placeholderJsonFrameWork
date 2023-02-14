package ro.crownstudio.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

public class Tools {

    private static final Logger LOGGER = LogManager.getLogger(Tools.class);

    public static byte[] getBytesFromURL(URL url) {
        try (BufferedInputStream inputStream = new BufferedInputStream(url.openStream())) {
            return inputStream.readAllBytes();
        } catch (IOException e) {
            LOGGER.error("Cannot download bytes from url: " + url, e);
        }
        return null;
    }

    public static String getTestName(ITestResult result) {
        String name = null;

        try {
            name = result.getMethod()
                    .getConstructorOrMethod()
                    .getMethod()
                    .getAnnotation(Test.class)
                    .testName();
        } catch (NullPointerException ignore) {}

        if (name == null || name.isEmpty()) {
            name = result.getName();
        }

        return name;
    }
}
