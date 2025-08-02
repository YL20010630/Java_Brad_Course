package tw.apis;

public class User {
	private String account;
	private String passwd;
	private String name;
	private boolean gender;
	private int age;
	
	private User(Builder builder) {
		this.account = builder.account;
		this.passwd = builder.passwd;
		this.name = builder.name;
		this.gender = builder.gender;
		this.age = builder.age;
	}
	
	public static class Builder{
		private String account;
		private String passwd;
		private String name;
		private boolean gender;
		private int age;
		
		public Builder account(String account) {this.account = account; return this;}
		public Builder passwd(String passwd) {this.passwd = passwd; return this;}
		public Builder name(String name) {this.account = name; return this;}
		public Builder gender(boolean gender) {this.gender = gender; return this;}
		public Builder age(int age) {this.age = age; return this;}
		
		public User build() {
			return new User(this);
		}
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

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	

}