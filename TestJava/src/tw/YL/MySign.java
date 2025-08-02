package tw.YL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tw.apis.MyClock;
import tw.apis.MyDrawer;
import tw.apis.MyDrawer2;


/*
	提供一個畫布 (MyDrawer) 讓使用者可以手寫或簽名
	有清除、復原、重做功能
	可以改變筆的顏色
	可以把畫的內容存成 JPEG 圖片
	也可以把簽名線條物件序列化（Object 檔）保存
	讀取儲存的物件重新繪製
 */


public class MySign extends JFrame{
	private MyDrawer myDrawer;
	private JButton clear, undo, redo, color;
	private JButton saveJpg, saveObject, loadObject;
	
//	建構式MySign()
	public MySign() {
		super("簽名 App");
		
		myDrawer = new MyDrawer();
		setLayout(new BorderLayout());
		add(myDrawer);
		
		JPanel top = new JPanel(new FlowLayout());
		clear = new JButton("Clear"); top.add(clear);
		undo = new JButton("Undo"); top.add(undo);
		redo = new JButton("Redo"); top.add(redo);
		color = new JButton("Color"); top.add(color);
		saveJpg = new JButton("Save JPEG"); top.add(saveJpg);
		saveObject = new JButton("Save Object"); top.add(saveObject);
		loadObject = new JButton("Load Object"); top.add(loadObject);
		
		MyClock myclock = new MyClock();
		top.add(myclock);
		
		add(top, BorderLayout.NORTH);
		
		setSize(800, 640);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initEvent();
	}
	
//	把各種按鈕的事件綁定起來
	private void initEvent() {
//		清空畫面
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.clear();
			}
		});
		
//		復原
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.undo();
			}
		});
		
//		取消復原
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.redo();
			}
		});
		
//		換顏色
		color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});
		
//		選擇路徑後把畫面存成圖檔
		saveJpg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveJpeg();
			}
		});
		
//		序列化畫的物件存檔
		saveObject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveObj();
			}
		});
		
//		反序列化後重新繪製
		loadObject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadObj();
			}
		});
	}
	
	private void changeColor() {
		Color newColor = JColorChooser.showDialog(this, "Change Color", myDrawer.getColor());
//		JColorChooser.showDialog 提供一個色彩選擇視窗，非常適合讓使用者換筆色
		
		if (newColor != null) {
			myDrawer.changeColor(newColor);
		}
//		回傳選的顏色後，呼叫myDrawer.changeColor()換筆色
	}
	
	private void saveJpeg() {
		JFileChooser jfc = new JFileChooser();
//		使用 JFileChooser 讓使用者選擇要儲存的檔名
		if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File saveFile = jfc.getSelectedFile();
			try {
//				呼叫 myDrawer.saveJPEG()，將簽名畫布內容轉成 JPEG 並輸出
				if (myDrawer.saveJPEG(saveFile)) {
					JOptionPane.showMessageDialog(this, "Save Success");
				}else {
					JOptionPane.showMessageDialog(this, "Save Failure");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Save Failure");
			}
		}
	}
	
	private void saveObj() {
		JFileChooser jfc = new JFileChooser();		// 儲存檔名
		if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File saveFile = jfc.getSelectedFile();
			try {
//				呼叫 myDrawer.saveLines() 把目前所有線條（物件序列化）存檔，這樣下次載入能還原線條
				myDrawer.saveLines(saveFile);
				JOptionPane.showMessageDialog(this, "Save Success");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Save Failure");
			}
		}
	}

	private void loadObj() {
		JFileChooser jfc = new JFileChooser();
//		選擇檔案後，呼叫 myDrawer.loadLines() 反序列化，重新繪製簽名
		if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File loadFile = jfc.getSelectedFile();
			try {
				myDrawer.loadLines(loadFile);;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Load Failure");
			}
		}
	}
	
	
	public static void main(String[] args) {
		new MySign();
	}

}