// Lab07v110.java
// This is the 110 point version.
// Zion Nimchuk
// January 10, 2017
// APCS, Chris Robinson
// This program draws a road, 
// cars with a randomized color and position 
// and trees with randomized branches, height and leaf size.

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
		
		//Tree.draw(g, rand, 50, 200);
		Tree.drawTrees(g, rand, 200, width);

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

	private static final Color skyBlue = new Color (0, 191, 255);

	public static void draw(Graphics graphics, int newWidth)
	{
		g = graphics;
		width = newWidth;
		g.setColor(skyBlue);
		g.fillRect(0, 0, 800, 200);
		g.setColor(Color.gray);
		g.fillRect(0, 200, 800, 400);

		drawSidewalk();
	}
	private static void drawSidewalk()
	{
		int increment = width / 10;
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

	// Some custom colors because I didn't like the pre-made ones.
	private static final Color brown = new Color (165,42,42);
	private static final Color leafGreen = new Color (34, 139, 34);
	
	private static final int branchWidth = 20;
	public static void drawTrees(Graphics graphics, Random random, int posY, int width)
	{
		int amountOfTrees = random.nextInt(3)+2;
		for (int i = 0; i < amountOfTrees; i++)
		{
			Tree.draw(graphics, random, random.nextInt(width), posY);
		}
	}

	public static void draw(Graphics graphics, Random random, int posX, int posY)
	{
		g = graphics;
		rand = random;
		x = posX;
		y = posY;
		
		treeHeight = rand.nextInt(200)+100;

		drawTrunk();

		int amountOfBranches = rand.nextInt(8)+1;
		for (int i = 0; i < amountOfBranches; i++)
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
		int branchHeight = y - branchWidth - rand.nextInt(treeHeight - branchWidth);
		
		g.setColor(brown);
		int branchDistance = rand.nextInt(100);
		//Left Side of the trunk
		if (rand.nextBoolean())
		{
			int branchPosX = x - branchDistance;
			g.fillRect(branchPosX, branchHeight, branchDistance, branchWidth);
			drawLeaves(branchPosX, branchHeight);
		}
		//Right side of the trunk
		else
		{
			int branchPos = x + 50;
			g.fillRect(branchPos, branchHeight, branchDistance, branchWidth);
			drawLeaves(branchPos + branchDistance, branchHeight);
		}
	}

	private static void drawLeaves(int centerX, int centerY)
	{
		g.setColor(leafGreen);
		int leafHeight = rand.nextInt(80) + 30;
		int leafWidth = rand.nextInt(80) + 30;
		g.fillOval(centerX - (leafWidth / 2), centerY - (leafHeight / 2), leafWidth, leafHeight);
	}
}