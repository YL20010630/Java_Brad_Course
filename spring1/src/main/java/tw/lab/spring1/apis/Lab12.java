package tw.lab.spring1.apis;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
	
 */

@RestController
@RequestMapping("/lab12")
public class Lab12 {

	@Autowired
	@Qualifier("northJdbc")
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private OrderDetailRowMapper mapper;
	
	/*
	 SELECT o.OrderID id, p.ProductName pname,
	  			od.UnitPrice price, od.Quantity qty
	 FROM orders o
	 JOIN orderdetails od ON o.OrderID = od.OrderID
	 JOIN products p ON od.ProductID = p.ProductID
	 WHERE o.OrderID = :orderId
	 */
//	test1：取得單一訂單的明細列表
	@GetMapping("/order/{orderId}")
	public List<OrderDetail> test1(@PathVariable int orderId) {
		String sql = """
					 SELECT o.OrderID id, p.ProductName pname,
					  			od.UnitPrice price, od.Quantity qty
					 FROM orders o
					 JOIN orderdetails od ON o.OrderID = od.OrderID
					 JOIN products p ON od.ProductID = p.ProductID
					 WHERE o.OrderID = :orderId
				""";
		Map<String,Object> params = new HashMap<>();
		params.put("orderId", orderId);
		
//		jdbc.query(sql, params, mapper)：用 OrderDetailRowMapper 把每一筆資料轉成 OrderDetail 物件
		return jdbc.query(sql, params, mapper);
	}
	
	
	/*
	 	 SELECT o.OrderID id, o.OrderDate odate,
	 	 	p.ProductName pname, od.UnitPrice price, od.Quantity qty
	 	 FROM orders o
		 JOIN orderdetails od ON o.OrderID = od.OrderID
		 JOIN products p ON od.ProductID = p.ProductID
		 
		 WHERE o.OrderID = :orderId
	 */
//	test2：取得訂單與明細
	@GetMapping(value = {"/orders", "/orders/{orderId}"})
	public List<Order> test2(@PathVariable(required = false) Integer orderId){
		String sql = """
		 	 SELECT o.OrderID id, o.OrderDate odate,
		 	 	p.ProductName pname, od.UnitPrice price, od.Quantity qty
		 	 FROM orders o
			 JOIN orderdetails od ON o.OrderID = od.OrderID
			 JOIN products p ON od.ProductID = p.ProductID				
				""";
		Map<String,Object> params = new HashMap<>();
//		如果orderId為null，查詢所有訂單；不為null則查詢特定訂單
		if (orderId != null) {
			sql += "WHERE o.OrderID = :orderId";
			params.put("orderId", orderId);
		}
		
//		jdbc.queryForList 查出來是 List<Map<String,Object>>，每筆 Map 是一筆資料列，因為是 JOIN，會有重複訂單ID
		List<Map<String,Object>> orderMap = jdbc.queryForList(sql, params);
		//System.out.println(orders.size());
		// Output => []  代表如果查不到資料，就會得到一個空的 List []
		
		
//		用 HashMap<Integer, Order> 把訂單依 ID 存起來，避免重複新增訂單物件
		HashMap<Integer, Order> orders = new HashMap<>();
		
		for (Map<String,Object> row : orderMap) {
			int oid = (Integer)row.get("id");
			Order order = orders.get(oid);
			if (order == null) {
				order = new Order();
				order.setOrderId(oid);
				LocalDateTime odate =  (LocalDateTime)row.get("odate");
				order.setOrderDate(odate.toString());
				orders.put(oid, order);
			}
			
			OrderDetail detail = new OrderDetail();
			detail.setId(oid);
			detail.setPname((String)row.get("pname"));
			detail.setPrice(((BigDecimal)row.get("price")).doubleValue());
			detail.setQty((Integer)row.get("qty"));
			
			order.getOrderDetails().add(detail);
		}
		
		return new ArrayList<Order>(orders.values());
	}
	
	/*
		先查到資料 orderMap 是一個多筆資料列表，每筆是欄位名稱對應欄位值的 Map。
		建立一個空的 orders HashMap 用來整理這些資料，
		依據訂單ID把相關明細合併到同一個 Order 物件，
		最後回傳整理好的訂單清單。
	 */
	
	
}
