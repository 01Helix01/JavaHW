import java.util.*;
import java.lang.*;
import java.io.*;
class ProblemSolution{
	int num;
	int pal;
	String isit;
	
    public String isPalindrome(){
    	// Get num
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        
        // Check if num is three digits
        if (num < 100 || num > 999)
        {
        	// Your num was not a three digit integer
        	pal = -1;
        }
        
        // Check if num is palindrome
        else
        {
        	if (num / 100 == num % 10)
        	{
        		// Num is a palindrome
        		pal = 1;
        	}
        	else
        	{
        		// Num is not a palindrome
        		pal = 0;
        	}
        }
        
        switch (pal) {
        case -1 :
        	isit = "Invalid";
        	break;
        case 0 :
        	isit = "Not palindrome";
        	break;
        case 1 :
        	isit = "Palindrome";
        	break;
        }
    
        return isit;
	}
}

