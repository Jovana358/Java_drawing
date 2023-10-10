package geometry;

import java.awt.Graphics;

public class Line extends Shape {
		
	 private Point start;
	 private Point end;
	
	  	 
	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}


	public Line(Point start, Point end, boolean selected) {
		super(selected);
		this.start = start;
		this.end = end;
	}
		
	
	
	 public Point getStart() {
		return start;
	}


	public void setStart(Point start) {
		this.start = start;
	}


	public Point getEnd() {
		return end;
	}


	public void setEnd(Point end) {
		this.end = end;
	}


	public double length() {
		 
		 return start.distance(end);
	 }

	 
	public boolean contains(Point p) {
		double distFromStart = start.distance(p);
		double distFromEnd = end.distance(p);
			return distFromStart + distFromEnd - this.length() < 5 ;
	}


	@Override
	public void draw(Graphics g) {
		this.setGraphicState(g);
		g.drawLine(this.start.getX(), this.start.getY(), this.end.getX(), this.end.getY());
		
		if (this.selected) {
			g.drawRect(start.getX() - 3, start.getY() - 3, 6, 6);
			g.drawRect(end.getX() - 3, end.getY() - 3, 6, 6);

		}
		
	}
}
