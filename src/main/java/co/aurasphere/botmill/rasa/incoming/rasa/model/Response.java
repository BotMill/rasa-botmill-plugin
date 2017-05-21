/**
 * 
 * MIT License
 *
 * Copyright (c) 2017 BotMill.io
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */
package co.aurasphere.botmill.rasa.incoming.rasa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;

/**
 * The Class Response.
 */
public class Response implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The text. */
	private String text;

	/** The entity. */
	private List<Entity> entities;

	/** The intent. */
	private Intent intent;

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text
	 *            the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the entity.
	 *
	 * @return the entity
	 */
	public List<Entity> getEntities() {
		return entities;
	}

	/**
	 * Sets the entity.
	 *
	 * @param entity
	 *            the new entity
	 */
	public void setEntities(List<Entity> entity) {
		this.entities = entity;
	}

	/**
	 * Gets the intent.
	 *
	 * @return the intent
	 */
	public Intent getIntent() {
		return intent;
	}

	/**
	 * Sets the intent.
	 *
	 * @param intent
	 *            the new intent
	 */
	public void setIntent(Intent intent) {
		this.intent = intent;
	}
	
	public StringEntityValue searchForStringEntityValue(String value) {
		// if (entityName instanceof JsonPrimitive) {
		for (Entity ent : this.getEntities()) {
			if (ent.getEntity().equals(value)) {
				if (ent.getValue() instanceof StringEntityValue) {
					return ((StringEntityValue) ent.getValue());
				}
			}
		}
		return null;
	}
	
	public RasaEntityValue searchForDucklingValue(String value) {
		for (Entity ent : this.getEntities()) {
			if (ent.getEntity().equals(value)) {
				if (ent.getValue() instanceof DucklingTimeEntityValue && ent.getDuckling() != null) {
					return ((DucklingTimeEntityValue) ent.getValue());
				}else if(ent.getValue() instanceof StringEntityValue && ent.getDuckling() != null) {
					return ((StringEntityValue) ent.getValue());
				}
			}
		}
		return null;
	}
	
	public List<RasaEntityValue> searchForDucklingValues(String value) {
		List<RasaEntityValue> values = new ArrayList<RasaEntityValue>();
		for (Entity ent : this.getEntities()) {
			if (ent.getEntity().equals(value)) {
				if (ent.getValue() instanceof DucklingTimeEntityValue && ent.getDuckling() != null) {
					values.add((DucklingTimeEntityValue) ent.getValue());
				}else if(ent.getValue() instanceof StringEntityValue && ent.getDuckling() != null) {
					values.add((StringEntityValue) ent.getValue());
				}
			}
		}
		return values;
	}


}
