package ro.crownstudio.engine.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import ro.crownstudio.config.Config;
import ro.crownstudio.engine.reporter.TestReporter;

import java.io.File;

public class SuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        TestReporter.getInstance()
                .init(new File(System.getProperty("user.dir") + Config.getInstance().getReportPath()));
    }

    @Override
    public void onFinish(ISuite suite) {
        TestReporter.getInstance().generateReport();
    }
}
