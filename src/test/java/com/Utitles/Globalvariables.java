package com.Utitles;

public interface Globalvariables {
	String CONFIG_FILE = "Config.properties";

	String BASE_URL = CommonUtils.getProperty("Dev_URL");
	String MOBILE = CommonUtils.getProperty("Mobile_dev");
	String PIN = CommonUtils.getProperty("Pin");
	String VALUE = CommonUtils.getProperty("Dev_location");
	String Browser = CommonUtils.getProperty("Browser");
	
	
	
	int EXPLICIT_WAIT = Integer.valueOf(CommonUtils.getProperty("explicitWait")); // 15;
    int IMPLICIT_WAIT = Integer.valueOf(CommonUtils.getProperty("implicitWait")); // 5;
	String testoutput= CommonUtils.getProperty("test-output");
	String Logs = CommonUtils.getProperty("Logs");
	String Report = CommonUtils.getProperty("Report");
	String FailedScenarios = CommonUtils.getProperty("FailedScenarios");
	String aviDirPath = CommonUtils.getProperty("aviDirPath");

	//Docker
	String DockerUrl=CommonUtils.getProperty("Url");
	String Docker_start=CommonUtils.getProperty("Start");
	String Docker_stop=CommonUtils.getProperty("Stop");
	String Cmd_close=CommonUtils.getProperty("close");


}
