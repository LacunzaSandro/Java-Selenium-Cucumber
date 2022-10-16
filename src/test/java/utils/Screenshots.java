package utils;


import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.shaded.messages.types.FeatureChild;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshots {


    Scenario scenario;

    public Screenshots(Scenario scenario) {
        this.scenario = scenario;
    }


    public  static void takeScreenShot(Scenario scenario) throws MalformedURLException {
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "attached screenshot:");
    }

    public static void saveAnScreenShot() throws IOException {
        String screenshotdir = System.getProperty("user.dir") + PropertiesReader.getProperty("screenshot.rel.path");

        File src = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        Date oDate = new Date();
        SimpleDateFormat oSDF = new SimpleDateFormat("ddMMYYYY_HHmmss");
        String sDate = oSDF.format(oDate);
        FileUtils.copyFile(src, new File(screenshotdir + "Screenshot_" + sDate + ".png"));
    }
}
