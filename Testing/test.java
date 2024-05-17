public class test {
	
	public static void main(String[] args) {
		getTime(1000);
		getTime(10000);
		getTime(100000); 
		getTime(1000000);
		}
	
	public static void getTime(int n) {
		//int[] list = random(n);
		int[] list = sorted(n);
		long startTime = System.currentTimeMillis();
		//bubbleSort(list);
		mergeSort(list);
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time for n = " + n + " is "
		+ (endTime - startTime) + " milliseconds.");
		}
	
	private static int[] random(int n) {
		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
		list[i] = (int) (Math.random() * 1000);
		}
		return list;
		}
	
	private static int[] sorted(int n) {
		int[] list = new int[n];
		for (int i = 0; i < n; i++)
		list[i] = i;
		return list;
		}
	
	
	/** Bubble sort method */
	public static void bubbleSort(int[] list) {
		boolean needNextPass = true;

		for (int k = 1; k < list.length && needNextPass; k++) {
			// Array may be sorted and next pass not needed
			needNextPass = false;
			for (int i = 0; i < list.length - k; i++) {
				if (list[i] > list[i + 1]) {
					// Swap list[i] with list[i + 1]
					int temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;

					needNextPass = true; // Next pass still needed
				}
			}
		}
	}

	/* l is for left index and r is right index of the
	 sub-array of arr to be sorted */

	public	static void mergeSort(int arr[], int l, int r) {
		if (l < r) {
			// Same as (l+r)/2, but a static voids overflow for
			// large l and h
			int m = l + (r - l) / 2;

			// Sort first and second halves
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}
	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	public	static void merge(int arr[], int l, int m, int r) {
		int i, j, k;
		int n1 = m - l + 1;
		int n2 = r - m;

		/* create temp arrays */
		int[] L = new int[n1];
		int[] R = new int[n2];

		/* Copy data to temp arrays L[] and R[] */
		for (i = 0; i < n1; i++)
			L[i] = arr[l + i];

		for (j = 0; j < n2; j++)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays back into arr[l..r]*/
		i = 0; // Initial index of first subarray
		j = 0; // Initial index of second subarray
		k = l; // Initial index of merged subarray
		while (i < n1 && j < n2) {

			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy the remaining elements of L[], if there
		 are any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy the remaining elements of R[], if there
		 are any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

	}
	public	static void mergeSort(int arr[]) {
		mergeSort(arr, 0, arr.length - 1);
	}
}