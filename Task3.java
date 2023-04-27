package day5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(co);
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        
        WebElement fname=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
		fname.sendKeys("401");
		WebElement submit_btn=driver.findElement(By.name("submit"));
		submit_btn.click();
		Alert alert1=driver.switchTo().alert();
		alert1.dismiss();
		Thread.sleep(3000);
		fname.clear();
		fname.sendKeys("402");
	    submit_btn.click();
	    Alert alert2=driver.switchTo().alert();
	    alert2.accept();
	    Thread.sleep(3000);
	    Alert alert3=driver.switchTo().alert();
	    String txt=alert3.getText();
	    alert3.accept();
	}

}