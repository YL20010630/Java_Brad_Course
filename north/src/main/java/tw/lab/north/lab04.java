package tw.lab.north;

import java.util.List;

import org.hibernate.Session;

import tw.lab.entity.Employee;


//	用 HQL查詢 Employee 實體


public class lab04 {
	public static void main(String[] args) {
		String hql = """
				FROM Employee e
				ORDER BY e.Title ASC, e.LastName DESC
				""";
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
//			createQuery(hql, Employee.class) 建立一個以 Employee 類別為結果型態的查詢
//			執行後回傳 List<Employee>，每個元素是映射到資料庫資料的 Employee 實體物件
			List<Employee> employees = 
				session.createQuery(hql, Employee.class).getResultList();
			for (Employee employee : employees) {
				System.out.printf("%d. %s : %s %s\n",
						employee.getEmployeeId(),
						employee.getTitle(),
						employee.getLastName(),
						employee.getFirstName());
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}		
	}
}