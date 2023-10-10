package geometry;

import java.awt.Graphics;

public class Point extends Shape {
	
	protected int x ;
	protected int y;

	
	
	public Point (int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, boolean selected) {
		super(selected);
		this.x = x;
		this.y = y;
	
	}
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	public boolean contains (Point p) {
		return this.distance(p) < 5;
		
	}
	
	public double distance (Point p) {
		double dx = this.x - p.x;
		double dy = this.y - p.y;
		return Math.sqrt(dx*dx + dy*dy);
			
	}
	
	public void draw(Graphics g) {
		g.drawLine(x, y, x, y);
		
		if (this.selected) {
			g.drawRect(this.x - 3, this.y - 3, 6, 6);
		}
		
	}
	
	
}
