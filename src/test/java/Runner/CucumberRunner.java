package Runner;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.aventstack.extentreports.ExtentReports;
import com.sitture.ExtentFormatter;

import utils.ExtantReporters;

@RunWith(cucumber.api.junit.Cucumber.class)
@cucumber.api.CucumberOptions(
					features={"src/test/java/features"},
					glue={"StepDefenitions"},
					tags = {"@Regression"},
					//plugin=	{"pretty","html:target/cucumber"}
					plugin = {"pretty","html:target/cucumber","com.sitture.ExtentFormatter"}
								
		)
public class CucumberRunner {
	
	@BeforeClass
    public static void setup() {		
	  ExtentFormatter.initiateExtentFormatter();

        // Loads the extent config xml to customize on the report.
        ExtentFormatter.loadConfig(new File("src/test/java/extent-config.xml"));
        // User can add the system information as follows
        ExtentFormatter.addSystemInfo("Browser Name", "Chrome");
        ExtentFormatter.addSystemInfo("Browser version", "v87.0.1");
        ExtentFormatter.addSystemInfo("Selenium version", "v2.53.1");
    	    }
	
}
