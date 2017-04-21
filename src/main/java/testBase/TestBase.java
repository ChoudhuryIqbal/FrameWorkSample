package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestBase extends CommonApi{
	public Properties Repository=new Properties();
	public File f;
	
	
	public void init() throws IOException{
		loadPropertiesFile();
		
	}
	public void loadPropertiesFile() throws IOException{
		
		//load config file
		f=new File(System.getProperty("user.dir"+"\\src\\main\\java\\config\\config.properties"));
	
		FileInputStream fi=new FileInputStream(f);
		Repository.load(fi);
		
		
		
		//load page locator
		//load loginpage.properties
		f=new File(System.getProperty("user.dir"+"\\src\\main\\java\\pageLocator\\loginpage.properties"));
		fi=new FileInputStream(f);
		Repository.load(fi);
		//report page
		f=new File(System.getProperty("user.dir"+"\\src\\main\\java\\pageLocator\\reportsPage.properties"));
		fi=new FileInputStream(f);
		Repository.load(fi);
		
		
		//taskPage
		f=new File(System.getProperty("user.dir"+"\\src\\main\\java\\pageLocator\\taskPage.properties"));
		fi=new FileInputStream(f);
		Repository.load(fi);
		
		
		//timeTrack properties
		f=new File(System.getProperty("user.dir"+"\\src\\main\\java\\pageLocator\\timeTracks.properties"));
		fi=new FileInputStream(f);
		Repository.load(fi);
		
	}
	
	
	
	public static WebElement getLocator(String locator) throws Exception{
		String [] split=locator.split(":");
		String locatorType=split[0];
		String locatorValue=split[1];
		
		if(locatorType.equalsIgnoreCase("id")){
			return driver.findElement(By.id(locatorValue));
		}
		else if(locatorType.equalsIgnoreCase("name")){
			return driver.findElement(By.name(locatorValue));
		
		}
		else if(locatorType.equalsIgnoreCase("classname")){
			return driver.findElement(By.className(locatorValue));
					
		}
		else if(locatorType.equalsIgnoreCase("tagname")){
			return driver.findElement(By.tagName(locatorValue));
					
		}
		
		else if(locatorType.equalsIgnoreCase("linktext")){
			return driver.findElement(By.linkText(locatorValue));
					
		}
		else if(locatorType.equalsIgnoreCase("partiallinkText")){
			return driver.findElement(By.partialLinkText(locatorValue));
					
		}
		else if(locatorType.equalsIgnoreCase("cssselector")){
			return driver.findElement(By.cssSelector(locatorValue));
					
		}
		else if(locatorType.equalsIgnoreCase("xpath")){
			return driver.findElement(By.xpath(locatorValue));
					
		}
		
		else{
			throw new Exception("unknown locator type: "+locatorType+".");
		}
		
		
		
		
	}
	public static List<WebElement> getLocators(String locator) throws Exception{
		String [] split=locator.split(":");
		String locatorType=split[0];
		String locatorValue=split[1];
		
		if(locatorType.equalsIgnoreCase("id")){
			return driver.findElements(By.id(locatorValue));
		}
		else if(locatorType.equalsIgnoreCase("name")){
			return driver.findElements(By.name(locatorValue));
		
		}
		else if(locatorType.equalsIgnoreCase("classname")){
			return driver.findElements(By.className(locatorValue));
					
		}
		else if(locatorType.equalsIgnoreCase("tagname")){
			return driver.findElements(By.tagName(locatorValue));
					
		}
		
		else if(locatorType.equalsIgnoreCase("linktext")){
			return driver.findElements(By.linkText(locatorValue));
					
		}
		else if(locatorType.equalsIgnoreCase("partiallinkText")){
			return driver.findElements(By.partialLinkText(locatorValue));
					
		}
		else if(locatorType.equalsIgnoreCase("cssselector")){
			return driver.findElements(By.cssSelector(locatorValue));
					
		}
		else if(locatorType.equalsIgnoreCase("xpath")){
			return driver.findElements(By.xpath(locatorValue));
					
		}
		
		else{
			throw new Exception("unknown locator type: "+locatorType+".");
		}
		
		
		
		
	}
	
	
	public WebElement getWebElement(String locator) throws Exception {
		return getLocator(Repository.getProperty(locator));
	}
	public List<WebElement> getWebElements(String locator) throws Exception {
		return getLocators(Repository.getProperty(locator));
	}
	
	
}
