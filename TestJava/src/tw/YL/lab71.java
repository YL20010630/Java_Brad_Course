package tw.YL;

public class lab71 {

	public static void main(String[] args) {
		lab711 obj1 = new lab711();
		lab712 obj2 = new lab712();
		obj1.start();
//		obj2.run();
		Thread t1 = new Thread(obj2);
		t1.start();

	}

}

class lab711 extends Thread{
	@Override
	public void run() {
		System.out.println("lab711: run Thread");
	}
}

class lab712 implements Runnable{
	@Override
	public void run() {
		System.out.println("lab712: run");
	}
}
