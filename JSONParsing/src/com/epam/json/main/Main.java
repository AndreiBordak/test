package com.epam.json.main;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.epam.json.entity.Docs;
import com.epam.json.exception.ArcServiceException;
import com.epam.json.parsing.JsonService;
import com.epam.json.utils.HtmlUtils;
import com.epam.json.utils.ObjectFactory;
import com.epam.json.web.ArcService;

public class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		ArcService client = ObjectFactory.createInstance(ArcService.class);
		Docs docs = null;

		if (args.length != 0 && args[0] != null && !args[0].isEmpty()) {
			client.setId(args[0]);
		} else {
			client.setId("f18ef4f9-6ff4-4549-a878-bab9b847ae9e");
		}

		try {
			docs = new JsonService().parse(client.getResponseContent());
		} catch (ArcServiceException e) {
			LOGGER.error("Cannot get content from arc service", e);
		} catch (IOException e) {
			LOGGER.error("Cannot close reader", e);
		}

		if (docs != null) {
			System.out.println(docs.toString());
			HtmlUtils.writeToHtmlFile(docs.toHtml());
		} else {
			HtmlUtils.writeToHtmlFile(HtmlUtils.NO_SUCH_RECORD);
		}

	}

}
