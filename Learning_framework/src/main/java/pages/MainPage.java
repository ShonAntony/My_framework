package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	
	@FindBy(xpath = "//input[@id= 'name']")
	WebElement nameTxtFld ;
	
	@FindBy(xpath = "//input[@id= 'email']")
	WebElement emailTxtFld ;
	
	@FindBy(xpath = "//input[@id= 'password']")
	WebElement pwdTxtFld ;
	
	@FindBy(xpath = "//button[text()='Register']")
	WebElement registerBtn;
	
	@FindBy(xpath = "//div[text()='Registered successfully']")
	WebElement registeredToaster;
	
	@FindBy(xpath = "//p[text()='UI Testing Concepts']")
	WebElement uiTestingLnk;
	
	@FindBy(xpath = "//a[contains(text(),'Login Now')]")
	WebElement loginLnk;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//div[text()='Signin successful']")
	WebElement signinToaster;
	
	
	public WebElement getSigninToaster() {
		return signinToaster;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getLoginLnk() {
		return loginLnk;
	}

	public WebElement getUiTestingLnk() {
		return uiTestingLnk;
	}

	public WebElement getRegisteredToaster() {
		return registeredToaster;
	}

	public MainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getNameTxtFld() {
		return nameTxtFld;
	}

	public WebElement getEmailTxtFld() {
		return emailTxtFld;
	}

	public WebElement getPwdTxtFld() {
		return pwdTxtFld;
	}

	public WebElement getRegisterBtn() {
		return registerBtn;
	}
	
	

}
