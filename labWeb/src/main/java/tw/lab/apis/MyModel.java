package tw.lab.apis;

public class MyModel {
	private int x, y;
	public MyModel(String x, String y) {
		this.x = Integer.parseInt(x); 
		this.y = Integer.parseInt(y);
	}
	public String plus() {
//		加空字串是為了轉成字串
		return x + y + "";
	}

}
