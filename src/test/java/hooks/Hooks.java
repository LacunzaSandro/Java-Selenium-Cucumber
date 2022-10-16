package hooks;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import utils.PropertiesReader;
import utils.Screenshots;

import java.io.File;
import java.io.IOException;


public class Hooks {

    Scenario scenario;

    @Before
    public void setUp(Scenario scenario) throws IOException {
        //load de properties file
        PropertiesReader.loadProperties();
        this.scenario = scenario;
        String fullPathName = System.getProperty("user.dir") + PropertiesReader.getProperty("screenshot.rel.path");
        if ((new File(fullPathName)).exists()) {
            FileUtils.cleanDirectory(new File(fullPathName));
        }
    }

    @After
    public void tearDown() throws IOException {
        Driver.tearDown();
    }

    @AfterStep()
    public void attach_screenshot() throws Throwable {
        Screenshots.saveAnScreenShot();
        Screenshots.takeScreenShot(scenario);
    }


}
