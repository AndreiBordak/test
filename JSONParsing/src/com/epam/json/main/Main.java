package com.epam.json.main;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.epam.json.entity.Docs;
import com.epam.json.exception.ArcServiceException;
import com.epam.json.parsing.JsonService;
import com.epam.json.web.ArcService;

public class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	public static void main(String[] args) {



		ArcService client = new ArcService();
		Docs docs = null;



		if(args.length!=0&&args[0]!=null&&!args[0].isEmpty()){

			client.setId(args[0]);
		}else{
			client.setId("28559cca-6ac6-4e32-880c-1c531805fd1e");
		}


		try {
			docs = new JsonService().parse(client.getResponseContent());
		} catch (ArcServiceException | IOException e) {
			LOGGER.error("Cannot get content from arc service", e);
		}

		if (docs != null) {
			System.out.println(docs.toString());
		}

	}

}
