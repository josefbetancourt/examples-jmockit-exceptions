package com.octodecillion.examples.jmockit_exceptions;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Verifications;

/**
 * Unit test for simple App.
 */
public class AppTest{
	/**
	 * 
	 * @param mockLogger Logger object that will be behaviorally mocked.
	 */
	@Test
    public void shouldLogAtLevelSevere(@Mocked final Logger mockLogger)
    {
		/**
		 * state-based mock of collaborator ShoppingSvc
		 */
		new MockUp<ShoppingSvc>() {
    		@Mock
    		public String getProductName(int id) throws IOException{
    			throw new IOException("Forced exception for testing");
    		}
    		
		};
		
		// the CUT	
    	final App app = new App();

    	// what we expect to be invoked
    	new Expectations() {{
			mockLogger.log(Level.SEVERE,anyString); 
		}};
		
		app.getProduct(123); // actual invocation
		
		// verify that we did invoke the expected method of collaborator
		new Verifications(){{
			mockLogger.log(Level.SEVERE, anyString);  // we logged at level SEVERE
		}};
    }
}
