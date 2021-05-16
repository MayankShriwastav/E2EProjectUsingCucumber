package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{
		
	public LoginPage(WebDriver driver){
		super(driver);
	}	
	
	
	private @FindBy(id ="user_email")
	WebElement userName;
	
	private @FindBy(id ="user_password")
	WebElement password;
	
	private @FindBy(name ="commit")
	WebElement submit;
	
	public WebElement userName(){
		return userName;
	}
	public WebElement password(){
		return password;
	}
	public WebElement submit(){
		return submit;
	}

}
