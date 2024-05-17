import java.util.*;
import java.lang.*;
import java.io.*;
class HW2_P4{

    public int findMajority(int[] array){
    	
    	// take array and find it's candidate
        int candidate = findCandidate(array);
        
        // If candidate is the majority number, return it
        if (isMajority((array), candidate))
        	return candidate;
        
        // Return 0 if no majority element
        else
        	return 0;
	}
    
    /* Function to find the candidate for Majority */
    int findCandidate(int a[]) {
    	int count = 0;
    	int highest = 0;
        int candidate = 0;
        
        // look for multiple occurrences of each number in the array
        for (int i = 0; i < a.length; i++)
        {
        	count = 0;
        	for (int j = 0; j < a.length; j++)
        	{
        		if (a[i] == a[j])
        			count++;
        	}
        	
        	if (count > highest)
        		candidate = a[i];
        }
        
        return candidate;
    }
    
    /* Function to check if the candidate occurs more than n/2 times */
    boolean isMajority(int a[], int cand) {
    
    	int count = 0;
    	
    	for (int i = 0; i < a.length; i++)
    	{
    		if (a[i] == cand)
    			count++;
    	}
    	
    	if (count > (a.length/2))
    		return true;
    	
    	else
    		return false;
    }

    
}
class DriverMain{
	public static void main(String args[]){
		HW2_P4 hw  = new HW2_P4();
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = s.nextInt();
        }
        System.out.print(hw.findMajority(A));
	}
}
