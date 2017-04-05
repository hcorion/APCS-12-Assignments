// Lab14av100.java
// This is the 100 point version
// Zion Nimchuk
// March 23, 2017
// This program draws a circle, triangle, octagon and circle each with a heading and information about the number of sides each shape has.


import java.awt.*;
import java.applet.*;
import java.util.ArrayList;


public class Lab14av100 extends Applet
{
	public void paint(Graphics g)
	{
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Shape1Square(100, 50, 20, 60));
		shapes.add(new Shape2Triangle(510, 50, 420, 60));
		shapes.add(new Shape3Octagon(100, 350, 20, 320));
		shapes.add(new Shape4Circle(510, 350, 420, 320));
		for (Shape shape: shapes)
		{
			shape.drawShape(g);
		}
		drawGrid(g);
   }

	public void drawGrid(Graphics g)
	{
		g.drawRect(10,10,800,600);
		g.drawLine(10,300,810,300);
		g.drawLine(410,10,410,610);
	}
}

