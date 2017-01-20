package co.aurasphere.botmill.rasa;

import static org.junit.Assert.assertNotNull;

import java.net.ConnectException;

import org.apache.http.conn.HttpHostConnectException;
import org.junit.Before;
import org.junit.Test;

import co.aurasphere.botmill.rasa.incoming.model.Response;
import co.aurasphere.botmill.rasa.service.RasaService;

public class RasaBotMillServiceTest {

	@Before
	public void setup() {
		RasaBotMillContext.configure().setup("http://localhost:5000");
	}

	@Test
	public void testParse() {
		if (checkConnection()) {
			Response resp = RasaService.sendParseRequest("q");
			assertNotNull(resp);
		}
		assert (true);
	}

	private boolean checkConnection() {

		Response status = RasaService.getStatus();
		if (status == null) {
			return false;
		}
		return true;
	}
}
