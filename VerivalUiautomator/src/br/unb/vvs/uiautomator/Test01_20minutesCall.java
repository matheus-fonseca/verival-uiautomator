package br.unb.vvs.uiautomator;
//Device used to implement this test: Samsung Galaxy Note 2- Android version 4.1

// Import the uiautomator libraries
import static br.unb.vvs.uiautomator.StringGetter.getString;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Test01_20minutesCall extends UiAutomatorTestCase {

	public void setUp() {
		String output = "\nTeste " + this.getName().substring(4) + "() ";
		System.out.println(output);
		getUiDevice().pressHome();
	}
	
	public void test20MinutesCall() throws UiObjectNotFoundException,
			InterruptedException {

		// Create the buttonObject called Telefone
		UiObject phone = new UiObject(new UiSelector().text(getString("phone")));

		// Simulate a click to enter the Telefone numbers screen.
		phone.click();

		// Creating the objects
		UiObject eight = new UiObject(new UiSelector().description(getString("eight")));
		UiObject three = new UiObject(new UiSelector().description(getString("three")));
		UiObject four = new UiObject(new UiSelector().description(getString("four")));
		UiObject seven = new UiObject(new UiSelector().description(getString("seven")));
		UiObject call = new UiObject(new UiSelector().description(getString("call")));

		// Calling the number 83438877 and waiting 20minutes
		eight.click();
		three.click();
		four.click();
		three.click();
		eight.click();
		eight.click();
		seven.click();
		seven.click();
		call.click();
		try {
			this.sleep(180000);
			UiObject endCall = new UiObject(new UiSelector().text(getString("endCall")));
			endCall.click();
		} catch (Exception e) {
			fail("");
		}
	}
}
