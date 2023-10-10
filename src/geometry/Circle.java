package geometry;

import java.awt.Graphics;

public class Circle extends Shape {
	
	protected int radius ;
	protected Point center ;
	
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
		
	}
	
	
	public Circle( Point center, int radius, boolean selected) {
		super(selected);
		this.radius = radius;
		this.center = center;
	}


	public double getRadius() {
		return radius;
	}
	public void setRadius(int r) throws Exception {
		if(r >= 0)
		this.radius = r;
		else
			throw new Exception("Vrijednost ne moze biti negativan broj !");
	}
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public boolean contains (Point p) {	
		return this.center.distance(p) < this.radius;
	}

	
	@Override
	public void draw(Graphics g) {
		this.setGraphicState(g);
		g.drawOval(this.center.getX()- this.radius,this.center.getY()- this.radius , 2*this.radius, 2*this.radius);
		
		if (selected) {
			Point north = new Point(this.center.getX(), this.center.getY() - this.radius, true);
			north.draw(g);
			
			Point south = new Point (this.center.getX(), this.center.getY() + this.radius, true);
			south.draw(g);
			
			Point west = new Point (this.center.getX() - this.radius, this.center.getY(), true);
			west.draw(g);
			
			Point east = new Point (this.center.getX() + this.radius, this.center.getY(), true);
			east.draw(g);
		}
	}
	
	//r2 pi
	
	public double area() {
		return radius * radius* Math.PI;
	}

}
