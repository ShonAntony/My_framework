package genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public DatabaseUtility dLib = new DatabaseUtility();
	public DatabaseUtility eLib = new DatabaseUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();

	public WebDriver driver;
	public static WebDriver sdriver;

	// this method is to connect to the database before the suite execution
	@BeforeSuite
	public void dbConnect() {
		System.out.println("the database is connected");
		// dLib.connectToDB();
	}

	// this method is to launch the specific browser
	@BeforeClass
	public void configBC() throws Exception {

		String browser = fLib.getValueFromPropertyFile("browser");
		System.out.println("the browser is" + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		wLib.maximizeBrowserWindow(driver);
		System.out.println("browser is launched");

		System.out.println("browser opened");
		wLib.maximizeBrowserWindow(driver);
		
	}

	// this method is to login to the application
	@BeforeMethod
	public void configBM() throws Exception {
		String url= fLib.getValueFromPropertyFile("url");
		driver.get(url);
		System.out.println("the user has logged in");
		
		// here we need to get the username and the password from the property file and
		// then use it
	}

	// this method is to logout from the application
	@AfterMethod
	public void configAM() {
		System.out.println("the user has logged out");
	}

	// this method is to close the browser
	@AfterClass
	public void configAC() {
		driver.quit();
		System.out.println("the browser is closed");
	}

	// this method is to close the database connection
	@AfterSuite
	public void configAS() {
		/* dLib.closeDB(); */
		System.out.println("DB closed");
	}

}
