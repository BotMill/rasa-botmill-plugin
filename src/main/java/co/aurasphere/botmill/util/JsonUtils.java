package co.aurasphere.botmill.util;

import java.util.Calendar;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thub.ml.util.CalendarSerializer;
import com.thub.ml.util.DateToLongJsonDeserializer;
import com.thub.ml.util.EnumLowercaseSerializer;

public class JsonUtils {

	private static Gson gson;
	
	private static Gson getGson() {
		if (gson == null) {
			// Creates the Gson object which will manage the information
			// received
			GsonBuilder builder = new GsonBuilder();

			// Register an adapter to manage the date types as long values
			builder.registerTypeAdapter(Date.class,
					new DateToLongJsonDeserializer());
			
			// Serializes enums as lower-case.
			builder.registerTypeHierarchyAdapter(Enum.class,
					new EnumLowercaseSerializer());
			
			// Serializes calendar in format YYYY-MM-DDThh:mm.
			builder.registerTypeHierarchyAdapter(Calendar.class,
					new CalendarSerializer());

			gson = builder.create();
		}
		return gson;
	}
	
	public static <T> T fromJson(String json, Class<T> T){
		return getGson().fromJson(json, T);
	}
	
	public static String toJson(Object src){
		return getGson().toJson(src);
	}

}
