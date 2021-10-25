package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Servicenow {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		driver.get("http://dev95455.service-now.com");
		
		driver.manage().window().maximize();
		
		WebElement homepage = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));

		driver.switchTo().frame(homepage);

		//driver.findElement(By.xpath("//button[text()='Try it']")).click();
	
		driver.findElement(By.xpath("//label[text()='User name']/following::input[1]")).click();
		driver.findElement(By.xpath("//label[text()='User name']/following::input[1]")).sendKeys("admin");
		driver.findElement(By.xpath("//label[text()='Password']/following::input[1]")).click();
		driver.findElement(By.xpath("//label[text()='Password']/following::input[1]")).sendKeys("jYRf7qYrDwC4");
		
		driver.findElement(By.id("sysverb_login")).click();
		
		driver.findElement(By.xpath("//label[text()='Filter navigator']/following::input[1]")).
		sendKeys("incident",Keys.DOWN.ENTER);
		
		driver.findElement(By.xpath("//span[text()='Incident']/following::div[text()='All'][1]")).click();
	
		WebElement incident = driver.findElement(By.xpath("	//iframe[@id='gsft_main']"));

		driver.switchTo().frame(incident);
		
		driver.findElement(By.xpath("//button[text()='New']")).click();
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(15));
		
		WebElement caller = driver.findElement(By.xpath("//span[text()='Caller']/following::input[@id='sys_display.incident.caller_id']"));
		
		wait.until(ExpectedConditions.visibilityOf(caller));
		
		caller.sendKeys("abel.tuter@example.com",Keys.DOWN.ENTER);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Caller']/following::input[@id='incident.short_description']")).
		sendKeys("Issue with a web page",Keys.DOWN.ENTER);
		
		String incidentnumber = driver.findElement(By.xpath("//span[text()='Number']/following::input[@id='incident.number']")).getAttribute("value");
		
		System.out.println("Noted incident number"+incidentnumber);
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Press Enter from within the input to submit the search.']/following::input[1]")).
		sendKeys(incidentnumber,Keys.DOWN.ENTER);
		
		String text = driver.findElement(By.xpath("//table[@id='incident_table']//tr[1]/td[3]/a")).getText();
		
		System.out.println("Received Incident number" + text);
		
		if(incidentnumber.equals(text))
		{
			System.out.println("Both incidents are same");
		}
		else
			System.out.println("Both Incidents are not same");
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		
		File dst= new File("./snap/pic1.png");
		
		FileUtils.copyFile(screenshotAs, dst);
		
		
		
		
	}

}
