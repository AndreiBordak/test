package com.epam.json.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class HtmlUtils {

	public static final String NO_SUCH_RECORD ="<h1>No such brands for this ID</h1>";

	public static void writeToHtmlFile(String str){

		PrintWriter writer=null;
		try {
			writer = new PrintWriter("report.html", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {

		}
		writer.println(str);
		writer.close();
	}
}
