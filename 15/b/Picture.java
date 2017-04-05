import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 *
 * 02-27-15 altered by Leon Schram
 * This file is made shorter to focus on the Lab15b assignment.
 *
 */



//////////////////////////////////////////////////////////////////////////
//
// This is the student starting file of the Lab15b assignment.
//
// This is the only file that students use to write their methods.
//
//////////////////////////////////////////////////////////////////////////


public class Picture extends SimplePicture
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments 
     */
    public Picture()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() +
            " height " + getHeight() + " width " + getWidth();
        return output;

    }

    private Color getAverage(Pixel pixel)
    {
        int average = (int) pixel.getAverage();
        return new Color(average, average, average);
    }

    ////////////////////////////////////////////////////////////////////////  

    // REQUIRED FOR 80-POINTS
    public void grayScale()
    {
        Pixel[] pixels = getPixels();
        for (int i = 0; i < pixels.length; i++)
        {
            pixels[i].setColor(getAverage(pixels[i]));
        }
    }

    //////////////////////////////////////////////////////////////////////////  

    // REQUIRED FOR 80-POINTS
    public void mirror()
    {   
        Pixel[][] pixels = getPixels2D();
        Color[][] colors = new Color[pixels.length][pixels[0].length];
        for (int x = 0; x < pixels.length; x++)
        {
            int altY = pixels[x].length;
            for (int y = 0; y < pixels[x].length; y++)
            {
                altY--;
                colors[x][y] = pixels[x][altY].getColor();
            }
        }
        for (int x = 0; x < pixels.length; x++)
        {
            for (int y = 0; y < pixels[x].length; y++)
            {
                pixels[x][y].setColor(colors[x][y]);
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    // REQUIRED FOR 80-POINTS
    public void upsideDown()
    {
        Pixel[][] pixels = getPixels2D();
        Color[][] colors = new Color[pixels.length][pixels[0].length];
        int altX = pixels.length;
        for (int x = 0; x < pixels.length; x++)
        {
            altX--;
            for (int y = 0; y < pixels[x].length; y++)
            {
                colors[x][y] = pixels[altX][y].getColor();
            }
        }
        for (int x = 0; x < pixels.length; x++)
        {
            for (int y = 0; y < pixels[x].length; y++)
            {
                pixels[x][y].setColor(colors[x][y]);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////

    // REQUIRED FOR 90-POINTS
    public void mirrorVertical()
    {
        Pixel[][] pixels = getPixels2D();
        Color[][] colors = new Color[pixels.length][pixels[0].length];
        int middleY = pixels[0].length / 2;
        
        for (int x = 0; x < pixels.length; x++)
        {
            
            int altY = middleY;
            for (int y = 0; y < middleY; y++)
            {
                altY--;
                colors[x][y] = pixels[x][altY].getColor();
            }
        }
        for (int x = 0; x < pixels.length; x++)
        {
            for (int y = 0; y < middleY; y++)
            {
                pixels[x][y+middleY].setColor(colors[x][y]);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////

    // REQUIRED FOR 90-POINTS
    public void mirrorHorizontal()
    {
        Pixel[][] pixels = getPixels2D();
        Color[][] colors = new Color[pixels.length][pixels[0].length];
        int middleX = pixels.length / 2;
        int altX = middleX;
        for (int x = 0; x < middleX; x++)
        {
            altX--;
            for (int y = 0; y < pixels[x].length; y++)
            {
                colors[x][y] = pixels[altX][y].getColor();
            }
        }
        for (int x = 0; x < middleX; x++)
        {
            for (int y = 0; y < pixels[x].length; y++)
            {
                pixels[x+middleX][y].setColor(colors[x][y]);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////      

    // REQUIRED FOR 90-POINTS
    public void mirrorDiagonal()
    {
        Pixel[][] pixels = getPixels2D();

        int smallestDim = Math.min(pixels.length, pixels[0].length);
        Color[][] colors = new Color[smallestDim][smallestDim];
        System.out.println(smallestDim);
        for(int i = 0; i < smallestDim; i++)
        {
            for (int x = 0; x < i; x++)
            {
                colors[i][x] = pixels[i][x].getColor();
            }
            for (int x = i+1; x < smallestDim; x++)
            {
                colors[i][x] = Color.red;
            }
        }
        for (int i = 0; i < smallestDim; i++)
        {
            for (int y = 0; y < i; y++)
            {
                pixels[y][i].setColor(colors[i][y]);
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////

    // REQUIRED FOR 100-POINTS
    public void mirrorTemple()
    {
        Pixel[][] pixels = getPixels2D();
        int repairPoint = 100;
        int middleX = pixels[0].length / 2;

        for (int x = 0; x < middleX; x++)
        {
            for (int y = 0; y < repairPoint; y++)
            {
                pixels[y][pixels[0].length - 1 - x]
                    .setColor(pixels[y][x].getColor());
            }
        }

    }

}