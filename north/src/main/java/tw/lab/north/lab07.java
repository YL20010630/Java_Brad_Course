package tw.lab.north;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import tw.lab.entity.Employee;

public class lab07 {
	public static void main(String[] args) {
		// Criteria 標準查詢
		/*
		 * Criteria => session => XxxBuilder
		 * CriteriaQuery => 查詢物件
		 */
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = builder.createQuery(Employee.class);
			
			Root<Employee> root = cq.from(Employee.class);
			
			cq.multiselect(
					root.get("title"),
					root.get("lastName"),
					root.get("firstName")
					);
			
			cq.orderBy(
					builder.asc(root.get("title")),
					builder.desc(root.get("lastName")));
			
			List<Employee> employees = session.createQuery(cq).getResultList();
			for (Employee employee : employees) {
				System.out.printf("%s : %s %s\n",
						employee.getTitle(),
						employee.getLastName(),
						employee.getFirstName());
			}				
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}