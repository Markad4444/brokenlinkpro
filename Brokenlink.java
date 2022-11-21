package pkga1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brokenlink {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement accountbtn=driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));

		Actions act= new Actions(driver);
		act.moveToElement(accountbtn).build().perform();
		WebElement signinbtn = driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']/a"));
		act.moveToElement(signinbtn).click().build().perform();
		
		driver.findElement(By.id("ap_email")).sendKeys("9049221706");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Flipkart@123");
		driver.findElement(By.id("signInSubmit")).click();
		List<WebElement> list= driver.findElements(By.tagName("a"));
		int totallink=list.size();
		System.out.println(totallink);
		int brokenlink=0;
		int validlink=0;
		for(WebElement eachlink: list)
		{
			
			 String hreflink=eachlink.getAttribute("href");
			 Thread.sleep(2000);
			 //System.out.println(hreflink);
			 if(hreflink!=null)
			 {
			 URL url = null;
			try {
				url = new URL(hreflink);
			} catch (MalformedURLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			 HttpURLConnection conn = null;
			try {
				conn = ( HttpURLConnection)url.openConnection();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				conn = ( HttpURLConnection)url.openConnection();
			}
			 try {
				conn.connect();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				conn.connect();

			}
			 int response = 0;
			try {
				response = conn.getResponseCode();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response = conn.getResponseCode();

			}
			 if(response>=400)
			 {
				 System.out.println(hreflink+" is broken link");
				 brokenlink ++;
			 }
			 else
			 {
				 System.out.println(hreflink+" is valid link");
				 validlink ++;
			 }
			 }
			 }
		System.out.println("total brolen link "+brokenlink );
		System.out.println("total brolen link "+validlink );

		Thread.sleep(5000);
		driver.quit();
		

		
		
	}

}
