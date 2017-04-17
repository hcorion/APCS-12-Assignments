import java.awt.Graphics;

import javax.net.ssl.ExtendedSSLSession;

public class SquareFractal
{
    // Directions
    // 0 = Up    or North
    // 1 = Right or East
    // 2 = Down  or South
    // 3 = Left  or West
    private enum Directions {TopLeft, TopRight, BottomRight, BottomLeft};
    //private enum 
    private int width;
    private int height;
    private Graphics g;

    public SquareFractal(Graphics graphics, int width, int height)
    {
        this.g = graphics;
        this.width = width;
        this.height = height;
    }
    public void draw()
    {
        drawSquare(width/4, height/4, 2);
        final int amount = 2;
        genFractal(4);
    }

    /*
     * genFractal
     * Generates a square fractal.
     * 
     * Arguments:
     * iterations: The number of iterations that the fractal generates.
     */
    private void genFractal(int iterations)
    {
        iterations--;
        if (iterations > 0)
        {
            genRightFractal(iterations);
            genLeftFractal(iterations);
            genStraightFractal(iterations);
        }
        /*int scalar = scale / 2;
        if (scalar > 0)
        {
            drawSquare(width/scalar, height/scalar, scale);
            genFractal(scalar);
        }*/
    }
    private void genRightFractal(int iterations)
    {
        genFractal(iterations);
        Directions direction = Directions.BottomLeft;
        direction = Directions.values()[direction.ordinal() + 1];
    }
    private void genLeftFractal(int iterations)
    {
        genFractal(iterations);
    }

    private void genStraightFractal(int iterations)
    {
        genFractal(iterations);
    }

    private Directions getDirection(int xPos, int yPos)
    {
        final int halfWidth = width / 2;
        final int halfHeight = height / 2;

        if (xPos > halfWidth && yPos > halfHeight)
            return Directions.BottomRight;
        else if (xPos < halfWidth && yPos < halfHeight)
            return Directions.TopLeft;
        else if (xPos > halfWidth && yPos < halfHeight)
            return Directions.TopRight;
        else if (xPos < halfWidth && yPos > halfHeight)
            return Directions.BottomLeft;
        else
            throw new Error("Error, tried to calculate direction for invalid position: x: " + xPos + " y: " + yPos);
    }

    /*
     * A simple wrapper over the fillRect method.
     * This makes drawing of squares simpler and makes sense in this situation.
     * Arguments:
     * x: The top left X position
     * y: The top left Y position
     * scale: The size, so if scale is 4, height will be height / 4
     */
    private void drawSquare(int x, int y, int scale)
    {
        g.fillRect(x, y, width / scale, height / scale);
    }
}