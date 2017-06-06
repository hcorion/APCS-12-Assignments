import java.awt.*;

public class Bullet extends GameObject
{
    private static final int bulletSize = 20;
    private Color color;
    private float accX;
    private float accY;
    public Bullet(int x, int y, int level, float accX, float accY)
    {
        this.x = x;
        this.y = y;

        this.accX = accX;
        this.accY = accY;
        
        // TODO Color based on level.
        color = Color.red;
        if (level > 25)
            level = 25;
        color = new Color(level*10,0,0);

    }
    public void draw(Graphics g)
    {
        g.setColor(color);
        final int div = bulletSize/2;
        g.fillOval(x-div, y-div, bulletSize, bulletSize);
    }
    public boolean move(int width, int height)
    {
        this.x += accX;
        this.y += accY;
        if (this.x > width || this.y > height)
        {
            return false;
        }
        return true;
    }

}