// FinalProject01.java
// Zion Nimchuk
// Date
// APCS, Chris Robinson
// Breif description of what the programs does.

import java.awt.*;
import java.applet.*;
import java.awt.event.*;


public class FinalProject01 extends Applet
{
	private boolean init;
	private SpaceDodger game;
	private int mouseX;
	private int mouseY;
	private final int width = 1000;
	private final int height = 650;

	public void init()
	{
		setSize(width, height);
		game = new SpaceDodger(getGraphics(), width, height, this);
	}
	public void paint(Graphics g)
	{
		game.loop(this, mouseX, mouseY);
		
		//repaint();
	}
	public void update(Graphics g)
	{
		game.paint(this);
		paint(g);
		//try { Thread.sleep(1); } catch(InterruptedException ex) {}

		/*game.paint(this);
		g.setColor(Color.white);
		g.clearRect(0, 0, width, height);
		game.paint(this);
		paint(g);
		game.paint(this);*/
		//System.out.println("x");
	}
	public boolean mouseMove(Event e, int x, int y)
	{
		mouseX = x;
		mouseY = y;
		return true;
	}
}


