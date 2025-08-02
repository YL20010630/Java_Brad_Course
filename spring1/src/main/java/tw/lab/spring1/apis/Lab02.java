package tw.lab.spring1.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lab02")
public class Lab02 {
//	@Autowired：自動注入 Spring 容器中符合型別的 Bean
	@Autowired
	private Bike bike1;
	
	@Autowired
	private Bike bike2;

	@Autowired
//	@Qualifier：指定注入哪個 Bean 名稱
	@Qualifier("bike1")
	private Bike bike3;
	
	@Autowired
	private Bike3 myBike;

	public Lab02() {
		System.out.println("lab02()");
	}
	
	@RequestMapping("/test1")
	public void test1() {
		bike1.upSpeed();
	}
	
	@RequestMapping("/test2")
	public void test2() {
		bike2.upSpeed();
	}

	@RequestMapping("/test3")
	public void test3() {
		bike3.upSpeed();
	}

	@RequestMapping("/test4")
	public void test4() {
		myBike.upSpeed();
	}

}