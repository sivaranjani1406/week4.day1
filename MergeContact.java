package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement findElement = driver.findElement(By.id("username"));
		findElement.sendKeys("Demosalesmanager");

		WebElement findElement2 = driver.findElement(By.id("password"));
		findElement2.sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::img[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> lst= new ArrayList<String>(windowHandles);
		
		
		driver.switchTo().window(lst.get(1));
		
		String text = driver.findElement(By.xpath("//a[@class='linktext'][1]")).getText();
		
		System.out.println(text);
		
		driver.close();
		
		driver.switchTo().window(lst.get(0));
		
		driver.findElement(By.xpath("//input[@id='ComboBox_partyIdFrom']")).click();
		
		driver.findElement(By.xpath("//input[@id='ComboBox_partyIdFrom']")).sendKeys(text);
		
		driver.findElement(By.xpath("//input[@id='ComboBox_partyIdFrom']")).sendKeys(Keys.DOWN.ENTER);
		
		
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img[1]")).click();
		

		
		List<String> lst1= new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(lst1.get(1));
		
	String text2=driver.findElement(By.xpath("//span[text()='Contact List']/following::table[3]/tbody/tr[1]/td[1]")).getText();
		
		System.out.println(text2);

		driver.close();
		
		
	driver.switchTo().window(lst1.get(0));
		
		driver.findElement(By.xpath("//input[@id='ComboBox_partyIdTo']")).click();
		
		driver.findElement(By.xpath("//input[@id='ComboBox_partyIdTo']")).sendKeys(text2);
		
	driver.findElement(By.xpath("//input[@id='ComboBox_partyIdTo']")).sendKeys(Keys.DOWN.ENTER);
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
	
		
	}

}
