package initializer;

import org.openqa.selenium.support.PageFactory;

import pageFactory.TestPageObjects;
import testBase.TestBase;

public class PageInitializer extends TestBase {
	
	public TestPageObjects testPage() {
		TestPageObjects testPage = PageFactory.initElements(getDriver(), TestPageObjects.class);
		return testPage;
	}

}
