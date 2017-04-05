import java.awt.*;

public abstract class GenericShape implements Shape
{
    protected String name;
    protected int sides;
    protected int shapeX;
    protected int shapeY;
    protected int messageX;
    protected int messageY;

    public void displayNumSides(Graphics g)
    {
        g.drawString("A " + name + " has " + sides + " sides.", shapeX, shapeY+shapeSize+50);
    }

    public GenericShape(int shapeX, int shapeY, int messageX, int messageY)
    {
        // Set positions.
        this.shapeX = shapeX;
        this.shapeY = shapeY;
        this.messageX = messageX;
        this.messageY = messageY;
    }

    public void displayName(Graphics g)
    {
        g.drawString(name, messageX, messageY);
    }
}