package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.PropertiesReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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


	/**
	 * get browser configuration from global.properties
	 * there we can configurate the arguments that we'll use
	 * variable = browser.chrome.config
	 */
	private ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		String config = PropertiesReader.getProperty("browser.chrome.config");
		List<String> listConfig = Arrays.asList(config.split(","));
		options.addArguments(listConfig);

		return options;
	}

}
