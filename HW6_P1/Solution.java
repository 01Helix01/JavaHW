import java.util.*;
import java.lang.*;
import java.io.*;

/* Analysis:
 * The other classes create a Heap of a given size and pass it to our Solution class
 * For this project, we must convert that Heap into a BST
 * Using the given functions in MaxHeap and BST we are able to sort the Heap's elements and
 * insert them into the given MyBST "bst"
 */

/* Design:
 * Create a new ArrayList
 * Remove every element of the Heap and insert it into our list
 * Recursively insert a new Tree element starting from both sides,
 * until the two sides meet
 */



/*
 * convert MaxHeap to a complete MyBST
 */

class Solution{
    public static void convert(MaxHeap maxHeap, MyBST bst){
        // Write your code here, you can add more methods
    	
    	// Create new Integer ArrayList "list"
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	// For each element in the Heap, remove from the Heap and add to our new list
    	while(maxHeap.getSize() > 0)
    	{
    		list.add((Integer) maxHeap.remove());

    	}
    	
    	// Start to recursively make our new Tree
    	createTree(bst, list, 0, list.size() - 1);
	}
    
    private static void createTree(MyBST bst, ArrayList<Integer> list, int low, int high)
    {
    	// Until our high and low meet, keep creating a new Tree on both sides
    	if(low <= high)
    	{
    		int mid = (low + high)/2;
    		
    		// Insert the middle of this portion of the list to the BST
    		bst.insert(list.get(mid));
    		
    		// LHS Tree
    		createTree(bst, list, low, mid - 1);
    		
    		// RHS Tree
    		createTree(bst, list, mid + 1, high);
    	}
    }
}
