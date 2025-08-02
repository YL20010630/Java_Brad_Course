package tw.lab.spring1.apis;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/*
	針對ResquestBody使用，而不是針對資料表
 */

public class Member {
	private long id;
	
//	@Size(...) 限制 account 長度
	@Size(min=6, max=20)
	private String account;
	
//	@Pattern(...) 用正則表達式檢查密碼格式
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$")
	private String passwd;
	
//	@NotBlank 表示 name 不可為空
	@NotBlank
	private String name;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
}
