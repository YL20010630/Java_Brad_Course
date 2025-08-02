package tw.YL;

import java.util.Timer;
import java.util.TimerTask;

public class lab72 {

	public static void main(String[] args) {
		Timer timer = new Timer();		// 預設跑前景
		MyTask task1 = new MyTask();
//		timer.schedule(task1, 1*1000);
		timer.schedule(task1, 0, 1*1000);
		timer.schedule(new StopTask(timer), 10*1000);
		System.out.println("Main");

	}
}
class MyTask extends TimerTask {
	private int i;
	@Override
	public void run() {
		System.out.println(i++);
	}
}
class StopTask extends TimerTask {
	private Timer timer;
	public StopTask(Timer timer) {
		this.timer = timer;
	}
	@Override
	public void run() {
		timer.cancel();
		timer.purge();
		timer = null;
	}
}