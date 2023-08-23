package com.pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utitles.Drivermanger;
import com.Utitles.Globalvariables;

public class BasePage implements Globalvariables {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions actions;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, EXPLICIT_WAIT), this);
	}

	public void waitForPageLoad() {
		pause(1);
		WebDriverWait wait = new WebDriverWait(Drivermanger.getDriver(), Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});
	}

	protected void pause(int sec) {
		try {
			Thread.sleep(sec * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void scrolltopixel() {
		JavascriptExecutor js = (JavascriptExecutor) Drivermanger.getDriver();
		js.executeScript("window.scrollBy(0, 100);");

	}

	protected void highlightElement(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) Drivermanger.getDriver();
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')",
				element);

	}

	protected void clearAndEnterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	protected void click(WebElement xpathExpression) {
		xpathExpression.click();

	}

	public void appupdate(WebElement ele) {
		int maxIterations = 10;

		// Sleep duration between iterations (in milliseconds)
		int sleepDuration = 1000;

		// Loop until the element is found or the maximum iterations are reached
		for (int i = 0; i < maxIterations; i++) {
			try {
				// Find and click the desired element
				WebElement cancel = ele;
				cancel.click();
				break;
			} catch (NoSuchElementException e) {
				// Element not found, move to the next step
				break;
			}

		}
	}

	public void check_out(WebElement ele) {
		// Maximum number of iterations
		int maxIterations = 10;

		// Sleep duration between iterations (in milliseconds)
		int sleepDuration = 1000;

		// Loop until the element is found or the maximum iterations are reached
		for (int i = 0; i < maxIterations; i++) {
			try {
				// Find and click the desired element
				WebElement continueElement = ele;
				continueElement.click();
				break;
			} catch (NoSuchElementException e) {
				// Element not found, move to the next step
				break;
			}

		}

	}

}
