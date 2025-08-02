package tw.lab.test;

// 論壇Model

public class Post {
	private String username;
	private String message;
	
	public Post(String username, String message) {
		this.username = username;
		this.message = message;
	}
	
	public void username() {
		return username;
	}
	
	public void message() {
		return message;
	}


}
