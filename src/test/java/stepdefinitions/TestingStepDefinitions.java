package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TestingLoginPage;
import utils.PropertiesReader;

import java.net.MalformedURLException;

public class TestingStepDefinitions {

    private final TestingLoginPage testingLoginPage;

    public TestingStepDefinitions(TestingLoginPage testingLoginPage) {
        this.testingLoginPage = testingLoginPage;
    }


    @Given("User Login to the Facebook Login Page")
    public void user_login_to_the_facebook_login_page() throws MalformedURLException {
        testingLoginPage.openPage(PropertiesReader.getProperty("host.testing"));
    }
    @When("User Enter email {string}")
    public void user_enter_email(String email) {
        testingLoginPage.fillUsername(email);
    }
    @When("User Enter Password as {string}")
    public void user_enter_password_as(String password) {
        testingLoginPage.fillPassword(password);
    }
    @When("Click on Log In button")
    public void click_on_log_in_button() {
        testingLoginPage.clickBottomLogin();
    }
    @Then("Login should be Unsuccessful and error message should be dislayed {string}")
    public void login_should_be_unsuccessful_and_error_message_should_be_dislayed(String textError) {
        Assert.assertEquals(textError, testingLoginPage.getTextError());
    }
}

