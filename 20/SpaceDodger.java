import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import java.applet.*;

public class SpaceDodger
{
    // Graphical
    private Graphics g;
    private int width;
    private int height;

    // Game related
    private ArrayList<GameObject> objects;
    private Plane plane;
    private Random rand;
    // The number of waves the player has been through
    private int wave = 0;

    //Physics and time-dependant
    private long physicsTime;
    private long waveTime;
    // The time before the next wave in milliseconds.
    private static final int MaxWaveTime = 6 * 1000;

    public SpaceDodger(Graphics g, int width, int height, Applet appletContext)
    {
        this.g = g;
        this.width = width;
        this.height = height;

        this.plane = new Plane(this.g, appletContext, width, height);
        objects = new ArrayList<GameObject>();

        // Send an initial wave of bulllets
        for (GameObject obj: Wave.getDiagonalWave(width, height, wave))
        {
            objects.add(obj);
        }

        physicsTime = System.currentTimeMillis();
        waveTime = System.currentTimeMillis();

        rand = new Random();
    }

    public void paint(Applet appletContext)
    {
        for (int i = 0; i < objects.size(); i++)
        {
            objects.get(i).draw(g);
        }

        plane.draw(g);
    }

    public void loop(Applet appletContext, int mouseX, int mouseY)
    {
        //Physics can't be frame-rate dependant
        if (System.currentTimeMillis() - physicsTime >= 20)
        {
            plane.move(mouseX, mouseY);
            physicsTime = System.currentTimeMillis();

            ArrayList<Integer> objectsToRemove = new ArrayList<Integer>();
            for (int i = 0; i < objects.size(); i++)
            {
                if (!objects.get(i).move(width, height))
                {
                    objectsToRemove.add(i);
                }
                if (plane.hasCollided(objects.get(i).getX(), objects.get(i).getY()))
                {
                    plane.loseHealth();
                    objectsToRemove.add(i);
                }
            }
            for (int i = 0; i < objectsToRemove.size(); i++)
            {
                objects.remove(objectsToRemove.get(i)-i);
            }
            g.setColor(Color.white);
		    g.clearRect(0, 0, width, height);
        }

        if (System.currentTimeMillis() - waveTime >= MaxWaveTime)
        {
            waveTime = System.currentTimeMillis();
            wave++;
            for (GameObject obj: Wave.getRandomWave(rand, width, height, wave))
            {
                objects.add(obj);
            }
        }
        //appletContext.update(g);
        appletContext.repaint();
        
    }
}