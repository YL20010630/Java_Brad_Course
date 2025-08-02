package tw.lab.north;

import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/*

	把 HashMap<String, Object> 轉成 JSON 字串
	再把 JSON 字串轉回 HashMap<String, Object>

 */

public class lab09 {

	public static void main(String[] args) {
		HashMap<String, Object> person = new HashMap<>();
		person.put("name", "Cyncia");
		person.put("age", 18);
		person.put("gender", false);
		person.put("weight", 42.5);
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(person);
			System.out.println(json);
			
			System.out.println("-----");
			
			HashMap<String, Object> cia;
			cia = mapper.readValue(json, 
					new TypeReference<HashMap<String, Object>>() {});
			
			System.out.println(cia.get("name"));
			System.out.println(cia.get("age"));
			System.out.println(cia.get("gender"));
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
	}

}