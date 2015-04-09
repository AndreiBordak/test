package com.epam.json.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

public class HtmlUtils {

	private static final Logger LOGGER = Logger.getLogger(HtmlUtils.class);

	public static final String NO_SUCH_RECORD = "<h1>No such brands for this ID</h1>";
	public static String FILENAME = "report.html";
	public static String ENCODING = "UTF-8";

	public static void writeToHtmlFile(String str) {

		PrintWriter writer = null;
		try {
			writer = new PrintWriter(FILENAME, ENCODING);
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error(e);
		}
		writer.println(str);
		writer.close();
	}

	public static void writeToHtmlFile(String str, String fileName,
			String encoding) throws FileNotFoundException,
			UnsupportedEncodingException {
		PrintWriter writer = null;
		writer = new PrintWriter(fileName, encoding);
		writer.println(str);
		writer.close();
	}
}
