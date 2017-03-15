

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class testonly {
	public static void main(String[] args){
//		System.setProperty("webdriver.chrome.driver","C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.firefox.marionette","C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.baidu.com");

//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.id("kw"));
		element.sendKeys("zzzz");
		element.submit();
		System.out.print("success");		
		// 显示搜索结果页面的 title
		System.out.println("2 Page title is: " + driver.getTitle());

		// 关闭浏览器
		driver.quit();
	}
}
