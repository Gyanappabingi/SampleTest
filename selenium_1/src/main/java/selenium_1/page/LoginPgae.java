package selenium_1.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium_1.base.Base;

public class LoginPgae extends Base{
	
	@FindBy(xpath = "//input[@name=\"username\"]")
	WebElement un;
	
	@FindBy(xpath = "//input[@type=\"password\"]")
	WebElement pw;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement lgnbtn;
	
	public LoginPgae(){
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String uname,String pass) {
		un.sendKeys(uname);
		pw.sendKeys(pass);
		lgnbtn.click();
		return new HomePage();
	} 

}
