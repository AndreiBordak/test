package com.epam.json.entity;

import com.google.gson.annotations.SerializedName;
import com.epam.json.constants.Schema;

public abstract class Item {

	@SerializedName(Schema.MTVI_ID)
	private String mtviId;

	@SerializedName(Schema.MTVI_SHORT_ID)
	private String mtviShortId;


	@SerializedName(Schema.TITLE)
	private String title;

	public String getMtviId() {
		return mtviId;
	}

	public void setMtviId(String mtviId) {
		this.mtviId = mtviId;
	}

	public String getMtviShortId() {
		return mtviShortId;
	}

	public void setMtviShortId(String mtviShortId) {
		this.mtviShortId = mtviShortId;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mtviId == null) ? 0 : mtviId.hashCode());
		result = prime * result
				+ ((mtviShortId == null) ? 0 : mtviShortId.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Item)) {
			return false;
		}
		Item other = (Item) obj;
		if (mtviId == null) {
			if (other.mtviId != null) {
				return false;
			}
		} else if (!mtviId.equals(other.mtviId)) {
			return false;
		}
		if (mtviShortId == null) {
			if (other.mtviShortId != null) {
				return false;
			}
		} else if (!mtviShortId.equals(other.mtviShortId)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}



}
