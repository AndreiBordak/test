package com.epam.json.parsing;

import java.io.IOException;
import java.io.Reader;

import com.epam.json.constants.Schema;
import com.epam.json.entity.Docs;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonService {

	public Docs parse(Reader reader) throws IOException {
		Docs docs = null;
		JsonObject jObj = new JsonParser().parse(reader).getAsJsonObject()
				.getAsJsonObject(Schema.RESPONSE_OBJECT);
		Gson gson = new GsonBuilder().create();
		docs = gson.fromJson(jObj, Docs.class);
		reader.close();
		return docs;
	}

}
