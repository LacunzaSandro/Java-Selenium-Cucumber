package pages;

import driver.Driver;
import driver.Waits;
import org.openqa.selenium.support.PageFactory;
import utils.Screenshots;

import java.net.MalformedURLException;

public abstract class BasePage {


    protected Waits w = new Waits();


    public BasePage() throws MalformedURLException {
        Driver.initializeDriverManager();
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
