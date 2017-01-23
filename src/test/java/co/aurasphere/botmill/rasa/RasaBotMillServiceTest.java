package co.aurasphere.botmill.rasa;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import co.aurasphere.botmill.rasa.incoming.model.Response;
import co.aurasphere.botmill.rasa.service.RasaService;

public class RasaBotMillServiceTest {

	@Before
	public void setup() {
		RasaBotMillContext.configure().setup("http://127.0.0.1:5000","123456789");
	}

	@Test
	public void testParse() {
		if (checkConnection()) {
			Response resp = RasaService.sendParseRequest("musta ka na?");
			assertNotNull(resp);
		}
		assert (true);
	}
	
	@Test
	@Ignore // only run train test if necessary. This is an expensive process.
	public void testTrainString() {

		if (checkConnection()) {
			JsonParser parser = new JsonParser();
			Object obj;
			try {
				obj = parser.parse(new FileReader("src/test/resources/training.json"));
				JsonObject jsonObject = (JsonObject) obj;
				System.out.println(jsonObject.toString());
				RasaService.sendTrainRequest(jsonObject.toString());
			} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		checkConnection();
		assert (true);
	}
	
	@Test
	@Ignore // only run train test if necessary. This is an expensive process.
	public void testTrainFile() {

		if (checkConnection()) {
			try {
				RasaService.sendTrainFileRequest(new File("src/test/resources/training.json"));
			} catch (JsonIOException | JsonSyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		checkConnection();
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
