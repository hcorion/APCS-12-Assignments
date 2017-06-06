import java.util.Arrays;

public class MergeSort
{
    private static int[] array;
    private static int[] tempArray;

    public static int[] MergeSort( int[] newArray)
    {
        array = newArray;
        tempArray = new int[array.length];
        mergeSort(0, array.length-1);
        return array;

    }

    public static int[] MergeSortGPA( int[] newArray)
    {
        array = newArray;
        tempArray = new int[array.length];
        mergeSort(0, array.length-1);
        return array;

    }


    private static void mergeSort( int first, int last)
	{
		if (first < last)
		{
			int middle  = (first + last) / 2; 
			mergeSort(first, middle);
			mergeSort(middle + 1, last);
			merge(first, middle, last);
		}
	}
	private static void merge(int first, int middle, int last)
	{
		int bottomHalf = first;
		int topHalf = middle+1;
		int i = first;
		while (bottomHalf <= middle && topHalf <= last)
		{
			if (array[bottomHalf] <= array[topHalf])
            {
                tempArray[i] = array[bottomHalf];
                bottomHalf++;
            }
            else
            {
                tempArray[i] = array[topHalf];
                topHalf++;
            }
            i++;
		}
        while(bottomHalf <= middle)
        {
            tempArray[i] = array[bottomHalf];
            i++;
            bottomHalf++;
        }
        while(topHalf <= last)
        {
            tempArray[i] = array[topHalf];
            i++;
            topHalf++;
        }
        for (int h = first; h <= last; h++)
            array[h] = tempArray[h];
	}

    /*private static void display( int[] array )
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
    }*/
}