import java.util.ArrayList;
import java.util.Random;
public class Wave
{
    public static ArrayList<GameObject> getSquareWave(int width, int height, int level)
    {
        ArrayList<GameObject> result = new ArrayList<GameObject>();
        final int gridNumber = 6;
        int b = width/gridNumber;
        for (int i = 0; i < gridNumber+1; i++)
        {
            result.add(new Bullet(b*i, 0, level, 0, 2));
        }
        int x = height/(gridNumber-2);
        for (int i = 0; i < gridNumber+1; i++)
        {
            result.add(new Bullet(0, x*i, level, 2, 0));
        }
        return result;
    }

    public static ArrayList<GameObject> getDiagonalWave(int width, int height, int level)
    {
        ArrayList<GameObject> result = new ArrayList<GameObject>();
        final int numberOf = 10;
        for (int i = 0; i < numberOf; i++)
        {
            result.add(new Bullet(-numberOf * (i*20), -numberOf * (i*20), level, 3, 3));
        }
        return result;
    }

    public static ArrayList<GameObject> getWeirdDiagonalWave(Random rand, int width, int height, int level)
    {
        ArrayList<GameObject> result = new ArrayList<GameObject>();
        final int numberOf = 10;
        for (int i = 0; i < numberOf; i++)
        {
            result.add(new Bullet(-numberOf * (i*20), -numberOf * (i*20), level, rand.nextInt(4)+1, 3));
        }
        return result;
    }

    public static ArrayList<GameObject> getSwirlWave(int width, int height, int level)
    {
        ArrayList<GameObject> result = new ArrayList<GameObject>();
        final int numberOf = 10;
        for (int i = 0; i < numberOf; i++)
        {
            result.add(new Bullet(-numberOf * (i*20), -numberOf * (i*20), level, i+1, 3));
        }
        return result;
    }
    public static ArrayList<GameObject> getBarrageWave(Random rand, int width, int height, int level)
    {
        ArrayList<GameObject> result = new ArrayList<GameObject>();
        final int numberOf = 15;
        for (int i = 0; i < numberOf; i++)
        {
            result.add(new Bullet(0, rand.nextInt(width/2)-50, level, rand.nextInt(4)+1, rand.nextInt(4)+1));
        }
        return result;
    }
    
    public static ArrayList<GameObject> getRandomWave(Random rand, int width, int height, int level)
    {
        
        switch (rand.nextInt(5))
        {
            case 0:  return getSquareWave(width, height, level);
            case 1:  return getDiagonalWave(width, height, level);
            case 2:  return getWeirdDiagonalWave(rand, width, height, level);
            case 3:  return getSwirlWave(width, height, level);
            case 4:  return getBarrageWave(rand, width, height, level);
            default: return getSquareWave(width, height, level);
        }

    }
}