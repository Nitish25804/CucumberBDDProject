package StepDefination;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import PageObject.AddNewCustomerPage;
import PageObject.Dashboard;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefi extends BaseClass {
	
	@Before
	public void Setup() {
		Log=LogManager.getLogger("StepDefi");
		ReadConf=new ReadConfig();
		String Browser=ReadConf.getBrowser();
		switch(Browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;	
		}
		
		Log.info("Setup 1 Executed");
	}	
	
	@Given("User Lunch Chrome Browser")
	public void user_lunch_chrome_browser() {
		
	    lp=new LoginPage(driver);
		ds=new Dashboard(driver);
		an=new AddNewCustomerPage(driver);
		sc=new SearchCustomerPage(driver);
	}
/////////////////////////Login Feature////////////////
	@When("User Open URL {string}")
	public void user_open_url(String url) {
	   driver.get(url); 
	   Log.info("Url Lunched....");
	}

	@When("User Enter Email as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String Email, String Password) {
	    lp.EnterEmail(Email);
	    lp.EnterPassword(Password);
	    Log.info("Email And Password Entered....");
	}

	@When("Click On Login")
	public void click_on_login() {
	    lp.ClickOnLoginButton();
	    Log.info("Login Button Clicked");
	}

	@Then("Page Title Should Be {string}")
	public void page_title_should_be(String ExpectedTitle) {
		Log.info("Titel Compared....");
	    String ActualTitle=driver.getTitle();
	    System.out.println(ActualTitle);
	    if(ActualTitle.equalsIgnoreCase(ExpectedTitle)) {
	    	Log.info("Title Matched....");
	    	Assert.assertTrue(true);
	    }else {
	    	Log.warn("Test Failed: Title Did Not Matched.....");
	    	Assert.assertTrue(false);
	    }
	}

	@When("User Click on Log Out Link")
	public void user_click_on_log_out_link() {
	   ds.ClickLogOutButton();
	   Log.info("Log Out Button Clicked.....");
	}

	@Then("Close The Browser")
	public void close_the_browser() {
		driver.close();
		Log.info("Driver.closed....");
	}
	
	//////////////////////Add New Customer//////////////////////////
	
	@Then("User Can View Dashboard")
	public void user_can_view_dashboard() {
		Log.info("User Can Viev Dash Board.....");
	    String ActualTitle=ds.GetTitle();
	    String ExpectedTitle="Dashboard / nopCommerce administration";
	    if(ActualTitle.equalsIgnoreCase(ExpectedTitle)) {
	    	Assert.assertTrue(true);
	    	Log.info("Title Matched....");
	    }else {
	    	Log.warn("Title Did not Matched....");
	    	Assert.assertTrue(false);
	    }
	}

	@When("User Click On Customers Menu")
	public void user_click_on_customers_menu() {
		Log.info("Click On Customer Manu....");
	   ds.ClickCustomerManu();
	}

	@When("Click On The Customer Menu Itoms")
	public void click_on_the_customer_menu_itoms() {
		Log.info("Click on Customer Manu id Done....");
	   ds.ClickCustomerItom();
	   try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@When("Click On Add New button")
	public void click_on_add_new_button() {
		Log.info("Add New Button Clicked....");
	    ds.ClickAddNew();
	}

	@Then("User Can View Add New Customer Page")
	public void user_can_view_add_new_customer_page() {
	    String ActualTitel=an.GetPageTitle();
	    String ExpectedTitel="Add a new customer / nopCommerce administration";
	    if(ActualTitel.equalsIgnoreCase(ExpectedTitel)) {
	    	Log.info("Verification Passed....");
	    	Assert.assertTrue(true);
	    }else {
	    	Log.warn("Varification Fail");
	    	Assert.assertTrue(false);
	    }
	}

	@When("User Enter Customer Info")
	public void user_enter_customer_info() {
	   //an.EnterTypeEmail("test1@yourstore.com");
	   Log.info("New Youser Info Started Entering");
	   an.EnterTypeEmail(GenerateRandomEmailId()+"@gmail.com");
	   an.EnterPassword("test1");
	   an.EnterFirstName("Milind");
	   an.EnterLastName("Sanam");
	   an.SelectGender();
	   an.EnterDateOfBirth("12/31/1986");
	   an.EnterCompanyName("CodeFoe Tech");
	   an.IsTaxExemt();
	   an.SelectManagerOfVender("Vendor 2");
	   an.ClickActive();
	   an.EnterAdminComment("Admin Comment");

	}

	@When("Click On The Save button")
	public void click_on_the_save_button() {
	    an.ClickSave();
	    Log.info("Save Button Clicked....");
	}

	@Then("User Can view Conformation Message {string}")
	public void user_can_view_conformation_message(String ExpectedConformationMsg) {
	  String BodyTag=driver.findElement(By.tagName("Body")).getText();
	  if(BodyTag.contains(ExpectedConformationMsg)) {
		  Log.info("Conformation Msg Is Viewed");
		  Assert.assertTrue(true);
	    }else {
	    	Log.warn("Verification Fail....");
	    	Assert.assertTrue(false);
	  }
	}
	
	/////////////////////Search Customer/////////////////////////////
	@When("Enter Customer Email")
	public void enter_customer_email() {
	   sc.EmailAdd("arthur_holmes@nopCommerce.com");
	   Log.info("Email Entered....");
	}

	@When("Click On Search button")
	public void click_on_search_button() {
	    sc.SearchButton();
	    Log.info("Search Button Clicked....");
	}

	@Then("User Should Found Email In Search Table")
	public void user_should_found_email_in_search_table() {
	    String ExpectedEmail="arthur_holmes@nopCommerce.com";
	    if(sc.SearchCustByEmail(ExpectedEmail)== true) {
	    	Log.info("Verification cvomplited....");
	    	Assert.assertTrue(true);
	    }else
	    	Log.warn("Verification Failed....");
	    	Assert.assertTrue(false);
	}

////////////////////////////Search Customer By Name//////////////////////////
	@When("Enter Customer First Name")
	public void enter_customer_first_name() {
	   sc.EnterFirstName("Arthur");
	   Log.info("First Name Entered");
	}

	@When("Enter Customer Last Name")
	public void enter_customer_last_name() {
	   sc.EnterLastName("Holmes");
	   Log.info("Last Name Entered");
	}

	@Then("User Should Found Name In Search Table")
	public void user_should_found_name_in_search_table() {
		String ExpectedName="Arthur Holmes";
		if(sc.SearchCustomerByName(ExpectedName)== true) {
			Log.info("Name Matched.....");
			Assert.assertTrue(true);
		}else {
			Log.warn("Title UnMatched....");
			Assert.assertTrue(false);
		}
	}
	
	@After
	public void TearDown(Scenario sc) {
		if(sc.isFailed()) {
			final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "image/png", sc.getName());
			Log.info("Test Case Failed");
			driver.quit();
		}else {
			Log.info("Test Passed");
		}

	}
	
	
}
