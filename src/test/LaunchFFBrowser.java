package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFFBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Launch Browser
		System.setProperty("WebDriver.gecko.driver", "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		// open simplilearn.com
		driver.navigate().to("https://www.simplilearn.com");
		
		// maximize window
		driver.manage().window().maximize();
		
		// wait for some time
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		//close windows
		driver.close();
	}

}
