package driver;


import org.openqa.selenium.WebDriver;
import utils.Architecture;

import java.net.MalformedURLException;
import java.time.Duration;

public abstract class DriverManager {

	public final static int TIMEOUT_IMPLICIT = 10;
	public final static int TIMEOUT_LOAD_PAGE = 10;
	protected ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
	protected abstract WebDriver createDriver() throws MalformedURLException;
	
	public void quitDriver() {
		if (null != drivers.get()) {
			try {
				drivers.get().quit();
				drivers.remove();
			} catch (Exception e) {

			}
			
		}
	}
	
	public WebDriver getDriver() throws MalformedURLException {
		if (null == drivers.get()) {
			drivers.set(this.createDriver());
		}
		drivers.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT_IMPLICIT));
		drivers.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TIMEOUT_LOAD_PAGE));
		return drivers.get();
	}
	
	protected boolean is64bits() {
		return Architecture.is64bits();
	}
}
