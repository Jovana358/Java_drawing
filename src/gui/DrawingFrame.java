package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class DrawingFrame extends JFrame {
	private JPanel contentPane;
	private JToggleButton tglSelect;
	private JToggleButton tglPoint;
	private JToggleButton tglLine;
	private JToggleButton tglRectangle;
	private JToggleButton tglCircle;
	private JToggleButton tglDonut;
	private JButton btnDelete;
	DrawingPanel drawingPanel;

	private Line newLine;
	private Rectangle newRectangle;
	private Circle newCircle;
	private Donut newDonut;
	private Shape selectedShape;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrame frame = new DrawingFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DrawingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.newLine = null;
		this.newRectangle = null;

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		drawingPanel = new DrawingPanel();

		drawingPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				onDrawingPanelClicked(e);
			}
		});
		contentPane.add(drawingPanel, BorderLayout.CENTER);

		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);

		tglSelect = new JToggleButton("Select");
		toolBar.add(tglSelect);

		tglPoint = new JToggleButton("Point");
		toolBar.add(tglPoint);

		tglLine = new JToggleButton("Line");
		toolBar.add(tglLine);

		tglRectangle = new JToggleButton("Rectangle");
		toolBar.add(tglRectangle);

		tglCircle = new JToggleButton("Circle");
		toolBar.add(tglCircle);

		tglDonut = new JToggleButton("Donut");
		toolBar.add(tglDonut);
		
		btnDelete = new JButton("delete");
		toolBar.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				drawingPanel.shapes.remove(selectedShape);
				selectedShape = null;
				drawingPanel.repaint();
			}
		});

		ButtonGroup group = new ButtonGroup();
		group.add(tglSelect);
		group.add(tglPoint);
		group.add(tglLine);
		group.add(tglRectangle);
		group.add(tglCircle);
		group.add(tglDonut);

	}

	protected void onDrawingPanelClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Point clickedPoint = new Point(e.getX(), e.getY());

		if (this.tglSelect.isSelected()) {
			Iterator<Shape> it = this.drawingPanel.getShapes().iterator();
			while (it.hasNext()) {
				Shape shapes = it.next();
				if (shapes.contains(clickedPoint)) {
					shapes.setSelected(true);
					selectedShape = shapes;
					System.out.println("selektovano");
				} else {
					shapes.setSelected(false);
				}
			}
		} else if (this.tglPoint.isSelected()) {
			drawingPanel.shapes.add(clickedPoint);
		} else if (this.tglLine.isSelected()) {
			if (newLine == null) {
				newLine = new Line(clickedPoint, null);
			} else {
				newLine.setEnd(clickedPoint);
				drawingPanel.shapes.add(newLine);
				newLine = null;
			}
		} else if (this.tglRectangle.isSelected()) {
			if (newRectangle == null) {
				newRectangle = new Rectangle(clickedPoint, -1, -1);
				RectangleDialog dialog = new RectangleDialog(this, newRectangle);
				dialog.setVisible(true);
				if (newRectangle.getWidth() != -1) {
					drawingPanel.shapes.add(newRectangle);
				}
				newRectangle = null;

			}
		} else if (this.tglCircle.isSelected()) {
			if (newCircle == null) {
				newCircle = new Circle(clickedPoint, -1);
				CircleDialog dialog = new CircleDialog(this, newCircle);
				dialog.setVisible(true);
				if (newCircle.getRadius() != -1) {
					drawingPanel.shapes.add(newCircle);
				}
				newCircle = null;
			}
		} 
		else if (this.tglDonut.isSelected()) {
			if (newDonut == null) {
				newDonut = new Donut(clickedPoint, -1, -1);
				DonutDialog dialog = new DonutDialog(this, newDonut);
				dialog.setVisible(true);
				if (newDonut.getRadius() != -1) {
					drawingPanel.shapes.add(newDonut);
				}
				newDonut = null;
			}
		}

		drawingPanel.repaint();

	}

}
