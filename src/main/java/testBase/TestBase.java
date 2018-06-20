package testBase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;

public class TestBase {

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public WebDriver getDriver() {
		return driver.get();
	}

	@BeforeTest
	@Parameters(value = { "URL", "Browser", "RemoteUrl" })
	public void initialSetup(String url, String browser, String remoteUrl) throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setBrowserName(browser);
		desiredCapabilities.setJavascriptEnabled(true);
		desiredCapabilities.setPlatform(Platform.ANY);
		driver.set(new RemoteWebDriver(new URL(remoteUrl), desiredCapabilities));
		getDriver().get(url);
		getDriver().manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser() {
		getDriver().quit();
	}

}
