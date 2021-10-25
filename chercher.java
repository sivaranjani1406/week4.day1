package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chercher {

	public static void main(String[] args) {
	
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		driver.get(" https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		driver.manage().window().maximize();
		
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		
		driver.switchTo().frame(frame1);
		
		
		driver.findElement(By.xpath("//b[@id='topic']/following::input[1]")).sendKeys("Test");
		
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		
		driver.switchTo().frame(frame3);
		
		driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']/following::input[1]")).click();
		
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		
		driver.switchTo().frame(frame2);
		
		WebElement animal = driver.findElement(By.xpath("//select[@id='animals']"));
		
		Select obj=new Select(animal);
		
		obj.selectByValue("babycat");
		

	}

}
