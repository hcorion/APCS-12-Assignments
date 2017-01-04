// Lab07st.java
// Student Version

import java.awt.*;
import java.applet.*;
import java.util.*; 
																

public class Lab07v110 extends Applet
{
	
	public void paint(Graphics g) 	
	{
		Car car = new Car(0, 0);
		car.draw(g, Color.green);
	}
		
}

class Car
{
	public int x;
	public int y;

	private Graphics g;

	public Car(int posX, int posY)
	{
		x = posX;
		y = posY;
	}

	public void draw(Graphics graphics, Color color)
	{
		g = graphics;

		g.setColor(color);
		g.fillPolygon(body());

		drawWheels();
	}
	private Polygon body()
	{
        Polygon body = new Polygon();
		body.addPoint(x,		y+150);
        body.addPoint(x, 		y+75);
        body.addPoint(x+75, 	y+50);
        body.addPoint(x+125,	y);
        body.addPoint(x+275,	y);
        body.addPoint(x+275,	y+50);
        body.addPoint(x+375,	y+50);
        body.addPoint(x+380, 	y+150);
		return body;
	}
	private void drawWheels()
	{
		g.setColor(Color.black);
		g.fillOval(x+70, y+120, 60, 60);
		g.fillOval(x+250, y+120, 60, 60);
		g.setColor(Color.gray);
		g.fillOval(x+80, y+130, 40, 40);
		g.fillOval(x+260, y+130, 40, 40);
	}
}
 