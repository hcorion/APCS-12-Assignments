// Lab07v110.java
// This is the 110 point version.
// Zion Nimchuk
// January 10, 2017
// APCS, Chris Robinson
// This program draws a road, 
// a car with a randomized color and position 
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
		
		Tree.drawTrees(g, rand, 200, width);

		Car car = new Car(rand.nextInt(width), rand.nextInt(200) + 100);
		car.draw(g, randomColor(rand));
	}
	
	private static Color randomColor(Random random)
	{
		return new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
	}
}