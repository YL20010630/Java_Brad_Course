package tw.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DebugGraphics;
import javax.swing.JPanel;

/*
	Point換成String, Integer(整數) 來記錄
	只有把座標換成 HashMap<String,Integer>
 */

public class MyDrawer2 extends JPanel{
	private ArrayList<Line2> lines, recycler;
	private Color defaultColor;
	
	public MyDrawer2() {
		lines = new ArrayList<>();
		recycler = new ArrayList<>();
		defaultColor = Color.BLACK;
		
		setBackground(Color.YELLOW);
		
		MyMouseAdapter adapter = new MyMouseAdapter();
		addMouseListener(adapter);
		addMouseMotionListener(adapter);

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(4));
		
		
		
		for (Line2 line : lines) {
			g2d.setColor(line.getColor());	
			for (int i=1; i<line.numberOfPoint(); i++) {
				HashMap<String, Integer> p1 = line.getPoint(i-1);
				HashMap<String, Integer> p2 = line.getPoint(i);
				g2d.drawLine(p1.get("x"), p1.get("y"), p2.get("x"), p2.get("y"));
			}
			
		}
	}
	
	private class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			Line2 line = new Line2(defaultColor);
			HashMap<String, Integer> point = new HashMap<>();		// 必須用這行來存每一點
			point.put("x", e.getX());point.put("y", e.getY());
			line.addPoint(point);
			lines.add(line);
//			因為沒寫line2，所以要實作出來
			recycler.clear();
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX());point.put("y", e.getY());
			lines.getLast().addPoint(point);
			repaint();
		}
	}
	
	public void clear() {
		lines.clear();
		repaint();
	}
	
	public void undo() {
		if (lines.size() > 0) {
			recycler.add(lines.removeLast());
			repaint();
		}
	}
	public void redo() {
		if (recycler.size() > 0) {
			lines.add(recycler.removeLast());
			repaint();
		}
	}
	
	public Color getColor() {
		return defaultColor;
	}
	
	public void changeColor(Color newColor) {
		defaultColor = newColor;
	}
	
}