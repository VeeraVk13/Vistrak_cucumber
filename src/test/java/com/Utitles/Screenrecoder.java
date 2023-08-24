package com.Utitles;

import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.File;


import static org.monte.media.FormatKeys.*;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.VideoFormatKeys.*;
import static org.monte.media.VideoFormatKeys.QualityKey;

public class Screenrecoder {


    private static ScreenRecorder screenRecorder;

    public static void startScreenRecording(WebDriver driver) {
        try {
            // Get browser window dimensions
            org.openqa.selenium.Dimension windowSize = driver.manage().window().getSize();
            org.openqa.selenium.Point windowPosition = driver.manage().window().getPosition();

            Rectangle browserBounds = new Rectangle(windowPosition.x, windowPosition.y, windowSize.width, windowSize.height);

            GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
                    .getDefaultConfiguration();

            // Specify the directory and file name for recording
            File videoFileDirectory = new File("ScreenRecord/");
            videoFileDirectory.mkdirs(); // Ensure the directory exists
            File videoFile = new File(videoFileDirectory, "screenRecording.avi");

            screenRecorder = new ScreenRecorder(gc, browserBounds,
                    new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
                            Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                    null, videoFile);
            screenRecorder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopScreenRecording() {
        try {
            if (screenRecorder != null)
                screenRecorder.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
