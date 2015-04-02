package com.epam.json.web;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import com.epam.json.exception.ArcServiceException;

@SuppressWarnings("deprecation")
public class ArcService {

	private static final String QUERY_PREFIX = "{\"select\":{\"mtvi:id|mtvi:shortId|mtvi:lastModified|title|responseCode\":1, \"conditions\":{ \"mtvi:id|mtvi:shortId|mtvi:lastModified|title\":1, \"ruleSet\":{\"mtvi:id|mtvi:shortId|mtvi:lastModified|title\":1, \"ruleMap\": {\"key|value\":1}}}},\"where\":{\"byId\":[\"";
	private static final String QUERY_POSTFIX ="\"]},\"start\":0,\"rows\":3}";
	private static String URL = "http://mongo-arc-v2.mtvnservices.com/jp/redirektor?stage=live&indent=true&q=";

	private String mtviId;
	private String query;



	{
		mtviId = "f18ef4f9-6ff4-4549-a878-bab9b847ae9e";
		query = QUERY_PREFIX+ mtviId + QUERY_POSTFIX;
	}

	public ArcService(){
		super();
	}

	public ArcService(String mtviId){
		this.mtviId = mtviId;
		changeId();
	}

	public void setId(String id) {
		this.mtviId = id;
		if (id != null && !id.isEmpty()) {
			changeId();
		}
	}

	private String buildUrl() throws UnsupportedEncodingException{
		return URL += URLEncoder.encode(query, "UTF-8");
	}

	private void changeId() {
		query = QUERY_PREFIX+ mtviId + QUERY_POSTFIX;;
	}

	@SuppressWarnings("resource")
	public HttpResponse arcRequest() throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		return client.execute(new HttpGet(buildUrl()));
	}

	public Reader getResponseContent() throws ArcServiceException{
		Reader reader = null;
		try {
			reader = new InputStreamReader(arcRequest().getEntity()
					.getContent());
		} catch (IllegalStateException | IOException e) {
			throw new ArcServiceException("Cannot get content from arc sevice", e);
		}

     	return reader;
	}

}
