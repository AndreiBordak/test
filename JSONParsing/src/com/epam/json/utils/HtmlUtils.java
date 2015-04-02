package com.epam.json.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class HtmlUtils {

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
