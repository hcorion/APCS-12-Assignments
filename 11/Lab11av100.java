// Lab11ast.java
// The "Sieve of Eratosthenes" Program
// 2017-01-24
// THIS IS THE IMPROVED STUDENT STARTING FILE WITH COMMENTS AND HINTS. CR

import java.util.Scanner;

public class Lab11av100
{
	public static void main(String[] args)
	{
		System.out.println("\nLab11a\n");
		final int numOfPrimeNumbers = 100;
		boolean primes[] = new boolean[numOfPrimeNumbers];   // Array to hold primes, true or false.
                                             // The index of the array represents each number. 
                                             // The value stored at each index is true or false, prime or not prime.
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
		for (int num = 3; num < primes.length; num+=1 )
		{
			for (int x = 2; x < num; x++ )
			{
				if ( !isPrime(num) )
				{
					primes[num] = false;
				}
			}
		}
      // See the word document for Steps 1-4.
      // Step 1: A for-loop to set all of numbers in the array from 2 to 100 to true,
      // whether prime or not.
      // Step 2: A for-loop to run through all of the numbers in the array.
            // A for-loop inside the above for-loop to check each number, starting with 2.
            // If it is prime, change all of its multiples to not prime.
      // Step 3-4: Process repeats until MAX is reached.
   }
   public static boolean isPrime(int n) {
    //check if n is a multiple of 2
    if (n%2==0) return false;
    //if not, then just check the odds
    for(int i=3;i*i<=n;i+=2) {
        if(n%i==0)
            return false;
    }
    return true;
}
	public static void displayPrimes(boolean[] primes)
	{
		final int[] goodprimes = new int[] {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
		for (int i = 0; i < primes.length; i++)
		{
			if (contains(goodprimes, i))
			{
				if (primes[i] == false)
				{
					System.out.print("Error! Invalid prime: " + goodprimes[i] + " should be declared true but isn't");
					System.exit(1);
				}
			}
			else if (primes[i] == true)
			{
				System.out.print("Error! Invalid prime: " + goodprimes[i] + " should be declared false but isn't");
				System.exit(1);
			}
		}
		System.out.println("\n\nPRIMES BETWEEN 1 AND "+ primes.length);
		System.out.println();
		for (int i = 0; i < primes.length; i++)
		{
			System.out.println(primes[i] + "\t" + i);
		}
		
	}
	public static boolean contains(final int[] array, final int v) {
    if (v == 0) {
        for (final int e : array)
            if (e == 0)
                return true;
    } else {
        for (final int e : array)
            if (e == v)
                return true;
    }

    return false;
}
}



