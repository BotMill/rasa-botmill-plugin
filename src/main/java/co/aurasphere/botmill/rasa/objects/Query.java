package co.aurasphere.botmill.rasa.objects;

import java.io.Serializable;

public class Query implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String protocol;
	private String host;
	private String port;
	private String queryText;
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getQueryText() {
		return queryText;
	}
	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}
	
	
}
