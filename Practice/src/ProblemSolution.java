import java.util.*;
/** 	-Analysis- 
 * Input will be provided in console with the exact provided input format and
 * will be printed in the console with provided output format. 
 *     -Design-
 * Read the input from console as a String. In the provided input format, the strings are separated with a single space. 
 * Assumption: The input format is always correct therefore no type checking or format checking is needed.
 * Trim the string to make sure there is no extra space. 
 * firstName and lastName are both string type, age is an int type and weight is a double value with two floating points.
 * Convert String to double and int type values. 
**/

class ProblemSolution{
	
	public static void main(String args[]){
		ProblemSolution problemSolution  = new ProblemSolution();
        problemSolution.solution();
	}
	
    public void solution(){
        // Read input
        Scanner input = new Scanner(System.in);
		String inputString = input.nextLine().trim();
        // extract the index of the first space
		int i = inputString.indexOf(' ');
        // extract the index of the second space
		int j = inputString.indexOf(' ' , i+1);
        // extract the index of the second space
		int k = inputString.indexOf(' ', j+1);
        // first name end at the index position i
		String firstName = inputString.substring(0,i);
        // last name starts from index position i+1 and end at the index position j
		String lastName = inputString.substring(i+1, j);
        // age starts from index position j+1 and end at the index position k
		int age = Integer.parseInt(inputString.substring(j+1, k));
        // weight starts from index position k+1
		double weight = Double.parseDouble(inputString.substring(k+1));	
        
        //print the results
		System.out.println("FirstName: " + firstName);
		System.out.println("LastName: " + lastName);
		System.out.printf("Your age is %d and your weight is %.2f", age, weight);
	}
}

