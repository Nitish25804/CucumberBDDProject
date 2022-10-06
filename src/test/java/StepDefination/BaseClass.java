package StepDefination;


import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.Dashboard;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;

//Parent Class
public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public Dashboard ds;
	public AddNewCustomerPage an;
	public SearchCustomerPage sc;
	public static Logger Log;
	public ReadConfig ReadConf;
	
	public String GenerateRandomEmailId() {
		return RandomStringUtils.randomAlphabetic(5);
	}

}
