package tw.Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.event.MouseMotionAdapter;



//	視窗
public class bubble extends JFrame {
	public static void main(String[] args) {
		new bubble();
	}
	
	BubblePanel panel;		// 如果只有在建構式內用，也可以放建構式內宣告
	public bubble() {
		super("bubble");
		
//		要在視窗建構式裡加入遊戲頁面JPanel
//		加任何東西都要先new
		panel = new BubblePanel();
//		要記得add裡加頁面還要加BorderLayout
		add(panel, BorderLayout.CENTER);
		
		
//		視窗版面設定建立在初始類別的建構式裡
		setSize(640, 840);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
//		setBackground(Color.blue);		// 錯誤，視窗內的所有設定要去JPanel設定
		

		
		
	}
}


//	遊戲頁面
class BubblePanel extends JPanel {
//	建構式外把該用到的東西都宣告，這裡算全域宣告
	BufferedImage BallImg;		// *圖檔宣告型別用BufferedImage
//	Image newBallImg;		// 放這的屬性只代表一個，若是跟球有關的屬性不能放這
	int ballW, ballH;
		// 這裡只有一顆球的座標
//	如果想要放很多球的各自座標

	Timer timer;

	
	LinkedList<BubbleUp>balls;		// <>裡放物件類型class
//	還要記得初始化
//	balls = new LinkedList<BubbleUp>();
//	錯誤，在類別裡只能宣告不能初始化，要去建構式裡初始化
	
	long lastAddTime = 0;
	
	private void addBall(int x, int y) {
		BubbleUp ball = new BubbleUp(x-(ballW/2), y-(ballH/2));
		balls.add(ball);
//		timer = new Timer();		// 放這邊會建立多次，在Panel建構式放一個就好
//		timer.schedule( new BubbleUp(), 0, 30);
		timer.schedule( ball, 0, 30);		// 每隔30毫秒呼叫一次
//		因為BubbleUp建構式帶參數，所以這邊不能直接用new
	}
	
	
	public BubblePanel() {
//		外觀設定於建構式裡
		setBackground(Color.blue);
		timer = new Timer();
		balls = new LinkedList<BubbleUp>();

//		在遊戲頁面啟動這些
//		依時間執行的邏輯要加new
		
		try {
			
//			只有讀檔沒有畫出來
//			BallIimg = new BallImg("dir3/ball.png");		// 錯誤，要讀檔
			BallImg = ImageIO.read(new File("dir3/bubble.png"));
//			讀取圖檔用ImageIO.read(new File("路徑")
			
			
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		點滑鼠增加球
		addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                addBall(e.getX(), e.getY());
            }
        });
		
//		滑鼠移動事件
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                long now = System.currentTimeMillis();
                if (now - lastAddTime > 10) {   // 每0.01秒加一顆
                    addBall(e.getX(), e.getY());
                    lastAddTime = now;		// 切換每次增加球的時間點
                }
            }
        });
	}

//	泡泡的顯示
//	在 paintComponent 用迴圈把所有泡泡畫出來
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(BubbleUp ball : balls) {
			if (ball.visible) {
//			g.drawImage(newBallImg, ballX, ballY, scaleWidth, scaleHeight, null);	// 錯誤，這裡的座標還是最外層panel的球座標
				g.drawImage(ball.newBallImg, ball.ballX, ball.ballY, null);	
			}
		}
	}
	
	
//	球的移動邏輯
	class BubbleUp extends TimerTask {	// 隨時間移動，要加TimerTask
		int ballX, ballY;
		int dx, dy;
		int ballsize;
		Image newBallImg;
		long lastFlashTime = 0;		// 避免太常閃爍
		
//		閃爍功能需要宣告的屬性
		 boolean visible = true;       // 泡泡是否可見
		 boolean flashing = false;     // 是否開始閃爍
		 long flashStartTime = 0;      // 記錄開始閃爍時間

		public BubbleUp(int ballX, int ballY) {
			this.ballX = ballX;
			this.ballY = ballY;
			dx = (int)(Math.random()*6-3);
			dy = -5;
			
			ballsize = (int)(Math.random()*61)+10;		// 10~50
			newBallImg = BallImg.getScaledInstance(ballsize, ballsize, Image.SCALE_SMOOTH);
//				getScaledInstance(int width, int height, int hints)，()各代表像素寬, 像素高, 縮圖品質

		}
		public void run() {
			ballX += dx;
			ballY += dy;
				
//			設定球到頂部閃爍一秒消失
			if (ballY <= 0) {
				ballY = 0;		// 固定泡泡
				dx = 0;
				
				if(!flashing) {		// 只在第一次到頂部時記錄，這樣才可以只在剛剛進入閃爍的那一瞬間記錄時間
//				若不是閃爍
					flashing = true;	// 則切換成閃爍狀態
					flashStartTime  = System.currentTimeMillis();		
					// 進入閃爍狀態當下的電腦時間					
				}
				
				if( (System.currentTimeMillis()-flashStartTime) <=1000) {
//				現在的時間減當時的時間，閃爍時長
					
					if(System.currentTimeMillis()- lastFlashTime > 500) {
//					每0.2秒閃爍一次
						visible = !visible;		// 每次切換可見			
						lastFlashTime = System.currentTimeMillis();		// 要記得切換
						
					}
				}else {
					cancel();		//	停止目前移動的計時任務
					SwingUtilities.invokeLater(() -> balls.remove(this));
//					把修改 Swing 介面的程式碼，安全地交給 Swing 的執行緒執行，防止多執行緒同時碰到 Swing 元件
					
				}
					
//				timer.schedule(new BubbleEnd(ballX, ballY) {balls.remove(ball);}, 2*1000);
					
			
			}
			repaint();
		}

		


			
		
	}
	
	
	
}




/*
		
		🟡 練習題：滑鼠連發泡泡遊戲
		請完成一個 Swing 程式，需求如下：
		
		✅ 畫面背景為藍色
		✅ 按下滑鼠後，會在該位置產生「一個圓形泡泡」，泡泡會向上慢慢漂浮
		✅ 每個泡泡大小固定 30x30 像素
		✅ 泡泡上升到畫面頂端後就停留兩秒並在原本位置上閃一下白色殘影並刪除
		✅ 可以同時產生多個泡泡（LinkedList）
		✅ 每 30ms 更新一次所有泡泡位置
		✅ 每 16ms 重繪畫面
		
		➡️ 提示
		你需要：
		
		一個 Bubble 類別（儲存位置、移動邏輯）
		一個 LinkedList<Bubble> 來管理所有泡泡
		一個 Timer 去定時移動
		一個 RefreshView 定時 repaint
		
		泡泡消失的邏輯：
		
		在泡泡碰到頂部 ballY <= 0 時，先把泡泡座標固定住。
		設置一個「閃爍狀態」和一個計時器，讓泡泡閃爍約兩秒。
		閃爍結束後，從 LinkedList移除這個泡泡物件，並取消計時。

		➡️ 進階挑戰（選做）
		🌟 進階：
		泡泡上升時帶有隨機左右飄的效果
		
		🌟 進階：
		泡泡顏色隨機

*/
