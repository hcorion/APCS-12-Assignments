import java.awt.*;

public class SurfaceStudio extends AllInOne
{
    // The Surface Studio is Microsoft's new all-in-one PC.

    public SurfaceStudio()
    {
        // Creates as Surface Studio All-In-One PC with a 
        // 4500 x 3000 screen resolution
        // 35 GB of ram and an
        // Intel Core i7
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
        drawScreen(g, x, y);
    }

    private void drawBase(Graphics g, int x, int y)
    {
        g.setColor(Color.gray);
        g.fillRect(286, 538, 228, 19);

        g.fillPolygon(new int[]{293, 507, 514, 285}, new int[]{514,514,538, 538}, 4);

        g.setColor(Color.black);
        g.drawRect(286, 538, 228, 19);
        g.drawPolygon(new int[]{293, 507, 514, 285}, new int[]{514,514,538, 538}, 4);
    }

    private void drawScreen(Graphics g, int x, int y)
    {
        // Draw the border
        g.setColor(Color.black);
        g.fillRoundRect(111, 62, 690-111, 460-62, 10, 10);

        // We want to draw a screen of size 542x362
        // So we need to scale the 4500x3000 display by 0.1204
        final float screenScale = 0.1204f;

        screen.draw(g, 128, 80, screenScale);

        drawText(g);
    }

        
    
    private void drawText(Graphics g)
    {
        g.setColor(Color.black);
        // Let's also put some text on the screen.
        g.drawString ("Microsoft Surface Studio", 240, 110);
        g.drawString(getCPU(), 240, 130);
        g.drawString("RAM: " + getRAM() + "GB", 240, 150);
        g.drawString("Screen Resolution: " + screen.getWidth() + " × " + screen.getHeight(), 240, 170);
        g.drawString("Peripherals attached: ", 240, 190);
        final int peripheralStart = 210;
        for (int i = 0; i < peripherals.size() ; i++)
        {
            g.drawString(peripherals.get(i).getName() + " via " + peripherals.get(i).getConnector(), 270, peripheralStart + (i * 20) );
        }
    }
    private void drawStands(Graphics g, int x, int y)
    {
        // Drawing the left stand.
        g.setColor(Color.black);
        g.drawPolygon(new int[]{267, 279, 283, 300, 292, 294, 269}, new int[]{460, 460, 512, 515, 516, 536, 536}, 7);
        g.setColor(Color.gray);
        g.fillPolygon(new int[]{267, 279, 283, 300, 292, 294, 269}, new int[]{460, 460, 512, 515, 516, 536, 536}, 7);
        // Drawing the right stand.
        g.setColor(Color.black);
        g.drawPolygon(new int[]{521, 533, 531, 511, 501, 513, 517}, new int[]{460, 460, 536, 536, 516, 517, 511}, 7);
        g.setColor(Color.gray);
        g.fillPolygon(new int[]{521, 533, 531, 511, 501, 513, 517}, new int[]{460, 460, 536, 536, 516, 517, 511}, 7);
    }
}