package ro.crownstudio.engine;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import ro.crownstudio.config.Config;
import ro.crownstudio.config.Environment;

import java.lang.reflect.Method;

public class TestEngine {

    protected Logger logger;
    protected Config config;
    protected Environment environment;
    protected RequestSpecification reqSpec;

    @BeforeMethod
    public void testSetup(Method method) {
        this.logger = LogManager.getLogger(this);
        this.config = Config.getInstance();
        this.environment = config.getEnvironment();
        this.reqSpec = new RequestSpecBuilder()
                .setContentType("application/json")
                .setBaseUri(this.environment.getBaseUrl())
                .build();
    }
}
