package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class SearchCustomerPage {
	
	WebDriver ldriver;
	
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(xpath="//input[@name='SearchEmail']")
	WebElement EmailAddress;
	
	@FindBy(xpath="//button[@id='search-customers']")
	WebElement SearchClick;
	
	@FindBy(xpath="//table[@role='grid']")
	WebElement SearchResult;
	
	@FindBy(xpath="//input[@name='SearchFirstName']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@name='SearchLastName']")
	WebElement LastName;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> TableRows;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr[1]/td")
	List<WebElement> TableColumn;
	
	public void EmailAdd(String Email) {
		EmailAddress.sendKeys(Email);
	}
	
	public void EnterFirstName(String First) {
		FirstName.sendKeys(First);
	}
	
	public void EnterLastName(String Last) {
		LastName.sendKeys(Last);
	}
	
	public void SearchButton() {
		SearchClick.click();
	}
	
	public boolean SearchCustByEmail(String Email) {
		boolean found=false;
		int totalRows=TableRows.size();
		int totalColumn=TableColumn.size();
		for(int i=1;i<totalRows;i++) {
				WebElement WebElementEmail=ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+ "]/td[2]"));
				String ActualEmail=WebElementEmail.getText();
				if(ActualEmail.equalsIgnoreCase(Email)) {
					found=true;
				}
		}
		return found;
	}
	public boolean SearchCustomerByName(String Name) {
		boolean found =false;
		int totalRow=TableRows.size();
		int totalColumn=TableColumn.size();
		for(int i=1;i<totalRow;i++) {
			WebElement WebElementName=ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+ "]/td[3]"));
			String ActualName=WebElementName.getText();
			if(ActualName.equalsIgnoreCase(Name)) {
				found=true;
			}
		}
		return found;
	}

}
