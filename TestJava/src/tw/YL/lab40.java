package tw.YL;

import java.io.File;

public class lab40 {

	public static void main(String[] args) {
		File f1 = new File("c:\\lab\\Java\\dir2");
		if(f1.exists()) {
			System.out.println("OK");
		} else {
			System.out.println("XX");
			f1.mkdir();
		}
	}

}
