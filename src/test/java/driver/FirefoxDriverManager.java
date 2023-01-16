package driver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.PropertiesReader;


import java.util.Arrays;
import java.util.List;

import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;


public class FirefoxDriverManager extends DriverManager {

    @Override
    protected WebDriver createDriver() {


        WebDriverManager.getInstance(FIREFOX).setup();


        return new FirefoxDriver(getFirefoxOptions());
    }

    /**
     * get browser configuration from global.properties
     * there we can configurate the arguments that we'll use
     * variable = browser.chrome.config
     */
    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        String config = PropertiesReader.getProperty("browser.firefox.config");
        List<String> listConfig = Arrays.asList(config.split(","));
        options.addArguments(listConfig);
        return options;
    }

}