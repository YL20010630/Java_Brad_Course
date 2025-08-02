package tw.lab.north;

import java.util.List;

import org.hibernate.Session;

import tw.lab.entity.Employee;


//	用 Hibernate 的 native SQL 查詢，並且不直接映射成 Employee 實體類別，而是以 Object[] 陣列來接收每一列資料


public class lab03 {
	public static void main(String[] args) {
		String sql = """
				SELECT * FROM employees 
				ORDER BY Title ASC, LastName DESC
				""";
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
//			使用 createNativeQuery 執行 SQL，並且用 Object[].class 指定結果是一個 Object 陣列的清單
			List<Object[]> employees = 
				session.createNativeQuery(sql, Object[].class).getResultList();
//			每一筆查詢結果（每一列資料）會是一個 Object 陣列，陣列內的元素對應資料庫欄位的值，欄位順序與 SQL 查詢結果相同
			
			for (Object[] employee : employees) {
				System.out.printf("%d. %s : %s %s\n",
						employee[0],
						employee[1],
						employee[2],
						employee[3]);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}		
	}
}





