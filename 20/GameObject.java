import java.awt.*;

public abstract class GameObject
{
    protected int x;
    protected int y;
    public abstract void draw(Graphics g);
    public abstract boolean move(int width, int height);

    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
}