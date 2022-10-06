package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {

		ldriver=rdriver;

		PageFactory.initElements(rdriver,this);
	}
	@FindBy(xpath="//input[@id='Email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement Password;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement Login;
	
    public void EnterEmail(String EmailAdd) {
    	Email.clear();
    	Email.sendKeys(EmailAdd);
    }
    
    public void EnterPassword(String PWord) {
    	Password.clear();
    	Password.sendKeys(PWord);
    }
    
    public void ClickOnLoginButton() {
    	Login.click();
    }

}
