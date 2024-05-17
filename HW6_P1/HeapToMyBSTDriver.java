import java.util.*;
import java.lang.*;
import java.io.*;

//---------------DO NOT CHANGE ANYTHING IN THIS FILE---------------------------------
class HeapMyToBSTDriver{
	public static void main(String args[]){
		MaxHeap maxHeap = new MaxHeap();
		MyBST bst = new MyBST();
        
        Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		// Add elements to the max heap
		for(int i = 0; i < size; i++)
			maxHeap.add(Integer.parseInt(input.next()));	

		Solution.convert(maxHeap, bst);
		
		bst.print();
	}
}
