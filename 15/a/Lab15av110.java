// Lab15av110.java
// This is the 110 point version
// Zion Nimchuk
// March 29, 2017
// This program uses Leon Schram's Magic Square algorithm to generate and test magic squares.



import java.util.Scanner;
import java.text.DecimalFormat;

public class Lab15av110
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

      System.out.print("Enter the odd# size of the Magic Square -->  ");
      int size = input.nextInt();

      MagicSquare magic = new MagicSquare(size);

      magic.computeMagicSquare();
      magic.displayMagicSquare();
      magic.checkRows();          // for 100 & 110 Point Version Only
      magic.checkColumns();		 // for 100 & 110 Point Version Only
      magic.checkDiagonals();	 	 // for 100 & 110 Point Version Only
	}
}