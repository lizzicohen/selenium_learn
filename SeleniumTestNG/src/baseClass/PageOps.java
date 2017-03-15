package baseClass;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageOps {
	String url;
	String content;
	String id;
	String name;
	String className;
	WebDriver driver;
	public PageOps() {
		super();
		this.url = null;
		this.content = null;
		this.id = null;
		this.name = null;
		this.className = null;
		this.driver = null;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getclassName() {
		return className;
	}
	public void setclassName(String className) {
		this.className = className;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public PageOps naviTo(String url){
		driver.get(url);
		return this;
	}
	public PageOps inputById(String id,String content){
		driver.findElement(By.id(id)).sendKeys(content);
		return this;
	}
	public PageOps inputByName(String name,String content){
		driver.findElement(By.name(name)).sendKeys(content);
		return this;
	}
	public PageOps inputByClass(String className,String content){
		driver.findElement(By.className(className)).sendKeys(content);
		return this;
	}
	public PageOps justClick(String content,int n){
		List<WebElement> welist = driver.findElements(By.xpath("//*[contains(text(),'"+content+"')]"));
//		System.out.println(welist.get(0).getText().toString());
		if(n < welist.size()){
			System.out.println("click:"+welist.get(n).getText().toString());
			welist.get(n).click();
		}
		return this;
	}
	public void confirm(String id){
		driver.findElement(By.id(id)).click();
	}
	public void confirmByClass(String className){
		driver.findElement(By.className(className)).click();
	}
	public void alertAccept(){
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void alertDismiss(){
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
}
