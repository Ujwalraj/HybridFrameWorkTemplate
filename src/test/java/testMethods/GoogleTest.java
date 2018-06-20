package testMethods;

import java.util.logging.Logger;

import org.testng.annotations.Test;

import initializer.PageInitializer;

public class GoogleTest extends PageInitializer {
	
	public Logger log = Logger.getLogger(GoogleTest.class.getName());

	@Test
	public void testing1() throws InterruptedException {
		log.info("Test case started");
		testPage().assertTitle("Google");
		log.info("Test case Title verified");
		log.info(" Test Case ended");
	}

}
