import java.util.*;
import java.lang.*;
import java.io.*;
class HW2_P1{
    public String format(int number, int width){
    	// Convert to string
    	String num = number;
    	
    	if(num.length() < width)
    	{
    		for(int z = num.length; z < width; z++)
    			num = 0 + num;
    	}
    	
    	return num;
		
	}
}
class DriverMain{
	public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine().trim());
        int width = Integer.parseInt(input.nextLine().trim());
		HW2_P1 hw  = new HW2_P1();
        System.out.print(hw.format(num,width));
	}
}
