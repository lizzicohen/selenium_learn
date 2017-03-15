package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import inf.Infos;

public class BrowserChoose {
	String browser;
	WebDriver driver;
	public String getBrowser() {
		return browser;
	}
	public BrowserChoose() {
		super();
		this.browser = null;
		this.driver = null;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public WebDriver browserType(){
		switch (browser){
		case "IE":
			System.out.println("Using IE");
			System.setProperty("webdriver.ie.driver",Infos.iedriverPath);
			driver = new InternetExplorerDriver();
			break;
		case "Chrome":
			System.out.println("Using Chrome");
			break;
		case "Firefox":
			System.out.println("Using Firefox");
			System.setProperty("webdriver.firefox.marionette",Infos.firefoxdriverPath);
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Browser Option:IE/Chrome/Firefox");
		}
		return driver;
	}
	public void close(){
		driver.quit();
	}


}
