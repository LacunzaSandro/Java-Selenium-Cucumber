package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class RemoteChromeDriverManager extends DriverManager {
	
	@Override
	protected WebDriver createDriver() throws MalformedURLException {
		String remote_ip = System.getProperty("REMOTE_IP");
		return new RemoteWebDriver(new URL("http://" + remote_ip + ":4444/wd/hub"),getChromeOptions());
	}

	

	private ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("intl.accept_languages", "es");
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-features=EnableEphemeralFlashPermission");
		return options;
	}

}
