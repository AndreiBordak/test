package com.epam.json.entity;

import java.util.List;

import com.epam.json.constants.Schema;
import com.google.gson.annotations.SerializedName;

public class Rule extends Item {

	private static final String KEY_PATTERN = "pattern";
	private static final String KEY_OUTPUT = "output";
	private static final String KEY_TYPE = "type";

	@SerializedName(Schema.RULE_MAP)
	private List<RuleMap> ruleMap;

	private String pattern;
	private String output;
	private String type;

	public Rule() {
		super();
	}

	public void setRuleMap(List<RuleMap> ruleMap) {
		this.ruleMap = ruleMap;
	}

	public List<RuleMap> getRuleMap() {
		return ruleMap;
	}

	public String getPattern() {
		if (pattern == null) {
			pattern = getValue(KEY_PATTERN);
		}
		return pattern;
	}

	public String getOutput() {
		if (output == null) {
			output = getValue(KEY_OUTPUT);
		}
		return output;
	}

	public String getType() {
		if (type == null) {
			type = getValue(KEY_TYPE);
		}
		return type;
	}

	private String getValue(String key) {
		if (ruleMap != null) {
			for (RuleMap rule : ruleMap) {
				if (key.equals(rule.key.toLowerCase())) {
					return rule.value;
				}
			}
		}
		return null;
	}

	private class RuleMap {

		@SerializedName(Schema.MTVI_ID)
		private String mtviId;

		@SerializedName(Schema.KEY)
		private String key;

		@SerializedName(Schema.VALUE)
		private String value;

		public String toHtml() {
			StringBuilder sb = new StringBuilder();
			sb.append("<ul>");
			sb.append("<li>" + "key   ---" + key + "</li>");
			sb.append("<li>" + "value   ---" + value + "</li>");
			sb.append("</ul>");
			return sb.toString();
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((output == null) ? 0 : output.hashCode());
		result = prime * result + ((pattern == null) ? 0 : pattern.hashCode());
		result = prime * result + ((ruleMap == null) ? 0 : ruleMap.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (!(obj instanceof Rule)) {
			return false;
		}
		Rule other = (Rule) obj;
		if (output == null) {
			if (other.output != null) {
				return false;
			}
		} else if (!output.equals(other.output)) {
			return false;
		}
		if (pattern == null) {
			if (other.pattern != null) {
				return false;
			}
		} else if (!pattern.equals(other.pattern)) {
			return false;
		}
		if (ruleMap == null) {
			if (other.ruleMap != null) {
				return false;
			}
		} else if (!ruleMap.equals(other.ruleMap)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}

	public String toHtml() {
		StringBuilder sb = new StringBuilder();

		sb.append("ruleMap");
		for (RuleMap ruleMap : this.ruleMap) {
			sb.append("<ul>");
			sb.append("<li>" + "---" + ruleMap.toHtml() + "</li>");
			sb.append("</ul>");
		}

		return sb.toString();
	}

}
