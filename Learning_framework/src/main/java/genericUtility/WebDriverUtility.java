
package genericUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	// this method is used to maximize the window
	// @param driver
	public void maximizeBrowserWindow(WebDriver driver) {
		driver.manage().window().maximize();

	}

	// this method is used to minimize the window
	// @param driver
	public void mainimizeBrowserWindow(WebDriver driver) {
		driver.manage().window().minimize();

	}

	// this memthod to load the page implicitly
	// @param driver
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// this method is to load the page with custom time
	// @param driver and time in seconds
	public void waitForPageToLoadInGivenTime(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

	}

	// this method is to wait until the element is visible
	// @param driver and the element
	public void waitUntilTheElementIsVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// this method is to select the item from the listbox based on the index
	// @param element and the index
	public void select(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);

	}

	// this method is to select the item from the listbox based on the value
	// @param element and the value
	public void select(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);

	}

	// this method is to select the item from the listbox based on the text
	// @param element and the text
	public void select(String text, WebElement element) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);

	}

	// this method is used to move the mouse to the target element
	// @param driver and element
	public void mouseMoveOnTheElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).click().build().perform();
	}

	// this method is used to drag and drop the elements
	// @param driver , source and destination element
	public void mouseDragAndDrop(WebDriver driver, WebElement src, WebElement dest) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dest).build().perform();
	}

	// this method is to double click on the element
	// @param driver
	public void mouseDoubleClick(WebDriver driver) {
		Actions a = new Actions(driver);
		a.doubleClick().perform();

	}

	// this method is to double click on the element
	// @param driver and element
	public void mouseDoubleClick(WebDriver driver, WebElement element) {
		try {
			Actions a = new Actions(driver);
			a.doubleClick(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// this method is to perform right click on the element
	// @param driver
	public void rightClick(WebDriver driver) {
		try {
			Actions a = new Actions(driver);
			a.contextClick().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// this method is to perform right click on the element
	// @param driver
	public void rightClick(WebDriver driver, WebElement element) {
		try {
			Actions a = new Actions(driver);
			a.contextClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to perform a key press enter
	// @parama driver
	public void pressEnterKey(WebDriver driver) {

		try {
			Actions a = new Actions(driver);
			a.sendKeys(Keys.ENTER).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// this method is to perform a key press enter
	// @parama driver
	// if we need we can pass the driver if else its not needed
	public void pressEnterKeyRobot(WebDriver driver) {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to release the enter key using robot class
	//
	public void enterKeyReleaseRobot() {
		try {
			Robot r = new Robot();
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// this method is to switch to an iframe
	// @params driver name/id
	public void switchFrame(WebDriver driver, String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to switch to an iframe using the address
	// @params driver and address
	public void switchFrame(WebDriver driver, WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// this method is to accept the alert popup
	// @param driver
	public void acceptAlert(WebDriver driver) {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// this method is to reject the alert popup
	// @param driver
	public void cancelAlert(WebDriver driver) {
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// this method is used to switch between widows
	// @paramas are driver and the page title
	public void switchWindow(WebDriver driver, String title) {

		// here we are fetching all the handles
		Set<String> winhdls = driver.getWindowHandles();

		Iterator<String> it = winhdls.iterator();

		while (it.hasNext()) {

			String winId = it.next();

			String curentTitle = driver.switchTo().window(winId).getTitle();

			if (curentTitle.endsWith(title)) {
				break;
			}

		}

	}

	// this method is to scroll the webpage to the exact pixel vertically
	// @param driver and the pixels
	public void scrollBarAction(WebDriver driver, String pix) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,800" + pix + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to scroll the webpage till the element is visible
	// @param driver and element
	public void scrollTillElement(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			int y = element.getLocation().getY();
			js.executeScript("window.scrollBy(0," + y + ")", element);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	// this method is to take the screen shot of the failed script screen
	public static String takeSS(WebDriver sdriver , String ssName) {
		TakesScreenshot ts = (TakesScreenshot)sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "./screenshot/"+ssName+".png";
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}





