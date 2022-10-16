package driver;

import logging.Logging;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import static driver.DriverType.getDriverType;

public  class Driver implements Logging {

    protected static DriverManager driverManager;

    public static synchronized void initializeDriverManager() throws MalformedURLException {
        if (null == driverManager) {
            driverManager = DriverFactory.valueOf(getDriverType()).getDriverManager();
        } else {
            driverManager.getDriver();
        }
    }

    public static void openPage(String url) throws MalformedURLException {
        driverManager.getDriver().get(url);
    }

    public static WebDriver getDriver() throws MalformedURLException {
        return driverManager.getDriver();
    }


    public static void tearDown() throws MalformedURLException {
        if(driverManager.getDriver()!=null) {
            driverManager.quitDriver();
        }
    }

}
