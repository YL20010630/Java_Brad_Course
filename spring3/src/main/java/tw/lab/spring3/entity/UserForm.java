package tw.lab.spring3.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserForm {
	@NotBlank(message = "Email 不可空")
	@Email(message = "請輸入有效Email")
	private String email;
	
	@Size(min = 6, message = "密碼長度 >= 6")
	private String passwd;
	
	@NotBlank(message = "name 不可空")
	private String name;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
