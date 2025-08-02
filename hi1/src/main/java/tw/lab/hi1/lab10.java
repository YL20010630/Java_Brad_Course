package tw.lab.hi1;

import java.util.Date;

import tw.lab.dao.CustDao;
import tw.lab.entity.Cust;
import tw.lab.entity.Order;

public class lab10 {

	public static void main(String[] args) {
		CustDao dao = new CustDao();
		
		Cust cust = new Cust();
		cust.setCname("ispan");
		cust.setBirthday("1999-09-09");
		cust.setTel("123456789");
		
		Order order1 = new Order();
		order1.setOrderDate(new Date());
		
		Order order2 = new Order();
		order2.setOrderDate(new Date());
		
		cust.addOrder(order1);
		cust.addOrder(order2);
		
		dao.update(cust);
		
		
	}

}
