package StepDefenitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import PageObject.HomePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.PropertyReader;

public class Hooks {
	
	public static WebDriver driver;
	
	@Before
	public void openBrowser() throws IOException, ParseException{
		PropertyReader reader = PageFactory.initElements(driver, PropertyReader.class);		
		String url = reader.getUrl();
		String userName = reader.getUserName();
		String pwd = reader.getPassword();
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenum_Learn\\selenium-java-3.141.59\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);			
	}
	
	@After
	public void enabledScreenShot(Scenario scenario){		
		if(scenario.isFailed()){
			try{
				scenario.write("current page url"+driver.getCurrentUrl());
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}catch(WebDriverException somePlateformDontSupportScreenshots){
				System.err.println(somePlateformDontSupportScreenshots.getMessage());
			}
		}
		driver.quit();
	}

}
