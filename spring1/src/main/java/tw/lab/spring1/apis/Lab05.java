package tw.lab.spring1.apis;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
		Restful
		Create: Post
		Delete: Delete
		Read: 	Get
		Updata: Put
		
	 */

@RestController
@RequestMapping("/lab05")
public class Lab05 {
	
//	查詢所有使用者
	@GetMapping("/users")
	public void m1() {
		System.out.println("m1()");
	}
	
//	查詢特定使用者
	@GetMapping("/user/{id}")
	public void m2(@PathVariable Integer id) {
		System.out.println("m2():id = "+ id);
	}
	
//	查詢某使用者的某台腳踏車資訊
	@GetMapping("/user/{id}/bike/{bid}")
	public void m3(@PathVariable Integer id, @PathVariable Integer bid) {
		System.out.println("m3():id = "+ id +", bikeSpeed = "+ bid);
	}
	
//	建立使用者
	@PostMapping("/user")
	public void m4(@RequestBody User user) {
		System.out.println("post:" + user.getName());
	}
	
//	更新使用者資料
	@PutMapping("/user")
	public void m5(@RequestBody User user) {
		System.out.println("put:" + user.getName());
	}
	
//	刪除使用者
	@DeleteMapping("/user/{id}")
	public void m6(@PathVariable Integer id) {
		System.out.println("delete id = " + id);
	}
	
	
	
}
