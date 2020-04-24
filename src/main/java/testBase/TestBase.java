package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.TestUtil;

public class TestBase 
{

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException 
	{

		try 
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Practise\\CucumberPOM\\src\\main\\java\\Config\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch(IOException e) 
		{
			e.printStackTrace();
		}


	}
	
	public static void initilization() 
	{
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.contentEquals("chrome")) 
		{
			System.setProperty("webdriver.chrome.silentOutput","true");
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Chrome\\Chrome81\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut, TimeUnit.SECONDS);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
