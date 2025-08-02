package tw.lab.apis;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.SortedMap;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

// 工具類別
// 包含多個靜態方法

public class labUtils {
	
//	載入HTML方法
	public static String loadView() throws Exception {
		String source = "C:\\Users\\皮\\eclipse-workspace\\labWeb\\src\\main\\webapp\\views\\view1.html";
		File html = new File(source);
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(html));
		byte[] data = bin.readAllBytes();
		bin.close();
		
		return new String(data);
	}
	
	public static String loadView(String view) throws Exception {
		String source = String.format(
				"C:\\Users\\皮\\eclipse-workspace\\labWeb\\src\\main\\webapp\\views\\view1.html",view);
		File html = new File(source);
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(html));
		byte[] data = bin.readAllBytes();
		bin.close();
		
		return new String(data);
	}
	
//	計算方法
	public static String calc(String sx, String sy, String op) {
		try {
			int x = Integer.parseInt(sx);
			int y = Integer.parseInt(sy);
			StringBuffer sb = new StringBuffer();
			switch(op) {
				case "1": sb.append(x + y); break;
				case "2": sb.append(x - y); break;
				case "3": sb.append(x * y); break;
				case "4": sb.append(x / y).append(" ...... ").append(x % y) ; break;
			}
			return sb.toString();
		}catch(Exception e) {
			return "";
		}
	}
	
//	產生隨機分數方法
	public static String createScore() {
		return (int)(Math.random()*101)+"";
	}
	
//	JSON 字串 轉 Java 陣列
//	解析JSON方法	
//	取出其中每個店家的名稱電話地址，並將這些資料放入 TreeMap 中，再回傳整個 TreeMap 陣列
//	parseFood(...) 將 JSON 陣列轉成 TreeMap 陣列
//	SortedMap[]：回傳一個「有排序的 Map 陣列」；實際上是 TreeMap<String, String>[]
	public static SortedMap[] parseFood(String json) {
		
//		將JSON字串[{...},{...},{...}]解析成JSONArray物件
		JSONArray root = new JSONArray(json);
//		root為多筆{...}
		
//		建立一個陣列，長度和JSON陣列一樣大
//		TreeMap<String, String>[] foods 是很多餐廳的清單
		TreeMap<String, String>[] foods = new TreeMap[root.length()];
		
		for (int i=0; i<root.length(); i++) {
			try {
//				個別資料
//				getJSONObject(i) 取出第 i 筆店家物件
				JSONObject food = root.getJSONObject(i);				
				
//				TreeMap<String, String> map 是一間餐廳的詳細資料
//				用 TreeMap<String, String> 儲存名稱電話地址
				TreeMap<String, String> map = new TreeMap<String, String>();
				map.put("name", food.getString("Name"));
				map.put("tel", food.getString("Tel"));
				map.put("addr", food.getString("City")+food.getString("Town")+food.getString("Address"));
				
//				最後把這個 map 放到陣列中對應位置
				foods[i] = map;
			}catch(Exception e) {
				System.out.println(e + ":" + i);
			}
		}
		//System.out.println(foods.length);
		
//		回傳TreeMap[] 陣列
		return foods;
	}
	
//	Java 陣列 轉 JSON 字串
	public static String order2JSON(SortedMap[] rows) {
//		建立主 JSON 物件 root，用來裝整份訂單資訊（客戶、員工、明細、總價）
		JSONObject root = new JSONObject();
		if (rows.length > 0) {
//			從第一筆資料取出兩個欄位存入customer、employee
			root.put("customer", String.format("%s (%s)", 
					rows[0].getOrDefault("ContactName", ""), 
					rows[0].getOrDefault("CompanyName", "")));
			root.put("employee", String.format("%s %s", 
					rows[0].getOrDefault("FirstName", ""), 
					rows[0].getOrDefault("LastName", "")));
			
			double total = 0;	// 總金額初始化
//			放所有商品的JSON陣列
//			details = [{一個商品的資料}, {第二個商品資料}, {}...]
			JSONArray details = new JSONArray();
//			rows是SortedMap[] 陣列代表多筆訂單明細，row是單筆訂單明細
//			{"cus":"名","emp":"名","details":[{"pid":"1","pname":"名"},{}...]},{row}
			for (SortedMap<String, String> row: rows) {
//				obj = {pid,pname...},{},{}...
//				obj是detail[]裡的JSON物件{}
				JSONObject obj = new JSONObject();
				obj.put("pid", row.getOrDefault("ProductID", ""));
				obj.put("pname", row.getOrDefault("ProductName", ""));
				obj.put("price", row.getOrDefault("UnitPrice", ""));
				obj.put("qty", row.getOrDefault("Quantity", ""));
				
//				字串轉數值後相乘加入sum欄位
				double price = Double.parseDouble(obj.get("price").toString());
				int qty = Integer.parseInt(obj.get("qty").toString());
				double sum = price*qty;
				obj.put("sum", price*qty);
				
				total += sum;
				
				details.put(obj);
			}
			root.put("details", details);
			root.put("total", total);
		}
//		回傳JSON字串
		return root.toString();
		
//		root 是整張訂單的 JSON 物件，包含客戶、員工、商品明細 details、總金額。
//		details 是所有商品明細的 JSON 陣列（每一筆是 obj）。
//		obj 是每筆商品明細資料的 JSON 物件。
//		rows 是一筆訂單的所有明細，每筆是 SortedMap（通常來自資料庫）。
//		row 是單筆明細資料，表示一個商品購買記錄。
		
		
		
	}
	
	
	
}
