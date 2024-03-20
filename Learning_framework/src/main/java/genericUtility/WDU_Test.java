package genericUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WDU_Test {

	// this method is to maximixze the browser
	// @param driver
	public void maximizeBrowser(WebDriver driver) {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to minimize the browser
	// @param driver
	public void minimizeBrowser(WebDriver driver) {
		try {
			driver.manage().window().minimize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to wait implicitly
	// @param driver
	public void waitForBrowserToLoad(WebDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to wait implicitly
	// @param driver and time
	public void waitForBrowserToLoad(WebDriver driver, int time) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to wait until the element is visible
	// @param driver element and time
	public void waitTillElementIsVisible(WebDriver driver, WebElement element, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// this method is to select the dropdown
	// @param element and index
	public void selectValuesFromDropdown(WebElement element, int index) {
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to select the dropdown
	// @param element and value
	public void selectValuesFromDropdown(WebElement element, String values) {
		try {
			Select s = new Select(element);
			s.selectByValue(values);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is used to select the dropdown
	// @param element and visible text
	public void selectValuesFromDropdownVisibleTxt(String visibleTxt, WebElement element) {
		try {
			Select s = new Select(element);
			s.deselectByVisibleText(visibleTxt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is used to select all the values from a multiselect dropdown
	// @param element
	public void selectAllOptions(WebElement element) {
		try {
			Select s = new Select(element);
			int size = s.getOptions().size();
			for (int i = 0; i < size; i++) {
				s.selectByIndex(i);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is used to deselect the selected values from a multiselect
	// dropdown
	// @param element
	public void deselectOptions(WebElement element) {
		try {
			Select s = new Select(element);
			s.deselectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is used to switch iframe
	// @param driver
	public void switchFrame(WebDriver driver, int index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is used to switch iframe
	// @param driver and Name or ID
	public void switchFrame(WebDriver driver, String NameOrId) {
		try {
			driver.switchTo().frame(NameOrId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is used to switch iframe
	// @param driver and element
	public void switchFrame(WebDriver driver, WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is used to switch windows
	// @param driver and title
	public void switchWindow(WebDriver driver, String title) {
		try {
			Set<String> whs = driver.getWindowHandles();
			Iterator<String> it = whs.iterator();
			while (it.hasNext()) {
				String winID = it.next();
				String currentTitle = driver.switchTo().window(winID).getTitle();
				if (currentTitle.endsWith(title)) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is used to accept the alerts
	// @param driver
	public void acceptAlert(WebDriver driver) {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is used to dismiss the alerts
	// @param driver
	public void dismissAlert(WebDriver driver) {
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to mouse hover on the element and click
	// @param driver and the element
	public void mouseMoveAndClick(WebDriver driver, WebElement element) {
		try {
			Actions a = new Actions(driver);
			a.moveToElement(element).click().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// this method is to mouse hover on the element
	// @param driver and the element
	public void mouseMoveOnTheElement(WebDriver driver, WebElement element) {
		try {
			Actions a = new Actions(driver);
			a.moveToElement(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// this method is to perform a right click
	// @param driver and the element
	public void mouseRightClickOnElement(WebDriver driver, WebElement element) {
		try {
			Actions a = new Actions(driver);
			a.moveToElement(element).contextClick().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to press ENTER button
	// @param
	public void pressEnter() {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to press TAB button
	// @param
	public void pressTab() {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			r.keyRelease(KeyEvent.VK_TAB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to press UP arrow button
	// @param
	public void pressUpArrow() {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_UP);
			Thread.sleep(2000);
			r.keyRelease(KeyEvent.VK_UP);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to press DOWN arrow button
	// @param
	public void pressDownArrow() {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			r.keyRelease(KeyEvent.VK_DOWN);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to press the ENTER button
	// @param driver
	public void pressEnter(WebDriver driver) {
		try {
			Actions a = new Actions(driver);
			a.sendKeys(Keys.ENTER).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to press the TAB button
	// @param driver
	public void pressTab(WebDriver driver) {
		try {
			Actions a = new Actions(driver);
			a.sendKeys(Keys.TAB).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to press the UP arrow button
	// @param driver
	public void pressUpArrow(WebDriver driver) {
		try {
			Actions a = new Actions(driver);
			a.sendKeys(Keys.ARROW_UP).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is to press the DOWN arrow button
	// @param driver
	public void pressDownArrow(WebDriver driver) {
		try {
			Actions a = new Actions(driver);
			a.sendKeys(Keys.ARROW_DOWN).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is for hard wait
	public void hardWait() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// this method is for hard wait
	public void hardWait(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// this method is used to check if the element is displayed
	// @param element
	public void isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// this method is used to check if the element is enabled
	// @param element
	public void isEnabled(WebElement element) {
		try {
			element.isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// this method is used to check if the element is selected
	// @param element
	public void isSelected(WebElement element) {
		try {
			element.isSelected();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// this method is used to scroll the webpage
	// @param driver
	public void scrollWebPage(WebDriver driver) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,800)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method is used to execute javascript commands
	// @param driver
	public void executeJavascriptCommand(WebDriver driver, String command) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(command);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
