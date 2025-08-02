package tw.lab.hi1;

import java.util.Date;

import tw.lab.dao.CustDao;
import tw.lab.entity.Cust;
import tw.lab.entity.Order;

public class lab09 {

	public static void main(String[] args) {
		CustDao dao = new CustDao();
		
		Cust cust = dao.getById(1);
		if (cust != null) {
			System.out.println(cust.getCname());
			System.out.println(cust.getOrders().size());
			
			Order order1 = new Order();
			order1.setOrderDate(new Date());

			Order order2 = new Order();
			order2.setOrderDate(new Date());
			
			cust.addOrder(order1);
			cust.addOrder(order2);

			dao.update(cust);
			
		}else {
			System.out.println("Cust NOT FOUND!");
		}
	}

}
