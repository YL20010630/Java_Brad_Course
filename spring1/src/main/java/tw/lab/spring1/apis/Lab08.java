package tw.lab.spring1.apis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("lab8")
@RestController
public class Lab08 {

    private final Bike1 bike1;
	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private Response response;

    Lab08(Bike1 bike1) {
        this.bike1 = bike1;
    }
	
//	test1  單筆新增會員
//	這是一個 POST API，接受兩個路徑，其中 isGetId 是可選的布林路徑參數
	@PostMapping(value= {"/member", "/member/{isGetId}"})
	public Response test1(
//			@RequestBody：表示從Postman傳來的JSON資料會自動轉換成Java的Member物件需要有(account、passwd、name 欄位)
			@RequestBody Member member, 
//			@PathVariable(required = false)：網址路徑中/member/true或/member/false會被抓進來當作isGetId，沒傳則為null
//			required = false表示這個網址的參數可以不傳
			@PathVariable(required = false)Boolean isGetId) {
		
//		如果沒傳 isGetId，就預設為 false
		isGetId = isGetId == null ? false : isGetId;
		System.out.println(isGetId);
		
		String sql = """
				INSERT INTO member (account,passwd,name)
				VALUES (:account, :passwd, :name)
				""";
		Map<String,String> params = new HashMap<>();
		params.put("account", member.getAccount());
		params.put("passwd", BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));
		params.put("name", member.getName());
		
//		KeyHolder 用來取得資料庫自動生成的主鍵（通常是自增的 id）
		KeyHolder keyHolder = new GeneratedKeyHolder();
//		jdbc.update() 執行 SQL，帶入參數和 KeyHolder
		int n = jdbc.update(sql, new MapSqlParameterSource(params) , keyHolder);
//		成功時從 keyHolder 取得新插入資料的 id
		int id = keyHolder.getKey().intValue();
		
//		setError中0代表成功，1錯誤代表，-1代表特殊錯誤或警告
		if (n > 0) {
			response.setError(0);
			response.setMesg("Insert Success");
			response.setInsertId(isGetId?id:0);
			
		}else {
			response.setError(-1);
			response.setMesg("Insert Failure");
		}
		
		
		
		return response;
	}
	
//	test2  批次新增多筆會員
	@PostMapping("/members")
	public Response test2(@RequestBody List<Member> members) {
		String sql = """
				INSERT INTO member (account,passwd,name)
				VALUES (:account, :passwd, :name)
				""";
//		建立一個 MapSqlParameterSource 陣列，大小是會員數量
		MapSqlParameterSource[] params = 
			new MapSqlParameterSource[members.size()];
//		用迴圈把每個會員資料轉成 MapSqlParameterSource，加到陣列中
		for (int i=0; i<members.size(); i++) {
			params[i] = new MapSqlParameterSource();
			params[i].addValue("account", members.get(i).getAccount());
			params[i].addValue("passwd", BCrypt.hashpw(members.get(i).getPasswd(), BCrypt.gensalt()));
			params[i].addValue("name", members.get(i).getName());
		}
		
//		建立一個 KeyHolder 用來接收資料庫自動產生的主鍵（例如 id，目前沒有作用，要抓主鍵需要改用 update() 並一筆一筆插入才行
		KeyHolder keyHolder = new GeneratedKeyHolder();
//		使用 NamedParameterJdbcTemplate 的 batchUpdate() 方法一次插入多筆資料
		int[] n = jdbc.batchUpdate(sql, params);
		System.out.println(n.length);
		
//		嘗試從 keyHolder 取得每筆資料的自動主鍵，但 batchUpdate() 是 批次執行的寫法，通常抓不到主鍵，要取得主鍵，要改為一筆一筆用 update(..., keyHolder)
		List<Map<String,Object>> ids = keyHolder.getKeyList();
		for (Map<String,Object> id: ids) {
			System.out.println(id.get("GENERATED_KEY"));		// GENERATED_KEY: 主鍵值
		}
		
		
		return response;
	}
	
	
}