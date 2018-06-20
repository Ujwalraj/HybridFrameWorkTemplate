package pageFactory;

import org.testng.Assert;

import initializer.PageInitializer;

public class TestPageObjects extends PageInitializer{
	
	public void assertTitle(String title) throws InterruptedException {
		//extentTest.get().log(Status.INFO, "Verify Page Title as " + title);
		//logger = Logger.getLogger("Check Page Title");
		//logger.info("Assert Title:" + title);
		Assert.assertEquals(getDriver().getTitle().trim(), title.trim(), "Invalid title");
		Thread.sleep(3000);
	}	

}
