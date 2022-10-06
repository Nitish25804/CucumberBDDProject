package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//Features/LoginFeature.feature",
		glue="StepDefination",
		dryRun=false,
		monochrome=true,
		tags="@Sanity",
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
/*html*///plugin={"pretty","html:target/CucumberReports/reports_html3.html"}
/*json *//*plugin={"pretty","json:target/CucumberReports/reports_json.json"}*/
		)

public class Run {
   //This Class Should Be Empty
}
