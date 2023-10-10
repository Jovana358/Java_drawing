package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
	
	protected boolean selected;
	
	public Shape() {
		
	}
	
	public Shape(boolean selected) {
		super();
		this.selected = selected;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public abstract boolean contains(Point p); 
		
	public abstract void draw(Graphics g); 
	
	public void setGraphicState(Graphics g) {
		if (this.selected) {
			g.setColor(Color.blue);
		}else  {
			g.setColor(Color.black);
		}
	}
}
