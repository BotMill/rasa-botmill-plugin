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

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;

import co.aurasphere.botmill.rasa.incoming.rasa.model.DucklingTimeEntityValue;
import co.aurasphere.botmill.rasa.incoming.rasa.model.Response;
import co.aurasphere.botmill.rasa.incoming.rasa.model.StringEntityValue;
import co.aurasphere.botmill.rasa.service.RasaService;
import co.aurasphere.botmill.util.JsonUtils;

/**
 * The Class RasaBotMillServiceTest.
 */
public class RasaBotMillServiceTest {

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		RasaBotMillContext.configure().setup("http://138.197.132.50:5001","3cXuFQdNBae2l/iInieT7Ud3mDVXwZUY");
	}

	/**
	 * Test parse.
	 */
	@Test
	public void testParse() {
		if (checkConnection()) {
			Response resp = RasaService.sendParseRequest("CYYZ KJFK 15JUL2017 20JUN2017");
			resp.searchForDucklingValue("time");
			System.out.println(resp.getText());
			assertNotNull(resp);
		}
		assert (true);
	}
	
	@Test
	public void testParseComplexDate() {
		if (checkConnection()) {
			Response resp = RasaService.sendParseRequest("can you setup request from uggw to cyyz tomorrow to friday?");
			System.out.println(resp.searchForStringEntityValue("departure_icao").getStringValue());
			System.out.println(((DucklingTimeEntityValue)resp.searchForDucklingValue("start_date")).getTo());
			System.out.println(((DucklingTimeEntityValue)resp.searchForDucklingValue("end_date")).getFrom());
			System.out.println(resp.searchForStringEntityValue("arrival_icao").getStringValue());
			
			Response resp1 = RasaService.sendParseRequest("uggw cyyz from tomorrow to friday?");
			//System.out.println(resp1.searchForStringEntityValue("departure_icao").getStringValue());
			System.out.println(((DucklingTimeEntityValue)resp1.searchForDucklingValue("start_date")).getTo());
			System.out.println(((DucklingTimeEntityValue)resp1.searchForDucklingValue("end_date")).getFrom());
			//System.out.println(resp1.searchForStringEntityValue("arrival_icao").getStringValue());
			
			Response resp2 = RasaService.sendParseRequest("tomorrow?");
			//System.out.println(resp2.searchForStringEntityValue("departure_icao").getStringValue());
			System.out.println(((StringEntityValue)resp2.searchForDucklingValue("start_date")).getStringValue());
			//System.out.println(resp2.searchForStringEntityValue("arrival_icao").getStringValue());
			assertNotNull(resp);
		}
		assert (true);
	}
	
	/**
	 * Test train string.
	 */
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		checkConnection();
		assert (true);
	}
	
	/**
	 * Test train file.
	 */
	@Test
	@Ignore // only run train test if necessary. This is an expensive process.
	public void testTrainFile() {

		if (checkConnection()) {
			try {
				RasaService.sendTrainFileRequest(new File("src/test/resources/training.json"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		checkConnection();
		assert (true);
	}

	/**
	 * Check connection.
	 *
	 * @return true, if successful
	 */
	private boolean checkConnection() {
		Response status = RasaService.getStatus();
		if (status == null) {
			return false;
		}
		return true;
	}
}
