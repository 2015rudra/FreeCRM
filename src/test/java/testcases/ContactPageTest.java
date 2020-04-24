package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;
import testBase.TestBase;
import utility.TestUtil;

public class ContactPageTest extends TestBase 
{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	TestUtil util;

	public ContactPageTest() throws IOException 
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException 
	{
		initilization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactPage = new ContactPage();
//		util = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = homePage.clickContactLink();
		
	}
	
	
	@DataProvider
	public Object[][] getCreateContactTestData() 
	{
		 Object data[][] = TestUtil.getTestData("contactTestData");
		return data;
	}
	
	
	
	  @Test(dataProvider = "getCreateContactTestData", priority=1) 
	  public void contact001(String fname, String lname) throws InterruptedException {
	  contactPage.clickNewButtonToCreateNewContact();
	  contactPage.createNewContact(fname, lname); }
	 
	 
	/*
	 * @Test(priority=2) public void contact002() throws InterruptedException {
	 * contactPage.deleteContacts(); }
	 */
	
	
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}

	
}
