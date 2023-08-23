package com.Utitles;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Drivermanger implements Globalvariables {

	private static WebDriver driver = null;
	private static final Logger LOG = LogManager.getLogger(Drivermanger.class);
	protected static WebDriverWait wait;

	public static void launchBrowser(String Browser) {

		try {
			switch (Browser) {
			case "chrome":
				LOG.info("User Given browser =" + Browser);
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().setSize(new Dimension(390, 844));
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			default:
				System.out.println("User did't give any input");
				break;
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static WebDriver getDriver() {
		return driver;
	}
}
