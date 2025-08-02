package tw.lab.spring3.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data		// => 會自動產生 Getter/Setter, toString
@NoArgsConstructor		//  => 會自動產生一個無參數建構式
public class MemberForm {
	private String account;
	private String passwd;
	private String name;
	private String area;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	
}
