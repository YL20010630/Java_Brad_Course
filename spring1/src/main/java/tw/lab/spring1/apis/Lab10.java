package tw.lab.spring1.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lab10")
public class Lab10 {
	
	@Autowired
	private Scooter scooter;
	
	public Lab10() {
		System.out.println("Lab10()");
	}
	
	@RequestMapping("/test1")
	public void test1() {
		scooter.m1();
	}
}
