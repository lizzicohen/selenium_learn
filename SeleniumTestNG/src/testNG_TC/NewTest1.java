package testNG_TC;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import baseClass.BrowserChoose;
import baseClass.LogIn;


public class NewTest1 {
	public static WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		BrowserChoose bc = new BrowserChoose();
		bc.setBrowser("Firefox");
		driver = bc.browserType();
	}

	@Test
	public void Test1() {
		try {
			LogIn l = new LogIn();
			l.setDriver(driver);
			l.Login();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}


	}
//	@Test
	public void Test2(){
		List<WebElement> sidelist = driver.findElements(By.xpath("//a[contains(text(),'Õ¹¿ª/ÕÛµþ')]"));
		for(WebElement e:sidelist){
			e.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
	}

	@AfterTest
	public void afterTest() {
		 driver.quit();
	}
}
