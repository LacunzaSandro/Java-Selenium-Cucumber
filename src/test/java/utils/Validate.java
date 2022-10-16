package utils;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class Validate extends SoftAssert {


	private WebDriver d;
	
	public Validate(WebDriver driver) {
		this.d = driver;
	}

}
