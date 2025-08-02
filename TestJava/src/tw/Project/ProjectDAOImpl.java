package tw.Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class ProjectDAOImpl implements ProjectDAO {
	private static final String URL = "jdbc:mysql://localhost/north";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private Connection conn;
	public ProjectDAOImpl() throws Exception {
		try {
			Properties prop = new Properties();
			prop.setProperty("user", USER);
			prop.setProperty("password", PASSWORD);
			conn = DriverManager.getConnection(URL, prop);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

		public List<SaleRanking> rankSaleEmployee() {
//		業績排行
			String sql = """
				SELECT o.EmployeeID, e.FirstName, e.LastName, SUM(od.UnitPrice*od.Quantity) sum FROM `orders` o
					JOIN orderdetails od ON o.OrderID = od.OrderID
					JOIN employees e ON o.EmployeeID = e.EmployeeID
					GROUP BY o.EmployeeID
					ORDER BY sum desc
				""";
			
//			建立暫時清單
			List<SaleRanking> SRlist = new ArrayList<>();
			
			try (PreparedStatement rstmt = conn.prepareStatement(sql)){
				ResultSet rs = rstmt.executeQuery();
				while (rs.next()) {
					int employeeId = rs.getInt("EmployeeID");
					String firstName = rs.getString("FirstName");
					String lastName = rs.getString("LastName");
					double totalSales = rs.getDouble("sum");
//					System.out.printf("員工ID：%d\t姓名：%s %s\t總銷售額：%.2f%n", employeeId, firstName, lastName, totalSales);
//					不印資料，只加入list
					
//					建立排行物件並加入清單
					SaleRanking rankings = new SaleRanking(employeeId, firstName, lastName, totalSales);
					SRlist.add(rankings);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			return SRlist;
			
	}
	
	
}
