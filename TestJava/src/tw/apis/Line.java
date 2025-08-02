package tw.apis;

import java.awt.Color;
import java.util.ArrayList;

public class Line {
	private ArrayList<Point> points;
	private Color color;
	
	public Line(Color color) {
		points = new ArrayList<>();
		this.color = color;
	}
	public void addPoint(Point p) {
//	addPoint(Point p)：新增一個點到線上
		points.add(p);
	}
	public Point getPoint(int index) {
//	getPoint(int index)：取得該索引的點
		return points.get(index);
	}
	public int numberOfPoint() {return points.size();}
//	numberOfPoint()：目前線上有多少點
	
	public Color getColor() {return color;}
//	getColor()：取得該線的顏色
	
}

//	用 ArrayList<Point> 紀錄一條線上的多個點，點與點連成曲線
//	有線的顏色 Color