package pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		
		dr.get("https://www.flipkart.com/search?sid=czl&otracker=CLP_Filters&p%5B%5D=facets.serviceability%5B%5D%3Dtrue&p%5B%5D=facets.brand%255B%255D%3DSamsung");
		dr.manage().window().maximize();
		
		List<WebElement> list = dr.findElements(By.xpath("//*[@class='_1vC4OE _2rQ-NK']"));
		int count = list.size();
		
		for (int i=0;i<count;i++) 
		{
			a.add(list.get(i).getText().substring(1).replaceAll(",", ""));
			
			int price = Integer.parseInt(a.get(i));
			System.out.println(price);
			
			b.add(price);
		}
				
		int maxValue = Collections.max(b);
		System.out.println("-------------------------------------------");
		System.out.println(maxValue);
		
		dr.quit();

	}

}
