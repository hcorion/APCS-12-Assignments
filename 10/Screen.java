import java.awt.Color;
import java.awt.Graphics;

public class Screen
{
    // The width in pixels
    private int width;
    // The height in pixels
    private int height;
    public Screen(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    // Draws the screen pixel for pixel.
    public void draw(Graphics g, int x, int y)
    {
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }

    // Draws the screen but allows for scaling.
    public void draw(Graphics g, int x, int y, float scale)
    {
        g.setColor(Color.white);
        g.fillRect(x, y, (int) Math.floor( (float)width * scale), (int) Math.floor( (float)height * scale));
    }
    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }
}