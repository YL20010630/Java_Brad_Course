package tw.lab.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id		// 主鍵
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// 主鍵自動產生(IDENTITY 表示由資料庫自動遞增)
	@Column(name = "id")		// 對應資料表的 id 欄位
	private Long id;
	
	@Column(name = "order_date")
	private Date orderDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}



	//-------------------
//	多對一，顧客可以有多筆訂單
	@ManyToOne
	@JoinColumn(name = "cust_id")		// 這個外鍵欄位會對應到 cust 資料表的 id 欄位，Hibernate 會自動產生 cust_id 欄位
	private Cust cust;

	public Cust getCust() {
		return cust;
	}

	public void setCust(Cust cust) {
		this.cust = cust;
	}
	

	
	
	
	
	
	
	
	
}
	
	
	
	
	