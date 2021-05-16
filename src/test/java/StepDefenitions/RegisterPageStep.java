package StepDefenitions;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;

import PageObject.HomePage;
import PageObject.RegisterPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DBConnection;

public class RegisterPageStep extends BaseSetupDef {
	
	public RegisterPageStep(){
		driver = Hooks.driver;
	}


	    @When("^User clicks on Register button$")
	    public void user_clicks_on_register_button() throws Throwable {
	    	HomePage hp = PageFactory.initElements(driver, HomePage.class);
			hp.register().click();
	    }
	    
	    @Then("^User navigated to Register Page and enters new user details$")
	    public void user_navigated_to_register_page_and_enters_new_user_details() throws Throwable {	    	
	    	RegisterPage rp = PageFactory.initElements(driver, RegisterPage.class);
	    	ArrayList<String> data = rp.getNewUserData();
			rp.fullName().sendKeys(data.get(0));
			rp.email().sendKeys(data.get(1));
			rp.password().sendKeys(data.get(2));
			rp.confirmPassword().sendKeys(data.get(3));	
	    }
	    
}
