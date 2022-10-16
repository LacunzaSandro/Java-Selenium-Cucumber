package driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class Waits {

    private static <T> T waitForCondition(WebDriver driver, Integer timeOutSeconds, Function<WebDriver, T> condition) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeOutSeconds))
                .ignoring(WebDriverException.class)
                .until(condition);
    }

    public void waitForElementToBeVisible(WebDriver driver, final WebElement element, int seconds) {
        waitForCondition(driver, seconds, d -> element.isDisplayed());
    }
    public void waitForJS(WebDriver driver, int seconds) {
        waitForCondition(driver, seconds, d -> {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            return (Boolean)javascriptExecutor.executeScript("return document.readyState == 'complete' && (typeof jQuery == 'undefined' || jQuery.active == 0)");
        });
    }
    public void waitForNewTabLoad(WebDriver driver, final int handles, int seconds) {
        waitForCondition(driver,seconds,d -> !driver.getWindowHandles().equals(handles));
    }
    public void waitForAlert(WebDriver driver, int seconds) {
        waitForCondition(driver,seconds, d -> {
            return	ExpectedConditions.alertIsPresent().apply(driver) != null;
        });
    }

}
