// Lab07st.java
// Student Version

import java.awt.*;
import java.applet.*;
import java.util.*; 
																

public class Lab07v110 extends Applet
{
	private int width = 800;
	public void init()
	{
		setSize(width, 600);
	}
	public void paint(Graphics g) 	
	{
		Road.draw(g, width);
		Random rand = new Random();
		
		Tree.draw(g, rand, 50, 200);

		Car car = new Car(rand.nextInt(width), rand.nextInt(200) + 100);
		car.draw(g, randomColor(rand));

		
	}
	private static Color randomColor(Random random)
	{
		return new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
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

class Road
{
	private static Graphics g;
	private static int width;
	public static void draw(Graphics graphics, int newWidth)
	{
		g = graphics;
		width = newWidth;
		g.setColor(Color.green);
		g.fillRect(0, 0, 800, 200);
		g.setColor(Color.gray);
		g.fillRect(0, 200, 800, 400);

		drawSidewalk();
	}
	private static void drawSidewalk()
	{
		int increment = width / 10;
		System.out.println(increment);
		for (int i = 0; i < width; i+= increment)
		{
			g.setColor(Color.black);
			g.fillRect(i, 500, increment, 100);
			g.setColor(Color.gray);
			g.fillRect(i+2, 502, increment-2, 96);
		}
	}
}
class Tree
{
	private static Graphics g;
	private static Random rand;
	private static int x;
	private static int y;
	private static int treeHeight;

	private static final Color brown = new Color (2,2, 2);
	public static void draw(Graphics graphics, Random random, int posX, int posY)
	{
		g = graphics;
		rand = random;
		x = posX;
		y = posY;
		
		treeHeight = rand.nextInt(50)+50;

		drawTrunk();

		for (int i = 0; i > rand.nextInt(8)+1; i++)
		{
			drawBranch();
		}

	}
	private static void drawTrunk()
	{
		g.setColor(brown);
		g.fillRect(x, y-treeHeight, 50, treeHeight);
	}

	private static void drawBranch()
	{
		int branchPoint = rand.nextInt(treeHeight);
		g.setColor(brown);
		g.fillRect(x, y-treeHeight, 50, treeHeight);
	}

	private static void drawLeaves()
	{

	}
}