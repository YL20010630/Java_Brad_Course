package tw.YL;

import tw.apis.User;

public class lab79 {

	public static void main(String[] args) {
		User user = new User.Builder()
					.account("brad")
					.name("Brad")
					.gender(false)
					.age(18)
					.build();
		System.out.println(user.getAccount());
		
	}

}