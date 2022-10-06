package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	
	WebDriver ldriver;
	public Dashboard(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement CustomerMenu;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement CustomerItom;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement AddNew;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement Logout;
	
	public String GetTitle() {
		return ldriver.getTitle();
	}
	
	public void ClickCustomerManu() {
		CustomerMenu.click();
	}
	
	public void ClickCustomerItom() {
		CustomerItom.click();
	}
	
	public void ClickAddNew() {
		AddNew.click();
	}
	
	public void ClickLogOutButton() {
		Logout.click();
	}

}
