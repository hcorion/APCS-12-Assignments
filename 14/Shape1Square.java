// Shape1Square.java
// Lab14v100

import java.awt.*;

public class Shape1Square extends GenericShape
{   
    public Shape1Square(int shapeX, int shapeY, int messageX, int messageY)
    {
        // Setup positions.
        super(shapeX, shapeY, messageX, messageY);

        // Setup basic values.
        this.name = "Square";
        this.sides = 4;
    }
    public void drawShape(Graphics g)
    {
        g.fillRect(shapeX, shapeY, shapeSize, shapeSize);
        displayName(g);
        displayNumSides(g);
    }
}