import java.util.*;

class Driver{
	// FibonacciTail class
	static class FibonacciTail
	{
		public static long fib(int n)
		{
			if(n <= 1)
				return n;
			else
				return fib(n - 1) + fib(n - 2);
		}
	}
	
	// Main method - only used for testing
	public static void main(String[] args)
	{
	    Scanner in = new Scanner(System.in);
	    
	    System.out.println(FibonacciTail.fib(in.nextInt()));
	}	
}