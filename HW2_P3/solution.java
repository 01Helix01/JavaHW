import java.util.*;
import java.lang.*;
import java.io.*;
class HW2_P3{
    
    public int[] getArray(){
        Scanner scanner = new Scanner(System.in);
        
        // get length
        int length = scanner.nextInt();
        
        int intArray[] = new int[length];
        
        // fill array
        for (int i = 0; i < length; i++)
        	intArray[i] = scanner.nextInt();
        
        return intArray;
    }
    
    public void pushZero(int array[]){
    	int arraySorted[] = new int[array.length];
    	int k = 0;
    	
    	
    	// copy over zeros into new array
    	for (int j = 0; j < array.length; j++)
    	{
    		if (array[j] == 0)
    			arraySorted[k++] = 0;
    	}
    	
    	// copy everything else
    	for (int m = 0; m < array.length; m++)
    	{
    		if (array[m] != 0)
    			arraySorted[k++] = array[m];
    	}
    	
    	// replace original array
    	for (int p = 0; p < array.length; p++)
    	{
    		array[p] = arraySorted[p];
    	}
    }
    
}
class DriverMain{
	public static void main(String args[]){
		HW2_P3 hw  = new HW2_P3();
        int[] array = hw.getArray();
        hw.pushZero(array);
        
        //Print the result array
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
	}
}
