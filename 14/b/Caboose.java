// Caboose.java
// 02-24-15 by Leon Schram
// Modified March 24th 2017 by Zion Nimchuk

// This is one of the student starting files
// of the Lab14b lab assignment.


import java.awt.*;


public class Caboose extends RailCar
{
	public Caboose(Color cC, int xPos, int yPos)
	{
		super(cC,xPos,yPos);
   }

	public void drawCar(Graphics g)
	{
		super.drawCar(g);
		drawWindows(g);
		drawCupola(g);
	}

	private void drawWindows(Graphics g)
	{
	    g.setColor(Color.white);
	    g.fillRect(xPos+30,yPos+30,30,30);
	    g.fillRect(xPos+90,yPos+30,30,30);
	}

	private void drawCupola(Graphics g)
	{
	    g.setColor(Color.red);
	    g.fillRect(xPos+30,yPos-30,90,30);
	    g.setColor(Color.black);
	    g.fillRect(xPos+25,yPos-30,100,5);
	}
}

