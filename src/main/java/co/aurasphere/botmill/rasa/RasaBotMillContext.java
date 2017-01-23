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
package co.aurasphere.botmill.rasa;
import co.aurasphere.botmill.rasa.outgoing.model.RasaConnectionConfig;

// TODO: Auto-generated Javadoc
/**
 * The Class RasaBotMillContext.
 */
public class RasaBotMillContext {
	
	/** The rasa config. */
	private static RasaConnectionConfig rasaConfig;
	
	/** The instance. */
	private static RasaBotMillContext instance;
	
	/**
	 * Creates the action.
	 *
	 * @return the action frame builder
	 */
	public static RasaBotMillContext configure() {
		if (instance == null) {
			instance = new RasaBotMillContext();
		}
		rasaConfig = new RasaConnectionConfig();
		return instance;
	}
	
	/**
	 * Setup.
	 *
	 * @param serverProtocol the server protocol
	 * @param serverUrl the server url
	 * @param serverPort the server port
	 */
	public void setup(String serverProtocol, String serverUrl, String serverPort) {
		rasaConfig.setHost(serverUrl);
		rasaConfig.setPort(serverPort);
		rasaConfig.setProtocol(serverProtocol);
	}
	
	/**
	 * Setup.
	 *
	 * @param serverProtocol the server protocol
	 * @param serverUrl the server url
	 * @param serverPort the server port
	 * @param token the token
	 */
	public void setup(String serverProtocol, String serverUrl, String serverPort, String token) {
		rasaConfig.setHost(serverUrl);
		rasaConfig.setPort(serverPort);
		rasaConfig.setProtocol(serverProtocol);
		rasaConfig.setToken(token);
	}
	
	/**
	 * Sets the up.
	 *
	 * @param serverUrl the new up
	 */
	public void setup(String serverUrl) {
		rasaConfig.setHost(serverUrl);
	}
	
	/**
	 * Setup.
	 *
	 * @param serverUrl the server url
	 * @param token the token
	 */
	public void setup(String serverUrl, String token) {
		rasaConfig.setHost(serverUrl);
		rasaConfig.setToken(token);
	}
	
	/**
	 * Gets the rasa config.
	 *
	 * @return the rasa config
	 */
	public static RasaConnectionConfig getRasaConfig() {
		return rasaConfig;
	}
}
