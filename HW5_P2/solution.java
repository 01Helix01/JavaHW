import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;
import java.io.*;

/* Analysis:
 * In this program, we must find and delete all duplicates in our code
 * Then, return the new length
 */

/* Design:
 * Traverse the list by simply using a for loop incrementing i until i < size - 1
 * If the integer in position i is equal to i + 1, we have a duplicate
 * When duplicates are found, remove it from the list and decrease i and size by 1
 * This basically makes it such that it was never there in the first place
 */

class ProblemSolution{
    public static int removeDuplicate(List<Integer> list){
    	
    	int size = list.size();
    	
    	if (size <= 0)
    		return 0;
    	
    	for (int i = 0; i < size - 1; i++)
    	{
    		//System.out.println("Now at" + list.get(i));
    		
    		if (list.get(i).equals(list.get(i+1)))
    		{
    			//System.out.println("Found duplicate: " + list.get(i));
    			list.remove(i);
    			
    			//System.out.println("Removed duplicate: " + list.get(i));
    			i--;		
    			size--;
    		}
    	}
    	
    	return list.size();
    }
}


