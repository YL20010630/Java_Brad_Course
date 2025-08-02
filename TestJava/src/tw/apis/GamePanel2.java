package tw.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class GamePanel2 extends JPanel {
	private BufferedImage ballImg;
	private Timer timer;
	private int viewW, viewH;
	private int ballW, ballH;
	private LinkedList<BallTask> balls;		// balls → 放所有球的 LinkedList（多球同時存在）
	

	public GamePanel2() {
		setBackground(Color.PINK);
		
		balls = new LinkedList<>();		// 初始化多球的清單，宣告一個 可以放很多 BallTask 的鏈結串列
		try {
			ballImg = ImageIO.read(new File("dir3/ball.png"));
			ballW = ballImg.getWidth(); ballH = ballImg.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
		}
		timer = new Timer();
		timer.schedule(new RefreshView(), 0, 16);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				BallTask ball = new BallTask(e.getX() - (int)(ballW/2.0), e.getY() - (int)(ballH/2.0));
//				e是滑鼠，ballW/2.0是球一半寬度，座標相減讓球的中心跟滑鼠點對齊
				balls.add(ball);	// 把這顆球加入 balls 清單
				timer.schedule(ball, 1*1000, 30);
				
			}
		});
		
	}
	
	private class RefreshView extends TimerTask{		// 排程，定時刷新畫面
		@Override
		public void run() {
			repaint();
		}
	}
	
	
	private class BallTask extends TimerTask {		// 球本身的座標邏輯
		int ballX, ballY;
		int dx, dy;
		
		public BallTask(int ballX, int ballY) {
			this.ballX = ballX; this.ballY = ballY;
			dx = (int)(Math.random()*17-8);		// *17是0~17，-8是-8~+9，讓球速落在-8~+9之間
			dy = (int)(Math.random()*17-8);
		}
		
		@Override
		public void run() {
			if (ballX <= 0 || ballX + ballW >= viewW) {
				dx *= -1;
			}
			if (ballY <= 0 || ballY + ballH >= viewH) {
				dy *= -1;
			}
			
			ballX += dx;
			ballY += dy;
		}
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {		// 劃出所有球
		super.paintComponent(g);
		viewW = getWidth(); viewH = getHeight();
		
		for(BallTask ball : balls) {
			g.drawImage(ballImg, ball.ballX, ball.ballY, null);
		}
		
		
	}
	
	
}