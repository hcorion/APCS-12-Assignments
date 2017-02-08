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
    public void draw(Graphics g, int x, int y)
    {
        g.drawRect(x, y, width, height);
    }
}