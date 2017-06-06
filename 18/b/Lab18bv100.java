// Lab18bv100.java
// Zion Nimchuk
// April 22, 2017
// Merging 2 Lists Into 1


import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Arrays;

import jdk.nashorn.internal.objects.NativeDataView;

public class Lab18bv100
{
	public static void main(String[] args)
	{
		int[] jsaList1 = {101, 105, 115, 125, 145, 165, 175, 185, 195, 225, 235, 275, 305, 315, 325, 335, 345, 355, 375, 385};
		int[] jsaList2 = {110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230, 240, 250, 270, 280, 320, 350, 400};

		Array list1 = new Array(jsaList1,"List #1");
		Array list2 = new Array(jsaList2,"List #2");
		Array list3 = new Array("Merged List");

		list3.merge(list1,list2);

		list1.display();
		list2.display();
		list3.display();

	}

}


class Array
{
	private ArrayList<Integer> list;
	private int size;
	private String listName;

	public Array(String ln)
	{
		list = new ArrayList<Integer>();
		size = 0;
		listName = ln;
	}
	public int size()
	{
		return list.size();
	}
	public int get(int index)
	{
		return list.get(index);
	}

	public Array(int[] jsArray, String ln)
	{
		list = new ArrayList<Integer>();
		size = jsArray.length;
		listName = ln;
		for (int j = 0; j < size; j++)
			list.add( new Integer( jsArray[j] ));
	}

	public void display()
	{
		System.out.println("\n" + listName + ":\n");
		System.out.println(list + "\n");
	}

	public void merge(Array array1, Array array2)
	{
		int arr1Index = 0;
		int arr2Index = 0;
		int i = 0;
		
		while (arr1Index <= array1.size()-1 && arr2Index <= array2.size()-1)
		{
			if (array1.get(arr1Index) <= array2.get(arr2Index))
            {
				list.add(array1.get(arr1Index));
                arr1Index++;
            }
            else
            {
				list.add(array2.get(arr2Index));
                arr2Index++;
            }
            i++;
		}
		while(arr1Index <= array1.size()-1)
        {
			list.add(i, array1.get(arr1Index));
            i++;
            arr1Index++;
        }

		while(arr2Index <= array2.size()-1)
        {
			list.add(i, array2.get(arr2Index));
            i++;
            arr2Index++;
        }
	}
}