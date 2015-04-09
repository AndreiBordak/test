package com.epam.json.entity;

import java.util.List;

import com.epam.json.constants.Schema;
import com.google.gson.annotations.SerializedName;

public class Brand extends Item {

	private static final String RESPONSE_CODE_BY_DEFAULT = "302";

	@SerializedName(Schema.RESPONSE_CODE)
	private String responseCode;

	@SerializedName(Schema.CONDITIONS)
	private List<Condition> conditions;

	{
		responseCode = RESPONSE_CODE_BY_DEFAULT;
	}

	public Brand() {
		super();
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public List<Condition> getContditions() {
		return this.conditions;
	}

	public void setContditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((conditions == null) ? 0 : conditions.hashCode());
		result = prime * result
				+ ((responseCode == null) ? 0 : responseCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Brand)) {
			return false;
		}
		Brand other = (Brand) obj;
		if (conditions == null) {
			if (other.conditions != null) {
				return false;
			}
		} else if (!conditions.equals(other.conditions)) {
			return false;
		}
		if (responseCode == null) {
			if (other.responseCode != null) {
				return false;
			}
		} else if (!responseCode.equals(other.responseCode)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		return builder.toString();
	}

	public String toHtml() {
		StringBuilder sb = new StringBuilder();

		for (Condition condition : conditions) {

			sb.append("<h2>" + condition.getTitle() + "</h2>");
			sb.append("<ul>");
			sb.append("<li>" + "mtvi:id      ---" + condition.getMtviId()
					+ "</li>");
			sb.append("<li>" + "mtvi:shortId ---" + condition.getMtviShortId()
					+ "</li>");
			sb.append("<li>" + condition.toHtml() + "</li>");
			sb.append("</ul>");
		}

		return sb.toString();
	}

}
