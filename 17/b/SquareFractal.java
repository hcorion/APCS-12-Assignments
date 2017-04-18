import java.awt.Color;
import java.awt.Graphics;

public class SquareFractal
{
    private static enum Directions {TopLeft, TopRight, BottomRight, BottomLeft};

    private static final int maxiteration = 10;
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
        // Draw the big black center square.
        drawSquare(width/3, height/3, 3);

        g.setColor(Color.red);

        // Four corners of the square.
        for (int i = 0; i < 4; i++)
        {
            genFractal(Directions.values()[i]);
        }
    }

    /*
     * genFractal
     * Generates a square fractal.
     * 
     * Arguments:
     * iteration: The number of iteration that the fractal generates.
     * direction: The direction in which this 'node' of the fractal is going.
     * xPos:      The top left x position this fractal 'node' is located at.
     * yPos:      The top left y position this fractal 'node' is located at.
     */
    private void genFractal(int iteration, Directions direction, int xPos, int yPos)
    {
        iteration++;

        xPos += updateX(direction, iteration);
        yPos += updateY(direction, iteration);

        drawFractalSegment(iteration, xPos, yPos);
        
        if (iteration < maxiteration)
        {
            // Generate the next clockwise fractal 'node'
            g.setColor(Color.green);   
            genFractal(iteration, inc(direction), xPos, yPos);

            // Generate the next counter-clockwise fractal 'node'
            g.setColor(Color.blue);
            genFractal(iteration, dec(direction), xPos, yPos);
            
            // Generate the next fractal 'node' going the same direction.
            g.setColor(Color.red);
            genFractal(iteration, direction, xPos, yPos);
        }
    }

    // Just a simple overloading method, see above genFractal for the real juicy stuff.
    private void genFractal(Directions direction) { genFractal(0, direction, width/3, height/3); }

    // Calculates how much the x position needs to change for the next fractal 'node'
    private int updateX(Directions direction, int iteration)
    {
        switch (direction)
        {
            case TopLeft: case BottomLeft:
                int scale = getScale(iteration);
                return -(width/scale);

            case TopRight: case BottomRight:
                int oldScale = getScale(iteration-1);
                return width/oldScale;
        }
        throw new Error("updateX was called but an invalid direction, " + direction.toString() + ", was given.");
    }

    // Calculates how much the y position needs to change for the next fractal 'node'
    private int updateY(Directions direction, int iteration)
    {
        switch (direction)
        {
            case TopLeft: case TopRight:
                int scale = getScale(iteration);
                return -(height/scale);

            case BottomRight: case BottomLeft:
                int oldScale = getScale(iteration-1);
                return height/oldScale;
        }
        throw new Error("updateY was called but an invalid direction, " + direction.toString() + ", was given.");
    }

    // Increments the direction.
    private static final Directions inc(Directions direction)
    {
        if (direction == Directions.BottomLeft)
            return Directions.TopLeft;
        return Directions.values()[direction.ordinal() + 1];
    }
    
    // Decrements the direction
    private static final Directions dec(Directions direction)
    {
        if (direction == Directions.TopLeft)
            return Directions.BottomLeft;
        return Directions.values()[direction.ordinal() - 1];
    }

    // A fancy algorithm that gives the correct scale values, ie 1 = 6 2 = 12 3 = 24 4 = 48 5 = 96...
    private static final int getScale(int iteration) { return 3 * (int)Math.pow(2, iteration); }

    //Makes drawing the fractal nicer.
    private void drawFractalSegment(int iteration, int xPos, int yPos) { drawSquare(xPos, yPos, getScale(iteration)); }
    
    // A simple wrapper over the fillRect method.
    private void drawSquare(int x, int y, int scale) { g.fillRect(x, y, width / scale, height / scale); }
}