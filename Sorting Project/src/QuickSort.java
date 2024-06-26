public class QuickSort {
	static int comp = 0;
	static int mvmt = 0;
	
	public static void quickSort(int[] list) {
		quickSort(list, 0, list.length-1);
	}
	
	public static void quickSort(int[] list, int first, int last) {
		if (last > first) {
			// Comparison
			comp++;
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex -1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
	
	/** Partition the array list[first..last] */
	public static int partition(int[] list, int first, int last) {
		int pivot = list[(first + last)/ 2]; // Choose the MIDDLE element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; //Index for backward search
		
		while (high > low) {
			// Search forward from left
			// Comparison 
			comp++;
			while (low <= high && list[low] <= pivot)
				low++;
			
			// Search backward from right
			while (low <= high && list[high] > pivot)
				high--;
			
			//	Swap two elements in the list
			if (high > low) {
				// Compare and move
				comp++;
				mvmt++;
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		while (high > first && list[high] >= pivot)
			high--;
		
		//	Swap pivot with list[high]
		if (pivot > list[high]) {
			// Compare and move
			comp++;
			mvmt++;
			list[first] = list[high];
			list[high] = pivot; 
			return high;
		}
		else {
			return first;
		}
	}
}
