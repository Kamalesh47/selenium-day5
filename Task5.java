package day5;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task5 {
	public static void main(String[]args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        
        driver.findElement(By.name("q")).sendKeys("Apple");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        String parent = driver.getWindowHandle();
        
        System.out.println(parent);
        System.out.println(driver.getTitle());
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        System.out.print("\n"+driver.getWindowHandle());
        
        System.out.println("\n"+driver.getTitle());
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        
        driver.findElement(By.name("q")).sendKeys("Cucumber");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        System.out.print("\n"+driver.getWindowHandle());
        
        System.out.println("\n"+driver.getTitle());
        Set<String>s = driver.getWindowHandles();
        System.out.println("Number of Windows opened="+s.size());
	}    
}