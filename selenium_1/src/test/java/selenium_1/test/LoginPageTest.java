package selenium_1.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import selenium_1.base.Base;
import selenium_1.page.HomePage;
import selenium_1.page.LoginPgae;
import selenium_1.util.Utility;

public class LoginPageTest extends Base{

	LoginPgae loginpage;
	Utility util;
	String sheetname="Sheet1";
	LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		launch();
		loginpage=new LoginPgae();
		util=new Utility();
	}
	@DataProvider(name = "data")
	public Object[][] getdata() throws IOException{
		Object[][] data=util.getExcelData(sheetname);
		return data;
	}
	
	@Test(dataProvider ="data" )
	public void loginTest(String username,String password) throws InterruptedException {
		HomePage homepage= loginpage.login(username, password);
		Thread.sleep(2000);
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
