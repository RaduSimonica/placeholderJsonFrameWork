package ro.crownstudio.engine.logging;

import org.testng.Reporter;
import ro.crownstudio.config.Config;
import ro.crownstudio.engine.reporter.TestReporter;
import ro.crownstudio.utils.Tools;
import com.aventstack.extentreports.Status;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Logger {

    public static void info(String message) {
        log(Status.INFO, message, null);
    }

    public static void log(String message, Throwable throwable) {
        log(Status.WARNING, message, throwable);
    }

    public static void log(Status status, String message, Throwable throwable) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
                .withZone(ZoneId.systemDefault());

        if (Config.getInstance().isLogToConsole()) {
            System.out.println(
                    "%s [%s] | %s".formatted(
                            formatter.format(Instant.now()),
                            Tools.getTestName(Reporter.getCurrentTestResult()),
                            message
                    )
            );
        }

        if (Config.getInstance().isLogToReporter() && TestReporter.getInstance().isInit()) {
            TestReporter.getInstance().log(
                    status,
                    "[%s] | %s".formatted(
                            Tools.getTestName(Reporter.getCurrentTestResult()),
                            message
                    ),
                    throwable
            );
        }
    }
}
