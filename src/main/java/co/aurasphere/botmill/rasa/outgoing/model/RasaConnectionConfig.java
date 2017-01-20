package co.aurasphere.botmill.rasa.outgoing.model;

import java.io.Serializable;

public class RasaConnectionConfig implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String protocol;
	private String host;
	private String port;
	private String token;
	
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public String toString() {
		if(port != null || protocol != null) {
			return this.host;
		}else {
			return this.protocol + this.host + this.port;
		}
	}
	
}
