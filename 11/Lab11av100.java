// Lab11av100.java
// This is the 100 point version
// Zion Nimchuk
// February 27, 2017
// The "Sieve of Eratosthenes" Program

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Lab11av100
{
	// The 100 point version requires the output to be 4 digits long.
	static final NumberFormat fourDigits = new DecimalFormat("0000");

	public static void main(String[] args)
	{
		System.out.println("\nLab11a\n");

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the primes upper bound  ===>>  ");
		final int numOfPrimeNumbers = input.nextInt();

		boolean primes[] = new boolean[numOfPrimeNumbers];

		computePrimes(primes);
		displayPrimes(primes);
	}

	public static void computePrimes(boolean[] primes)
	{
		System.out.println("\nCOMPUTING PRIME NUMBERS");

		primes[2] = true;

		for (int i = 3; i < primes.length; i+=2) {
            primes[i] = true;
        }

		for (int num = 3; num < primes.length; num+=2 )
		{
			for(int i=3;i*i<=num;i+=2)
			{
				if(num%i==0)
				{
					primes[num] = false;
					break;
				}
			}
		}
   }

	public static void displayPrimes(boolean[] primes)
	{
		System.out.println("\nPRIMES BETWEEN 1 AND " + primes.length);
		System.out.println();

		for (int i = 0; i < primes.length; i++)
		{
			if (primes[i] == true)
			{
				System.out.print(fourDigits.format(i) + " ");
			}
		}
	}
}



