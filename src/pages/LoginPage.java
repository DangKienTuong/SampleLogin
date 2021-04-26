package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	By username = By.name("uid");
	By pass = By.name("password");
	By loginBtn = By.name("btnLogin");
	By logOutBtn = By.xpath("//*[text()='Log out']");

	public void setUsername(String userID) {
		driver.findElement(username).sendKeys(userID);
	}

	public void setPassword(String passWord) {
		driver.findElement(pass).sendKeys(passWord);
	}

	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	
	public void clickLogout() {
		driver.findElement(logOutBtn).click();
	}
	
}
