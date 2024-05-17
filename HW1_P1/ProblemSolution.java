import java.util.*;
import java.lang.*;
import java.io.*;

/* Write your Analysis (What is the problem):
In this program, we need to first get a three digit integer. After determining that
the integer is in fact three digits, we will then add each digit in the integer then
return the sum. If the integer is not three digits, the program will return -1.
*/

/* Write your Design (How to solve the problem):
*Read the input as an integer
*Before we add each digit, first make sure that the input is three digits by ensuring it falls within the range 100 < num < 1000 
*If not, return -1 for the sum
* If the number is three digits: extract the digit in each place, then remove extracted digit
* After you get all three digits, get the sum and return that
*/

class ProblemSolution{
	int num;
	int sum = 0;
	
    public int sum(){
        // Read number
        Scanner input = new Scanner(System.in);
        
        num = input.nextInt();
       
        // Check if num is three digits
        if (num < 100 || num > 999)
        {
        	// Your num was not a three digit integer
        	sum = -1;
        }
        
        // If num is indeed three digits, extract each integer and add
        else
        {
        	int first = num % 10;
        	num /= 10;
        	int second = num % 10;
        	num /= 10;
        	int third = num % 10;
        	
        	sum = first + second + third;
        }
        
        return sum;
	}
}