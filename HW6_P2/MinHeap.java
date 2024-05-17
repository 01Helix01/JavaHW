import java.io.*;
import java.util.Collections;

/* Analysis:
 * In this code, we must complete the creation of a MinHeap
 * A MinHeap is a heap where each node is less or equal to it's children
 * We must create the add and remove methods
 * Remember when removing to reorder the heap
 */

/* Design:
 * To add to the heap, we will first add our new object to the list
 * Then, keeping track of it's and it's parent's position, compare our new
 * Object to the parent Object. If new value is greater, swap the two AND their positions.
 * To swap I used the swap() method from java.util.Collections
 * 
 * To remove from the heap, check if size is 0 or 1 - if not we have to do a bit of work.
 * Get the first Object from our list and store it. Then swap it and the last Object.
 * Call fixHeap recursively to continue to reorder the list into MinHeap form
 * After Heap has been fixed, return the first Object from the list we got earlier
 */

class MinHeap<E extends Comparable<E>> {
	private java.util.ArrayList<E> list = new java.util.ArrayList<>();

	/** Create a default heap */
	public MinHeap() {
	}

	/** Create a heap from an array of objects */
	public MinHeap(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	/** Add a new object into the heap */
	public void add(E newObject) {
        //write your code here
		
		// Add object into ArrayList
		list.add(newObject);
		int place = list.size() - 1;
		int placeParent = (place - 1) / 2;
		
		// swap the newObject with its parent until parent is smaller
		while(list.get(place).compareTo(list.get(placeParent)) < 0)
		{
			Collections.swap(list, place, placeParent);
			
			// if swapped, swap the place with the parent's
			place = placeParent;
			placeParent = (place - 1) / 2;
		}
        
    }
    /** Remove the root from the heap */
	public E remove() {
    
        //write your code here
		E min = null;
		
		// first, check if heap is empty
		if(getSize() == 0)
		{
			return null;
		}
		
		// next, make sure heap isn't just size 1, because then we can just remove 0
		else if(getSize() == 1)
		{
			min = list.remove(0);
			return min;
		}
		
		// if heap size > 1, we will have to get Object in place 0 and replace it
		min = list.get(0);
		list.set(0, list.remove(list.size() - 1));
		
		// then, in order to keep our MinHeap a MinHeap, we'll basically have to reconstruct it
		fixHeap(0);
		
		// finally, return the min we got when we first got position 0
		return min;
    }
	
	public void fixHeap(int i) {
		int l = 2 * (i + 1);
		int r = 2 * (i + 2);
		int min = -1;
		
		// make sure l is in bounds, then check if l position's object is smaller than 
		// i position's object. If it is, set min to l. If not, then just set the min to i
		if (l <= list.size() - 1 && list.get(l).compareTo(list.get(i)) < 0)  {
            min = l;
        } else {
        	min = i;
        }

		// same thing as we did before here, only this time with the right side and the min we just got
		// if right ends up smaller than our min, we know that r is the new min
        if (r <= list.size() - 1 && list.get(r).compareTo(list.get(min)) > 0) {
        	min = r;
        }

        // as long as our original value wasn't min, swap i and min,
        // then continue running fixHeap until it is
        // (if i ended up as min, this step would obviously be unnecessary)
        if (min != i) {
        	Collections.swap(list, i, min);
            fixHeap(min);
        }
	}
	
    
    /** Get the number of nodes in the tree */
	public int getSize() {
		return list.size();
	}
    
    public void print(){
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
	}
    
}
