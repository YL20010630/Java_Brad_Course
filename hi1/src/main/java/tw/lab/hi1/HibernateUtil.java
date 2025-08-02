package tw.lab.hi1;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tw.lab.entity.Member;
import tw.lab.entity.MemberInfo;
import tw.lab.entity.Gift;
import tw.lab.entity.Cust;
import tw.lab.entity.Order;
import tw.lab.entity.Student;
import tw.lab.entity.Course;

//	提供整個專案中唯一的 SessionFactory 實例，用於連接資料庫
//	避免重複初始化 SessionFactory，節省資源、提高效率


public class HibernateUtil {
//	宣告一個靜態的 SessionFactory 物件，靜態表示這個變數是類別共享的，只會有一個實例
	public static SessionFactory sessionFactory;
	
//	提供靜態方法 getSessionFactory()
	public static SessionFactory getSessionFactory() {
//		判斷 sessionFactory 是否已經初始化，若是 null，代表還沒建好
		if(sessionFactory == null) {
//			建立一個 Hibernate Configuration 物件
			Configuration config = new Configuration();
//			指定讀取 hibernate.cfg.xml 設定檔，這個檔案裡面包含資料庫連線資訊與其他設定
			config.configure("hibernate.cfg.xml");
			
//			手動註冊你要讓 Hibernate 管理的 Java 類別（Entity）
			config.addAnnotatedClass(Member.class);
			config.addAnnotatedClass(MemberInfo.class);
			config.addAnnotatedClass(Gift.class);
			config.addAnnotatedClass(Cust.class);
			config.addAnnotatedClass(Order.class);
			config.addAnnotatedClass(Student.class);
			config.addAnnotatedClass(Course.class);
			
//			建立 SessionFactory 實例並儲存在靜態變數中
			sessionFactory = config.buildSessionFactory();
		}
		return sessionFactory;
	}
}

