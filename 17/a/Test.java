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
		return n + sum(n-1);
	}
    
	// returns n factorial
	public static int fact(int n)
	{
		if ( n <= 0)
			return n;
		return n * sum(n-1);
	}
   
	// returns the nth Fibonacci number
	public static int fibo(int n)
	{
		return 0;
	}
   
	// returns the gcf of n1 and n2
	public static int gcf(int n1, int n2)
	{
		return 0;
	}		
   
	// returns n1 raised to the n2 power
	public static int pow(int n1, int n2)
	{
		return 0;
	}
   
}