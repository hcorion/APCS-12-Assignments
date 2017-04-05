// Shape3Octagon.java
// Lab14v100

import java.awt.*;

public class Shape3Octagon extends GenericShape
{
    public Shape3Octagon(int shapeX, int shapeY, int messageX, int messageY)
    {
        // Setup positions.
        super(shapeX, shapeY, messageX, messageY);

        // Setup basic values.
        this.name = "Octagon";
        this.sides = 8;
    }
    public void drawShape(Graphics g)
    {
        g.fillPolygon(octogon());
        displayName(g);
        displayNumSides(g);
    }

    public Polygon octogon()
    {
        final int quarter = (int)Math.floor(shapeSize * 0.25f);
        final int third = (int)Math.floor(shapeSize * 0.75f);
        return new Polygon(
            new int[]{shapeX + quarter, shapeX + third, shapeX + shapeSize, shapeX + shapeSize, shapeX + third,     shapeX + quarter,   shapeX,         shapeX          },
            new int[]{shapeY,           shapeY,         shapeY + quarter,   shapeY + third,     shapeY + shapeSize, shapeY + shapeSize, shapeY + third, shapeY + quarter}, 
            sides);
    }
}

