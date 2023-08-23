package steps;

import org.openqa.selenium.WebDriver;

import com.pageobjects.LoginPage;

public class LoginPageSteps {

	private final LoginPage loginPage;

	public LoginPageSteps(WebDriver driver) {
		this.loginPage = new LoginPage(driver);

	}

	public void Enter_the_Login_details(String Mobile, String Pin) throws InterruptedException {
		loginPage.Enter_the_Mobilenumber(Mobile);
		loginPage.Enter_the_Pin(Pin);
	}

	public void Login() throws InterruptedException {
		loginPage.Click_the_login_Btn();
	}
}
