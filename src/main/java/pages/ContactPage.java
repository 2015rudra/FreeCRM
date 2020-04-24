package pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.io.IOException;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import config.GlobalThings;
import testBase.TestBase;
import utility.TestUtil;

public class ContactPage extends TestBase{

	
	TestUtil util;
	WebDriverWait wait;
	
	
	
	
//	By newContactButton = By.xpath("//a//*[contains(text(),'New')]");
	@FindBy(xpath="//a//*[contains(text(),'New')]")
	WebElement newContactButton;
	
	
	
	  @FindBy(name="first_name") 
	  WebElement firstName;
	  
	  By name = By.name("first_name");
	 
	
//	By firstName = By.name("first_name");
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//a//*[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	
	@FindBy(xpath="//*[@class='ui right secondary pointing menu toolbar-container']//div//button[2]")
	WebElement saveContactButton;
	
	@FindBy(xpath="//p[contains(text(),'No records found')]")
	WebElement noRecordFound;
	
	
	  @FindBy(xpath="//div[@class='ui tiny modal transition visible active']//button[2]")
	  WebElement contactDeleteConfirmationButton;
	 
	
//	By contactDeleteConfirmationButton = By.xpath("//div[@class='ui tiny modal transition visible active']//button[2]");
	
	public ContactPage() throws IOException 
	{
		super();
		PageFactory.initElements(driver, this);
		util = new TestUtil();
		
		
	}
	
	public void clickNewButtonToCreateNewContact() 
	{
		TestUtil.waitForAnObject(driver, newContactButton, GlobalThings.minWait);
		newContactButton.click();
	}
	
	public void createNewContact(String fname, String lname) throws InterruptedException 
	{
		String contactName = "";
		
		TestUtil.waitForAnObject(driver, firstName, GlobalThings.minWait);
		
//		boolean aa = firstName.isDisplayed();
		
		/*
		 * boolean displayed = false; do{
		 * 
		 * if(aa==false) { driver.navigate().refresh(); Thread.sleep(7000); } try{
		 * displayed = driver.findElement(By.name("first_name")).isDisplayed(); } catch
		 * (NoSuchElementException e){ driver.navigate().refresh(); } }
		 * while(!displayed);
		 */
		
		/*
		 * do { driver.navigate().refresh(); Thread.sleep(4000); }
		 * while(!driver.findElement(name).isDisplayed());
		 */
		
		
		
		
		
		/*
		 * boolean displayed = false; do{ driver.navigate().refresh();
		 * Thread.sleep(7000); try{ displayed =
		 * driver.findElement(By.name("first_name")).isDisplayed(); } catch
		 * (NoSuchElementException e){ driver.navigate().refresh(); } }
		 * while(!displayed);
		 */
		
		
		
		if(firstName.isDisplayed()) 
		{
			Thread.sleep(4000);
			firstName.sendKeys(fname);
			lastName.sendKeys(lname);
			TestUtil.waitForAnObject(driver, saveContactButton, GlobalThings.minWait);
			if(saveContactButton.isDisplayed()) 
			{
				saveContactButton.click();
			}
			else 
			{
				Assert.fail("Save button not displayed.");
			}
			
//			contactLink.click();
		} 
		else 
		{
			Assert.fail("Add Contact page not loaded properly.");
		}
		
		TestUtil.waitForAnObject(driver, driver.findElement(By.xpath("//div[@class='ui header item mb5 light-black']")), GlobalThings.minWait);
		Thread.sleep(5000);
		boolean a = driver.findElement(By.xpath("//div[@class='ui header item mb5 light-black']")).isDisplayed();
		if(a == true) {
		contactName = driver.findElement(By.xpath("//div[@class='ui header item mb5 light-black']")).getText().trim();
		}
		else 
		{
			Assert.fail("username not displayed");
		}
		Assert.assertTrue(contactName.contains(fname), "User not created");
		contactLink.click();
	}
	
	
	public void deleteContacts() throws InterruptedException 
	{
//		List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class='ui fitted read-only checkbox']//*[@type='checkbox']"));
		
//		TestUtil.waitForAnObject(driver, noRecordFound, GlobalThings.minWait);
//		TestUtil.waitForAnObjectToBeInVisible(driver, noRecordFound, GlobalThings.minWait)
		/*boolean b = noRecordFound.isDisplayed();
		if(!(b==true)) 
		{*/
		
		List<WebElement> elementName = driver.findElements(By.xpath("//div[@class='ui fitted read-only checkbox']//*[@type='checkbox']"));
		int count = elementName.size();
		
		for (int i = 1; i<=count;) 
		{
			
				driver.findElement(By.xpath("//table[@class='ui celled sortable striped table custom-grid table-scroll']//tbody//tr["+count+"]//td[@class='right aligned collapsing options-buttons-container']//div//button")).click(); 
//				util.waitForAnObjectToBeVisible(driver, contactDeleteConfirmationButton, GlobalThings.microWait);
				TestUtil.waitForAnObject(driver, contactDeleteConfirmationButton, GlobalThings.microWait);
				
				contactDeleteConfirmationButton.click();
				count--;
		}
		/*
		 * } else { Assert.fail("No Records found to delete"); }
		 */
		}
	
	
	
}
