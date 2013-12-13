package br.unb.vvs.uiautomator;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import static br.unb.vvs.uiautomator.StringGetter.*;

public class TestLigaDesligaFuncionalidades extends UiAutomatorTestCase {
	
	public void setUp() {
		String output = "\nTeste " + this.getName().substring(4) + "() ";
		System.out.println(output);
		getUiDevice().pressHome();
	}
	
	public void testLigaDesligaWifi() throws UiObjectNotFoundException {
		UiObject allAppsButton = new UiObject(new UiSelector()
		.description(getString("allApps")));
		
		System.out.println("Entrando nos apps...");
		allAppsButton.clickAndWaitForNewWindow();

		UiObject appsTab = new UiObject(new UiSelector()
		.text(getString("appsTab")));

		appsTab.click();
		
		UiScrollable appViews = new UiScrollable(new UiSelector()
		.scrollable(true));

		appViews.setAsHorizontalList();
		
		System.out.println("Entrando nos settings...");
		UiObject settingsApp = appViews.getChildByText(new UiSelector()
		.className(android.widget.TextView.class.getName()), 
		getString("settingsApp"));
		settingsApp.clickAndWaitForNewWindow();

		UiScrollable settingsList = new UiScrollable(new UiSelector().scrollable(true));
		
		System.out.println("Encontrando o switch do Wi-Fi...");
		UiSelector wifiSelector = new UiSelector().className(android.widget.Switch.class.getName()).instance(0);
		UiObject wifiSwitch = settingsList.getChild(wifiSelector);

		System.out.println("Ligando/Desligando Wi-Fi...");
		if(wifiSwitch.isChecked()) {
			wifiSwitch.click();
			assertEquals(getString("switchOff"), wifiSwitch.getText());
			
			sleep(100);
			
			wifiSwitch.click();
			assertEquals(getString("switchOn"), wifiSwitch.getText());
		} else {
			wifiSwitch.click();
			assertEquals(getString("switchOn"), wifiSwitch.getText());
			
			sleep(100);
			
			wifiSwitch.click();
			assertEquals(getString("switchOff"),wifiSwitch.getText());
		}
	}
	
	public void testLigaDesligaBluetooth() throws UiObjectNotFoundException {   
		UiObject allAppsButton = new UiObject(new UiSelector()
		.description(getString("allApps")));
		
		System.out.println("Entrando nos apps...");
		allAppsButton.clickAndWaitForNewWindow();

		UiObject appsTab = new UiObject(new UiSelector()
		.text(getString("appsTab")));

		appsTab.click();
		
		UiScrollable appViews = new UiScrollable(new UiSelector()
		.scrollable(true));

		appViews.setAsHorizontalList();
		
		System.out.println("Entrando nos settings...");
		UiObject settingsApp = appViews.getChildByText(new UiSelector()
		.className(android.widget.TextView.class.getName()), 
		getString("settingsApp"));
		settingsApp.clickAndWaitForNewWindow();

		UiScrollable settingsList = new UiScrollable(new UiSelector().scrollable(true));
		
		System.out.println("Encontrando o switch do Bluetooth...");
		UiSelector bluetoothSelector = new UiSelector().className(android.widget.Switch.class.getName()).instance(1);
		UiObject bluetoothSwitch = settingsList.getChild(bluetoothSelector);
		
		System.out.println("Ligando/Desligando Bluetooth...");
		if(bluetoothSwitch.isChecked()) {
			bluetoothSwitch.click();
			assertEquals(getString("switchOff"), bluetoothSwitch.getText());
			sleep(100);
			bluetoothSwitch.click();
			assertEquals(getString("switchOn"), bluetoothSwitch.getText());
		} else {
			bluetoothSwitch.click();
			assertEquals(getString("switchOn"), bluetoothSwitch.getText());
			sleep(100);
			bluetoothSwitch.click();
			assertEquals(getString("switchOff"),bluetoothSwitch.getText());
		}
	}
}
