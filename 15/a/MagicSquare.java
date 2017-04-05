import java.text.DecimalFormat;

class MagicSquare
{
	private int size;
    private int middle;
	private int[][] magic;
	private static DecimalFormat output  = new DecimalFormat("000");;

	public MagicSquare(int s)
	{
		size = s;
		magic = new int[size][size];
	}

	public void computeMagicSquare()
	{
        int middle = Math.round((float)size / 2.0f);
        int curX = middle - 1;
        int curY = 0;
        int curNum = 1;
        int maxSize = size - 1;
        for (int i = 0; i < (size) * (size); i++)
        {
            magic[curY][curX] = curNum;
            curNum++;
            if (curY <= 0)
            {
                curY = maxSize;
            }
            else
            {
                curY--;
            }
            if (curX >= maxSize)
            {
                curX = 0;
            }
            else
            {
                curX++;
            }
            if (magic[curY][curX] != 0)
            {
                curX -= 1;
                curY += 2;
                if (curX < 0)
                {
                    curX = maxSize;
                }
                if (curY > maxSize)
                {
                    curY = curY - (size);
                }
            }
        }

	}

	public void displayMagicSquare()
	{
		System.out.println();
		System.out.println(size + "x" + size + " Magic Square");
		System.out.println("==================");
		System.out.println();
        for (int[] y: magic)
        {
            for (int x: y)
            {
                System.out.print(output.format(x) + " ");
            }
            System.out.print("\n");
        }
	}

	public void checkRows()
	{
		System.out.println();
		System.out.println("Checking Rows");
		System.out.println("=============");
		System.out.println();

        for (int[] y: magic)
        {
            String additions = "";
            int sum = 0;
            for (int x: y)
            {
                additions += output.format(x) + "+";
                sum += x;
            }
            // Just a easy way to remove the trailing '+' sign
            additions = additions.substring(0, additions.length()-1);

            System.out.print(additions + " = " + sum + "\n");
        }
	}

	public void checkColumns()
	{
		System.out.println();
		System.out.println("Checking Columns");
		System.out.println("================");
		System.out.println();
        for (int x = 0; x < size; x++)
        {
            String additions = "";
            int sum = 0;
            for (int y = 0; y < size; y++)
            {
                additions += output.format(magic[y][x]) + "+";
                sum += magic[y][x];
            }
            // Just a easy way to remove the trailing '+' sign
            additions = additions.substring(0, additions.length()-1);

            System.out.print(additions + " = " + sum + "\n");
        }
   }

	public void checkDiagonals()
	{
		System.out.println();
		System.out.println("Checking Diagonals");
		System.out.println("==================");
		System.out.println();

        System.out.println(diagonalLeftToRight());
        System.out.println(diagonalRightToLeft());
	}
    private String diagonalLeftToRight()
    {
        // Going from top left to bottom right.
        String result = "";
        int sum = 0;
        int y = 0;
        for (int x = 0; x < magic.length; x++)
        {
            result += output.format(magic[y][x]) + "+";
            sum += magic[y][x];
            y++;
        }
        // Just a easy way to remove the trailing '+' sign
        result = result.substring(0, result.length()-1);
        return result + " = " + sum;

    }

    private String diagonalRightToLeft()
    {
        // Going from top right to bottom left.
        String result = "";
        int sum = 0;
        int y = 0;
        for (int x = magic.length-1; x >= 0; x--)
        {
            result += output.format(magic[y][x]) + "+";
            sum += magic[y][x];
            y++;
        }
        // Just a easy way to remove the trailing '+' sign
        result = result.substring(0, result.length()-1);

        return result + " = " + sum;
    }
}