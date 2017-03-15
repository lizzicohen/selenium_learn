package baseClass;

import org.openqa.selenium.WebDriver;
import inf.Infos;

public class LogIn {
	WebDriver driver;
	String url;
	public LogIn() {
		// TODO Auto-generated constructor stub
		url = Infos.loginUrl;
		
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public WebDriver Login(){
		/*
		driver.get(url);
		WebElement we = driver.findElement(By.id("accountName"));
		we.sendKeys("admin");
		we = driver.findElement(By.id("password"));
		we.sendKeys("Passw0rd");
		ReadCode rc = new ReadCode();
		rc.setFilename(Infos.codeUrl);
		driver.findElement(By.id("randImg")).sendKeys(rc.readURLCode());
		driver.findElement(By.className("login_btn")).click();
		*/
		ReadCode rc = new ReadCode();
		PageOps p = new PageOps();
		p.setDriver(driver);
		p.naviTo(Infos.loginUrl);
		p.inputById("accountName", "admin");
		p.inputById("password", "Passw0rd");
		p.inputById("randImg",rc.readURLCode(Infos.codeUrl));
		p.confirmByClass("login_btn");;
		p.alertAccept();
		p.justClick("ÐÞ¸ÄÃÜÂë",0);
		return driver;
	}

}
