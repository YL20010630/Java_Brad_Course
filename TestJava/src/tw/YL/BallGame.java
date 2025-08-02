package tw.YL;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.apis.GamePanel;
import tw.apis.GamePanel2;

public class BallGame extends JFrame {
	private GamePanel panel;
//	private GamePanel2 panel;
	
	private BallGame() {
		setLayout(new BorderLayout());
		
//		把外接功能在建構式創建new
		panel = new GamePanel();
//		panel = new GamePanel2();
		
		
//		要記得new完外接功能要add
		add(panel, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new BallGame();
	}

}