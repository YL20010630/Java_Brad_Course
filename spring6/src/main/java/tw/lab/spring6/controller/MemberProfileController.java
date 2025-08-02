package tw.lab.spring6.controller;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.standard.Severity;

import org.aspectj.lang.annotation.DeclareMixin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.lab.spring6.entity.Member;
import tw.lab.spring6.entity.Profile;
import tw.lab.spring6.service.MemberProfileService;

@RestController
@RequestMapping("/api")
public class MemberProfileController {

	@Autowired
	private MemberProfileService service;
	
	/*
	 * {
	 * 		"email": "brad@brad.tw",
	 * 		"passwd": "123456",
	 * 		"profile": {
	 * 						"cname": "Brad",
	 * 						"age": 18
	 * 					}
	 * }
	 */
	@PostMapping("/member")
	public ResponseEntity<Member> addMember(
			@RequestBody Map<String,Object> data){
		Member m = new Member();
		m.setEmail((String)data.get("email"));
		m.setPasswd((String)data.get("passwd"));
		
		Profile p = null;
		Map<String,Object> pdata = (Map<String,Object>)(data.get("profile"));
		if (pdata != null) {
			p = new Profile();
			p.setCname((String)pdata.get("cname"));
			p.setAge((Integer)pdata.get("age"));
		}
		Member newMember = service.save(m, p);
		
		return ResponseEntity.ok(newMember);
	}
	
	@RequestMapping("/member/{id}/profile")
	public ResponseEntity<Profile> updateProfile(
			@PathVariable Long id,
			@RequestBody Map<String,Object> data
			) {
		Map<String,Object> pdata = (Map<String,Object>)data;
		Profile p = new Profile();
		p.setCname((String)pdata.get("cname"));
		p.setAge((Integer)pdata.get("age"));
		Profile newp = service.setProfileToMember(id, p);
		return ResponseEntity.ok(newp);
	}
	
	@GetMapping("/member/{id}")
	public ResponseEntity<Member> queryMember(@PathVariable Long id){
		return ResponseEntity.ok(service.findMember(id));
	}
	
	@DeleteMapping("/member/{id}")
	public ResponseEntity<Map<String,Boolean>> delMember(@PathVariable Long id){
		service.deleteMember(id);
		Map<String,Boolean> map = new HashMap<String, Boolean>();
		map.put("success", true);
		return ResponseEntity.ok(map);
	}
	
}