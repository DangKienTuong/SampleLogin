package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By username = By.name("uid");
	By pass = By.name("password");
	By loginBtn = By.name("btnLogin");
	By logOutBtn = By.xpath("//*[text()='Log out']");

	public void Login(String userID, String passWord) {
		driver.findElement(username).sendKeys(userID);
		driver.findElement(pass).sendKeys(passWord);
		driver.findElement(loginBtn).click();
	}
	
	public void Logout() {
		driver.findElement(logOutBtn).click();
	}
	
}
