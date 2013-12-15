package br.unb.vvs.uiautomator;

import static br.unb.vvs.uiautomator.StringGetter.getString;

import java.util.Random;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class Test06_Send100TextMessage extends UiAutomatorTestCase {
	
	public void testEnviarCemMensagensdeTexto() throws UiObjectNotFoundException{
		
		
		for(int i = 0; i < 100; i++){
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));

		appViews.setAsHorizontalList().scrollBackward();
		
		UiObject mensagensField = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()), getString("messaging"));
		
		mensagensField.clickAndWaitForNewWindow();

		String name = "83438877";
		UiObject nameOrder = new UiObject (new UiSelector().className(android.widget.MultiAutoCompleteTextView.class.getName()).text(getString("to")));
		nameOrder.clearTextField();
		nameOrder.setText(name);
		
		String messengetext = "Verival test";
		UiSelector messenge = new UiSelector().className(android.widget.EditText.class.getName()).text(getString("typeMessage"));
		UiObject messengeOrder = new UiObject (messenge);
		messengeOrder.clearTextField();
		messengeOrder.setText(messengetext);
		
		
		UiSelector sendSelector = new UiSelector().className(android.widget.ImageButton.class.getName()).description(getString("send"));
		UiObject sendOrder = new UiObject (sendSelector);
		sendOrder.clickAndWaitForNewWindow();
		
		getUiDevice().pressHome();
		}
		
		
	}

}
