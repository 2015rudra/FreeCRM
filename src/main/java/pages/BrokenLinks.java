package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;

public class BrokenLinks {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rudra\\OneDrive\\Desktop\\FreeCRM_Selenium\\src\\main\\java\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

        driver.get("https://www.hubspot.com/products/crm");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println("Total links: " + links.size());

        for (WebElement link : links) {

            String href = link.getAttribute("href");

            // Skip links without href
            if (href == null || href.isEmpty()) {
                System.out.println("Broken/Invalid link: href is missing");
                continue;
            }

            // Skip anchors, javascript, mailto, etc.
            if (href.startsWith("#") ||
                href.startsWith("javascript:") ||
                href.startsWith("mailto:")) {
                continue;
            }

            try {
                HttpURLConnection connection =
                        (HttpURLConnection) URI.create(href).toURL().openConnection();

                connection.setRequestMethod("HEAD");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);

                int responseCode = connection.getResponseCode();

                if (responseCode >= 400) {
                    System.out.println(
                        "BROKEN: " + href + " --> " + responseCode
                    );
                } else {
                    System.out.println(
                        "VALID: " + href + " --> " + responseCode
                    );
                }

                connection.disconnect();

            } catch (Exception e) {
                System.out.println(
                    "ERROR: " + href + " --> " + e.getMessage()
                );
            }
        }

        driver.quit();
    }
	}

