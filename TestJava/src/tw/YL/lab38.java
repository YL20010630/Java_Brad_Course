package tw.YL;

import java.util.HashMap;
import java.util.Set;

public class lab38 {

	public static void main(String[] args) {
		HashMap<String, Object> person = new HashMap<>();
//		Key屬性 是 String → 屬性名稱（如 "name"、"age"）
//		Value屬性值 是 Object → 什麼型別都能放（字串、數字、布林都 OK）
		
		person.put("name", "Andy");
		person.put("gender", "true");
		person.put("age", "18");
		person.put("weight", "80.3");
		
		System.out.println(person.size());
		System.out.println(person.get("name"));
		System.out.println("--------");
		Set<String> keys = person.keySet();
//		 取得這個 map 裡所有的key 值集合	 ["mame", "genger", "age", "weight"]
		
		for(String key : keys) {
			System.out.println(key + ":" + person.get(key) + "\n");
		}

	}

}
