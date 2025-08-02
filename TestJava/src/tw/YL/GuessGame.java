package tw.YL;

import java.awt.BorderLayout;		// 一種排版方式（上下左右中）
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;		// 按鈕被點時的監聽器

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class GuessGame extends JFrame implements ActionListener{
//	這個類別是一個視窗（JFrame），也具備按鈕被點擊時的反應能力（ActionListener）
	private JButton guess;
	private JTextField input;
	
//	private JTextArea log;
	private JTextPane log;
//	改JTextPane 支援多顏色文字F
	
	private String answer;
	private int counter;
	
	
	public GuessGame() {
		super("Guess Number Game");		// 設定視窗標題
//		super 呼叫 JFrame 父類別
		
		guess = new JButton("猜");
		
		input = new JTextField();
		input.setFont(new Font(null, Font.BOLD | Font.ITALIC, 24));
		input.setForeground(Color.BLUE);
		
//		log = new JTextArea();
//		初始化按鈕、輸入框、紀錄框
		log = new JTextPane();
		
		setLayout(new BorderLayout());
//		setLayout() 是 JFrame的方法，
//		決定裡面放元件(如BorderLayout（上下左右中）、FlowLayout（預設，左到右排）)的排列方式
		add(log, BorderLayout.CENTER);
//		log紀錄區塊放中間
		
		JPanel top = new JPanel(new BorderLayout());
//		再建立一個「子面板」top，有自己的 BorderLayout，也有按鈕輸入框
//		new JPanel → 產生容器，new BorderLayout() → 排版規則
		top.add(guess, BorderLayout.EAST);
		top.add(input, BorderLayout.CENTER);
//		上面放guess按鈕跟input輸入框
		
		add(top, BorderLayout.NORTH);
//		將子面板top置於介面最上面
		
		guess.addActionListener(this);
//		讓按鈕點擊時觸發 actionPerformed()
//		這裡的this也就是 GuessGame 的物件本身
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		設定視窗大小、顯示視窗、關閉時結束程式
		
		initGame();
//		開始遊戲：產生一組新答案
	}

	public static void main(String[] args) {
		new GuessGame();
	}

	private void initGame() {
		counter = 0;
		answer = createAnswer(3);
//		使用 createAnswer() 隨機產生三位不重複的數字組合
		log.setText("");
		System.out.println(answer);
	}
	
	private String createAnswer(int d) {
		final int nums = 10;		// 建立 0~9 的數字
		int[] poker = new int[nums];		// 初始化陣列內容
		for (int i=0; i<poker.length; i++) poker[i] = i;
		
		for (int i = nums -1; i > 0; i--) {
//			i 從9到1
			int r = (int)(Math.random()*(i+1));
//			r 是隨機亂數 0到 i (包含i)
			// poker[r] <=> poker[i]
			int temp = poker[r];
			poker[r] = poker[i];
			poker[i] = temp;
		}
		
		StringBuffer sb = new StringBuffer();
//		StringBuffer 字串的暫存區，能用append動態修改字串，而不用String +=每次都新增物件
		for (int i=0; i<d; i++) sb.append(poker[i]);
//		取前 d 個數字（例如 3 位數）當答案
		
		return sb.toString();
//		把sb裡的字串回傳給呼叫它的人的人
	}
	
	private static String checkAB(String a, String g) {
//		a 正確答案，g 玩家猜的數字
//		static → 不需要 new 物件，就能用
//		void → 沒有回傳值
		
		int A, B;
		A = B = 0;
		for(int i = 0; i < g.length(); i++) {
			if(a.charAt(i)  == g.charAt(i)) {
				A++;
			}else if(a.indexOf(g.charAt(i)) != -1 ){
//			indexOf在字串或陣列中尋找	(某)的位置
//			indexOf(...) != -1 代表答案字串裡有這個數字
				B++;
			}
		}
		return String.format("%dA%dB", A, B);
//		.format 字串格式化
//		sb.toString()被存到answer變數裡
//		不能寫answer = sb.toString();
//		這樣就少了彈性，因為 createAnswer()就綁死只能給answer用，不適合在其他地方複用
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//	
//	因為GuessGame有implements ActionListener，所以必須寫出actionPerformed()這個方法
//	ActionEvent e 是事件物件，e 是事件的參考變數
		counter++;
		
		System.out.println("OK");
		String g = input.getText();
		String result = checkAB(answer, g);		// %dA%dB
//		原為checkAB(a, g)這裡寫checkAB(answer, g)，代表a = answer
		
		
//		log.append(String.format("%d. %s => %s\n", counter, g, result));
		StyledDocument style = log.getStyledDocument();
		
		Style s1 = style.addStyle("s1", null);
//		null：代表 沒有繼承任何既有樣式，從零開始定義
		StyleConstants.setForeground(s1, Color.RED);
		
		Style s2 = style.addStyle("s2", null);
		StyleConstants.setForeground(s2, Color.BLACK);
		
		Style s3 = style.addStyle("s3", null);
		StyleConstants.setForeground(s3, Color.BLUE);
		
		try {
			style.insertString(style.getLength(), g, s1);
			style.insertString(style.getLength(), " => ", s2);
			style.insertString(style.getLength(), result + "\n", s3);
		}catch(Exception ee) {
//		例外處理，若執行失敗，則{無}
//		ee  是 Exception 物件的參考名稱
			 ee.printStackTrace();
			
		}
		
		
		
		input.setText("");
		
		if (result.equals("3A0B")) {
			JOptionPane.showMessageDialog(null, "WINNER");
//			JOptionPane 是 Java Swing 提供的 訊息對話視窗工具，
//			showMessageDialog 會彈出一個提示對話框。
//			null是父視窗(parent component)的參數
//			null表示「沒指定視窗」，提示框會顯示在螢幕中央
			
			initGame();
		}else if (counter == 20) {
			JOptionPane.showMessageDialog(null, "LOSER: " + answer);
			initGame();
		}
		
		
	}

}

/*
	如果方法裡會用到物件的成員變數，就不能 static
	如果方法只靠參數就能跑完，就可以 static
*/