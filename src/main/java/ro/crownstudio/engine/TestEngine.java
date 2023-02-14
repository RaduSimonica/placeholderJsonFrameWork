package ro.crownstudio.engine;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import ro.crownstudio.config.Config;
import ro.crownstudio.engine.logging.Logger;
import ro.crownstudio.engine.reporter.TestReporter;

public class TestEngine {

    protected RequestSpecification reqSpec;

    @BeforeMethod
    public void testSetup() {
        TestReporter.getInstance().createTest(Reporter.getCurrentTestResult());
        Logger.info("Starting test...");

        this.reqSpec = new RequestSpecBuilder()
                .setContentType("application/json")
                .setBaseUri(Config.getInstance().getEnvironment().getBaseUrl())
                .build();
    }
}
