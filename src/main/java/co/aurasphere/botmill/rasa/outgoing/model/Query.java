package co.aurasphere.botmill.rasa.outgoing.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Query implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName("q")
	private String query;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	
}
