package co.aurasphere.botmill.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thub.ml.util.HttpUtils;


public class HttpUtils {
	
	private static final Logger logger = LoggerFactory
			.getLogger(HttpUtils.class);
	
	public static String post(String url, StringEntity entity) {
		HttpPost post = new HttpPost(url);
		post.setHeader("Content-Type", "application/x-www-form-urlencoded");
		post.setEntity(entity);
		return send(post);
	}
	
	public static String get(String url) {
		System.out.println(url);
		HttpGet get = new HttpGet(url);
		return send(get);
	}

	/**
	 * Sends a request.
	 * 
	 * @param request
	 *            the request to send
	 * @return response the response.
	 */
	public static String send(HttpRequestBase request) {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		logger.debug(request.getRequestLine().toString());
		HttpResponse httpResponse = null;
		String response = null;
		try {
			httpResponse = httpClient.execute(request);
			response = getResponseContent(httpResponse);
		} catch (Exception e) {
			logger.error("Error during HTTP connection ", e);
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				logger.error("Error while closing HTTP connection: ", e);
			}
		}
		return response;
	}
	
	private static String getResponseContent(HttpResponse response) throws IOException{
		InputStream inputStream = response.getEntity().getContent();
		BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
		InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
		BufferedReader br = new BufferedReader(inputStreamReader);
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = br.readLine()) != null) {
			result.append(line);
		}
		return result.toString();
	}
}
