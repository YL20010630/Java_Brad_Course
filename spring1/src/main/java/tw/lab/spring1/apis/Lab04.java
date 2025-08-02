package tw.lab.spring1.apis;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
	
	@RequestParam	URL 查詢參數
	@PathVariable	URL 路徑變數
	@RequestBody	JSON / 表單資料
	@RequestHeader	HTTP Header
	
 */


@RestController
@RequestMapping("/lab04")
public class Lab04 {
	
//	呼叫方式：/lab04/m1?x=3&y=5
//	m1()：從 URL 參數取得值（字串 + 手動轉型）
//	@RequestParam: 從 URL 查詢參數取值，如 ?x=3&y=5
//	required=false：表示可不傳
//	這裡先用 String 接，再用 Integer.parseInt() 轉換
	@RequestMapping("/m1")
	public void m1(
			@RequestParam(required = false, defaultValue = "0") String x, 
			@RequestParam(required = false, defaultValue = "0") String y) {
		try {
			Integer xx = Integer.parseInt(x);
			Integer yy = Integer.parseInt(y);
			int rr = xx + yy;
			System.out.printf("%d + %d = %d\n", xx, yy, rr);
		}catch(Exception e) {
			System.out.println("ERROR:" + e);
		}
	}
	
//	m2()：從 URL 參數取得值（直接接 Integer）
//	與 m1 類似，但直接接 Integer，Spring 幫忙自動轉型
	@RequestMapping("/m2")
	public String m2(
			@RequestParam(required = false, defaultValue = "0") Integer x, 
			@RequestParam(required = false, defaultValue = "0") Integer y) {
		int r = x + y;
		System.out.printf("%d + %d + %d\n", x, y, r);
		return r+"";
	}
	
//	m3()：從請求 body 傳入 JSON → 自動組成 Java 物件
	@RequestMapping("/m3")
//	@RequestBody：從 HTTP 請求的 body 解析 JSON，自動映射到 User 物件
	public void m3(@RequestBody User user) {
		System.out.println(user.getName());
		System.out.println(user.getGender());
		System.out.println(user.getAge());
	}
	
//	m4()：從 URL 的 路徑變數 取得資料
//	呼叫方式：/lab04/m4/123/Amy
	@RequestMapping("/m4/{id}/{name}")
	public void m4(
//			@PathVariable：把 URL 裡 /m4/123/Amy 的部分拆成變數使用
			@PathVariable String name,
			@PathVariable Integer id) {
		System.out.printf("%d : %s\n", id, name);
	}
	
//	m5()：綜合用法（路徑 + Query + JSON Body）
//	呼叫方式：POST /lab04/m5/1/Bob?x=5&y=10
//	Body 傳 JSON，URL 有 query param 和 path variable，全部一起處理
	@RequestMapping("/m5/{id}/{name}")
	public void m5(
			@PathVariable String name,
			@PathVariable Integer id,
			@RequestParam(required = false, defaultValue = "0") String x, 
			@RequestParam(required = false, defaultValue = "0") String y,
			@RequestBody User user			
			) {
		System.out.printf("%d : %s : %s : %s\n", id, name, x, y);
		System.out.println(user.getName());
		System.out.println(user.getGender());
		System.out.println(user.getAge());		
	}
	
//	m6()：從 Header 取得資料
	@RequestMapping("/m6")
	public void m6(
//			@RequestHeader：從 HTTP request headers 抓資料
			@RequestHeader String x, 
			@RequestHeader Integer y,
			@RequestHeader(name = "Content-Type") String contentType
			) {
		System.out.printf("%s : %d : %s\n", x, y, contentType);
	}
	
	
	
}