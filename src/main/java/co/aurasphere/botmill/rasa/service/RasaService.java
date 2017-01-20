package co.aurasphere.botmill.rasa.service;

import co.aurasphere.botmill.rasa.incoming.model.Response;
import co.aurasphere.botmill.rasa.outgoing.model.Query;
import co.aurasphere.botmill.util.NetworkUtils;

public class RasaService {

	public synchronized static Response sendParseRequest(String query) {
		Query q = new Query();
		q.setQuery(query);
		NetworkUtils.postParse(q);
		
		return null;
		
	}
	public synchronized static Response sendTrainRequest(Object data) {
		return null;
		
	}
	public synchronized static Response getStatus() {
		return null;
		
	}
}
