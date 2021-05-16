package PageObject;

import org.openqa.selenium.WebDriver;

public abstract class BaseClass {
	
	public static WebDriver driver;
	
	public BaseClass (WebDriver driver){
		this.driver = driver;
	}

}
