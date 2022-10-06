package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {
	
	WebDriver ldriver;
	
	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//input[@name='Email']")
	WebElement TypeEmail;
	
	@FindBy(xpath="//input[@name='Password']")
	WebElement TypePassword;
	
	@FindBy(xpath="//input[@name='FirstName']")
	WebElement TypeFirstName;
	
	@FindBy(xpath="//input[@name='LastName']")
	WebElement TypeLastName;
	
	@FindBy(xpath="//input[@id='Gender_Male']")
	WebElement SelectGenderMale;
	
	@FindBy(xpath="//input[@name='DateOfBirth']")
	WebElement DateOfBirth;
	
	@FindBy(xpath="//input[@name='Company']")
	WebElement TypeCompany;
	
	@FindBy(xpath="//input[@name='IsTaxExempt']")
	WebElement IsTaxEmem;
	
	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']")
	WebElement CustomerRole;
	
	@FindBy(xpath="//div[@class='k-widget k-multiselect k-multiselect-clearable']")
	WebElement NewsLater;
	
	@FindBy(xpath="//select[@name='VendorId']")
	WebElement ManagerOfVeneder;
	
	@FindBy(xpath="//input[@name='Active'][@class='check-box']")
	WebElement Active;
	
	@FindBy(xpath="//textarea[@name='AdminComment']")
	WebElement AdminComment;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement Save;
	
	@FindBy(xpath="//button[@name='save-continue']")
	WebElement SaveAndEdit;
	
	public String GetPageTitle() {
		return ldriver.getTitle();
	}
	
	public void EnterTypeEmail(String Email) {
		TypeEmail.sendKeys(Email);
	}
	
	public void EnterFirstName(String FName) {
		TypeFirstName.sendKeys(FName);
	}
	
	public void EnterLastName(String LName) {
		TypeLastName.sendKeys(LName);
	}
	
	public void EnterPassword(String Password) {
		TypePassword.sendKeys(Password);
	}
	
	public void SelectGender() {
		 SelectGenderMale.click();
	}
	
	public void EnterDateOfBirth(String DOB) {
		DateOfBirth.sendKeys(DOB);
	}
	
	public void EnterCompanyName(String Company) {
		TypeCompany.sendKeys(Company);
	}
	
	public void IsTaxExemt() {
		IsTaxEmem.click();
	}
	public void EnterNewsLater(int Name) {
		Select s=new Select(NewsLater);
		s.selectByIndex(Name);
	}
	
	public void SelectManagerOfVender(String Value) {
		Select s=new Select(ManagerOfVeneder);
		s.selectByVisibleText(Value);
	}
	
	public void ClickActive() {
		Active.click();
	}
	
	public void EnterAdminComment(String AText) {
		AdminComment.sendKeys(AText);
	}
	
	public void ClickSave() {
		Save.click();
	}

}
