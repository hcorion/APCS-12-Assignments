import java.awt.*;

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

    // Draws a Surface Studio All-in-One PC at position x, y with dimensions of 800x600 pixels
    public void draw(Graphics g, int x, int y)
    {
        drawStands(g, x, y);
        drawBase(g, x, y);
    }

    private void drawBase(Graphics g, int x, int y)
    {
        g.setColor(Color.gray);
        g.fillRect(286, 538, 230, 19);
        g.fillPolygon(new int[]{293, 507, 514, 285}, new int[]{514,514,538, 538}, 4);
        g.setColor(Color.black);
        g.drawRect(286, 538, 230, 19);
        g.drawPolygon(new int[]{293, 507, 514, 285}, new int[]{514,514,538, 538}, 4);
    }
    private void drawStands(Graphics g, int x, int y)
    {
        //g.setColor(Color.gray);
        //g.fillRect(286, 538, 230, 19);
        //g.fillPolygon(new int[]{293, 507, 514, 285}, new int[]{514,514,538, 538}, 4);
        g.setColor(Color.black);
        //g.drawRect(286, 538, 230, 19);
        g.drawPolygon(new int[]{267, 279, 283, 290, 292, 284, 269}, new int[]{460, 460, 512, 515, 516, 536, 536}, 7);
    }
}