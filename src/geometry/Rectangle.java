package geometry;

import java.awt.Graphics;

public class Rectangle extends Shape {
	 
	 
	 private Point upperx;
	 
	 private int width;
	 private int height;
	 
	 

	public Rectangle(Point upperx, int width, int height) {
		this.upperx = upperx;
		this.width = width;
		this.height = height;
	}
	

	public Rectangle(Point upperx, int width, int height, boolean selected) {
		super(selected);
		this.upperx = upperx;
		this.width = width;
		this.height = height;
	}


	public Point getUpperx() {
		return upperx;
	}


	public void setUpperx(Point upperx) {
		this.upperx = upperx;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int area() {
		return this.width * this.height;
	}
	 
	public boolean contains(Point p) {
		boolean X = p.getX()>= upperx.getX() && p.getX()<= upperx.getX() + width;
		boolean Y = p.getY()>= upperx.getY() && p.getY()<= upperx.getX() + height;
			return X && Y;
	}


	public void draw(Graphics g) {
		this.setGraphicState(g);
		g.drawRect(this.upperx.getX(), this.upperx.getY(), this.width, this.height);
		
		if(selected) {
			this.upperx.setSelected(true);
			this.upperx.draw(g);
			
			Point uppery = new Point (this.upperx.getX() + this.width, this.upperx.getY(), true);
			uppery.draw(g);
			
			Point lowerx = new Point (this.upperx.getX(), this.upperx.getY() + this.height, true);
			lowerx.draw(g);
			
			Point lowery = new Point (this.upperx.getX() + this.width, this.upperx.getY() + this.height, true);
			lowery.draw(g);
		}
	}
	@Override
	public String toString() {
		return "Rectangle [upperx=" + upperx + ", width=" + width + ", height=" + height + "]";
	}
	
}
