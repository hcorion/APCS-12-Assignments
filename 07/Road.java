// Road.java
// This is the 110 point version.
// Zion Nimchuk
// January 10, 2017
// APCS, Chris Robinson
// This program draws a road with a blue background, and a sidewalk.

import java.awt.*;

public class Road
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