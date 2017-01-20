package co.aurasphere.botmill.rasa.incoming.model;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String text;
	private List<Entity> entity;
	private String intent;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<Entity> getEntity() {
		return entity;
	}
	public void setEntity(List<Entity> entity) {
		this.entity = entity;
	}
	public String getIntent() {
		return intent;
	}
	public void setIntent(String intent) {
		this.intent = intent;
	}
	
	
	
	

}
