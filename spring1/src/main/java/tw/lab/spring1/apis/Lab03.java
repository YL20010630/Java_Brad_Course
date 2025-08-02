package tw.lab.spring1.apis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller		// Bean
@RequestMapping("/lab03")
public class Lab03 {
	public Lab03() {System.out.println("lab03()");}
	
	@RequestMapping("/test1")
	public String test1() {
		
		return "test1";
	}
	
}