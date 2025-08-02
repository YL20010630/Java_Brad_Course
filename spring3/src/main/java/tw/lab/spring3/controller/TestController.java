package tw.lab.spring3.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import tw.lab.spring3.entity.MemberForm;
import tw.lab.spring3.entity.User;
import tw.lab.spring3.entity.UserForm;

/*
 * request -> Controller (Model) -> Model 網頁需要的資料
 * -> View(Resolver) -> Thymeleaf -> HTML -> Response
 * 
 * RestController(return => String(Web Page) => JSON) -> Controller(JSP, Thymeleaf)
 */
@Controller
@RequestMapping("/")
public class TestController {

	@GetMapping("/index")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/member/index")
	public String indexMember(Model model) {
		return "member/index";
	}
	
	@GetMapping("/page1")
	public String page1(Model model) {
		model.addAttribute("name", "Lab");
		model.addAttribute("companyName", "Lab Big Company");
		model.addAttribute("companyTel", "04-23265860");
		
		User user = new User();
		user.setName("Lab");
		user.setAge(17);
		user.setGender(false);
		
		model.addAttribute("user", user);
		
		String now = 
			LocalDateTime.now().format(
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		model.addAttribute("now", now);
		
		return "page1";
	}
	
	@GetMapping("/member/register")
	public String register(Model model) {
		
		MemberForm form = new MemberForm();
		form.setAccount("lab");
		
		//List<String> areas = List.of("北屯區","南屯區","西屯區","北區","西區");
		List<Map<String,String>> areas = List.of(
				Map.of("zipcode","401","name","北屯區"),
				Map.of("zipcode","402","name","南屯區"),
				Map.of("zipcode","403","name","西屯區"),
				Map.of("zipcode","404","name","北區"),
				Map.of("zipcode","405","name","西區")
				);
		
		
		model.addAttribute("areas", areas);
		
		model.addAttribute("memberForm", form);
		
		return "member/register";
	}
	@PostMapping("/member/register")
	public String addMember(Model model, 
			@ModelAttribute MemberForm form) {
		
		System.out.println(form.getAccount());
		System.out.println(form.getPasswd());
		System.out.println(form.getName());
		System.out.println(form.getArea());
		
		model.addAttribute("status", "註冊成功");
		
		return "member/register";
	}
	@GetMapping("/page2/{status}")
	public String page2(Model model, @PathVariable String status) {
		model.addAttribute("status", status);
		return "page2";
	}
	
	@GetMapping("/page3")
	public String page3(Model model) {
		model.addAttribute("userForm", new UserForm());
		return "page3";
	}
	
	@PostMapping("/page3")
	public String page3post(Model model,
			@ModelAttribute @Valid UserForm userForm,
			BindingResult bindResult) {
		
		if (bindResult.hasErrors()) {
			return "page3";
		}
		
		return "page4";
	}
	
	@GetMapping("/page5")
	public String page5(Model model) {
		List<String> areas = List.of("北屯區","南屯區","西屯區","北區","西區");
		model.addAttribute("areas", areas);
		return "page5";
	}
	
}