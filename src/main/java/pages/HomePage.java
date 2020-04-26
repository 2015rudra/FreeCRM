package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.GlobalThings;
import testBase.TestBase;
import utility.TestUtil;

public class HomePage extends TestBase
{
	
	TestUtil util;
	WebDriverWait wait;
	
	
//	By loggedUsername = By.xpath("//span[@class='user-display']");
	
//	By contactLink = By.xpath("//a//*[contains(text(),'Contacts')]");
	
	@FindBy(xpath="//a//*[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement loggedUsername;
	
	
	
	

	public HomePage() throws IOException 
	{
		super();
		PageFactory.initElements(driver, this);
		util = new TestUtil();
	}
	
	public String getHomePageTitle() 
	{
		return driver.getTitle();
	}
	
	public String getLoggedInUserName() 
	{
		TestUtil.waitForAnObject(driver, loggedUsername, GlobalThings.minWait);
		return loggedUsername.getText();
	}

	
	public ContactPage clickContactLink() throws IOException 
	{
		TestUtil.waitForAnObject(driver, contactLink, GlobalThings.minWait);
		contactLink.click();
		return new ContactPage();
	}
	
	
}
