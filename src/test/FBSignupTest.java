package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignupTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		// click on create new account
		WebElement signUp = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		signUp.click();

		// enter first name
		WebElement fName = driver.findElement(By.xpath("//input[@name='firstname']"));
		fName.sendKeys("John");

		// enter surname
		WebElement lName = driver.findElement(By.xpath("//input[@name='lastname']"));
		lName.sendKeys("White");

		// enter mobile number
		WebElement mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		mobile.sendKeys("9999999999");

		// enter password
		WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		password.sendKeys("Abcd@12345");

		// print the default selected date of birth
		WebElement selectedDate = driver.findElement(By.xpath("//select[@name='birthday_day']/option[@selected='1']"));
		WebElement selectedMonth = driver
				.findElement(By.xpath("//select[@name='birthday_month']/option[@selected='1']"));
		WebElement selectedYear = driver.findElement(By.xpath("//select[@name='birthday_year']/option[@selected='1']"));
		System.out.println("The default selected date is " + selectedDate.getText() + "-" + selectedMonth.getText()
				+ "-" + selectedYear.getText());

		// select date of birth from dropdown list

		WebElement drpDate = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select ddDay = new Select(drpDate);
		ddDay.selectByVisibleText("10");
		// ddDay.selectByValue("10");

		// select month of birth from dropdown list

		WebElement drpMonth = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select ddMonth = new Select(drpMonth);
		ddMonth.selectByVisibleText("Jan");

		// select year of birth from dropdown list
		WebElement drpYear = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select ddYear = new Select(drpYear);
		ddYear.selectByVisibleText("2000");

		// print the dropdown list
		List<WebElement> list = driver.findElements(By.xpath("//select[@title='Month']/option"));
		System.out.println("Available months in dropdown list :");
		for (WebElement month : list) {
			System.out.println(month.getText());

			String Gender = "Male";
			String dummyXpath = "//label[text()='kuch_bhi']";
			String ActualXpath = dummyXpath.replace("kuch_bhi", Gender);

			// String ActualXpath = "//label[text()='" + Gender + "']";

			WebElement genderElem = driver.findElement(By.xpath(ActualXpath));
			genderElem.click();

		}

	}

}
