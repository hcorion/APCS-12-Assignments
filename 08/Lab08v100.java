// Lab08v100.java
// This is the 100 point version.
// Zion Nimchuk
// January 13, 2017
// APCS, Chris Robinson
// This program takes text input from the user and outputs whether it is a Palindrome or almost a Palindrome

import java.util.Scanner;

public class Lab08v100
{
	public static void main(String args[])
	{
		System.out.println("\nLab08v100\n");
		Scanner input = new Scanner(System.in);
		boolean notFinished = false;
		do 
		{
			System.out.print("Enter a string  ===>>  ");
			String str = input.nextLine();
			System.out.println();
			System.out.println("Entered String:     " + str);

			boolean isPal = Palindrome.isPal(str);
			System.out.println("Palindrome:         " + isPal);

			if (isPal)
				System.out.println("Almost Palindrome:  " + false);
			else
				System.out.println("Almost Palindrome:  " + Palindrome.almostPal(str));
			
			System.out.print("Do you wish to repeat this program [Y/N]?  ===>>  ");
			String repeat = input.nextLine();
			notFinished = repeat.equalsIgnoreCase("y");
			System.out.println();
		} 
		while (notFinished);
	}
}

class Palindrome 
{

	/*
	 * Precondition:  s is an arbitrary String.
	 * Postcondition: The value of true is returned if s is a Palindrome, false otherwise.
	* Note:          >>>>> This method is required for both the 80 point and the 100 point versions  <<<<<
	 */
	public static boolean isPal(String s) 
	{
		//The amount of characters that we need to check against each other.
		double halfway = Math.floor(s.length() / 2.0f);

		for (int i = 0; i < halfway; i++) 
		{
			String front = s.substring(i, i + 1);
			String back = s.substring(s.length() - i - 1, s.length() - i);
			
			if (!front.equalsIgnoreCase(back))
				return false;
		}

		return true;
	}

	/*
	 * Precondition:  s is a String of one character.
	 * Postcondition: The value of true is returned if s is a letter and false ot
	 herwise.
	
	* Note:          >>>>> This method is only completed for the 100 point version  <<<<<
	 */
	private static boolean isLetter(String letter) 
	{
		// I could make the code a lot cleaner if we had covered arrays yet.
		if (letter.equals("!") || letter.equals(" ") || letter.equals(",") || letter.equals(".") || letter.equals("-") ||
			letter.equals("_") || letter.equals("\"") || letter.equals("?") || letter.equals("'") || letter.equals(";"))
			{
			return false;
			}
		return true;
	}

	/*
	 * Precondition:  s is an arbitrary String.
	 * Postcondition: All non-letter characters are removed from s, and this "purged" String is returned.
	* Note:          >>>>> This method is only completed for the 100 point version  <<<<<
	 */
	private static String purge(String s)
	{
		//Probably could use some sort of regex, but we haven't covered that, so here is my implementation.
		for (int i = 0; i < s.length(); i++)
		{
			if (!isLetter(s.substring(i, i + 1)))
			{
				s = s.substring(0, i) + s.substring(i + 1, s.length());
				i -= 1;
			}
		}
		return s;

	}

	/*
	 * Precondition:  s is an arbitrary String.
	 * Postcondition: After purging all non-letter characters from s,
	 *                the value of true is returned if the resulting String is a Palindrome, false otherwise.
	* Note:          >>>>> This method is only completed for the 100 point version  <<<<<
	 */
	public static boolean almostPal(String s) 
	{
		return isPal(purge(s));
	}

}
