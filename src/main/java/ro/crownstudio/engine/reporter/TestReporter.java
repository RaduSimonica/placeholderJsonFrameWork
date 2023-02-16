package ro.crownstudio.engine.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.Getter;
import org.testng.ITestResult;
import ro.crownstudio.utils.Tools;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestReporter {

    private static TestReporter INSTANCE;

    @Getter
    private ExtentReports extentReports;
    private Map<Long, ExtentTest> tests;
    @Getter
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
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setTimeStampFormat("HH:mm:ss.SSS");

        this.extentReports.attachReporter(sparkReporter);
        if (this.tests == null) {
            this.tests = new ConcurrentHashMap<>();
        }

        isInit = true;
    }

    public void createTest(ITestResult result) {
        if (!isInit) {
            return;
        }
        ExtentTest test = extentReports.createTest(
                Tools.getTestName(result),
                Tools.getTestDescription(result)
        );
        tests.put(Thread.currentThread().threadId(), test);
    }

    public void endTest(Status status, String message) {
        if (!isInit) {
            return;
        }
        tests.get(Thread.currentThread().threadId()).log(status, message);
    }

    public void log(Status status, String message, Throwable throwable) {
        if (!isInit) {
            return;
        }
        tests.get(Thread.currentThread().threadId()).log(status, message, throwable, null);
    }

    public void generateReport() {
        if (!isInit) {
            return;
        }
        extentReports.flush();
    }
}
