// Lab09av100.java
// This is the 100 point version.
// Zion Nimchuk
// January 23, 2017
// This program receives the input of two numbers by the user then divides it and returns the output and also provides the fraction simplified.

import java.util.Scanner;

public class Lab09av100
{
	private static int num, den;   // numerator and denominator of the rational number

	public static void main (String[] args)
	{
		enterData();
		Rational r = new Rational(num,den);
		r.displayData();
	}

	public static void enterData()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter the numerator ----> ");
		num = input.nextInt();
		System.out.print("\nEnter the denominator --> ");
		den = input.nextInt();
	}
}

class Rational
{
	private int firstNum;
	private int firstDen;
	private int reducedNum;
	private int reducedDem;
	private int gcf;
	public Rational(int num, int den)
	{
		firstNum = num;
		firstDen = den;
		getGCF(firstNum, firstDen);
		reducedNum = firstNum / gcf;
		reducedDem = firstDen / gcf;
	}
	public void displayData()
	{
		System.out.println();
		System.out.println(getOriginal() + " equals " + getDecimal());
		System.out.println();
		System.out.println("and reduces to " + getReduced());
	}

	private String getOriginal()
	{
		return firstNum + "/" + firstDen;
	}

	private void getGCF(int n1,int n2)
	{
		int remainder = 0;
		do
		{
			remainder = n1 % n2;
			if (remainder == 0)
				gcf = n2;
			else
			{
				n1 = n2;
				n2 = remainder;
			}
		}
		while (remainder != 0);
	}

	private double getDecimal()
	{
		return (double)firstNum / firstDen;
	}
	
	private String getReduced()
	{
		return reducedNum + "/" + reducedDem;
	}
}