package br.unb.vvs.uiautomator;

//Device used to implement this test: Samsung Galaxy S3- Android version 4.3, CyanogenMod
//Import the uiautomator libraries
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Test02_40SequencedCalls extends UiAutomatorTestCase {
	public void setUp() {
		String output = "\nTest " + this.getName().substring(4) + "() ";
		System.out.println(output);
		// Simulate a short press on the HOME button.
		getUiDevice().pressHome();
	}

	public void test40SequencedCalls() throws UiObjectNotFoundException,
			InterruptedException {
		
		// Create the buttonObject called Telefone
		UiObject phone = new UiObject(new UiSelector().packageNameMatches("com.cyanogenmod.trebuchet").classNameMatches("android.widget.TextView").index(0));

		// Simulate a click to enter the Telefone numbers screen.
		phone.click();

		// Creating the numberObjects
		UiObject zero = new UiObject(new UiSelector().description("zero"));
		UiObject two = new UiObject(new UiSelector().description("dois"));
		UiObject three = new UiObject(new UiSelector().description("três"));
		UiObject seven = new UiObject(new UiSelector().description("sete"));
		UiObject eight = new UiObject(new UiSelector().description("oito"));
		UiObject nine = new UiObject(new UiSelector().description("nove"));
		UiObject call = new UiObject(new UiSelector().description("discar"));
		UiObject finalize = new UiObject(new UiSelector().description("Finalizar"));


		//Calling the number 9090-82372882 40 times
		for(int i=0;i<41;i++){

			// Simulate a short press on the HOME button.
			getUiDevice().pressHome();
			phone.click();
			
			nine.click();
			zero.click();
			nine.click();
			zero.click();
			eight.click();
			two.click();
			three.click();
			seven.click();
			two.click();
			eight.click();
			eight.click();
			two.click();
			
			call.click();
			this.sleep(2000);
			finalize.click();			

		}
		
	
		

	}

}
