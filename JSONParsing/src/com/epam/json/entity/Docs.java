package com.epam.json.entity;

import java.util.List;

import com.epam.json.constants.Schema;
import com.google.gson.annotations.SerializedName;

public class Docs {

	@SerializedName(Schema.DOCS)
	private List<Brand> brands;

	public Docs() {
		super();
	}

	public List<Brand> getBrands() {
		return brands;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Brand brand : this.getBrands()) {
			sb.append(brand.getTitle() + "\n");

			for (Condition con : brand.getContditions()) {
				sb.append("    " + con.getTitle() + "\n");

				for (Rule rule : con.getRule()) {
					sb.append("           " + rule.getTitle() + "\n");
					;
				}
			}
		}
		return sb.toString();
	}

	public String toHtml() {
		StringBuilder sb = new StringBuilder();

		for (Brand brand : brands) {
			sb.append("<h1>" + brand.getTitle() + "</h1>");
			sb.append("<ul>");
			sb.append("<li>" + "mtvi:id      ---" + brand.getMtviId() + "</li>");
			sb.append("<li>" + "mtvi:shortId ---" + brand.getMtviShortId()
					+ "</li>");
			sb.append("<li>" + brand.toHtml() + "</li>");
			sb.append("</ul>");

		}

		return sb.toString();
	}

}
