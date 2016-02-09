package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CustomerCarePage extends PageObject {

	@FindBy(css = "input[name='Name']")
	private WebElementFacade nume;

	@FindBy(css = "input[name='Email']")
	private WebElementFacade email;

	@FindBy(css = "input[name='Subject']")
	private WebElementFacade subject;

	@FindBy(css = "textarea[name='Message']")
	private WebElementFacade message;

	@FindBy(css = "div[class*='wrapper'] > button")
	private WebElementFacade sendButton;

	@FindBy(css = "div[id*='wrapper'] span")
	private WebElementFacade returnMessage;

	public void type_name(String value) {
		nume.waitUntilVisible();
		nume.type(value);
	}

	public void type_email(String value) {
		email.type(value);
	}

	public void type_subject(String value) {
		subject.type(value);
	}

	public void type_message(String value) {
		message.type(value);
	}

	public void click_sendButton() {
		sendButton.click();
	}

	public String getResponseMessage() {
		
		// wait until message changes on screen
		for (int i=0; i<1000; i++){
			waitABit(1000);
			System.out.println(returnMessage.getTextValue());
			if (returnMessage.getTextValue().length()>10)
				break;
		}
		return returnMessage.getTextValue();
	}

}