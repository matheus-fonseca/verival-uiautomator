package br.unb.vvs.uiautomator;

//Device used to implement this test: Samsung Galaxy S3- Android version 4.3, CyanogenMod
//Import the uiautomator libraries
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Test04_callEmergencyNumbers extends UiAutomatorTestCase {

	public void callEmergencyNumbersTest() throws UiObjectNotFoundException {

		// Simulate a short press on the HOME button.
		// getUiDevice().pressHome();

		UiObject emergencyCall = new UiObject(
				new UiSelector().text("CHAMADA DE EMERGÊNCIA"));

		emergencyCall.click();

		UiObject zero = new UiObject(new UiSelector().description("zero"));
		UiObject one = new UiObject(new UiSelector().description("um"));
		UiObject two = new UiObject(new UiSelector().description("dois"));
		UiObject nine = new UiObject(new UiSelector().description("nove"));

		// Calling the police
		one.click();
		nine.click();
		zero.click();

		UiObject call = new UiObject(new UiSelector().description("discar"));
		call.click();

		// Finishing the call
		UiObject endCall = new UiObject(
				new UiSelector().description("Finalizar"));
		endCall.click();

		// Simulate a short press on the HOME button.
		// getUiDevice().pressHome();

		emergencyCall.click();

		// Calling the fireman
		one.click();
		nine.click();
		two.click();
		call.click();

		// Finishing the call
		endCall.click();

	}

}
