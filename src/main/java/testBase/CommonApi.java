package testBase;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class CommonApi {
	public static WebDriver driver;

	/**
	 * This method initialize browser object
	 * 
	 * @param browser
	 * @param browser-driver
	 */
	public static WebDriver selectBrowser(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:/Users/Nafees_Iqbal/workspace/frame-sample/src/main/java/driver/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/Nafees_Iqbal/workspace/frame-sample/src/main/java/driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					"C:/Users/Nafees_Iqbal/workspace/frame-sample/src/main/java/driver/geckodriver.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
			driver.manage().window().maximize();
			return driver;
		}

		return null;

	}

	/**
	 * @ @param
	 *       timeInSecond
	 */
	public void impliciteWait(int timeInSecond) {
		Reporter.log("waiting for page to load");
		try {
			driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);
			Reporter.log("Page is loaded");

		} catch (Throwable error) {
			Reporter.log("TimeOUt for page Load Request to complete after" + timeInSecond + " Second");
			Assert.assertTrue(false, "Timeout for page load request after " + timeInSecond + " second");

		}
	}

	/**
	 * @param element
	 * @param dropDownValue
	 */
	public void selectDropDownValue(WebElement element, String dropDownValue)

	{
		Select select = new Select(element);
		Reporter.log("selecting " + dropDownValue + "value in dropdown");

		select.selectByVisibleText(dropDownValue);

	}
	/**
	 * 
	 * @param timeToWaitInSec
	 * @throws InterruptedException
	 */
	public void driverwait(int timeToWaitInSec) throws InterruptedException {
		Reporter.log("Waiting for " + timeToWaitInSec + " seconds...");

		Thread.sleep(timeToWaitInSec * 1000);
	}

	/**
	 * @param element
	 * @param timeToWaitInSec
	 */
	public static void expliciteWait(WebElement element, int timeToWaitInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
