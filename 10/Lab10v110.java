// Lab10v110.java
// This is the 110 point version.
// Zion Nimchuk
// January 10, 2017
// APCS, Chris Robinson
// This program draws a All-in-one computer.
// I am having too much fun with this assignment so I'm gonna use some advanced features.

import java.awt.*;
import java.applet.*;
import java.util.*;
																

public class Lab10v110 extends Applet
{
	private int width = 800;
	public void init()
	{
		setSize(width, 600);
	}

	public void paint(Graphics g) 	
	{
        SurfaceStudio surfaceStudio = new SurfaceStudio();
		surfaceStudio.changeRAM(64);
		Mouse mouse = new Mouse();
		Keyboard keyboard = new Keyboard();
		surfaceStudio.addPeripheral(mouse);
		surfaceStudio.addPeripheral(keyboard);

		System.out.println(surfaceStudio.getCPU());
		System.out.println(surfaceStudio.getPeripherals());
		System.out.println(" The surface Studio has " + surfaceStudio.getRAM() + " GB of RAM.");
		surfaceStudio.draw(g, 0, 0);
    }
}

