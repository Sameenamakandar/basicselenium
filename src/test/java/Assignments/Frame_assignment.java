package Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame_assignment {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//open the url
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index?overview-summary.html");
		//fetch the address of first frame
		WebElement frame1=driver.findElement(By.xpath("//div[@class='leftTop']"));
		//create object for actions
		Actions a=new Actions(driver);
		//mouse over to frame1
		a.moveToElement(frame1).perform();
		//switching to the frame by frame name
		driver.switchTo().frame("packageListFrame");
		//performing actions on first frame
		driver.findElement(By.xpath("//a[text()='org.openqa.selenium']")).click();
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		
		//switch control to frame 2
		WebElement frame2=driver.findElement(By.xpath("//div[@class='leftBottom']"));
		Actions a1=new Actions(driver);
		a1.moveToElement(frame2).perform();
		driver.switchTo().frame("packageFrame");
		//perform actions on frame 2
		driver.findElement(By.xpath("//span[contains(text(),'WebDriver')][1]")).click();
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		
		//fetch the address of frame 3
        WebElement frame3=driver.findElement(By.xpath("//div[@class='rightContainer']"));
        Actions a2=new Actions(driver);
        a2.moveToElement(frame3).perform();
        driver.switchTo().frame("classFrame");
        //perform actions on frame 3
        driver.findElement(By.xpath("//a[text()='Help']")).click();
		
	}

}
