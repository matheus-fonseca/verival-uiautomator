package br.unb.fga.software.verival;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class TestLigaDesligaFuncionalidades extends UiAutomatorTestCase {
	
	public void setUp() {
		String output = "\nTeste " + this.getName().substring(4) + "() ";
		System.out.println(output);
		getUiDevice().pressHome();
	}
	
	public void testLigaDesligaWifi() throws UiObjectNotFoundException {   
		UiObject allAppsButton = new UiObject(new UiSelector()
		.description("Apps"));
		System.out.println("Entrando nos apps...");
		allAppsButton.clickAndWaitForNewWindow();

		UiObject appsTab = new UiObject(new UiSelector()
		.text("Apps"));

		appsTab.click();
		
		UiScrollable appViews = new UiScrollable(new UiSelector()
		.scrollable(true));

		appViews.setAsHorizontalList();
		
		System.out.println("Entrando nos settings...");
		UiObject settingsApp = appViews.getChildByText(new UiSelector()
		.className(android.widget.TextView.class.getName()), 
		"Settings");
		settingsApp.clickAndWaitForNewWindow();

		UiScrollable settingsList = new UiScrollable(new UiSelector().scrollable(true));
		
		System.out.println("Encontrando o switch do Wi-Fi...");
		UiSelector wifiSelector = new UiSelector().className(android.widget.LinearLayout.class.getName());
		UiObject wifiLayout = settingsList.getChildByText(wifiSelector,"Wi‑Fi", true);

		UiObject wifiSwitch = wifiLayout.getChild(new UiSelector().className(android.widget.Switch.class.getName()));
		
		System.out.println("Ligando/Desligando Wi-Fi...");
		if(wifiSwitch.getText().equals("ON")) {
			wifiSwitch.click();
			assertEquals("OFF", wifiSwitch.getText());
			wifiSwitch.click();
			assertEquals("ON", wifiSwitch.getText());
		} else {
			wifiSwitch.click();
			assertEquals("ON", wifiSwitch.getText());
			wifiSwitch.click();
			assertEquals("OFF",wifiSwitch.getText());
		}
	}
	
	public void testLigaDesligaBluetooth() throws UiObjectNotFoundException {   
		UiObject allAppsButton = new UiObject(new UiSelector()
		.description("Apps"));
		System.out.println("Entrando nos apps...");
		allAppsButton.clickAndWaitForNewWindow();

		UiObject appsTab = new UiObject(new UiSelector()
		.text("Apps"));

		appsTab.click();
		
		UiScrollable appViews = new UiScrollable(new UiSelector()
		.scrollable(true));

		appViews.setAsHorizontalList();
		
		System.out.println("Entrando nos settings...");
		UiObject settingsApp = appViews.getChildByText(new UiSelector()
		.className(android.widget.TextView.class.getName()), 
		"Settings");
		settingsApp.clickAndWaitForNewWindow();

		UiScrollable settingsList = new UiScrollable(new UiSelector().scrollable(true));
		
		System.out.println("Encontrando o switch do Bluetooth...");
		UiSelector bluetoothSelector = new UiSelector().className(android.widget.LinearLayout.class.getName());
		UiObject bluetoothLayout = settingsList.getChildByText(bluetoothSelector,"Bluetooth", true);

		UiObject bluetoothSwitch = bluetoothLayout.getChild(new UiSelector().className(android.widget.Switch.class.getName()));
		
		System.out.println("Ligando/Desligando Bluetooth...");
		if(bluetoothSwitch.getText().equals("ON")) {
			bluetoothSwitch.click();
			assertEquals("OFF", bluetoothSwitch.getText());
			bluetoothSwitch.click();
			assertEquals("ON", bluetoothSwitch.getText());
		} else {
			bluetoothSwitch.click();
			assertEquals("ON", bluetoothSwitch.getText());
			bluetoothSwitch.click();
			assertEquals("OFF",bluetoothSwitch.getText());
		}
	}
}
