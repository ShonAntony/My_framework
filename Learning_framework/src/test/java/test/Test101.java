package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import pages.MainPage;

@Listeners(genericUtility.ListenerImp.class)

public class Test101 extends BaseClass {
	MainPage m;
	
	@Test
	public void register() throws Exception {
		m = new MainPage(driver);
		String username = fLib.getValueFromPropertyFile("username");		
		String password = fLib.getValueFromPropertyFile("password");
		String email = fLib.getValueFromPropertyFile("email");
		wLib.waitForPageToLoad(driver);
		m.getUiTestingLnk().click();
		m.getNameTxtFld().sendKeys(username);
		m.getEmailTxtFld().sendKeys(email);
		m.getPwdTxtFld().sendKeys(password);
		m.getRegisterBtn().click();
	}
	
	
	@Test
	public void login() throws Exception {
		m = new MainPage(driver);
		String password = fLib.getValueFromPropertyFile("password");
		String email = fLib.getValueFromPropertyFile("email");
		wLib.waitForPageToLoad(driver);
		m.getUiTestingLnk().click();
		wLib.scrollTillElement(driver, m.getLoginLnk());
		m.getLoginLnk().click();
		wLib.waitUntilTheElementIsVisible(driver, m.getEmailTxtFld());
		m.getEmailTxtFld().sendKeys(email);
		m.getPwdTxtFld().sendKeys(password);
		m.getLoginBtn().click();

		
	}
	
}
