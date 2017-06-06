// Lab17bvst.java
// Lab17bv110.java
// This is the 110 point version
// Zion Nimchuk
// April 18, 2017
// This program generates a square fractal recursively.


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
	}
}