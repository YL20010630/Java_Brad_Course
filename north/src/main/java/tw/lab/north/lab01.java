package tw.lab.north;

import java.util.List;

import org.hibernate.Session;

import tw.lab.entity.Employee;

public class lab01 {

	public static void main(String[] args) {
		String sql = """
				SELECT * FROM employees 
				ORDER BY Title ASC, LastName DESC
				""";
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			List<Employee> employees = 
//					.createNativeQuery()是SQL查詢，.createQuery()是HSQL查詢
//					Employee.class 是將結果轉成 Employee 物件，.getResultList()：取得查詢結果
					session.createNativeQuery(sql, Employee.class).getResultList();
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