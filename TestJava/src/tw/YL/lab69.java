package tw.YL;


public class lab69 {
	
	/*
		Thread執行序
		同時執行多條工作
		
		interrupt 插入
	 */

	/*
		Thread.sleep(100)：暫停執行緒，避免一直佔用 CPU
		可能被 interrupt() 中斷，觸發 InterruptedException
		執行緒暫停後會再次排程執行，模擬多工切換
	 */
	
	
	
	public static void main(String[] args) {
		MyThread mt1 = new MyThread("A");
		MyThread mt2 = new MyThread("B");
//		mt1.setDaemon(true);		// 若前景(main)結束，背景也會結束
//		mt1.setDaemon(false);
		mt1.start();	// 生命週期，只有一次
//		mt2.start();
		System.out.println("main");
//		mt1.run();		// 物件方法
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("--------");
		mt1.interrupt();
	}

}

class MyThread extends Thread {
	private String name;
	
	MyThread(String name){this.name = name;}
	@Override
	public void run() {
		for(int i=0; i<20; i++) {
//			System.out.println(i);
			System.out.printf("%s : %d\n", name, i);
			try {
				Thread.sleep(100);		// 暫停100毫秒，讓cpu資源讓出
			} catch (InterruptedException e) {
				System.out.println("interrupt");
				break;
			}
			
		}
	}
}

//	mt1.interrupt();會中斷 mt1 執行緒，如果此時 mt1 剛好在 Thread.sleep()，就會拋出 InterruptedException，程式進入 catch 區塊，印出 interrupt，並且 break 結束迴圈