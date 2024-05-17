import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		
		// Create a scanner to get user input
		Scanner userInput = new Scanner(System.in);
		
		// Declare timer variables (will need to be divided by 1000000 to get ms)
		long startTime;
		long elapsedTime;
		// Declare user selection variables
		int arraySelect;
		int sizeSelect;
		int algoSelect;
		// Declare size of array variable (with default -1)
		int size = -1;
		
		 
		// Pick the array type to be used //
		System.out.println("1. InOrder\n"
						 + "2. ReverseOrder\n"
						 + "3. AlmostOrder\n"
						 + "4. RandomOrder\n"
						 + "List Properties, select the data type of list you wish to use: ");
		
		// Get user input
		arraySelect = userInput.nextInt();
		
		
		// Pick the size of the array to be used
		System.out.println("1. 5000\n"
				 		 + "2. 15000\n"
				 		 + "3. 50000\n"
				 		 + "Input Size, select the size of list: ");

		// Get user input
		sizeSelect = userInput.nextInt();
		
		// Pick size of array to be generated //
		switch(sizeSelect)
		{
		case 1: size = 5000;
			break;
		case 2: size = 15000;
			break;
		case 3: size = 50000;
			break;
		default: System.out.println("INVALID SELECTION");
			break;
		}
		
		// Generate array of selected type with selected size
		int[] Array = new int[size];
		switch(arraySelect)
		{
		case 1: // Generate an InOrder Array
			for(int i = 0; i < size; i++)
			{
			    Array[i] = i;
			}
			break;
			
		case 2: // Generate a ReverseOrder Array
			for(int i = 0; i < size; i++)
			{
			    Array[i] = size-i;
			}
			break;
			
		case 3: // Generate an AlmostOrder Array
			for(int i = 0; i < size; i++)
			{
			    if((i % 100) == 0)
			    {
			        Array[i] = i + 2;
			    }
			    else
			    {
			        Array[i] = i;
			    }
			}
			break;
			
		case 4: // Generate a RandomOrder Array
		    for(int i = 0; i < size; i++)
		    {
		        Array[i] = (int)(Math.random()*size);
		    }
		    break;
		    
		default: System.out.println("INVALID SELECTION");
			break;
		}
		
		
		// Print Unsorted array for testing
		/*
		for(int i = 0; i < size; i++)
		{
		        System.out.println(Array[i]);
		}
		*/
		
		
		// Pick the Sorting Algorithm to be used //
		System.out.println("1. Insertion Sort\n"
				+ "2. Selection Sort\n"
				+ "3. Quick Sort\n"
				+ "4. Merge Sort\n"
				+ "5. Heap Sort\n"
				+ "6. Radix Sort\n"
				+ "Sorting Algorithm, select the sorting algorithm: ");
		
		// Get user input
		algoSelect = userInput.nextInt();
		
		
		
		// Select the correct algorithm and print the comparisons, movements, and time elapsed in milliseconds
		switch(algoSelect)
		{
		case 1: startTime = System.nanoTime();
				InsertionSort.insertionSort(Array);
				elapsedTime = System.nanoTime() - startTime;
				System.out.println("Comparisons: " + InsertionSort.comp + "\n"
						+ "Movements: " + InsertionSort.mvmt + "\n"
						+ "Total Time: " + elapsedTime/1000000);
			break;
		case 2: startTime = System.nanoTime();
				SelectionSort.selectionSort(Array);
				elapsedTime = System.nanoTime() - startTime;
				System.out.println("Comparisons: " + SelectionSort.comp + "\n"
				+ "Movements: " + SelectionSort.mvmt + "\n"
				+ "Total Time: " + elapsedTime/1000000);
			break;
		case 3: startTime = System.nanoTime();
				QuickSort.quickSort(Array);
				elapsedTime = System.nanoTime() - startTime;
				System.out.println("Comparisons: " + QuickSort.comp + "\n"
				+ "Movements: " + QuickSort.mvmt + "\n"
				+ "Total Time: " + elapsedTime/1000000);
			break;
		case 4: startTime = System.nanoTime();
				MergeSort.mergeSort(Array);
				elapsedTime = System.nanoTime() - startTime;
				System.out.println("Comparisons: " + MergeSort.comp + "\n"
				+ "Movements: " + MergeSort.mvmt + "\n"
				+ "Total Time: " + elapsedTime/1000000);
			break;
		case 5: // Before we sort, we must first convert our int array to Integer
	        Integer[] integerArray = new Integer[size];
	        
	        for (int i = 0; i < size; i++) {
	        	integerArray[i] = Integer.valueOf(Array[i]);
	        }
	        
	        startTime = System.nanoTime();
			HeapSort.heapSort(integerArray);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("Comparisons: " + HeapSort.comp + "\n"
			+ "Movements: " + HeapSort.mvmt + "\n"
			+ "Total Time: " + elapsedTime/1000000);
			
			break;
		case 6: startTime = System.nanoTime();
				RadixSort.radixsort(Array, size);
				elapsedTime = System.nanoTime() - startTime;
				System.out.println("Comparisons: " + RadixSort.comp + "\n"
				+ "Movements: " + RadixSort.mvmt + "\n"
				+ "Total Time: " + elapsedTime/1000000);
			break;
		default: System.out.println("INVALID SELECTION");
			break;
		}
		
		// Close the scanner
		userInput.close();
		
		// Print sorted array for testing
		/*
		for(int i = 0; i < size; i++)
		{
			System.out.println(Array[i]);
		}
		*/
		
	}
}