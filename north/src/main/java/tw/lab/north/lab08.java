package tw.lab.north;

import java.util.List;

import org.hibernate.Session;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import tw.lab.entity.Product;

/*
	
	用 Criteria 查詢庫存量小於等於安全庫存量的商品(即 UnitsInStock <= ReorderLevel)
	
 */


/*
 * SELECT ..... 
 * FROM products
 * WHERE UnitsInStock <= ReorderLevel
 */
public class lab08 {
	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> cq = builder.createQuery(Product.class);
			Root<Product> root = cq.from(Product.class);
			
			Predicate lowStock = builder.lessThanOrEqualTo(root.get("unitsInStock"), root.get("reorderLevel"));
			
			cq.multiselect(
					root.get("productName"),
					root.get("unitsInStock"),
					root.get("unitsOnOrder"),
					root.get("reorderLevel")
					).where(lowStock);
			
			List<Product> ps = session.createQuery(cq).getResultList();
			
			for (Product pp : ps) {
				System.out.printf("%s:%d:%d\n", 
						pp.getProductName(),
						pp.getUnitsInStock(),
						pp.getReorderLevel());
			}
			
			System.out.println("-- JSON --");
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ps);
			System.out.println(json);
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}