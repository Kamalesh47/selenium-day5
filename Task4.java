package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task4 {

public static void main(String[] args) throws InterruptedException
{
	WebDriverManager.chromedriver().setup();
	ChromeOptions co = new ChromeOptions();
co.addArguments("--remote-allow-origins=*");
WebDriver driver = new ChromeDriver(co);
driver.get("https://www.abhibus.com/bus-ticket-booking");
driver.manage().window().maximize();
WebElement from = driver.findElement(By.xpath("//*[@id=\"source\"]"));
from.sendKeys("Coimbatore");
Thread.sleep(3000);
from.sendKeys(Keys.ENTER);
WebElement to = driver.findElement(By.xpath("//*[@id=\"destination\"]"));
to.sendKeys("Madurai");
Thread.sleep(3000);
to.sendKeys(Keys.ENTER);
WebElement date = driver.findElement(By.xpath("//*[@id=\"datepicker1\"]"));
date.click();
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("arguments[0].setAttribute('value','28-04-2023')", date);
WebElement search = driver.findElement(By.xpath("//*[@id=\"seo_search_btn\"]"));
search.click();
}

}