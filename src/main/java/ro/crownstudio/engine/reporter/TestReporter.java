package ro.crownstudio.engine.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import ro.crownstudio.utils.Tools;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestReporter {

    private static final Logger LOGGER = LogManager.getLogger(TestReporter.class);
    private static TestReporter INSTANCE;

    @Getter
    private ExtentReports extentReports;
    private Map<Long, ExtentTest> tests;
    private boolean isInit = false;

    private TestReporter() {}

    public synchronized static TestReporter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestReporter();
        }
        return INSTANCE;
    }

    public void init(File output) {
        this.extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(output);
        this.extentReports.attachReporter(sparkReporter);
        if (this.tests == null) {
            this.tests = new ConcurrentHashMap<>();
        }

        isInit = true;
    }

    public void createTest(ITestResult result) {
        if (!isInit) {
            LOGGER.error("TestReporter not initialized. Will not create a test.");
            return;
        }
        ExtentTest test = extentReports.createTest(
                Tools.getTestName(result),
                result.getMethod().getDescription()
        );
        tests.put(Thread.currentThread().threadId(), test);
    }

    public void endTest(Status status, String message) {
        if (!isInit) {
            LOGGER.error("TestReporter not initialized. Will not end a test.");
            return;
        }
        tests.get(Thread.currentThread().threadId()).log(status, message);
    }

    public void generateReport() {
        if (!isInit) {
            LOGGER.error("TestReporter not initialized. Will not flush tests.");
            return;
        }
        extentReports.flush();
    }
}
