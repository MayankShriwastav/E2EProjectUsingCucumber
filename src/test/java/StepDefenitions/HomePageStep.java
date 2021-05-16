package StepDefenitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import PageObject.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class HomePageStep extends BaseSetupDef {
	
	public HomePageStep(){
		driver = Hooks.driver;
	}
	
	@Given("^User launches home application$")
	public void user_launches_home_application() throws Throwable {
		System.out.println("Application launched...!");
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		if(hp.popUp().size()>0){
			hp.popUp().get(0).click();
		}
	}
	
	@When("^User is on home page$")
	public void user_is_on_home_page() throws Throwable {
	/*	HomePage hp = PageFactory.initElements(driver, HomePage.class);
		if(hp.popUp().size()>0){
			hp.popUp().get(0).click();
		}*/
	}

	@Then("^User searches for Featured Courses and navigation bar$")
	public void user_searches_for_Featured_Courses_and_navigation_bar() throws Throwable {
		HomePage hpo = PageFactory.initElements(driver, HomePage.class);
		Assert.assertEquals("Featured Courses", hpo.courses().getText());
		Assert.assertTrue(hpo.nevigationBar().isDisplayed());
		System.out.println("Feature Courses and Navigation bar is available");
	}

	@And("^User clicks the login button$")
	public void user_clicks_the_login_button() throws Throwable {
		HomePage hpo = PageFactory.initElements(driver, HomePage.class);
		hpo.login().click();
	}

}
