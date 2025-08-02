package tw.lab.spring0.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewFile2Controller {

	@GetMapping("/api/chart-data")
	public Map<String, Object> getData() {
	    System.out.println("API 被呼叫了");

	    Map<String, Object> result = new HashMap<>();
	    result.put("labels", List.of("Mon", "Tue", "Wed"));
	    result.put("values", List.of(100, 200, 300));
	    System.out.println("資料送出！");
	    return result;
	}

	

}
