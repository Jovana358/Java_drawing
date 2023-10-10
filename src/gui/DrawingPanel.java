package gui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class DrawingPanel extends JPanel {

	/**
	 * 
	 */

	protected ArrayList<Shape> shapes = new ArrayList<>();
	
	public DrawingPanel()  {
		this.shapes.add(new Point(100,100));
		this.shapes.add(new Line(new Point(200,200), new Point(400,400)));
		this.shapes.add(new Rectangle (new Point(500,500), 100, 50));
		this.shapes.add(new Circle (new Point(100,300), 70));
		this.shapes.add(new Donut (new Point(300,100), 80, 40));
	}
	
	public void paint (Graphics g) {
		super.paint(g);
		
		Iterator<Shape> it = shapes.iterator();
		while (it.hasNext()) {
			it.next().draw(g);		
		}
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	

	

}
