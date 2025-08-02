package tw.YL;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tw.apis.GiftTable;

/*
	主視窗類別
*/

public class MyGift extends JFrame{
	private GiftTable table;
	private JButton del;
	
	public MyGift() {
		super("伴手禮");
		
		setLayout(new BorderLayout());
		
		del = new JButton("Delete");
		JPanel top = new JPanel(new FlowLayout());
		top.add(del);
		add(top, BorderLayout.NORTH);
		
//		new之前要在建構式外宣告，就可以是全域，
//		如果在這邊寫GiftTable table = new GiftTable();就不是全域
		table = new GiftTable();
		JScrollPane jsp = new JScrollPane(table);		// // 放在 JScrollPane 中以支援捲動
		add(jsp, BorderLayout.CENTER);
		
//		add(table, BorderLayout.CENTER);		// table 已經包在 jsp 裡加入過了，不能重複加

		
//		放視窗介面建構式最下面
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.delRow();
			}
		});
	}
	

	public static void main(String[] args) {
		new MyGift();

	}

}



