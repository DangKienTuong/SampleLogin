package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
    private WebElement weUserID;
    @FindBy(name="password")
    private WebElement wePassWord;
    @FindBy(name="btnLogin")
    private WebElement btnLogin;
    @FindBy(xpath="//*[text()='Log out']")
    private WebElement btnLogout;

	public void Login(String userID, String passWord) {
		weUserID.sendKeys(userID);
		wePassWord.sendKeys(passWord);
		btnLogin.click();
	}
	
	public void Logout() {
		btnLogout.click();
	}
	
}
