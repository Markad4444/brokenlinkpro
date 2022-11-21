package pkga1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Totestwebtable {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
WebDriver driver= new ChromeDriver();

driver.get("https://www.w3schools.com/html/html_tables.asp");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
/*List<WebElement> listrow=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
int rowsize=listrow.size();
System.out.println("no of rows in table "+rowsize);
List<WebElement> listcoloumn=driver.findElements(By.xpath("//table[@id='customers']//tr/th"));
int coloumnsize=listcoloumn.size();
System.out.println("no of coloumn in table "+coloumnsize);*/

/*WebElement firstlistrowattribute=driver.findElement(By.xpath("//table[@id='customers']//th[1]"));
System.out.println(firstlistrowattribute.getText());
List<WebElement> firstlistrow=driver.findElements(By.xpath("//table[@id='customers']//td[1]"));
List<WebElement> firstlistcoloumn=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td"));*/
int count=0;

for(int i=1;i<=7;i++)
{
for(int j=1;j<=3;j++)
{ if(i==1)
{
	WebElement firsttworow=driver.findElement(By.xpath("//table[@id='customers']//tr["+i+"]//th["+j+"]"));
	String text=firsttworow.getText();
	System.out.println(text+" ");
}
else
{
WebElement firsttworow1=driver.findElement(By.xpath("//table[@id='customers']//tr["+i+"]//td["+j+"]"));
String text1=firsttworow1.getText();
System.out.println(text1+" ");
count++;
}
}
}
System.out.println("data count"+count);






Thread.sleep(8000);
driver.quit();
	}

}
