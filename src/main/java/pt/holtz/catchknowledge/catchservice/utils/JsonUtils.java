package pt.holtz.catchknowledge.catchservice.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class JsonUtils {

	public static <T> List<T> jsonArrayToList(String json, Class<T> elementClass) throws IOException {
	    ObjectMapper objectMapper = new ObjectMapper();
	    CollectionType listType = 
	      objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, elementClass);
	    return objectMapper.readValue(json, listType);
	}
	
	public static List<Object> extractToMap(String strName,String strValue) {
		List<Object> qttObjects = new ArrayList<Object>();
		Map<String,String> mapParam = new HashMap<String, String>();
		mapParam.put("name", strName);
		mapParam.put("value", strValue);
		qttObjects.add(mapParam);
		return qttObjects;
	}
	
}
