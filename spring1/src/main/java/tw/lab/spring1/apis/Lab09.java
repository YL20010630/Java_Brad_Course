package tw.lab.spring1.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
	使用Spring Boot 抓取開放資料並存入資料庫
 */

@RestController
@RequestMapping("/lab09")
public class Lab09 {
	
//	jdbc：讓你可以執行安全的 SQL 操作
	@Autowired
	private NamedParameterJdbcTemplate jdbc;

//	template：用來發出 HTTP 請求，像一個小型的 HTTP 客戶端
	@Autowired
	private RestTemplate template;
	
//	test1：抓 JSON 字串 → 轉物件 → 存入資料庫
	@RequestMapping("/test1")
	public void test1() {		
		String url = "https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelStay.aspx";
		
//		RestTemplate template = new RestTemplate();
		
//		用 RestTemplate 抓取 JSON 字串
//		getForObject：向網址發出 GET 請求，拿回的資料格式是 String
//		String.class：HTTP 結果以純文字格式取得
		String content = template.getForObject(url, String.class);
//		System.out.println(content);
		
		
//		System.out.println(content);
		
//		用 ObjectMapper 將JSON轉物件 變成List<Hotel>
		ObjectMapper mapper = new ObjectMapper();
		try {
//			TypeReference：泛型支援 List<Hotel>
			List<Hotel> hotels = mapper.readValue(content, new TypeReference<List<Hotel>>() {});	
//			for(Hotel hotel : hotels) {
//				System.out.println(hotel.getName());
//			}
			
//			清除舊資料、重設自動編號，保持乾淨
			jdbc.update("DELETE FROM hotel", new MapSqlParameterSource());
			jdbc.update("ALTER TABLE hotel auto_increment = 1", new MapSqlParameterSource());
			
			String sql = """
					INSERT INTO hotel (name,addr,tel)
					VALUES (:name, :addr, :tel)
					""";
//			建立一個 MapSqlParameterSource 陣列，大小是會員數量
			MapSqlParameterSource[] params = 
				new MapSqlParameterSource[hotels.size()];
//			用迴圈把每個Hotel資料轉成 MapSqlParameterSource，加到陣列中
			for (int i=0; i<hotels.size(); i++) {
				params[i] = new MapSqlParameterSource();
				params[i].addValue("name", hotels.get(i).getName());
				params[i].addValue("addr", hotels.get(i).getAddr());
				params[i].addValue("tel", hotels.get(i).getTel());
			}
//			batchUpdate() 一次執行多筆 SQL
			int[] n = jdbc.batchUpdate(sql, params);
			
			System.out.printf("%d / %d\n", n.length, hotels.size());
			
			System.out.println("Finish");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
		
		
//		test2：抓資料 → 直接轉成陣列 → 顯示名稱，(用簡單寫法直接轉成陣列)
		@RequestMapping("/test2")
		public void test2() {
			String url = "https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelStay.aspx";
//			RestTemplate template = new RestTemplate();
			
//			Hotel[].class：HTTP 結果轉成 Hotel 陣列
			Hotel[] hotels = template.getForObject(url, Hotel[].class);
			for(Hotel hotel : hotels) {
				System.out.println(hotel.getName());
			}			
		}
}
	
	