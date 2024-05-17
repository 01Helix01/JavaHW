import java.util.*;
import java.lang.*;
import java.io.*;

/* Anaylsis:
 * Will need to display the reverse of a given string
 * Must do so recursively
 */

/* Design:
 * Use tail recursion to return the reverse
 * the tail call being when a string with length 0 is called
 * take substring of str from 1 though end of the string plus the first char,
 * do this enough and our original string will become reversed
 * when the str variable is empty, the string has been reversed
 */

class ReverseString{
     public static String reverse(String str){
        //write your code here
    	if(str.length() == 0)
    	{
    		return str;
    	}
    	
    	return reverse(str.substring(1)) + str.charAt(0);
     }
}
     
class DriverMain{
	public static void main(String Args[]){
        Scanner input = new Scanner(System.in);
        System.out.print(ReverseString.reverse(input.nextLine()));
	}
}
