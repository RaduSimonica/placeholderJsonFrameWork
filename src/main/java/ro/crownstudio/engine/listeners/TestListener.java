package ro.crownstudio.engine.listeners;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ro.crownstudio.engine.reporter.TestReporter;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        TestReporter.getInstance().createTest(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        TestReporter.getInstance().endTest(Status.PASS, "Test passed successfully!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        TestReporter.getInstance().endTest(Status.FAIL, "Test FAILED!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        TestReporter.getInstance().endTest(Status.SKIP, "Test was skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        TestReporter.getInstance().endTest(Status.WARNING, "Test failed, but not so much :)");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        TestReporter.getInstance().endTest(Status.FAIL, "Test failed due to timeout.");
    }

    @Override
    public void onStart(ITestContext context) {
        // Not yet implemented.
    }

    @Override
    public void onFinish(ITestContext context) {
        // Not yet implemented.
    }
}
