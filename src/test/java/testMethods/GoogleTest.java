package testMethods;

import org.testng.annotations.Test;

import initializer.PageInitializer;

public class GoogleTest extends PageInitializer {

	@Test
	public void testing1() throws InterruptedException {
		testPage().assertTitle("Google");
	}

}
