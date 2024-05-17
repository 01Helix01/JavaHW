import java.util.*;
import java.lang.*;
import java.io.*;
class ProblemSolution{
	boolean val = true;
	String in;
	char c;
	boolean ssn[] = {true,true,true,false,true,true,false,true,true,true,true};
	
    public boolean isValid(){
        // Read the SSN
        Scanner input = new Scanner(System.in);
        
        in = input.nextLine();
        
        System.out.println(in);
        
        // Make sure string is 11 char long
        int length = in.length();
        if (length != 11)
        	val = false;
        
        // Compare each char of string to snn array
        int i = 0;
        while(i < 10 && val == true)
        {
        	
        	c = in.charAt(i);
        	
        	if(ssn[i] == Character.isDigit(c))
        		val = true;
        	else
        		val = false;
        		
        	i++;
        } 
        
        return val;
	}
}

