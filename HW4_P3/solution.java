import java.util.*;
import java.lang.*;
import java.io.*;

/* Analysis:
 * Use a recursive method in order to get a Decimal from a Binary
 * If number given was not Binary, do not try to convert it the same way we would a binary
 */

/* Design:
 * If value not Binary, use Integer.parseInt to convert it instead of our recursive method
 * Use recursion until the whole String has been converted
 * How to convert BInary to Decimal:
 * For each number d in the series d_n-1
 * decimal = (d0 * 2^1) + (d1 * 2^2) + ... (dn * 2^n)
 * we will recursively find each (dn * 2^n) and add it to our static total
 */

class BinaryToDecimal{

  // You can add more methods
	public static Boolean isBinary(String str){
		// make sure all numbers are 1 or 0
		for (int i = 0; i < str.length(); i++)
		{
			char b = str.charAt(i);
			if (!(b == '1' || b == '0'))
				return false;
		}
		
		// all numbers were either 1 or 0
		return true;
	}
    
    public static int binaryToDecimal(String binaryString){
    	// position in the string
    	int index = 0;
    	// our total number that will be returned at the end
		int decimal = 0;
		// power we will multiply by
    	int value = binaryString.length() - 1;
    	
    	// if number isn't binary, convert from String to int
    	if(!(isBinary(binaryString)))
    	{
    		return Integer.parseInt(binaryString);
    	}
		
    	// start finding decimal recursively 
		return binaryToDecimal(binaryString, index, decimal, value);
	}
    
    public static int binaryToDecimal(String binaryString, int index, int decimal, int value){
    	
    	// add number at index * 2 to the power of it's position in the string to our total decimal
    	decimal += (Integer.parseInt(binaryString.charAt(index) + "") * Math.pow(2, value));
    	
    	// see if we've reached the end of the string
    	if (value == 0)
    		return decimal;
    	else
    		return binaryToDecimal(binaryString, index + 1, decimal, value - 1);
	}
}

class DriverMain{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
        System.out.print(BinaryToDecimal.binaryToDecimal(input.nextLine()));
	}
}
