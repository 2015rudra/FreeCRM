package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testBase.TestBase;

public class LoginPageTest extends TestBase

{

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() throws IOException 
	{
		super();
		
	}

	
	@BeforeMethod
	public void setup() throws IOException 
	{
		initilization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	
	
	
	  @Test public void TestCase1() throws IOException 
	  { 
		  homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	  }
	 
	
	@Test
	public void TestCase2() 
	{
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(actualTitle, "Cogmento CRM", "Title din't matched");
	}
	
	
	@AfterMethod
	public void tearDown() 
	{
//		loginPage.logout();
		driver.quit();
	}
}
