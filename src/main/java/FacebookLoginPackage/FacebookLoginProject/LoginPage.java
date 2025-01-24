package FacebookLoginPackage.FacebookLoginProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement EmailFeild;
	
	@FindBy(xpath="//input[@id='pass']")
	WebElement PasswordField;
	
	@FindBy(xpath="//button[@name='login']")
	WebElement LoginButton;
	
	
	public void EnterEmail(String username)
	{
		EmailFeild.sendKeys(username);
	}
	
	public void EnterPassword(String password)
	{
		PasswordField.sendKeys(password);
	}
	
	public void ClickLogin()
	{
		LoginButton.click();
	}
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	
	}
}

