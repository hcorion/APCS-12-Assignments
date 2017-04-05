// Shape4Circle.java
// Lab14v100

import java.awt.*;

public class Shape4Circle extends GenericShape
{
    public Shape4Circle(int shapeX, int shapeY, int messageX, int messageY)
    {
        // Setup positions.
        super(shapeX, shapeY, messageX, messageY);

        // Setup basic values.
        this.name = "Circle";
    }
    public void drawShape(Graphics g)
    {
        g.fillOval(shapeX, shapeY, shapeSize, shapeSize);
        displayName(g);
        displayNumSides(g);
    }
}