import java.util.*;

class Driver{
	
	// Main method - only used for testing
	public static void main(String[] args)
	{
    	Scanner in = new Scanner(System.in);

		String test1 = in.nextLine();
		String test2 = in.nextLine();
		
		Boolean results1 = isPal(test1);
		Boolean results2 = isPal(test2);
		
		System.out.println(results1);
		System.out.println(results2);
	}
	
	// get high and low then call isPal
	static boolean isPal(String s){
		int high = s.length() - 1;
		int low = 0;
		return isPal(s, low, high);
	}

	// first, make sure we haven't gone through the whole word, then make sure they are the same
	// after confirming they are the same, add one to low and subtract one from the high, then repeat
	private static boolean isPal(String s, int low, int high){
		if(high <= low) return true;
		else if(s.charAt(low) != s.charAt(high)) return false;
		else
		{
			return isPal(s, low+1, high-1);
		}
	}

}