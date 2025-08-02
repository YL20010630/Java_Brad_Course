package tw.YL;

public class lab73 {
	
	/*
		join
	 */

	public static void main(String[] args) {
		lab731 b1 = new lab731("A", 10);
		lab731 b2 = new lab731("B", 20);
		b1.start();
		b2.start();
		System.out.println("main start");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		
		try {
			b1.join();		// 等 b1 執行完畢後再繼續往下執行
		} catch (InterruptedException e) {
		}
		System.out.println("main finish");
	}
}
class lab731 extends Thread {
	private String name;
	private int count;
	lab731(String name, int count){this.name = name; this.count = count;}
	@Override
	public void run() {
		for (int i=0; i<count; i++) {
			System.out.printf("%s : %d\n", name, i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}