package geometry;

import java.awt.Graphics;

public class Donut extends Circle  {

	private int innerRadius;

	public Donut( Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		super(center, radius , selected);
		this.innerRadius = innerRadius;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public boolean contains (Point p) {	
		return this.center.distance(p)<= this.radius && this.center.distance(p) >= this.innerRadius;
	}
	
	public void draw (Graphics g) {
		super.draw(g);
		this.setGraphicState(g);
		g.drawOval(center.getX()-innerRadius, center.getY()- innerRadius, 2*innerRadius, 2*innerRadius);
		
		if (selected) {
			Point up = new Point (this.center.getX(), this.center.getY() - this.innerRadius, true);
			up.draw(g);
			
			Point down = new Point (this.center.getX(), this.center.getY() + this.innerRadius, true);
			down.draw(g);
			
			Point left = new Point (this.center.getX() - this.innerRadius, this.center.getY(), true);
			left.draw(g);
			
			Point right = new Point (this.center.getX() + this.innerRadius, this.center.getY(), true);
			right.draw(g);
		}
	}
	
	@Override
	public String toString() {
		return "Donut [innerRadius=" + innerRadius + ", center=" + center + ", radius=" + radius + "]";
	}

}
