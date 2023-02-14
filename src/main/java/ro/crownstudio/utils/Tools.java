package ro.crownstudio.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import ro.crownstudio.engine.TestEngine;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;

public class Tools {

    private static final Logger LOGGER = LogManager.getLogger(Tools.class);

    public static byte[] getBytesFromURL(String url) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new URL(url).openStream())) {
            return inputStream.readAllBytes();
        } catch (IOException e) {
            LOGGER.error("Cannot download bytes from url: " + url, e);
        }
        return null;
    }

    public static String getTestName(ITestResult result) {
        String name = null;
        ITestNGMethod[] methods = result.getMethod()
                .getTestClass()
                .getTestMethods();

        for (ITestNGMethod testNGMethod : methods) {
            if (testNGMethod.isTest()) {
                Method method = testNGMethod.getConstructorOrMethod().getMethod();
                name = method.getAnnotation(Test.class).testName();

                if (name == null || name.isEmpty()) {
                    name = method.getName();
                }

                break;
            }
        }

        // Fallback. Should never enter here.
        if (name == null || name.isEmpty()) {
            name = result.getName();
        }

        return name;
    }

    public static String getTestDescription(ITestResult result) {
        ITestNGMethod[] methods = result.getMethod()
                .getTestClass()
                .getTestMethods();

        String description = null;
        for (ITestNGMethod testNGMethod : methods) {
            if (testNGMethod.isTest()) {
                Method method = testNGMethod.getConstructorOrMethod().getMethod();
                description = method.getAnnotation(Test.class).description();
            }
        }

        if (description == null || description.isEmpty()) {
            description = "Missing description";
        }

        return description;
    }
}
