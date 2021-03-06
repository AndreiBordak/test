package com.epam.json.entity;

import java.util.List;

import com.epam.json.constants.Schema;
import com.google.gson.annotations.SerializedName;

public class Condition extends Item {

	@SerializedName(Schema.RULE_SET)
	private List<Rule> ruleSet;

	public Condition() {
		super();
	}

	public List<Rule> getRule() {
		return this.ruleSet;
	}

	public void setRule(List<Rule> ruleSet) {
		this.ruleSet = ruleSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ruleSet == null) ? 0 : ruleSet.hashCode());
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
		if (!(obj instanceof Condition)) {
			return false;
		}
		Condition other = (Condition) obj;
		if (ruleSet == null) {
			if (other.ruleSet != null) {
				return false;
			}
		} else if (!ruleSet.equals(other.ruleSet)) {
			return false;
		}
		return true;
	}

	public String toHtml() {
		StringBuilder sb = new StringBuilder();
		sb.append("<h3>ruleSet</h3>");
		for (Rule rule : ruleSet) {
			sb.append("<h3>" + rule.getTitle() + "</h3>");
			sb.append("<ul>");
			sb.append("<li>" + "mtvi:id      ---" + rule.getMtviId() + "</li>");
			sb.append("<li>" + "mtvi:shortId ---" + rule.getMtviShortId()
					+ "</li>");
			sb.append("<li>" + rule.toHtml() + "</li>");
			sb.append("</ul>");
		}
		return sb.toString();
	}

}
