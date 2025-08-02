package tw.lab.north;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.fasterxml.jackson.databind.ObjectMapper;

/*

	查詢某筆訂單的詳情，包含員工、客戶、商品明細，並以 JSON 格式輸出

 */

public class lab11 {
	/*
	 * SELECT ......
	 * FROM order o
	 * JOIN employees e ON e.EmployeeID = o.EmployeeID
	 * JOIN customers c ON c.CustomerID = o.CustomerID
	 * JOIN orderdetails od ON o.OrderID = od.OrderID
	 * JOIN products p ON od.ProductID = p.ProductID 
	 */
	public static void main(String[] args) {
		String hql = """
				 SELECT 
				 	o.employee.lastName,
				 	o.customer.companyName,
				 	p.productName,
				 	d.unitPrice,
				 	d.quantity 
				 FROM Order o
				 JOIN o.orderDetails d
				 JOIN d.product p
				 WHERE o.orderId = :orderId
				""";
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			List<Object[]> result = session.createQuery(hql, Object[].class)
					.setParameter("orderId", 10249)
					.getResultList();
			
//			原始陣列列印
			for (Object[] row : result) {
				System.out.println("Employee:" + row[0]);
				System.out.println("Company:" + row[1]);
				System.out.println("Product:" + row[2] + ":" + row[3] + ":" + row[4]);
				System.out.println("------------");
			}
			
//			轉成 JSON  方式一：直接 List<Object[]> 
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
			System.out.println(json);
			System.out.println("-------");
			
			toResultJSON(result);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		

	}
	
//	轉成 JSON  方式二：轉成物件封裝
	static void toResultJSON(List<Object[]> result) throws Exception {
		HashMap<String, Object> root = new HashMap<String, Object>();
		if (result.size()>0) {
			root.put("success", true);
			root.put("count", result.size());
			root.put("employee", result.get(0)[0]);
			root.put("customer", result.get(0)[1]);
			
			List<Map<String,Object>> details = new ArrayList<>();
			for (Object[] row: result) {
				Map<String,Object> detail = new HashMap<String, Object>();
				detail.put("pname", row[2]);
				detail.put("price", row[3]);
				detail.put("qty", row[4]);
				details.add(detail);
			}
			root.put("details", details);
		}else {
			root.put("success", false);
		}
		
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
		System.out.println(json);
		System.out.println("-------");
		
		jsonToOrderItem(json);
		
	}
	
	static void jsonToOrderItem(String json) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		OrderItem order = mapper.readValue(json, OrderItem.class);
		System.out.println(order.custoomer);
		System.out.println(order.employee);
		System.out.println(order.count);
		System.out.println(order.success);
		for (DetailItem detail : order.details) {
			System.out.printf("%s : %f : %d\n", detail.pname, detail.price, detail.qty);
		}
	}
	
}

class OrderItem {
	public Boolean success;
	public Integer count;
	public String custoomer;
	public String employee;
	public List<DetailItem> details;
}
class DetailItem {
	public String pname;
	public Double price;
	public Integer qty;
}