package com.Utitles;

import java.net.URL;
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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

import static org.openqa.selenium.remote.DesiredCapabilities.*;

public class Drivermanger implements Globalvariables {

	private static WebDriver driver = null;
	private static final Logger LOG = LogManager.getLogger(Drivermanger.class);
	protected static WebDriverWait wait;

	public static void  launchBrowser(String browser) {
		try {
			switch (browser.toLowerCase()) {
				case "chrome":
					LOG.info("User Given browser =" + browser);
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage");
					URL url = new URL(DockerUrl);
					driver = new RemoteWebDriver(url, chromeOptions);
					driver.manage().window().setSize(new Dimension(390, 844));
					break;

				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "edge":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;
				default:
					System.out.println("User didn't give any valid input");
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
