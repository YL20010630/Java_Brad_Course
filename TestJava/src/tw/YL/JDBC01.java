package tw.YL;

public class JDBC01 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Class.forName("com.mincrift.sqlserver.cj.jdbc.SQLServerDriver");
			
			System.out.println("OK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
