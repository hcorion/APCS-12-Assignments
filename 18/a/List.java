import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;


class List
{
	private Person student[];	// stores array elements
	private int capacity;		// actual array capacity
	private int size;			// number of elements in the array

	public List(int c)
	{
		capacity = c;
		size = 0;
		student = new Person[capacity];
		
	}

	public void getList() throws IOException
	{
		FileReader inFile = new FileReader("students.dat");
		BufferedReader inStream = new BufferedReader(inFile);
		String s1,s2,s3,s4;
		int age, id;
		double gpa;
		int index = 0;
		while( ((s1 = inStream.readLine()) != null) &&
			   ((s2 = inStream.readLine()) != null) &&
			   ((s3 = inStream.readLine()) != null) &&
			   ((s4 = inStream.readLine()) != null) )
		{
			String name = s1;
			id = Integer.parseInt(s2);
			age = Integer.parseInt(s3);
			gpa = Double.parseDouble(s4);

			student[index] = new Person(name,id,age,gpa);
			index++;
		}
		inStream.close();
		size = index;
	}

	private String spaces(String name)
    {
    	int tab = 24 - name.length();
    	String temp = "";
    	for (int j = 1; j <= tab; j++)
    	    temp += " ";
    	return temp;
    }

	public void display(String listInfo)
	{
		DecimalFormat output = new DecimalFormat("0.000");
		System.out.println("\nDISPLAYING "+ listInfo);
		System.out.println("\nStudent ID#     Student Name            Age         GPA");
		System.out.println("============================================================");

		for (int k = 0; k < size; k++)
			System.out.println(
                student[k].id + "          " + 
                student[k].name + spaces(student[k].name) + 
                student[k].age + "          " + 
                output.format(student[k].gpa));
	}

	public void pause()
	{
		Scanner input = new Scanner(System.in);
		String dummy;
		System.out.println("\nPress <Enter> to continue.");
		dummy = input.nextLine();
	}


	public void displayStudent(int index)
	{
		System.out.println("Student Record for ID# " + student[index].id + "\n");
		System.out.println("Name: " + student[index].name);
		System.out.println("Age: " + student[index].age);
		System.out.println("GPA: " + student[index].gpa);
		System.out.println("\n\n");
	}

	private void swap(int x, int y)
	{

	}

	public void gpaSort()
	{
        student = MergeSortPerson.MergeSortGPA(student, size);
	}

	public void ageSort()
	{
		student = MergeSortPerson.MergeSortAge(student, size);
	}

	public void idSort()
	{
		student = MergeSortPerson.MergeSortID(student, size);
	}

	public int search(int studentID)
	{
		// WARNING! This method assumes the array was pre-sorted by ID.
		// This method also uses binary search.
		int high = size;
		int low = 0;
		while (high >= low)
		{
			int middle = (low + high) / 2;
			if (student[middle].id < studentID)
			{
				low = middle + 1;
				
			}
			else if (student[middle].id > studentID)
			{
				high = middle - 1;
			}
			else
			{
				// We found it!
				return middle;
			}
		}
		return -1;
	}

	public void delete(int index)
	{
		// Precondition:  "index" stores the index of a student object that exists in the "student" array.
		// Postcondition: The student object at index "index" is removed from the "student" array.
		//                All other objects in the "student" array are unaffected.
		for (int i = index+1; i < size; i++)
		{
			student[i-1] = student[i];
		}
		size--;
		
	}
}