class Test
{
	// displays consecutive integers from k to n
	public static void countUp(int k, int n)
	{
		System.out.print(k + " ");
		if (k < n)
			countUp(++k, n);
	}
   
	// displays consecutive integers backwards from k to n
	public static void countDown(int k, int n)
	{
		System.out.print(n + " ");
		if (k < n)
			countDown(k, --n);
	}
   
	// returns the sum of all integers 1 + 2 + .... + n-1 + n
	public static int sum(int n)
	{
		if ( n <= 0)
			return n;
		return n + sum(--n);
	}
    
	// returns n factorial
	public static int fact(int n)
	{
		if ( n <= 1)
			return n;
		return n * fact(--n);
	}
   
	// returns the nth Fibonacci number
	public static int fibo(int n)
	{
		if ( n <= 2)
			return 1;
		return fibo(n-1) + fibo(n-2);
	}
   
	// returns the gcf of n1 and n2
	public static int gcf(int n1, int n2)
	{
		/*
		 * Explanation of algorithm
		 * 1. Divide n1 / n2, does it divide evenly? If it does then n2 is the answer.
		 * 2. If it doesn't then call gcf using n2 as n1 and use the remainder as n1.
		 * 3. Repeat.
		 */
		int remainder = n1 % n2;
		if (remainder == 0)
			return n2;
		return gcf(n2, remainder);
	}		
   
	// returns n1 raised to the n2 power
	public static int pow(int n1, int n2)
	{
		if (n2 == 0)
		{
			return 1;
		}
		return n1 * pow(n1, --n2);
	}
   
}