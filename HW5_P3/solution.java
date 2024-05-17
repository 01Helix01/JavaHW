import java.util.*;
import java.lang.*;
import java.io.*;

/* Analysis:
 * In this program, we must convert infix to postfix
 * After doing some research, I was able to find the precedence of each operand
 * We will push each operand into our stack, compare it's precedence with the next one, and if it is lower,
 * pop the stack
 */

/* Design:
 * First, I split the string using the spaces between each character and used those to make an array
 * I followed the logic for converting infix to postfix
 * I used several System.out's in different parts of the code to follow the logic,
 * finding where several bugs were messing with my output
 * I ran into problems finding when the expressions were parenthesis,
 * so I ended up creating a couple really dumb functions
 */

class InfixToPostfix{
    public String infixToPostfix(String expression) {
        String[] expressions = expression.split(" ");
        Stack<String> operands = new Stack<String>();
    	String result = "";
    	
    	for (int i = 0; i < expressions.length; ++i)
    	{
    		String temp = expressions[i];
    		
    		// Character is an operand
    		if(!isOperand(expressions,i))
    		{
    			result += temp + " ";
    		}
    		
    		// If ( detected push to the stack
    		else if (findWhichParenthesis(temp) == 1 )
    		{
    			//System.out.println("pushing " + temp);
    			operands.push(temp);
    		}
    		
    		// If ) detected pop stack until a ( is detected
    		else if (findWhichParenthesis(temp) == 2)
    		{
    			while(!operands.empty() && findWhichParenthesis(operands.peek()) != 1)
    			{
    				//System.out.println("popping " + operands.peek());
    				result += " " + operands.pop();
    				//System.out.println("result is " + result);
    			}
    			
    			//System.out.println("popping " + operands.peek());
    			operands.pop();
    		}
    		
    		else
    		{
    			// if current operand has greater precedence push to top of stack
    			while(!operands.isEmpty() && getPrecidence(expressions, i) <= getStackPrecidence(operands.peek()))
    			{
    				result += operands.pop() + " ";
    			}
    			
    			operands.push(temp);
    		}  		
    	}
    	
    	// empty 
    	while(!operands.empty())
    	{
    		String r = operands.pop();
    		//System.out.println("r = " + r);
    		result += r;
    	}
    	
    	return result;  	
    }
    	
    	
    	
    boolean isParenthesis(String s)
    {
    	switch(s)
    	{
    	case "(":
    	case ")":
    		return true;
    	}
    	
    	return false;
    }
    
    int findWhichParenthesis(String s)
    {
    	switch(s)
    	{
    	case "(":
    		return 1;
    	case ")":
    		return 2;
    	}
    	
    	return 0;
    }
    
    
    boolean isOperand(String[] e, int i)
    {
    	switch(e[i])
		{
		case "+":
		case "-":
		case "*":
		case "/":
		case "^":
		case "(":
		case ")":
			//System.out.println("Operand found: " + e[i]);
			return true;
		}
		
		return false;
    }
    
    int getPrecidence(String[] e, int i)
	{
		switch(e[i])
		{
		case "+":
		case "-":
		case "(":
		case ")":
			return 1;
		case "*":
		case "/":
			return 2;
		case "^":
			return 3;
		}
		
		return -1;
	}
    
    int getStackPrecidence(String s)
    {
    	switch(s)
		{
		case "+":
		case "-":
			return 1;
		case "*":
		case "/":
			return 2;
		case "^":
			return 3;
		}
		
		return -1;
    }
}
class DriverMain{
	public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        InfixToPostfix postfix = new InfixToPostfix();
        try {
             System.out.println(postfix.infixToPostfix(input.nextLine()));
        }
        catch (Exception ex) {
              System.out.println("Wrong expression");
        }
	}
}
