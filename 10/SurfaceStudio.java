import java.awt.Color;
import java.awt.Graphics;

public class SurfaceStudio extends AllInOne
{
    // The Surface Studio is Microsoft's new all-in-one PC.

    public SurfaceStudio()
    {
        super(4500, 3000, 32, "Intel Core i7");
    }

    public void changeRAM(int ramInGB)
    {
        System.out.println("The Surface Studio's RAM is not user upgradeable. The RAM will not change.");
    }

    public void draw(Graphics g)
    {
        drawBase(g);
    }

    private void drawBase(Graphics g)
    {
        g.setColor(Color.black);
        g.draw3DRect(100, 100, 50, 80, true);
        g.setColor(Color.blue);
        g.fill3DRect(100, 100, 50, 80, true);
    }
}