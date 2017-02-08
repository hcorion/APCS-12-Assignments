// Lab09bv100.java
// This is the 100 point version.
// Zion Nimchuk
// February 6, 2017
// This program receives the input of 2 numerators and 2 denominators and then multiplies, divides, adds and subtracts them.


import java.util.Scanner;


public class Lab09bv100
{
	private static int num1, den1;   // numerator and denominator of the 1st rational number
	private static int num2, den2;   // numerator and denominator of the 2nd rational number

	public static void main (String[] args)
	{
		enterData();

		Rational r1 = new Rational(num1,den1);
		Rational r2 = new Rational(num2,den2);
		Rational r3 = new Rational();

		r3.multiply(r1,r2);
		System.out.println("\n\n" + r1.getOriginal() + " * " + r2.getOriginal() + "  =  " + r3.getReduced());
		r3.divide(r1,r2);
		System.out.println("\n" + r1.getOriginal() + " / " + r2.getOriginal() + "  =  " + r3.getReduced());

		r3.add(r1,r2);
		System.out.println("\n" + r1.getOriginal() + " + " + r2.getOriginal() + "  =  " + r3.getReduced());
		r3.subtract(r1,r2);
		System.out.println("\n" + r1.getOriginal() + " - " + r2.getOriginal() + "  =  " + r3.getReduced());
		System.out.println();
	}

	public static void enterData()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter the 1st numerator ----> ");
		num1 = input.nextInt();
		System.out.print("\nEnter the 1st denominator --> ");
		den1 = input.nextInt();
		System.out.print("\nEnter the 2nd numerator ----> ");
		num2 = input.nextInt();
		System.out.print("\nEnter the 2nd denominator --> ");
		den2 = input.nextInt();
	}
}


class Rational
{
	private int firstNum;	   // entered numerator
	private int firstDen;	   // entered denominator
	private int reducedNum;		// reduced numerator
	private int reducedDen;		// reduced denominator
	private int gcf;           // greatest common factor

	public Rational(int num, int den)
	{
		firstNum = num;
		firstDen = den;
	}

	public Rational()
	{

	}

	private int getNum()
	{
		return firstNum;
	}

	private int getDen()
	{
		return firstDen;
	}	
	private void getGCF(int n1,int n2)
	{
		int rem = 0;
		do
		{
			rem = n1 % n2;
			if (rem == 0)
				gcf = n2;
			else
			{
				n1 = n2;
				n2 = rem;
			}
		}
		while (rem != 0);
	}

	// Returns the least common multiple.
	private int getLCM(int a, int b)
	{
		getGCF(a, b);
    	return a * (b / gcf);
	}

	public String getOriginal()
	{
		return firstNum + " / " + firstDen;
	}
	public String getReduced()
	{
		return firstNum / gcf + " / " + firstDen / gcf;
	}
	public void multiply(Rational r1, Rational r2)
	{
		firstNum = r1.getNum() * r2.getNum();
		firstDen = r1.getDen() * r2.getDen();
		getGCF(firstNum, firstDen);
	}
	public void divide(Rational r1, Rational r2)
	{
		firstNum = r1.getNum() * r2.getDen();
		firstDen = r1.getDen() * r2.getNum();
		getGCF(firstNum, firstDen);
	}
	public void add(Rational r1, Rational r2)
	{
		// Getting the lowest common multiple
		firstDen = getLCM(r1.getDen(), r2.getDen());

		// Working out the new numerators
		int num1 = firstDen / r1.getDen() * r1.getNum();
		int num2 = firstDen / r2.getDen() * r2.getNum();

		firstNum = num1 + num2;
		getGCF(firstNum, firstDen);
	}

	public void subtract(Rational r1, Rational r2)
	{
		// Getting the lowest common multiple
		firstDen = getLCM(r1.getDen(), r2.getDen());

		// Working out the new numerators
		int num1 = firstDen / r1.getDen() * r1.getNum();
		int num2 = firstDen / r2.getDen() * r2.getNum();

		firstNum = num1 - num2;
		getGCF(firstNum, firstDen);
	}


}