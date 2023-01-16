package pages;

import driver.Driver;
import logging.Logging;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Screenshots;
import utils.TimeOut;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;


@Slf4j
public class TestingLoginPage extends BasePage implements Logging {


    @FindBy(name = "username")
    private WebElement userTxt;

    @FindBy(name = "password")
    private WebElement passText;

    @FindBy(name = "signon")
    private WebElement loginBtn;

    @FindBy(xpath = "//li[.='Invalid username or password.  Signon failed.']")
    private WebElement textError;

    public TestingLoginPage() throws MalformedURLException {
        super();
    }

    public void fillUsername(String username) {
        userTxt.sendKeys(username);
    }

    public void fillPassword(String password) {
        passText.sendKeys(password);
    }

    public void clickBottomLogin() {
        w.waitForElementToBeVisible(loginBtn, TimeOut.SECOND_10.getValue());
        loginBtn.click();
    }

    public String getTextError() {
        return textError.getText();
    }

    public void openPage(String url) throws MalformedURLException {
        Driver.openPage(url);
    }
}
