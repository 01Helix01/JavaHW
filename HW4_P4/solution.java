import java.util.*;
import java.lang.*;
import java.io.*;
//write your analysis here
/* Analysis:
 * Use a recursive method to find all permutations of a string
 * Use the second function to move a character from str2 to str1
 */

/* Design:
 * For each permutation, recursively call displayPermution until s2's length = 0
 * In order to shuffle strings around, use the two strings to break it down bit by bit until s2 is fully shuffled into s1
 * At that point finish that branch of recursion and go on to the next
 * Continue until the original s2 has been fully broken down
 */

//write your design here
class AllPermutation{
    public static void displayPermuation(String s) { 
    	displayPermuation("", s);
    }
    
    // Shuffle around the components of our string
    
    public static void displayPermuation(String s1, String s2) {
        // Tail
    	if (s2.length() == 0)
    	{
    		System.out.println(s1);
    	}
    	else
    	{
    		for (int i = 0; i < s2.length(); i++)
    		{
    			// debugging code
    			//System.out.println(s1 + "+" + s2.charAt(i));
    			//System.out.println(s2.substring(0, i) + "+" + s2.substring(i + 1));
    			
    			displayPermuation(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i + 1));
    		}
    	}
    }
}

//Do not change the Driver class
class DriverMain{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
        AllPermutation.displayPermuation(input.nextLine());
	}
}
