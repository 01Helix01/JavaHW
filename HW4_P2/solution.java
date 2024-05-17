import java.util.*;
import java.lang.*;
import java.io.*;

/* Analysis: 
 * Must convert decimal to binary
 * Then turn that binary number to a string (?)
 * Must convert recursively
 */

/* Design:
 * If value less than zero, return an empty string
 * Use tail recursion with 0 as the tail which returns 0
 * To convert decimal to binary:
 * Divide by 2
 * Get int quotient for the next iteration
 * get remainder for binary digit
 * Repeat until quotient = 0
 */

class DecimalToBinary{
    public static String decimalToBinary(int value){
        //Write your code here
    	if (value < 0)
    		return "";
    	
    	if (value == 0)
    		return "0";
    	
    	int v = (value % 2 + 10 * Integer.parseInt(decimalToBinary(value/2)));
    	return Integer.toString(v);
		
	}
}

class DriverMain{
	public static void main(String args[]){
        Scanner input = new Scanner(System.in);
		System.out.print(DecimalToBinary.decimalToBinary(input.nextInt()));
	}
}
