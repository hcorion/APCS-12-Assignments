import java.util.Arrays;

public class MergeSortPerson
{
    private static int[] array;
    private static Person[] personArray;
    private static int[] tempArray;
    private static Person[] tempPersonArray;
    private static boolean descending;


    public static int[] MergeSort( int[] newArray)
    {
        array = newArray;
        tempArray = new int[array.length];
        mergeSort(0, array.length-1);
        return array;

    }

    private static void initArrays(Person[] newArray, int arraySize)
    {
        array = new int[arraySize];
        tempArray = new int[array.length];
        tempPersonArray = new Person[array.length];

        personArray = new Person[arraySize];
        for(int i = 0; i < arraySize; i++)
        {
            personArray[i] = newArray[i];
        }
    }
    public static Person[] MergeSortGPA( Person[] newArray, int arraySize)
    {
        initArrays(newArray, arraySize);
        
        for(int i = 0; i < arraySize; i++)
            array[i] = (int)(personArray[i].gpa*1000);

        // We want gpa in descending order.
        descending = true;

        mergeSort(0, array.length-1);
        return personArray;
    }

    public static Person[] MergeSortAge( Person[] newArray, int arraySize)
    {
        initArrays(newArray, arraySize);
        
        for(int i = 0; i < arraySize; i++)
            array[i] = personArray[i].age;

        // We want age in ascending order.
        descending = false;

        mergeSort(0, array.length-1);
        return personArray;
    }

    public static Person[] MergeSortID( Person[] newArray, int arraySize)
    {
        initArrays(newArray, arraySize);
        
        for(int i = 0; i < arraySize; i++)
            array[i] = personArray[i].id;

        // We want ID in ascending order.
        descending = false;

        mergeSort(0, array.length-1);
        return personArray;
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
            if (descending)
            {
                if (array[bottomHalf] >= array[topHalf])
                {
                    tempPersonArray[i] = personArray[bottomHalf];
                    tempArray[i] = array[bottomHalf];
                    bottomHalf++;
                }
                else
                {
                    tempPersonArray[i] = personArray[topHalf];
                    tempArray[i] = array[topHalf];
                    topHalf++;
                }
            }
            else
            {
                if (array[bottomHalf] <= array[topHalf])
                {
                    tempPersonArray[i] = personArray[bottomHalf];
                    tempArray[i] = array[bottomHalf];
                    bottomHalf++;
                }
                else
                {
                    tempPersonArray[i] = personArray[topHalf];
                    tempArray[i] = array[topHalf];
                    topHalf++;
                }
            }
            i++;
		}
        // Any unfilled values in the bottom half?
        while(bottomHalf <= middle)
        {
            tempPersonArray[i] = personArray[bottomHalf];
            tempArray[i] = array[bottomHalf];
            i++;
            bottomHalf++;
        }
        // Any unfilled values in the top half?
        while(topHalf <= last)
        {
            tempPersonArray[i] = personArray[topHalf];
            tempArray[i] = array[topHalf];
            i++;
            topHalf++;
        }
        for (int h = first; h <= last; h++)
        {
            array[h] = tempArray[h];
            personArray[h] = tempPersonArray[h];
        }
	}
}