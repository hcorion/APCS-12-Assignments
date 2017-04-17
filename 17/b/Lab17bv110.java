// Lab17bvst.java
// The student, starting version of the Lab17b assignment.


import java.awt.*;
import java.applet.*;


public class Lab17bv110 extends Applet
{
	private final int width = 1000;
	private final int height = 650;
	public void init()
	{
		setSize(width, height);
	}
	public void paint (Graphics g)
	{
		SquareFractal squareFractal = new SquareFractal(g, width, height);
		squareFractal.draw();
		//drawSquare1(g, width, height);
	}

	public void drawSquare1(Graphics g, int maxX, int maxY)
	{
		int midX = maxX/2;
		int midY = maxY/2;
		int startWidth = maxX/4;
		int startHeight = maxY/4;
		int tlX = midX - (startWidth/2);
		int tlY = midY - (startHeight/2);
		g.fillRect(tlX,tlY,startWidth,startHeight);
	}

	public void delay(long n)
	{
		n *= 1000;
		long startDelay = System.nanoTime();
		long endDelay = 0;
		while (endDelay - startDelay < n)
			endDelay = System.nanoTime();
	}

}


