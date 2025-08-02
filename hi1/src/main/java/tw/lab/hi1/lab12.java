package tw.lab.hi1;

import java.util.List;

import tw.lab.dao.CustDao;
import tw.lab.entity.Cust;
import tw.lab.entity.Order;

public class lab12 {

	public static void main(String[] args) {
		CustDao dao = new CustDao();
		Cust cust = dao.getById(1);
		List<Order> os = cust.getOrders();
		for (Order order : os) {
			System.out.printf("%d. %s\n", order.getId(), order.getOrderDate());
		}
	}

}
