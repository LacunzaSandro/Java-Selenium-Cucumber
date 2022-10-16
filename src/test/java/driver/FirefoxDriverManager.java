package driver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;


public class FirefoxDriverManager extends DriverManager {

    @Override
    protected WebDriver createDriver() {


        WebDriverManager.getInstance(FIREFOX).setup();


        return new FirefoxDriver(getFirefoxOptions());
    }


    private FirefoxOptions getFirefoxOptions() {
        return new FirefoxOptions();
    }

}