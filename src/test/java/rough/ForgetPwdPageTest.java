package rough;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForgetPwdPageTest {
	public static String TEST_RUN_ID = "74";
	public static String TESTRAIL_USERNAME = "abc@xyz.com";
	public static String TESTRAIL_PASSWORD = "Varun@3456699";
	public static String RAILS_ENGINE_URL = "https://absx.testrail.io/";
	public static final int TEST_CASE_PASSED_STATUS = 1;
	public static final int TEST_CASE_FAILED_STATUS = 5;
	WebDriver driver;
	String expected;
	String actual;
	
	@BeforeClass
	public void start() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ujwalrajshekar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.unilogcorp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='LOGIN']")).click();
		driver.findElement(By.xpath("//div/a[text()='Forgot Your Password?']")).click();
		
	}
	
	@Test
	public void forgetPageUrlTest() {
		expected = "https://unilog.force.com/Community/secur/forgotpassword.jsp?locale=us";
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void forgetPageTitle() {
		expected = "Forgot Your Password | Unilog Customer Community";
		actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void forgetPwdPageFieldLabelTest() {
		actual = driver.findElement(By.xpath("//div/label[text()='Username']")).getText();
		expected = "Username";
		Assert.assertEquals(actual, expected);
	}
	
	@AfterClass
	public void end() {
		driver.quit();
	}

}
