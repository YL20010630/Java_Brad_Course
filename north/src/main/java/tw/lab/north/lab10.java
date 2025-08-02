package tw.lab.north;

import com.fasterxml.jackson.databind.ObjectMapper;

import tw.lab.entity.Phone;
import tw.lab.entity.User;

/*
	將 JSON 字串轉成 Java 物件（User），並處理巢狀欄位與陣列
	使用User.java、Address.java、Phone.java
 */

public class lab10 {

	public static void main(String[] args) {
		String json = """
					{
						"name" : "Brad",
						"age": 18,
						"address": {
							"city": "台中市",
							"town": "南屯區",
							"addr": "公益路100號"
						},
						"phones": [
							{
								"type": "CHT",
								"number": "0912-123456"
							},
							{
								"type": "ABC",
								"number": "0912-765432"
							}
						]
					}				
				""";
		ObjectMapper mapper = new ObjectMapper();
		try {
			User user = mapper.readValue(json, User.class);
			System.out.println(user.getName());
			System.out.println(user.getAddress().getCity());
			for (Phone phone: user.getPhones()) {
				System.out.println(phone.getNumber());
			}
			//----------------------
			String json2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
			System.out.println(json2);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}