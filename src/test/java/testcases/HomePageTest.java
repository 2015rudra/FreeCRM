package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testBase.TestBase;

public class HomePageTest extends TestBase
{

	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() throws IOException 
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws IOException 
	{
		initilization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	/*
	 * @Test public void HomePageTest1() { String actualTitle =
	 * homePage.getHomePageTitle(); Assert.assertEquals( actualTitle , "CRM"); }
	 * 
	 * 
	 * @Test public void HomePageTest2() { String actualusername =
	 * homePage.getLoggedInUserName().trim(); Assert.assertEquals(actualusername,
	 * "Rupesh Kadam", "Logged in username doesn't matched"); }
	 */
	@Test
	public void clickOnNewContactCreate() throws IOException 
	{
		homePage.clickContactLink();
	}
	
	@AfterMethod
	public void tearDown() 
	{
		loginPage.logout();
		driver.quit();
	}
	

}
