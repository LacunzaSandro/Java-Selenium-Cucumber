package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;


public class ChromeDriverManager extends DriverManager {
	
	@Override
	protected WebDriver createDriver() {
		if (!super.is64bits()) {
			WebDriverManager.getInstance(CHROME).arch32().setup();
		} else {
			WebDriverManager.getInstance(CHROME).setup();
		}
		
		return new ChromeDriver(getChromeOptions());
	}

	

	private ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--lang=es-MX");
		options.addArguments("--no-sandbox");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
		options.addArguments("--headless");
		options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        // Disable extensions and hide infobars
        options.addArguments("--disable-infobars");

		return options;
	}

}
