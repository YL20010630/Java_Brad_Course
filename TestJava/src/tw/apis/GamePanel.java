package tw.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class GamePanel extends JPanel {
	private BufferedImage ballImg;
	private int ballX, ballY;		// 球的位置
	private Timer timer;
	private int viewW, viewH;		// 視窗尺寸
	private int ballW, ballH;		// 球的尺寸
	private int dx, dy;				// 移動速度

	public GamePanel() {
		setBackground(Color.PINK);
		
		dx = dy = 4;
		ballX = ballY = 10;
		
		try {
			ballImg = ImageIO.read(new File("dir3/ball.png"));
			ballW = ballImg.getWidth();
			ballH = ballImg.getHeight();
//			記下球的寬高，用以判斷邊界
			
		} catch (IOException e) {		// 找不到圖檔就印出錯誤
			e.printStackTrace();
		}
		timer = new Timer();
		timer.schedule(new BallTask(), 1*1000, 30);		// 一秒後開始執行BallTask()，每30毫秒更新一次
		
	}
	
//	內部類別，負責更新球的位置
	private class BallTask extends TimerTask {
		public void run() {
			
			if(ballX <=0 || ballX + ballW >= viewW) {
				dx *= -1;
			}
			if(ballY <=0 || ballY + ballH >= viewH) {
				dy *= -1;
			}
//			碰到左右上下邊界就反彈
			
			ballX += dx;
			ballY += dy;
			repaint();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);	// 呼叫這行，每次更新都只顯示一顆球，避免殘影
//		先擦乾淨畫布，再繪製新畫面
		
		viewW = getWidth(); viewH = getHeight();
		System.out.printf("%d : %d\n", ballX, ballY);
		
		g.drawImage(ballImg, ballX, ballY, null);		// null那格用來監看圖片載入狀態

		
		
	}
	
	
}