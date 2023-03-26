package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Step1- Launch Chrome Browser and open facebook website
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		// Step2- Maximise the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MICROSECONDS);

		// Step3- Enter the UserName
		WebElement userName = driver.findElement(By.id("email"));
		userName.sendKeys("abcd@xyz.com");

		// Step4- Enter the password
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("Abcd@12345");

		// Step5- Click on the login button
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();

		

		driver.close();
	}

}
