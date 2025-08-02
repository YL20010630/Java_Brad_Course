package tw.lab.spring1.apis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/lab11")
public class Lab11 {
	
//	用來發送 HTTP 請求
    private final RestTemplate restTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
//	把查詢結果 ResultSet 轉換為 Java 的 Hotel 物件，這是你自己實作的 RowMapper 類別，用來一筆一筆轉物件
	@Autowired
	private HotelRowMapper mapper;

    Lab11(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
	
//    test1：查詢所有飯店
	@GetMapping("/hotels")
	public List<Hotel> test1(){
		String sql = "SELECT id, name, addr, tel FROM hotel";
		
//		查詢整張 hotel 表格，將每一筆轉為 Hotel 物件，並回傳 List<Hotel>
//		mapper 是把查到的每一筆資料轉成 Hotel 物件的工具
		return jdbc.query(sql, mapper);
		
	}
	
//	test2：查詢特定飯店(用 List 包起來)
	@GetMapping("/hotel/{hotelId}")
	public Hotel test2(@PathVariable Long hotelId) {
		String sql = "SELECT id, name, addr, tel FROM hotel WHERE id = :id";
		Map<String, Long> params = new HashMap<>();
		params.put("id", hotelId);
		List<Hotel> hs = jdbc.query(sql, params, mapper);
		if(hs.size() > 0) {
			return hs.get(0);		// 如果有資料，回傳第一筆
		}else {
//			若找不到該筆資料，回傳 errorcode = -1 的 Hotel 物件
			Hotel hotel = new Hotel();
			hotel.setErrorcode(-1);
			return hotel;
		}
	}
	
//	test3：查詢特定飯店（用 queryForObject）
	@GetMapping("/hotel/v2/{hotelId}")
	public Hotel test3(@PathVariable Long hotelId) {
		String sql = "SELECT id, name, addr, tel FROM hotel WHERE id = :id";
		Map<String, Long> params = new HashMap<>();
		params.put("id", hotelId);
		
		Hotel hotel;
		try {
//			用 queryForObject()：如果沒查到，會丟出例外 → 進 catch 區，回傳錯誤資料
			hotel = jdbc.queryForObject(sql, params, mapper);
			
		} catch (Exception e) {
			hotel = new Hotel();
			hotel.setErrorcode(-1);
		}
		return hotel;
	}
	
//	test4：關鍵字搜尋
	@GetMapping("/hotel/search/{key}")
	public List<Hotel> test4(@PathVariable String key) {
		String sql = """
				SELECT id, name, addr, tel FROM hotel 
				WHERE name LIKE :skey OR addr LIKE :skey OR tel LIKE :skey
					""";
		Map<String, String> params = new HashMap<>();
		params.put("skey", "%" + key + "%");
		
		return jdbc.query(sql, params, mapper);
	
	}
	
}
	
