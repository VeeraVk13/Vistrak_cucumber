package com.stepDefination;

import com.Utitles.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class common_steps implements Globalvariables {
    private static final Logger LOG = LogManager.getLogger(common_steps.class);

    @Before
    public void beforeScenario() {

        try {
            if (Drivermanger.getDriver() == null) {

                Drivermanger.launchBrowser(Browser);
                Screenrecoder.startScreenRecording(Drivermanger.getDriver());
            }
        } catch (Exception e) {

        }

    }

    @After
    public void afterScenario() {
        Drivermanger.getDriver().close();
        Screenrecoder.stopScreenRecording();
        Drivermanger.getDriver().quit();
    }

    @AfterStep
    public void attachScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Drivermanger.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "errorscreen");
        }

    }



}
