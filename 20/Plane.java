import java.awt.*;
import java.applet.*;
import javax.sound.sampled.*;

public class Plane
{
    // Graphical
    private Applet      appletContext;
    private Image       image;

    // Game related
    private int x;
    private int y;
    private int health;

    private static final String planeFileName   = "plane.png";
    private static final int    maxHealth       = 10;

    public Plane(Graphics g, Applet appletContext, int height, int width)
    {
        this.appletContext = appletContext;

        image = this.appletContext.getImage(this.appletContext.getDocumentBase(), planeFileName);

        x = width/2;
        y = height/2;
        health = maxHealth;
    }

    public void draw(Graphics g)
    {
        g.drawImage(image, x, y, appletContext);
    }

    public void move(int mouseX, int mouseY)
    {
        if (mouseX > x+50)
            x += 2;
        else
            x -= 2;
        if (mouseY < y)
            y -= 2;
        else
            y += 2;
    }

    public boolean hasCollided(int bulletX, int bulletY)
    {
        // Fuselage detector
        // Fuselage starts at x+48, y and ends at x+57, y+87
        if ( (bulletX > this.x+48 && bulletY > this.y) && (bulletX < this.x+57 && bulletY < this.y+87) )
        {
            return true;
        }
        // Wing detector
        // Wings start at x, y+22 and ends at x+107, y+38
        if ( (bulletX > this.x && bulletY > this.y+22) && (bulletX < this.x+107 && bulletY < this.y+38) )
        {
            return true;
        }

        return false;
    }

    public void loseHealth()
    {
        health--;
        System.out.println("planeHealth now at: " + health);
        playSound();
    }

    public static synchronized void playSound()
    {
        // This method was taken from here:
        // https://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java
        new Thread( new Runnable()
        {
            public void run()
            {
                try
                {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                        Plane.class.getResourceAsStream("lose_health.wav"));
                    clip.open(inputStream);
                    clip.start();
                    clip.drain();
                }
                catch (Exception e)
                {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
}