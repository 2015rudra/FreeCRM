package pages;

import java.io.IOException;

import org.apache.poi.hdgf.chunks.Chunk.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.GlobalThings;
import testBase.TestBase;
import utility.TestUtil;

public class LoginPage extends TestBase

{
	TestUtil util;
	WebDriverWait wait;

	@FindBy(name="email")
	WebElement uname;

	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginButton;
	
	By logoutIcon = By.xpath("//*[@role='listbox']");
	By logoutOption = By.xpath("//*[@class='menu transition visible']//a[4]");
	
	
	
	
	private By loginPanel = By.xpath("//div[@class='ui stacked segment']");
	
	
	public LoginPage() throws IOException 
	{
		super();
		PageFactory.initElements(driver, this);
		util = new TestUtil();
		wait = new WebDriverWait(driver, 30);
	}
	
	
	public String getPageTitle() 
	{
		return driver.getTitle();
	}
	
	public HomePage login(String username, String Password) throws IOException 
	{

		wait.until(ExpectedConditions.visibilityOfElementLocated (loginPanel));
		uname.clear();
		uname.sendKeys(username);
		pwd.clear();
		pwd.sendKeys(Password);
		loginButton.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loginPanel));
		
		return new HomePage();
	}
	
	public void logout() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated (logoutIcon));
		driver.findElement(logoutIcon).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated (logoutOption));
		driver.findElement(logoutOption).click();
	}
	
	
	

}
