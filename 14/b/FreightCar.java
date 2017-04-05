// FreightCar.java
// 02-24-15 by Leon Schram
// Modified March 24th 2017 by Zion Nimchuk

// This is one of the student starting files
// of the Lab14b lab assignment.


import java.awt.*;


public class FreightCar extends RailCar
{
	public FreightCar(Color cC, int xPos, int yPos)
	{
		super(cC,xPos,yPos);
   }

	public void drawCar(Graphics g)
	{
		super.drawCar(g);
		drawFreightDoors(g);
	}
   
	private void drawFreightDoors(Graphics g)
	{
		g.setColor(Color.black);
		g.drawRect(xPos+30,yPos+10,90,60);
      g.drawLine(xPos+75,yPos+10,xPos+75,yPos+70);
      g.drawLine(xPos+30,yPos+10,xPos+75,yPos+70);
      g.drawLine(xPos+30,yPos+70,xPos+75,yPos+10);
      g.drawLine(xPos+75,yPos+10,xPos+120,yPos+70);
      g.drawLine(xPos+75,yPos+70,xPos+120,yPos+10);
      g.fillRect(xPos+66,yPos+35,5,15);
      g.fillRect(xPos+80,yPos+35,5,15);
	}
 }

