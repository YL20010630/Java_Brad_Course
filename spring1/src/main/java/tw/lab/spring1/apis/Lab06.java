package tw.lab.spring1.apis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
	連接spring.application.name檔案
 */

@RestController
@RequestMapping("/lab06")
public class Lab06 {
	@Value("${company.name}")
	private String companyName;
	
	@Value("${age}")
	private Integer age;
	
	@RequestMapping("/m1")
	public void m1() {
		System.out.println(companyName);
		System.out.println(age);
	}
	
}