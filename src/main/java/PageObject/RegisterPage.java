package PageObject;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DBConnection;
import utils.PropertyReader;

public class RegisterPage extends BaseClass{
	
	public RegisterPage(WebDriver driver){
		super(driver);
		
	}
	
	private @FindBy(id ="user_name") WebElement fullName;
	
	private @FindBy(id ="user_email") WebElement email;
	
	private @FindBy(id ="user_password") WebElement password;
	
	private @FindBy(id ="user_password_confirmation") WebElement confirmPassword;
	
	public WebElement fullName(){
		return fullName;
	}
	public WebElement email(){
		return email;
	}	
	public WebElement password(){
		return password;
	}
	public WebElement confirmPassword(){
		return confirmPassword;
	}
	
	public ArrayList  getNewUserData() throws IOException, ParseException{
		PropertyReader reader = PageFactory.initElements(driver, PropertyReader.class);		
		String sql = reader.getQuery();		
		DBConnection db = PageFactory.initElements(driver, DBConnection.class);
    	ArrayList<String> data = db.connectMysqlDB(sql);
    	return data;
	}

}
