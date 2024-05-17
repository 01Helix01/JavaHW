import java.util.*;
import java.lang.*;
import java.io.*;

class DriverMain{
	public static void main(String args[]){
		MyBST myTree = new MyBST();
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();		
		// Add elements to the max heap
		for(int i = 0; i < size; i++)
			myTree.insert(Integer.parseInt(input.next()));	
		int a = input.nextInt();
		int b = input.nextInt();
		input.close();
	
		System.out.println(myTree.getDistance(a, b));
	}
}