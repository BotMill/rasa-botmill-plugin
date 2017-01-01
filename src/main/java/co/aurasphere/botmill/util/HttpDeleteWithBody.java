package co.aurasphere.botmill.util;

import org.apache.http.client.methods.HttpPost;

public class HttpDeleteWithBody extends HttpPost {

	public HttpDeleteWithBody(String url) {
		super(url);
	}

	@Override
	public String getMethod() {
		return "DELETE";
	}

}
