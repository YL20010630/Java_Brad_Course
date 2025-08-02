package tw.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class MyDrawer extends JPanel{
	//private ArrayList<Point> line;
	//private ArrayList<ArrayList<Point>> lines;
	private ArrayList<Line> lines, recycler;
	private Color defaultColor;
//	lines：目前畫面上所有的線；recycler：被 undo 掉的線，redo 時可以撿回來；defaultColor：目前的畫筆顏色

	public MyDrawer() {
		lines = new ArrayList<>();		// 初始化
		recycler = new ArrayList<>();	// 初始化
		defaultColor = Color.BLACK;		// 預設顏色
		
		setBackground(Color.YELLOW);
		
		MyMouseAdapter adapter = new MyMouseAdapter();
//		MyMouseAdapter 是匿名內部類別，用來監聽滑鼠事件
		
		addMouseListener(adapter);			// 滑鼠監聽
		addMouseMotionListener(adapter);	// 滑鼠移動監聽

//		MyMouseAdapter2 adapter = new MyMouseAdapter2(lines, recycler, this);
//		addMouseListener(adapter);
//		addMouseMotionListener(adapter);
	
	}
	
//	paintComponent 會根據所有 Line 和點繪製線條
	@Override
	protected void paintComponent(Graphics g) {
//	paintComponent 方法負責逐條線、逐點繪製線段，每次 Swing 重繪會呼叫這個
		super.paintComponent(g);
		
//		if(g instanceof Graphics2D) {
//			System.out.println("OK1");
//		} else if (g instanceof DebugGraphics) {
//			System.out.println("OK2");
//		} else {
//			System.out.println("OK3");
//		}
		Graphics2D g2d = (Graphics2D)g;
//		把 Graphics 物件（參數 g）強制轉型成 Graphics2D，讓線條可以設定寬度
//		這裡g的「型別」被宣告成 Graphics，但執行時傳進來的真實物件是 Graphics2D
		
		g2d.setStroke(new BasicStroke(4));		// 加粗
		
//		g.setColor(Color.BLUE);
		
//		g.drawLine(0, 0, 100, 200);
//		改成下面這句
//		for(int i = 1; i<line.size(); i++) {
//			Point p1 = line.get(i-1);
//			Point p2 = line.get(i);
//			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
//		}
//		點成線，p1~p2
//		又改成下面這個
//		把每一條 Line 的相鄰座標接起來畫成折線
		for (Line line : lines) {
			g2d.setColor(line.getColor());	
			for (int i=1; i<line.numberOfPoint(); i++) {
//			每條線的點集是一個序列，從第1個點開始走（i=1），因為要畫相鄰兩點之間的線段
				Point p1 = line.getPoint(i-1);		// 前一點 
				Point p2 = line.getPoint(i);		// 目前點
				g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());		// 在這兩點之間畫線段
			}
			
		}
	}
	
//	用戶點擊畫面，觸發 mousePressed → 新增一條 Line 並加入第一個點
	private class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
//		mousePressed：開始一條新的線（Line），紀錄起點
			Line line = new Line(defaultColor);
			Point p = new Point(e.getX(), e.getY());
			line.addPoint(p);
			lines.add(line);
			recycler.clear();
//			清除掉 recycler（因為 redo 的歷史要清除）
		}
		
//		用戶拖曳滑鼠，觸發 mouseDragged → 在該 Line 上加點
		@Override
		public void mouseDragged(MouseEvent e) {
//		mouseDragged：在最新的線上持續加入新的點(座標)
			Point p = new Point(e.getX(), e.getY());
			lines.getLast().addPoint(p);
			repaint();
//			repaint() 會觸發 paintComponent，使畫面更新重繪
		}
	}
	
	
	
	
//	private ArrayList<Line> lines, public void clear() {
//		lines.clear();
//		repaint();
//	}
	
	public void clear() {
//	clear()：清空所有線條並重繪
		lines.clear();
		repaint();
	}
	
	public void undo() {
//	undo()：將最後一條線移到 recycler
		if (lines.size() > 0) {
			recycler.add(lines.removeLast());
			repaint();
		}
	}
	public void redo() {
//	redo()：從 recycler 移回線條清單
		if (recycler.size() > 0) {
			lines.add(recycler.removeLast());
			repaint();
		}
	}
	
	public Color getColor() {
//	getColor()：取得目前的畫筆顏色
		return defaultColor;
	}
	
	public void changeColor(Color newColor) {
//	changeColor(Color newColor)：改變接下來新畫線的顏色
		defaultColor = newColor;
	}
	
//	將目前畫面畫進 BufferedImage 再存成 JPEG
	public boolean saveJPEG(File saveFile) throws Exception {
		BufferedImage img = 
			new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
//		先做一個和面板同樣大小的 BufferedImage
		Graphics2D g2d = img.createGraphics();
		paint(g2d);		// 把 paint() 畫進去
		
		return ImageIO.write(img, "jpg", saveFile);		// 寫成 jpg 檔
		
	}
	
//	將所有 Line 物件序列化儲存
	public void saveLines(File saveFile) throws Exception {
		ObjectOutputStream oout = 
			new ObjectOutputStream(
				new FileOutputStream(saveFile));
		oout.writeObject(lines);
		oout.flush();
		oout.close();
	}
	
//	反序列化 Line 陣列並更新畫布

	public void loadLines(File loadFile) throws Exception{
		try (ObjectInputStream oin = 
			new ObjectInputStream(new FileInputStream(loadFile));){
			Object obj = oin.readObject();
			if (obj instanceof ArrayList) {
				lines = (ArrayList<Line>)obj;
				recycler.clear();
				repaint();
			}
		}
	}
	
}



/*
class MyMouseAdapter2 extends MouseAdapter {
	private ArrayList<Line> lines, recycler;
	private MyDrawer myDrawer;
	
	MyMouseAdapter2(ArrayList<Line> lines, ArrayList<Line> recycler, MyDrawer myDrawer){
		this.lines = lines; this.recycler = recycler;
		this.myDrawer = myDrawer;
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		Line line = new Line();
		Point p = new Point(e.getX(), e.getY());
		line.addPoint(p);
		lines.add(line);
		recycler.clear();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = new Point(e.getX(), e.getY());
		lines.getLast().addPoint(p);
		myDrawer.repaint();
	}
}
*/