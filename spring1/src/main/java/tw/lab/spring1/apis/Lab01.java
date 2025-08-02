package tw.lab.spring1.apis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController		
// => Bean => Ioc => Server Starting
// => 會被 Spring 掃描為一個 Bean（元件） => Spring 會在啟動時將它放入 IoC 容器中（控制反轉） => 類中所有回傳值都會自動當作 HTTP 回應內容（
@RequestMapping("/lab01")
// 設定這個 Controller 的路徑前綴為 /lab01
public class Lab01 {
	public Lab01() {
		System.out.println("lab01()");
	}
	
	@RequestMapping("/test1")
	public void test1() {
		System.out.println("lab01:test1()");
	}
	
	@RequestMapping("/test2")
	public String test2() {
		System.out.println("lab01:test2()");
		return "Test2";
	}
	
	
}