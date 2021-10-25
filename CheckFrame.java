package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckFrame {

	public static void main(String[] args) throws Exception {
		
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		driver.get("http://leafground.com/pages/frame.html");
		
		driver.manage().window().maximize();
		
		WebElement frame1 = driver.findElement(By.xpath("//div[@id='wrapframe']/iframe"));
		
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		
		File dst= new File("./snap/pic1.png");
		
		FileUtils.copyFile(screenshotAs, dst);
		
		driver.switchTo().defaultContent();
		
		int size = driver.findElements(By.tagName("iframe")).size();
		
		System.out.println("size "+size);

	}

}
