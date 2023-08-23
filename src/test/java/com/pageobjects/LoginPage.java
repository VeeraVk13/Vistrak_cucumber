package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@placeholder='Mobile number']")
	private WebElement MOBILE_NUM;
	@FindBy(xpath = "//input[@placeholder='PIN']6")
	private WebElement PIN;
	@FindBy(xpath = "(//button[normalize-space()='Log In'])[1]")
	private WebElement LOGIN_BTN;
	@FindBy(xpath = "(//a[normalize-space()='Continue'])[1]")
	private WebElement POP_UP;
	@FindBy(xpath = "//div[@class='modal-content']//h5[@class='modal-title']")
	private WebElement ACCESS_POP_UP;
	@FindBy(xpath = "//a[normalize-space()='Cancel']")
	private WebElement UPDATE_CANCEL_BTN;

	public void Enter_the_Mobilenumber(String Mobile) throws InterruptedException {

		waitForPageLoad();
		pause(2);
		scrolltopixel();
		appupdate(UPDATE_CANCEL_BTN);
		highlightElement(MOBILE_NUM);
		clearAndEnterText(MOBILE_NUM, Mobile);
	
	}

	public void Enter_the_Pin(String Pin) throws InterruptedException {
		waitForPageLoad();
		pause(2);
		highlightElement(PIN);
		clearAndEnterText(PIN, Pin);

	}

	public void Click_the_login_Btn() throws InterruptedException {
		waitForPageLoad();
		pause(2);
		click(LOGIN_BTN);
		check_out(POP_UP);

	}
}
