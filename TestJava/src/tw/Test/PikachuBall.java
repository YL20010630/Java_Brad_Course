package tw.Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.security.PublicKey;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.text.JTextComponent.KeyBinding;

public class PikachuBall extends JFrame {

	public static void main(String[] args) {
		new PikachuBall();

	}
	
	public PikachuBall() {
		super("PikachuBall");
		
		GamePanel panel = new GamePanel();
		add(panel, BorderLayout.CENTER);
		
//		panel要比下面的set先加
		
//		setLayout(getLayout());
		setSize(1000, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel.requestFocusInWindow();		// 讓你的鍵盤 focus 穩定
		
		
	}

}

class GamePanel extends JPanel {
//	類別內宣告，類別建構式內初始化new
	Image P1;
	Image P2;
	Image Ball;
	Timer time = new Timer();
	int ballX = 450;
	int ballY = 50;
	int ballDx = 10;
	int ballDy = 10;
	int viewW, viewH;
	int ballW, ballH;
	int P1X, P1Y, P1W, P1H;
	int P2X, P2Y, P2W, P2H;
	int P1speedX, P1speedY, P2speedX, P2speedY;


	
	
	
	
	
	
	public GamePanel() {
		
//		外觀設定於建構式裡
		setBackground(Color.lightGray);
		try {
			Image P1img = ImageIO.read(new File("dir3/pikachuLeft.png"));
			Image P2img = ImageIO.read(new File("dir3/pikachu.png"));
			Image Ballimg = ImageIO.read(new File("dir3/pokeball.png"));

			P1 = P1img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			P2 = P2img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			Ball = Ballimg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//			.getScaledInstance適用於Image，不適用BufferedImage
			
//			若是用BufferedImage可以直接ballW = Ball.getWidth();，用Image型別這裡要加this
			ballW = Ball.getWidth(this);
			ballH = Ball.getHeight(this);
			P1W = P1.getWidth(this);
			P1H = P1.getHeight(this);
			P2W = P2.getWidth(this);
			P2H = P2.getHeight(this);
			
			P1X = 50;
			P1Y = 500;
			P2X = 750;
			P2Y = 500;
			
//			錯誤，BufferedImage是一種圖片物件，不能直接add進面板，在paint()裡面用drawImage()
//			panel.add(P1img);
//			panel.add(P2img);
//			panel.add(Ballimg);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);

		}
		
		time.schedule(new BallRun(), 0, 30);
		

		
//		getInputMap(WHEN_IN_FOCUSED_WINDOW)表示當視窗有焦點，就會接受鍵盤事件，不會被其他按鈕或元件影響。
//		KeyStroke.getKeyStroke("press up")抓取「按下 ↑ 鍵」這個動作的事件。
//		.put(..., "P1up")給它一個名字 P1up，讓等下 ActionMap 可以連接到這個行為。
//		getActionMap()負責把剛剛在 InputMap 取名 P1up 的動作，跟一段「要做什麼事」的程式碼連起來。
//		new AbstractAction() {...} 就是把一段匿名的動作程式碼寫在裡面
//		actionPerformed(ActionEvent e)當觸發 P1up 時，就執行這段程式
		
//		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed W"), "P1up");
//		getActionMap().put("P1up", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				P1speedY = -10;
//				repaint();
//			}
//		});
		

//		bindKey("pressed W", new Runnable() {
//			@Override
//			public void run() {
//				P1speedY = -10;
//			}
//		});
//		上面五行可縮寫成下一行
		bindKey("pressed W", () -> P1speedY = -10);
		bindKey("pressed S", () -> P1speedY = +10);
		bindKey("pressed A", () -> P1speedX = -10);
		bindKey("pressed D", () -> P1speedX = +10);
		bindKey("pressed UP", () -> P2speedY = -10);
		bindKey("pressed DOWN", () -> P2speedY = +10);
		bindKey("pressed LEFT", () -> P2speedX = -10);
		bindKey("pressed RIGHT", () -> P2speedX = +10);
		
		bindKey("released W", () -> P1speedY = 0);
		bindKey("released S", () -> P1speedY = 0);
		bindKey("released A", () -> P1speedX = 0);
		bindKey("released D", () -> P1speedX = 0);
		bindKey("released UP", () -> P2speedY = 0);
		bindKey("released DOWN", () -> P2speedY = 0);
		bindKey("released LEFT", () -> P2speedX = 0);
		bindKey("released RIGHT", () -> P2speedX = 0);
//		
//		
//		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed S"), "P1down");
//		getActionMap().put("P1down", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				P1speedY = +10;
//				repaint();
//			}
//		});
//		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed A"), "P1left");
//		getActionMap().put("P1left", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				P1speedX = -10;
//				repaint();
//			}
//		});
//		
//		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed D"), "P1right");
//		getActionMap().put("P1right", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				P1speedX = +10;
//				repaint();
//			}
//		});
//		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed UP"), "P2up");
//		getActionMap().put("P2up", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				P2speedY = -10;
//				repaint();
//			}
//		});
//		
//		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed DOWN"), "P2down");
//		getActionMap().put("P2down", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				P2speedY = +10;
//				repaint();
//			}
//		});
//		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed LEFT"), "P2left");
//		getActionMap().put("P2left", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				P2speedX = -10;
//				repaint();
//			}
//		});
//		
//		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed RIGHT"), "P2right");
//		getActionMap().put("P2right", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				P2speedX = +10;
//				repaint();
//			}
//		});
//		
////		放開按鍵速度歸0
//		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released W"), "P1upR");
//		getActionMap().put("P1upR", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				P1speedY = 0;
//				repaint();
//			}
//		});
//		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released S"), "P1downR");
//		getActionMap().put("P1downR", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				P1speedY = 0;
//				repaint();
//			}
//		});
//		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released A"), "P1leftR");
//		getActionMap().put("P1leftR", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				P1speedX = 0;
//				repaint();
//			}
//		});
//		
//		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released D"), "P1rightR");
//		getActionMap().put("P1rightR", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				P1speedX = 0;
//				repaint();
//			}
//		});
//		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released UP"), "P2upR");
//		getActionMap().put("P2upR", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				P2speedY = 0;
//				repaint();
//			}
//		});
//		
//		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released DOWN"), "P2downR");
//		getActionMap().put("P2downR", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				P2speedY = 0;
//				repaint();
//			}
//		});
//		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released LEFT"), "P2leftR");
//		getActionMap().put("P2leftR", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				P2speedX = 0;
//				repaint();
//			}
//		});
//		
//		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released RIGHT"), "P2rightR");
//		getActionMap().put("P2rightR", new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				P2speedX = 0;
//				repaint();
//			}
//		});
		
		setFocusable(true);

	}
//	善用bindKey簡寫
	void bindKey(String key, Runnable action) {
		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key), key);
		getActionMap().put(key, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				action.run();
				
			}
		});
	}
	
	
	@Override		// 隨時刷新
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(P1, P1X, P1Y, null);
		g.drawImage(P2, P2X, P2Y, null);
		g.drawImage(Ball, ballX, ballY, null);
		
		
		
		viewW = getWidth(); viewH = getHeight();		// 為了可以隨視窗縮放改變而放這定義
		
	}
	

	class BallRun extends TimerTask {
		public void run() {

			viewW = getWidth(); viewH = getHeight();
//			ballX += ballDx;
//			ballY += ballDy;
			
			int steps = 5; // 每次分5段
		    for (int i = 0; i < steps; i++) {
		        ballX += ballDx / steps;
		        ballY += ballDy / steps;
			
//			球的邊界撞擊判定
//			if (ballX <0) {
//				ballDx *= -1;
//				ballX = 0;
//			}
//			if (ballX+ballW > viewW) {
//				ballDx *= -1;
//				ballX = viewW-ballW;
//			}
//			if (ballY <0) {
//				ballDy *= -1;
//				ballY = 0;
//			}
//			if (ballY+ballH > viewH) {
//				ballDy *= -1;
//				ballY = viewH-ballH;
//			}
			
			// 碰牆
	        if (ballX < 0 || ballX + ballW > viewW) {
	            ballDx *= -1;
	            ballX += ballDx / steps; // 立即反彈
	        }
	        if (ballY < 0 || ballY + ballH > viewH) {
	            ballDy *= -1;
	            ballY += ballDy / steps;
	        }

//			只要 A 的右邊大於 B 的左邊，且 A 的左邊小於 B 的右邊，同時高度也相交，就算碰撞。
//			球跟P1碰撞
			if (ballX + ballW > P1X && ballX < P1X + P1W &&
				    ballY + ballH > P1Y && ballY < P1Y + P1H) {
				ballDx *= -1;
				ballDy *= -1;
			}
//			球跟P2碰撞
			if (ballX + ballW > P2X && ballX < P2X + P2W &&
				    ballY + ballH > P2Y && ballY < P2Y + P2H ) {
				ballDx *= -1;
				ballDy *= -1;
			}
		    }

//			Player碰撞牆壁判定
			if (P1X <0) {P1X = 0;}
			if (P1X+P1W > viewW) {P1X = viewW-P1W;}
			if (P1Y <0) {P1Y = 0;}
			if (P1Y+P1H > viewH) {P1Y = viewH-P1H;}
			if (P2X <0) {P2X = 0;}
			if (P2X+P2W > viewW) {P2X = viewW-P2W;}
			if (P2Y <0) {P2Y = 0;}
			if (P2Y+P2H > viewH) {P2Y = viewH-P2H;}
			
//			速度預設為0，按按鍵更改+-10速度
			P1X += P1speedX;
			P1Y += P1speedY;
			P2X += P2speedX;
			P2Y += P2speedY;
//			每時每刻都在抓取速度
			
			
//			要記得repaint
			repaint();
			
		}
	}




}






