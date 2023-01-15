package driver;

import logging.Logging;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.function.Function;

public class Waits implements Logging {

    private static <T> T waitForCondition(WebDriver driver, Integer timeOutSeconds, Function<WebDriver, T> condition) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeOutSeconds))
                .until(condition);
    }

    public void waitForElementToBeVisible(final WebElement element, int seconds) {
        try {
            WebDriver driver = Driver.getDriver();
            waitForCondition(driver, seconds, d -> element.isDisplayed());
        } catch (MalformedURLException e) {
            getLogger().error("Waiting Error: " + e.getMessage());
        }

    }


    public void waitForJS(int seconds) {
        try {
            WebDriver driver = Driver.getDriver();
            waitForCondition(driver, seconds, d -> {
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                return (Boolean) javascriptExecutor.executeScript("return document.readyState == 'complete' && (typeof jQuery == 'undefined' || jQuery.active == 0)");
            });
        } catch (MalformedURLException e) {
            getLogger().error("Waiting Error: " + e.getMessage());
        }


    }

    public void waitForNewTabLoad(final int handles, int seconds) {
        try {
            WebDriver driver = Driver.getDriver();
            waitForCondition(driver, seconds, d -> !driver.getWindowHandles().equals(handles));
        } catch (MalformedURLException e) {
            getLogger().error("Waiting Error: " + e.getMessage());
        }

    }

    public void waitForAlert(int seconds) {
        try {
            WebDriver driver = Driver.getDriver();
            waitForCondition(driver, seconds, d -> ExpectedConditions.alertIsPresent().apply(driver) != null);
        } catch (MalformedURLException e) {
            getLogger().error("Waiting Error: " + e.getMessage());
        }

    }

}
