package br.unb.vvs.uiautomator;

import static br.unb.vvs.uiautomator.StringGetter.getString;

import java.util.Random;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class Test08_Add1000NewContacts extends UiAutomatorTestCase {
	public void setUp() {
		String output = "\nTest " + this.getName().substring(4) + "() ";
		System.out.println(output);
		// Simulate a short press on the HOME button.
		getUiDevice().pressHome();
	}


	public void testCriarMilNumerosRandomicos() throws UiObjectNotFoundException{
		
		//Selecionando lista de contatos
		UiSelector peopleSelector = new UiSelector().text(getString("people")); 
		UiObject people = new UiObject(peopleSelector);
		people.clickAndWaitForNewWindow();
		
		for(int i = 0; i < 10; i++){
			if(i == 0){
				//Selectionando criação de novo contato
				UiSelector createSelector = new UiSelector().text(getString("createNew"));
				UiObject create = new UiObject(createSelector);
				create.clickAndWaitForNewWindow();
			}
			
			else{
			//Selecionando adição de um novo contato
			UiSelector createSelector = new UiSelector().description(getString("addContact"));
			UiObject create = new UiObject(createSelector);
			create.clickAndWaitForNewWindow();
			}
		
			//Adicionando um nome
			Random randName = new Random();
			String name = "Contact " + Integer.toString(i); 
			UiSelector nameContact = new UiSelector().className(android.widget.EditText.class.getName()).text(getString("name"));
			UiObject nameOrder = new UiObject (nameContact);
			nameOrder.clearTextField();
			nameOrder.setText(name);
			
			//Adicionando um numero
			Random randNumber = new Random();
			String number = Integer.toString(randNumber.nextInt(99999999));
			UiSelector numberContact = new UiSelector().className(android.widget.EditText.class.getName()).text(getString("phone"));
			UiObject numberOrder = new UiObject(numberContact);
			numberOrder.clearTextField();
			numberOrder.setText(number);
			
			//Completando a adição do novo número
			UiSelector doneSelector = new UiSelector().text(getString("done"));
			UiObject done = new UiObject(doneSelector);
			done.clickAndWaitForNewWindow();
			
			getUiDevice().pressBack();
			
			
			UiSelector contactListSelector = new UiSelector().scrollable(true);
			UiScrollable contactList = new UiScrollable(contactListSelector);
			contactList.scrollForward();
			
			UiSelector checkName = new UiSelector().className(android.widget.TextView.class.getName()).text(name);
			UiObject check = contactList.getChild(checkName); 
			
			assertEquals(name, check.getText());
		
		}
		
		
		
		
	}
	
	
	

}
