package br.unb.vvs.uiautomator;

import static br.unb.vvs.uiautomator.StringGetter.getString;

import java.util.Random;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Test07_SendVerifyEmail extends UiAutomatorTestCase {
	
	public void setUp() {
		String output = "\nTest " + this.getName().substring(4) + "() ";
		System.out.println(output);
//		try {
//			getUiDevice().pressHome();
//			configuraContaEmail();
//		} catch (UiObjectNotFoundException e) {
//			System.out.println("Nao foi possivel configurar a conta de Email para o teste. Saindo...");
//			System.exit(-1);
//		}
		getUiDevice().pressHome();
	}

	public void testSendVerifyEmail() throws UiObjectNotFoundException {   
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
		
		System.out.println("Entrando no Email...");
		UiObject emailApp = appViews.getChildByText(new UiSelector()
		.className(android.widget.TextView.class.getName()), 
		getString("emailApp"));
		emailApp.clickAndWaitForNewWindow();
		
		System.out.println("Indo para a home do email...");
		UiSelector homeSelector = new UiSelector().className(android.widget.ImageView.class.getName())
				.index(0);
		UiObject home = new UiObject(homeSelector);
		
		home.clickAndWaitForNewWindow();
		
		System.out.println("Selecionando opcao de criar novo email...");
		UiSelector newEmailSelector = new UiSelector().className(android.widget.TextView.class.getName())
				.description(getString("emailCompose"));
		UiObject newEmail = new UiObject(newEmailSelector);
		
		newEmail.clickAndWaitForNewWindow();
		
		System.out.println("Escrevendo o email do destinatário...");
		String dest = "verivaluiautomator@gmail.com";
		UiSelector destInputSelector = new UiSelector().className(android.widget.MultiAutoCompleteTextView.class.getName())
				.instance(0);
		UiObject destInput = new UiObject(destInputSelector);
		destInput.clearTextField();
		destInput.setText(dest);
		
		System.out.println("Escrevendo o titulo do email...");
		Random rand = new Random();
		String subject = "UI Test " + Integer.toString(rand.nextInt(1000));
		UiSelector subjectInputSelector = new UiSelector().className(android.widget.EditText.class.getName())
				.text(getString("emailSubject"));
		UiObject subjectInput = new UiObject(subjectInputSelector );
		subjectInput.clearTextField();
		subjectInput.setText(subject);
		
		System.out.println("Escrevendo o conteudo do email...");
		String content = "Content of the email.";
		UiSelector contentInputSelector = new UiSelector().className(android.widget.EditText.class.getName())
				.text(getString("emailContent"));
		UiObject contentInput = new UiObject(contentInputSelector );
		contentInput.clearTextField();
		contentInput.setText(content);
		
		System.out.println("Enviando o email...");
		UiSelector sendEmailSelector = new UiSelector().className(android.widget.TextView.class.getName())
				.description(getString("emailSend"));
		UiObject sendEmail = new UiObject(sendEmailSelector);
		
		sendEmail.clickAndWaitForNewWindow();
		
		System.out.println("Atualizando caixa de entrada...");
		UiSelector emailListSelector = new UiSelector().scrollable(true);
		UiScrollable emailList = new UiScrollable(emailListSelector);
		emailList.scrollToBeginning(Integer.MAX_VALUE);
		
		UiSelector updateSelector = new UiSelector().className(android.widget.TextView.class.getName()).description(getString("emailUpdate"));
		UiObject update = new UiObject(updateSelector);
		
		update.click();
		
		System.out.println("Esperando atualizacao da caixa de entrada (15s)...");
		sleep(15000);
		
		System.out.println("Verificando recebimento do email...");
		UiSelector lastEmailSelector = new UiSelector().className(android.view.View.class.getName()).instance(0);
		UiObject lastEmail = emailList.getChild(lastEmailSelector);
		
		assertEquals(getString("emailSubjectString") + ", " + subject, lastEmail.getContentDescription());
	}
	
}
