import java.util.*;
import java.lang.*;
import java.io.*;
class HW2_P2{
    public void printAlphabets(char ch){

		// make an array for the alphabet
    	char[] alphabetLower = 
    	{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    	char[] alphabetUpper =
    	{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    	
    	// go though the whole alphabet comparing the two arrays to the input char
    	for (int i = 1; i < 26; i++)
    	{
    		// ch was found to be upper case
	    	if (ch == alphabetUpper[i])
	    	{
	    		for (int k = 0; k < i; k++)
	        	{
	        		System.out.print(alphabetUpper[k] + " ");
	        	}
	    		System.out.print(ch);
	    		
	    		break;
	    	}
	    	
	    	// char was found to be lower case
	    	else if (ch == alphabetLower[i])
	    	{
	    		for (int k = 0; k < i; k++)
	        	{
	        		System.out.print(alphabetLower[k] + " ");
	        	}
	    		System.out.print(ch);
	    		
	    		break;
	    	}
    	}
    	
    	return;
	}
}
class DriverMain{
	public static void main(String args[]) throws java.lang.Exception {
        char inputChar = (char) System.in.read();
		HW2_P2 hw2P2  = new HW2_P2();
        hw2P2.printAlphabets(inputChar);

	}
}
