package tw.YL;

import java.awt.FlowLayout;  // 引入 FlowLayout 版面配置管理器
import javax.swing.JButton;  // 引入按鈕類別 JButton
import javax.swing.JFrame;   // 引入視窗類別 JFrame
//引入 Java 的 JFrame 類別，它是建立視窗的基礎

public class lab19 extends JFrame {
	private JButton b1, b2, b3;

//	建構子，當 new lab19() 被呼叫時執行
	public lab19() {
		b1 = new JButton("B1");
		b2 = new JButton("B2");
		b3 = new JButton("B3");
		
//		設定視窗的版面配置為 FlowLayout（水平方向排放，遇滿換行）
		setLayout(new FlowLayout());
		add(b1); add(b2); add(b3);
		
		
		
		setSize(640, 480);
		setVisible(true);    
//		設為 true 表示「顯示視窗」，否則就是隱藏。
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		按下視窗右上角的關閉按鈕時，結束程式
		
	}
	public static void main(String[] args) {
		new lab19();
		
		
	}

}
