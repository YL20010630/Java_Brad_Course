package tw.lab.hi1;

import java.util.List;

import tw.lab.dao.GiftDao;
import tw.lab.entity.Gift;

public class lab06 {

	public static void main(String[] args) {
		GiftDao dao = new GiftDao();
		List<Gift> gs1 = dao.getAll();
		for (Gift g : gs1) {
			System.out.printf("%d. %s : %s\n", g.getId(), g.getName(), 
					g.getCity()+g.getTown()+g.getAddr());
		}
		System.out.println("----");
		// SQL
		String sql = "SELECT * FROM gift WHERE name LIKE '%禮盒%'";
		List<Gift> gs2 = dao.getBySQL(sql);
		for (Gift g : gs2) {
			System.out.printf("%d. %s : %s\n", g.getId(), g.getName(), 
					g.getCity()+g.getTown()+g.getAddr());
		}
		System.out.println("----");
		
		// HQL
		//String hql = "FROM Gift g WHERE g.name LIKE '%紅豆%'";
		String hql = "SELECT g FROM Gift g WHERE g.name LIKE '%紅豆%' ORDER BY g.name";
		List<Gift> gs3 = dao.getByHQL(hql);
		for (Gift g : gs3) {
			System.out.printf("%d. %s : %s\n", g.getId(), g.getName(), 
					g.getCity()+g.getTown()+g.getAddr());
		}
		System.out.println("----");
		
		
	}
}
