// Shape2Triangle.java
// Lab14v100

import java.awt.*;

public class Shape2Triangle extends GenericShape
{
    public Shape2Triangle(int shapeX, int shapeY, int messageX, int messageY)
    {
        // Setup positions.
        super(shapeX, shapeY, messageX, messageY);

        // Setup basic values.
        this.name = "Triangle";
        this.sides = 3;
    }
    public void drawShape(Graphics g)
    {
        g.fillPolygon(triangle());
        displayName(g);
        displayNumSides(g);
    }

    private Polygon triangle()
    {
        return new Polygon(
            new int[]{shapeX + (shapeSize / 2), shapeX,             shapeX+shapeSize},
            new int[]{shapeY,                   shapeY + shapeSize, shapeY+shapeSize},
            sides
            );
    }
}

