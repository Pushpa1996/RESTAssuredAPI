package apiEngine.model.common;

import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CreateJSONObject {
	
	public ObjectNode objectCreation(Map<String,String> map) {
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode data = mapper.createObjectNode();
		
		for(Entry<String, String> S:map.entrySet()) {
			
			String key= S.getKey();
			String Value= S.getValue();
			data.put(key, Value);
			
		}
		
		return data;
		
	}

}
