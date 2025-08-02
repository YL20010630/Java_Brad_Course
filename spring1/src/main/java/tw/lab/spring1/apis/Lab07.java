package tw.lab.spring1.apis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.lab.spring1.Spring1Application;

@RestController
@RequestMapping("/lab07")
public class Lab07 {
	
	/*
		NamedParameterJdbcTemplate
		update() => insert, delete, update
		query() => select
		
	 */
	
//	用 @Autowired 把它注入後，就可以用 .update()、.query() 等方法去操作資料庫
	@Autowired
//	這行會注入 Spring Boot 幫你管理的 JdbcTemplate 類別，支援 SQL 查詢與資料綁定（可以用 :name 替代 ?）
	private NamedParameterJdbcTemplate jdbc;
	@Autowired
	private Response response;

	@PostMapping("/member")
//	透過 @RequestBody 將 JSON 轉成 Java Member 物件
	public Response addMember(@RequestBody Member member) {
		String sql = """
				INSERT INTO member (account,passwd,name)
				VALUES (:account, :passwd, :name)
				""";
		Map<String,String> params = new HashMap<>();
		params.put("account", member.getAccount());
		params.put("passwd", BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));
		params.put("name", member.getName());
		
		jdbc.update(sql, params);
		
		response.setError(0);
		response.setMesg("Success");
		
		return response;
		
	}
	
	@DeleteMapping("/member/{id}")
//	@PathVariable 取得網址中的 id
	public Response delMember(@PathVariable Integer id) {
		String sql = """
				DELETE FROM member
				WHERE id = :id
				""";
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		jdbc.update(sql, params);
		
		response.setError(0);
		response.setMesg("Success");
		
		return response;
	}
	
	@PutMapping("/member")
	public Response updateMember(@RequestBody Member member) {
		String sql = """
				Update member
				SET account = :account, name = :name
				WHERE id = :id
				""";
//		Map<String, Object>：可混合任何型別
		Map<String,Object> params = new HashMap<>();
		params.put("id", member.getId());
		params.put("account", member.getAccount());
		params.put("name", member.getName());
		
		int n = jdbc.update(sql, params);
		if(n>0) {
			response.setError(0);
			response.setMesg("Success");
		}else {
			response.setError(1);
			response.setMesg("Update Failure");
		}

		
		return response;
		
	}
	
	
	
}
