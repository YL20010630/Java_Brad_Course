package tw.lab.spring5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.lab.spring5.entity.Hotel;
import tw.lab.spring5.repository.HotelRepository;
import tw.lab.spring5.service.MemberService;

@RestController
@RequestMapping("/")
public class MemberController {

	@Autowired
	private MemberService service;
	
	@Autowired
	private HotelRepository repository;
	
	@RequestMapping("/test1")
	public void test1() {
		service.query1();
	}
	@RequestMapping("/test2")
	public void test2() {
		service.query2();
	}
	@RequestMapping("/test3")
	public void test3() {
		service.query3();
	}
	@RequestMapping("/test4")
	public void test4() {
		List<Hotel> hs = repository.findByNameAndAddrAndTel("民宿", "台南", "68");
		for (Hotel hotel: hs) {
			System.out.printf("%s : %s :%s\n", hotel.getName(), hotel.getAddr(), hotel.getTel());
		}

	}
	
	
	
	
	
}