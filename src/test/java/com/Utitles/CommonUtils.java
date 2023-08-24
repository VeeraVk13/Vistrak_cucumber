package com.Utitles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.monte.screenrecorder.ScreenRecorder;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.*;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;


import java.io.File;

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

	private static ScreenRecorder screenRecorder;

	public void startScreenRecording() {
		try {
			GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
					.getDefaultConfiguration();

			File videoFile = new File("reports/ScreenRecord/");
			screenRecorder = new ScreenRecorder(gc, null,
					new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
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

	public void stopScreenRecording() {
		try {
			if (screenRecorder != null)
				screenRecorder.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
