package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;

public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public Properties OR = new Properties();

	public WebDriver getDriver() {
		return driver.get();
	}

	public void loadData() throws IOException {
		File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\config\\config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);
		log.info("Loaded file :"+f);

	}
	
	@BeforeTest
	@Parameters(value = { "URL", "Browser", "RemoteUrl" })
	public void initialSetup(String url, String browser, String remoteUrl) throws MalformedURLException,IOException {
		loadData();
		log.info("Loading files");
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		log.info("Log 4j properties configured. ");
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setBrowserName(browser);
		log.info("Browser used for execution is :"+browser);
		desiredCapabilities.setJavascriptEnabled(true);
		desiredCapabilities.setPlatform(Platform.ANY);
		driver.set(new RemoteWebDriver(new URL(remoteUrl), desiredCapabilities));
		getDriver().get(url);
		log.info("Navigating to the URL :"+url);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeBrowser() {
		log.info("Closing the browser. ");
		getDriver().quit();
	}

}
