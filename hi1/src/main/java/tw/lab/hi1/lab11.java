package tw.lab.hi1;

import tw.lab.dao.CustDao;

public class lab11 {

	public static void main(String[] args) {
		CustDao dao = new CustDao();
		dao.removeOrderFromCust(9, 7);		// 第1個參數：Cust id，第2個參數：Order id
//		從編號為 9 的客戶（Cust）中，移除訂單編號為 7 的 Order。

	}

}
