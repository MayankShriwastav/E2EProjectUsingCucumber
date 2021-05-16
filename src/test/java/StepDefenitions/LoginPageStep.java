package StepDefenitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import PageObject.HomePage;
import PageObject.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageStep extends BaseSetupDef {

		public LoginPageStep(){
			driver = Hooks.driver;
		}

	@And("^User enters the invalid login (.+) and (.+)$")
	public void user_enters_the_invalid_login_and(String username, String password) throws Throwable {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.userName().sendKeys(username);
		lp.password().sendKeys(password);
	}

	@And("^User clicks on submit button$")
	public void user_clicks_on_submit_button() throws Throwable {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.submit().click();
	}

	@Then("^User gets restricted message$")
	public void user_gets_restricted_message() throws Throwable {
		//driver.close();
	}

}
