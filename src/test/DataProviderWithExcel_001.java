package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import profile.GlobalVar;
import profile.env;

import org.testng.annotations.DataProvider;
import utility.ExcelUtils;

public class DataProviderWithExcel_001 {
	
	env env = new env();
	GlobalVar globalVar = new GlobalVar();
	WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
        System.setProperty("webdriver.gecko.driver", globalVar.getDriverPath());
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(env.getURL());
	}

	@Test(dataProvider = "Authentication")
	public void f(String sUserName, String sPassword) {
		LoginPage login = new LoginPage(driver);
		login.setUsername(sUserName);
		login.setPassword(sPassword);
		login.clickLogin();
		login.clickLogout();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@DataProvider
	public Object[][] Authentication() throws Exception {
		ExcelUtils.setExcelFile(globalVar.getDataPath(), "Sheet1");
		sTestCaseName = this.toString();
		sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, 0);
		Object[][] testObjArray = ExcelUtils.getTableArray(globalVar.getDataPath(),
				"Sheet1", iTestCaseRow);
		return (testObjArray);
	}
}
