package co.aurasphere.botmill.rasa;
import co.aurasphere.botmill.rasa.outgoing.model.RasaConnectionConfig;

public class RasaBotMillContext {
	
	private static RasaConnectionConfig rasaConfig;
	
	/** The instance. */
	private RasaBotMillContext instance;
	
	/**
	 * Creates the action.
	 *
	 * @return the action frame builder
	 */
	public RasaBotMillContext configure() {
		if (instance == null) {
			instance = new RasaBotMillContext();
		}
		rasaConfig = new RasaConnectionConfig();
		return instance;
	}
	
	public static void setup(String serverProtocol, String serverUrl, String serverPort) {
		rasaConfig.setHost(serverUrl);
		rasaConfig.setPort(serverPort);
		rasaConfig.setProtocol(serverProtocol);
	}
	
	public static void setup(String serverUrl) {
		rasaConfig.setHost(serverUrl);
	}
	
	public static RasaConnectionConfig getRasaConfig() {
		return rasaConfig;
	}
}
