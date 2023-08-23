package com.Utitles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import com.pageobjects.LoginPage;

import java.io.*;

public class CommonUtils implements Globalvariables {

	private static final Properties properties = new Properties();

	public static String getProperty(String key) {
		try {
			InputStream stream = new FileInputStream(new File(CONFIG_FILE));
			properties.load(stream);
			stream.close();
		} catch (FileNotFoundException e) {
			// Log.error("File was Not Found: " + e.getMessage());
		} catch (IOException e) {
			// Log.error("There was a IO Exception: ", e);
		}
		return properties.getProperty(key);

	}

}
