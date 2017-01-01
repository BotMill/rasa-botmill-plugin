package co.aurasphere.botmill.rasa.objects;

import java.io.Serializable;

public class Entity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String start;
	private String end;
	private String value;
	private String entity;
	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	
	
	
}
