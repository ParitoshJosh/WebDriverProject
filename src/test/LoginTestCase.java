package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Step1- Launch Chrome Browser and open simplilearn website
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");

		// Step2- Maximise the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MICROSECONDS);

		// Step3- Click on the login link in top right corner
		System.out.println("The title of the page is " + driver.getTitle());

		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		String location = LoginLink.getAttribute("href");
		System.out.println("The link will take you to " + location);
		LoginLink.click();

		// Step4- Enter the UserName
		WebElement userName = driver.findElement(By.name("user_login"));
		userName.sendKeys("abcd@xyz.com");

		// Step5- Enter the password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Abcd@12345");

		// Step6 - Check the remember me checkbox

		WebElement rememberMe = driver.findElement(By.className("rememberMe"));
		rememberMe.click();

		// Step7- Click on the login button
		WebElement loginBtn = driver.findElement(By.name("btn_login"));
		loginBtn.click();

		// Step8- Validate the login was unsuccessful
				WebElement error = driver.findElement(By.className("error_msg"));
		String errorMsg = error.getText();
		String expErrorMsg = "The email or password you have entered is invalid.";

		if (error.isDisplayed() && errorMsg.equals(expErrorMsg)) {
			System.out.println("TC Passed");
		} else {
			System.out.println("TC Failed");
		}
		
		//Step9- Count total number of links
		List<WebElement> AllLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total No of links " + AllLinks.size());

		//Step10- Print all links
		for(WebElement Link: AllLinks) {
			System.out.println(Link.getAttribute("href"));
		}
		// Step11- Close the browser
		driver.close();

	}

}
