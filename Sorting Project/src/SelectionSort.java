public class SelectionSort {
	static int comp = 0;
	static int mvmt = 0;
	
	/** The method for sorting the numbers */
	public static void selectionSort(int[] list) { //int[] list?
		for (int i = 0; i < list.length -1; i++) {
			// Find the minimum in the list[i..list.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;
			
			for (int j = i+1; j < list.length; j++) {
				// Compare
				comp++;
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			
			//	Swap list[i] wiht list[currentMinIndex[ if necessary
			if (currentMinIndex != i) {
				// Move
				mvmt++;
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}
}
