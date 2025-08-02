package tw.lab.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity		// @Entity：這個類別會對應資料庫中的一個表格
@Table(name = "cust")		// 對應到資料庫中的 cust 資料表
public class Cust {
	@Id		// 主鍵
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// 主鍵自動產生(IDENTITY 表示由資料庫自動遞增)
	@Column(name = "id")		// 對應資料表的 id 欄位
	private long id;
	
	@Column(name = "cname")
	private String cname;
	
	@Column(name = "birthday")
	private String birthday;
	
	@Column(name = "tel")
	private String tel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

//	--------------------------------
	
//	一對多關聯
	@OneToMany(
//		對應在 Order 類別裡的 cust 屬性，是由 Order 負責關聯的外鍵
		mappedBy = "cust",
		
//		對 Cust 做的新增、刪除、更新操作會連帶對 Order 做出操作
		cascade = CascadeType.ALL,
		
//		每次讀取 Cust 也會立即抓出所有 Order
		fetch = FetchType.EAGER,
		
//		如果你從 orders 清單中移除了某個 Order，Hibernate 會把那筆訂單從資料庫刪除（不會成為孤兒資料）
		orphanRemoval = true
		)
	

	private List<Order> orders = new ArrayList<Order>();

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
//	雙向關聯同步
	public void addOrder(Order order) {
		orders.add(order);
		order.setCust(this);
	}
	
	public void delOrder(Order order) {
		orders.remove(order);
		order.setCust(null);
	}
	
	
}
